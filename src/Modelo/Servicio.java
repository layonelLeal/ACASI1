package Modelo;

import Modelo.Users.Profesor;
import Modelo.Users.Estudiante;
import Modelo.Users.Usuario;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
import supabase.Filter;
import supabase.Supabase;

public class Servicio {
    static private String sessionRole; //mejor guardar un sessión o user
    static private Sala[] sessionSalas = new Sala[0];
    static private Computador[] computers = new Computador[0];
    static private Sesion[] active_sessions = new Sesion[0];
    static private Sala currentManagmentSalas = new Sala();
    static private Estudiante student = null;
    static private Profesor teacher = null;
    static public String role = "";
    static private Date login_time;
    static private Date logout_time;
    static private Supabase supabase = new Supabase("https://rrkotxwnjddvzolduptl.supabase.co/", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InJya290eHduamRkdnpvbGR1cHRsIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MTEzNzU3NTMsImV4cCI6MjAyNjk1MTc1M30.f_wch4K52M85qijPY3ovSynCUoH2ax9eyknWnIJDmuQ");
    
    static public JSONObject iniciarSesion(String email, String password){
        JSONObject data = supabase.auth.LoginWithEmailAndPassword(email, password);
        if (data.has("user")){
            //El login fue correcto
            login_time = new Date();
            sessionRole = data.getJSONObject("user").getString("role");
            if (sessionRole.equals("admin")){
                teacher = new Profesor(data);
                role = "profesor";
            }else{
                student = new Estudiante(data);
                JSONArray response = supabase.from("joint_responsability_hours").select("*", new Filter("user_id", "eq", student.getId()));
                System.out.println(response.toString());
                student.setJoint_responsability_hours(response.getJSONObject(0).getFloat("joint_responsability_hours"));
                role = "estudiante";
            }
        }else{
            //El login falló
            HashMap<String, Object> errorMap = new HashMap<>();
            errorMap.put("errorMessage", "Tu usuario o contraseña no son incorrectos.");
            JSONObject error = new JSONObject(errorMap);

            return error;
        }
        return data;
    }
    
    static public void cerrarSesion(){
        if ("estudiante".equals(role)){
            logout_time = new Date();
            Float work_time = calcularDiferenciaHoras(login_time, logout_time);
            System.out.println("Tiempo en linea: " + work_time);
            HashMap <String, Float> updateInfo = new HashMap<>();
            Float new_time = student.getJoint_responsability_hours() - work_time;
            updateInfo.put("joint_responsability_hours", new_time);
            JSONObject body = new JSONObject(updateInfo);
            supabase.from("joint_responsability_hours").update(body, new Filter("user_id", "eq", student.getId()));
            student = null;
            teacher = null;
            sessionRole = null;
        }
    }
    
    public static float calcularDiferenciaHoras(Date inicio, Date fin) {
        // Calcula la diferencia en milisegundos
        long diffInMillies = fin.getTime() - inicio.getTime();
        
        // Convierte la diferencia a horas en decimal
        float diffInHours = (float) TimeUnit.MILLISECONDS.toMinutes(diffInMillies) / 60;

        // Redondea a 1 decimal
        BigDecimal bd = new BigDecimal(Float.toString(diffInHours));
        bd = bd.setScale(1, RoundingMode.HALF_UP);

        return bd.floatValue();
    }

    public static Estudiante getStudent() {
        return student;
    }
    
    static public Sala[] updateRooms(){
        JSONArray data = supabase.from("salas").select("*");
        sessionSalas = new Sala[data.length()];
        System.out.println(data.toString());
        for (int i = 0; i < data.length(); i++) {
            sessionSalas[i] = new Sala(data.getJSONObject(i));
        }
        return sessionSalas;
    }

    static public Sala[] getRooms(){
        if (sessionSalas.length == 0){
            sessionSalas = updateRooms();
            return sessionSalas;
        }
        return sessionSalas;
    }
    
    static public Computador[] getComputers(Integer sala_id){
        JSONArray response = supabase.from("computers").selecteq("*", "sala_id", sala_id);
        computers = new Computador[response.length()];
        for (int i = 0; i < response.length(); i++) {
            computers[i] = new Computador(response.getJSONObject(i));
        }
        return computers;
    }
    
    public static void createComputers(JSONArray computers_array){
        supabase.from("computers").insert(computers_array);
    }
    
    static public Sesion[] getActiveSessions(Sala dataSala){
        JSONArray data = supabase.from("active_sessions").selecteq("*,users(*),computers(*)", "sala_id", dataSala.getId());
        active_sessions = new Sesion[data.length()];
        System.out.println(data.toString());
        for (int i = 0; i < data.length(); i++) {
            Computador session_computer = new Computador(data.getJSONObject(i).getJSONObject("computers"));
            Usuario session_user = new Usuario(data.getJSONObject(i).getJSONObject("users"));
            active_sessions[i] = new Sesion(data.getJSONObject(i), dataSala, session_user, session_computer);
        }
        return active_sessions;
    }
    
    static public void updateActiveSessions(int sala_id){
        JSONArray data = supabase.from("active_sessions").selecteq("*,users(*),computers(*)", "sala_id", sala_id);
        active_sessions = new Sesion[data.length()];
        
        for (int i = 0; i < data.length(); i++) {
            Computador session_computer = new Computador(data.getJSONObject(i).getJSONObject("computers"));
            Usuario session_user = new Usuario(data.getJSONObject(i).getJSONObject("users"));
            active_sessions[i] = new Sesion(data.getJSONObject(i), currentManagmentSalas, session_user, session_computer);
        }
    }
    
    static public Sesion addActiveSession(String docNumber, Integer sala_id, String computer_id){
        JSONArray findUser = supabase.from("users").selecteq("*", "document_number", docNumber);
        if (findUser.length() == 0){
            System.out.println("No se encontro el usuario");
            return new Sesion();
        }
        Usuario findUsuario = new Usuario(findUser.getJSONObject(0));
        JSONArray body = new JSONArray("[{\"sala_id\":\"" + sala_id + "\", \"computer_id\":\"" + computer_id + "\", \"user_id\":\"" + findUsuario.getId() + "\"}]");
        System.out.println(body.toString());
        JSONArray newSessionResponse = supabase.from("active_sessions").insert(body);
        Sesion newSession = new Sesion(currentManagmentSalas, findUsuario, new Computador("", sala_id, 0));
        updateActiveSessions(sala_id);
        return newSession;
    }
    
    static public void deleteActiveSession(String uuid, int sala_id){
        System.out.println(uuid);
        JSONArray response = supabase.from("active_sessions").delete(new Filter("computer_id", "eq", uuid));
        System.out.println(response.toString());
        updateActiveSessions(sala_id);
    }
    
    static public Sala createRoom(String name, Integer rows, Integer cols, Map<Integer, int[]> computers_arrays){
        Sala newSala = new Sala(name, rows, cols, computers_arrays);
        Sala[] salas = new Sala[]{newSala};
        JSONArray body = new JSONArray(salas);
        System.out.println(body);
        JSONArray response = supabase.from("salas").insert(body);
        return new Sala(response.getJSONObject(0));
    }
    
    public static Sala getRoom(Integer id){
        System.out.println("Buscando una Sala en especial..");
        JSONArray salas = supabase.from("salas").selecteq("*","id", id);
        JSONObject sala = salas.getJSONObject(0);
        Sala createSala = new Sala(sala);
        return createSala;
    }
    
    public static Sesion[] getSessionsByRange(Integer sala_id, String start_time, String finish_time){
        Filter filterorder = new Filter("order", "start_time", "asc");
        Filter filterTipo = new Filter("sala_id", "eq", sala_id);
        Filter filterFechaInicio = new Filter("start_time", "gte", start_time);
        Filter filterFechaFin = new Filter("finish_time", "lte", finish_time);
        Filter[] filters = new Filter[]{filterFechaInicio, filterFechaFin, filterorder, filterTipo};
        
        JSONArray filteredSessions = supabase.from("sessions").select("*, users(*), salas(*)", filters);
        System.out.println(filteredSessions);
        Sesion[] arraySessions = new Sesion[filteredSessions.length()];
        System.out.println(filteredSessions.toString());
        
        for (int i = 0; i < filteredSessions.length(); i++) {
            arraySessions[i] = new Sesion(filteredSessions.getJSONObject(i));
        }
        
        return arraySessions;
    }
    
    public static Sesion[] getUsersBySessionAndRange(Integer sala_id, Date start_time, Date finish_time) throws ParseException{
        String finish_timeString = getDateFormatString("yyyy-MM-dd HH:mm:ss", finish_time);
        String start_timeString = getDateFormatString("yyyy-MM-dd HH:mm:ss", start_time);
        
        

        Filter filterTipo = new Filter("sala_id", "eq", sala_id);
        Filter filterorder = new Filter("order", "start_time", "asc");
        Filter filterFechaInicio = new Filter("start_time", "gte", URLEncoder.encode(start_timeString, StandardCharsets.UTF_8));
        Filter filterFechaFin = new Filter("finish_time", "lte", URLEncoder.encode(finish_timeString, StandardCharsets.UTF_8));
        Filter[] filters = new Filter[]{filterFechaInicio, filterFechaFin, filterorder, filterTipo};
        
        JSONArray filteredSessions = supabase.from("sessions").select("*,salas(*),users(*)", filters);
        System.out.println(filteredSessions);
        Sesion[] arraySessions = new Sesion[filteredSessions.length()];
        System.out.println(filteredSessions.toString());
        
        for (int i = 0; i < filteredSessions.length(); i++) {
            arraySessions[i] = new Sesion(filteredSessions.getJSONObject(i));
        }
        
        return arraySessions;
    }
    
    public static Date getDateFormat(String formatPattern, String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(formatPattern);
        return formatter.parse(date);
    }
    
    public static String getDateFormatString(String formatPattern, Date date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(formatPattern);
        formatter.setTimeZone(TimeZone.getDefault().getTimeZone("COT"));
        //String formattedDateStr = formatter.format(date);
        return formatter.format(date);
    }
    
    public static LinkedHashMap<String, Integer> getDaysOfYear(Date start_time, Date finish_time, Integer sala_id) throws ParseException{
        Sesion[] response = getUsersBySessionAndRange(sala_id, start_time, finish_time);

        LinkedHashMap<String, Integer> formatedSession = new LinkedHashMap<>();

        for (Sesion sesion : response) {
            System.out.println("_______________________________________________________");
            Date date = sesion.getHoraEntrada();
            System.out.println(date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            // Obtenemos el día y el mes
            Integer day = calendar.get(Calendar.DAY_OF_MONTH);
            Integer month = calendar.get(Calendar.MONTH) + 1; // Los meses en Calendar son 0-based
            

            // Formateamos la fecha como "dd/MM/yyyy"
            String dayStr = String.format("%02d/%02d", day, month);

            if (formatedSession.containsKey(dayStr)) {
                Integer aux = formatedSession.get(dayStr);
                formatedSession.put(dayStr, aux + 1);
            } else {
                System.out.println("No existe aún el día: " + dayStr);
                formatedSession.put(dayStr, 1);
            }
    }

    System.out.println(formatedSession.toString());
    return formatedSession;
    }
    
    public static LinkedHashMap<String, Integer> getMonth(Date start_time, Date finish_time, Integer sala_id) throws ParseException{
        //String month = null;
        
        Sesion[] response = getUsersBySessionAndRange(sala_id, start_time, finish_time);
    
        LinkedHashMap <String, Integer> formatedSession = new LinkedHashMap<>();

        for (Sesion sesion : response){
            System.out.println("_______________________________________________________");
            Date date = sesion.getHoraEntrada();
            System.out.println(date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.forLanguageTag("es-ES"));

            
            if (formatedSession.containsKey(month)){
                Integer aux = formatedSession.get(month);
                formatedSession.put(month, aux + 1);
            }else{
                System.out.println("No existe aún el mes: " + month);
                formatedSession.put(month, 1);
            }
        }
    
        System.out.println(formatedSession.toString());
        return formatedSession;
    }
  
    public static LinkedHashMap<String, Integer> getYear(Date start_time, Date finish_time, Integer sala_id) throws ParseException{
        //String month = null;
        
        Sesion[] response = getUsersBySessionAndRange(sala_id, start_time, finish_time);
    
        LinkedHashMap <String, Integer> formatedSession = new LinkedHashMap<>();

        for (Sesion sesion : response){
            System.out.println("_______________________________________________________");
            Date date = sesion.getHoraEntrada();
            System.out.println(date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            Integer year = calendar.get(Calendar.YEAR);
            String yearStr = String.valueOf(year);
            
            if (formatedSession.containsKey(yearStr)){
                Integer aux = formatedSession.get(yearStr);
                formatedSession.put(yearStr, aux + 1);
            }else{
                System.out.println("No existe aún el año: " + yearStr);
                formatedSession.put(yearStr, 1);
            }
        }
    
        System.out.println(formatedSession.toString());
        return formatedSession;
    }
    
    public static LinkedHashMap<String, Integer> getFaculty(Date start_time, Date finish_time, Integer sala_id) throws ParseException{
        
        Sesion[] response = getUsersBySessionAndRange(sala_id, start_time, finish_time);
        
       
        LinkedHashMap <String, Integer> formatedSession = new LinkedHashMap<>();

        for (Sesion sesion : response){
            String faculty = sesion.getUsuario().getFaculty();
            //System.out.println(sesion.getHoraEntrada().toString());
            if (formatedSession.containsKey(faculty)){
                Integer aux = formatedSession.get(faculty);
                formatedSession.put(faculty, aux + 1);
            }else{
                formatedSession.put(faculty, 1);
            }
        }
        
        System.out.println(formatedSession);

        return formatedSession;
    }
  
    public static JSONObject searchUser(String NomUsuario, String ApeUsuario, String DocUsuario){
        JSONObject findUser = new JSONObject();
        
        if (!NomUsuario.isBlank()){
            JSONArray response = supabase.from("users").select("*", new Filter("name", "eq", NomUsuario));
            findUser = response.getJSONObject(0);
            System.out.println(response.toString());
        }
        
        if (!ApeUsuario.isBlank()){
            JSONArray response = supabase.from("users").select("*", new Filter("last_name", "eq", ApeUsuario));
            findUser = response.getJSONObject(0);
            System.out.println(response.toString());
        }
        
        if (!DocUsuario.isBlank()){
            JSONArray response = supabase.from("users").select("*", new Filter("document_number", "eq", DocUsuario));
            findUser = response.getJSONObject(0);
            System.out.println(response.toString());       
        }       
        
        return findUser;  
    }
    
    public static String createUser(String name, String last_name, String document_number, String email, String vinculation, String faculty, String career){
        Usuario[] arraysUsers = new Usuario[1];
        arraysUsers[0] = new Usuario(career, faculty, Integer.valueOf(document_number), name, last_name, email);
        System.out.println("intentando crear usuario");
        JSONArray body = new JSONArray(arraysUsers);
        System.out.println(body.toString());
        JSONArray usuarioCreado = supabase.from("users").insert(body);
        return usuarioCreado.toString();
    }
    
    
}
