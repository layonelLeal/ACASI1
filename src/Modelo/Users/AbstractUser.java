package Modelo.Users;
import org.json.JSONObject;

public class AbstractUser {
    private String token;
    private String email;
    private String role;
    private String id;
    
    public AbstractUser (){
        this.token = "";
        this.email = "";
        this.role = "";
    }
    
    public AbstractUser (JSONObject userData){
        this.email = userData.getJSONObject("user").getString("email");
        this.token = userData.getString("access_token");
        this.role = userData.getJSONObject("user").getString("role");
        this.id = userData.getJSONObject("user").getString("id");
    }

    public AbstractUser(JSONObject user_data, Boolean isComplete) {
        if (isComplete){
            this.token = (String) user_data.getJSONObject("user").get("email");
            this.email = (String) user_data.getJSONObject("user").get("email");
            this.role = (String) user_data.getJSONObject("user").get("email");
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

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }
    
}
