package Modelo.Users;
import org.json.JSONObject;

public class AbstractUser {
    private String token;
    private String email;
    private String role;
    private Integer document;
    private String name;
    private String lastname;
    private String facultad;
    
    public AbstractUser (){
        this.token = "";
        this.email = "";
        this.role = "";
        this.document = 0;
        this.name = "";
        this.lastname = "";
        this.facultad = "";
    }
    
    public AbstractUser (JSONObject userData){
        this.email = (String) userData.getJSONObject("user").get("email");
        this.token = (String) userData.get("access_token");
        this.role = (String) userData.getJSONObject("user").getString("role");
    }

    public AbstractUser(JSONObject user_data, Boolean isComplete) {
        if (isComplete){
            this.token = (String) user_data.getJSONObject("user").get("email");
            this.email = (String) user_data.getJSONObject("user").get("email");
            this.role = (String) user_data.getJSONObject("user").get("email");
            this.document = (Integer) user_data.getJSONObject("user").get("email");
            this.name = (String) user_data.getJSONObject("user").get("email");
            this.lastname = (String) user_data.getJSONObject("user").get("email");
            this.facultad = (String) user_data.getJSONObject("user").get("email");
        }
    }    
   
    public String getRole(){
        return this.role;
    }
    
    public Boolean exist(){
        return !this.token.isEmpty();
    }
    
    public String getToken (){
        return token;
    }
    
    public void show(){
        System.out.println("Nombre: " + name);
    }
}
