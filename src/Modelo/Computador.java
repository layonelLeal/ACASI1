package Modelo;

import org.json.JSONObject;

public class Computador {
    private String id;
    private String name;
    private String estado;
    private Integer cont_sala;
    private Integer sala_id;
    
    
    public Computador(JSONObject computer_data){
        this.id = computer_data.getString("id");
        this.name = computer_data.getString("name");
        this.cont_sala = computer_data.getInt("cont_sala");
        System.out.println(cont_sala);
        this.estado = "libre";
    }

    public Computador(String name, Integer cont_sala, Integer sala_id) {
        this.name = name;
        this.cont_sala = cont_sala;
        this.sala_id = sala_id;
    }
    
    public void show(){
        System.out.println("Computador: " + name);
        System.out.println("ID computador" + id.toString());
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEstado() {
        return estado;
    }

    public Integer getCont_sala() {
        return cont_sala;
    }

    public Integer getSala_id() {
        return sala_id;
    }
    
}
