package Modelo.Users;
import org.json.JSONObject;

public class Usuario{
   private String career;
   private String faculty;
   private Integer document_number;
   private String name;
   private String last_name;
   private String email;
   private String id;
   
   public Usuario(JSONObject userData){
       this.id = userData.getString("id");
       this.name = userData.getString("name");
       this.document_number = userData.getInt("document_number");
       this.last_name = userData.getString("last_name");
       this.career = userData.getString("career");
       this.faculty = userData.getString("faculty");
   }

    public Usuario(String career, String faculty, Integer document_number, String name, String last_name, String email) {
        this.career = career;
        this.faculty = faculty;
        this.document_number = document_number;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getCareer() {
        return career;
    }

    public String getFaculty() {
        return faculty;
    }

    public Integer getDocument_number() {
        return document_number;
    }

    public String getName() {
        return name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getId() {
        return id;
    }

}
