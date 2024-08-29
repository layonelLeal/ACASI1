package Modelo;
import Modelo.Users.Usuario;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import org.json.JSONArray;

public class Sala {
    private String name;
    private Integer rows;
    private Integer cols;
    private Map<Integer, int[]> computers_arrays;
    private Integer id;
    private JSONArray computadores;
    
    
    public Sala(){
        this.id = -1;
    }

    public Sala(String name, Integer rows, Integer cols, Map<Integer, int[]> computersData) {
        this.name = name;
        this.rows = rows;
        this.cols = cols;
        this.computers_arrays = computersData;
    }
    
    public Sala(JSONObject data){
        this.id = data.getInt("id");
        this.name = data.getString("name");
        JSONObject test = data.getJSONObject("computers_arrays");
        Map<Integer, int[]> computers_data = new HashMap<>();

        // Recorrer las claves del JSONObject
        for (String key : test.keySet()) {
            int keyInt = Integer.parseInt(key); // Convertir la clave a Integer

            // Obtener el JSONArray asociado a la clave
            JSONArray jsonArray = test.getJSONArray(key);

            // Convertir el JSONArray a un array de enteros
            int[] values = new int[jsonArray.length()];
            for (int i = 0; i < jsonArray.length(); i++) {
                values[i] = jsonArray.getInt(i);
            }

            // Poner la clave y el array de enteros en el Map
            computers_data.put(keyInt, values);
        }
        this.computers_arrays = computers_data;
        this.rows = data.getInt("rows");
        this.cols = data.getInt("cols");
    }
    
    public Sala(JSONObject data, JSONArray computers_data){
        System.out.println(data.toString());
        System.out.println(computers_data.toString());
        
        this.name = (String) data.getString("name");
        this.id = (Integer) data.getInt("id");
        this.computadores =  new JSONArray(computers_data);
    }
    
    public void editarPropiedades (){
        //despues
    }
    
    public Sesion createSession(Usuario usuario, Computador computador){
        Sesion newSession = new Sesion(this, usuario, computador);
        return newSession;
    }
    
    public Boolean isAvalible (){
        return this.id != -1;
    }

    public JSONArray getComputadores() {
        return computadores;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getRows() {
        return rows;
    }

    public Integer getCols() {
        return cols;
    }

    public Map<Integer, int[]> getComputers_arrays() {
        return computers_arrays;
    }
   
}
