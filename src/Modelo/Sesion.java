package Modelo;
import Modelo.Users.Usuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

public class Sesion {
    private String estadoSesion;
    private Date horaEntrada;
    private Date horaSalida;
    private Computador computador;
    private Usuario usuario;
    private Sala sala;

    public Sesion() {
        this.usuario = new Usuario("", "", 0, "", "", "");
    }
    
    public Sesion(Sala sala, Usuario usuario, Computador computador) {
        this.usuario = usuario;
        this.computador = computador;
        this.sala = sala;
        this.horaEntrada = new Date();
        this.estadoSesion = "activa";
    }
    
    public Sesion(JSONObject allData){
        String start_time_string = allData.getString("start_time");
        String finish_time_string = allData.getString("start_time");
        
        Date start_time = getDateFormat("yyyy-MM-dd'T'HH:mm:ss", start_time_string);
        Date finish_time = getDateFormat("yyyy-MM-dd'T'HH:mm:ss", finish_time_string);
        
        this.horaEntrada = start_time;
        this.horaSalida = finish_time;
        this.usuario = new Usuario(allData.getJSONObject("users"));
        this.sala = new Sala(allData.getJSONObject("salas"));
    }
    
    public Sesion(JSONObject session_data, Sala sala, Usuario usuario, Computador computador) {
        this.usuario = usuario;
        this.computador = computador;
        this.sala = sala;
        this.horaEntrada = new Date();
        this.estadoSesion = "activa";
    }
    
    private Date getDateFormat(String formatPattern, String date) {
        SimpleDateFormat formatter = new SimpleDateFormat(formatPattern);
        try {
            return formatter.parse(date);
        } catch (ParseException ex) {
            return new Date();
        }
    }

    public String getEstadoSesion() {
        return estadoSesion;
    }

    public Date getHoraEntrada() {
        return horaEntrada;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public Computador getComputador() {
        return computador;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Sala getSala() {
        return sala;
    }
   
}
