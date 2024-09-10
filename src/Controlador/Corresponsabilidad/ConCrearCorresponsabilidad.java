package Controlador.Corresponsabilidad;

import Vista.CrearCorresponsabilidad;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Api.Api;
import org.json.JSONObject;
import java.util.HashMap;

public class ConCrearCorresponsabilidad implements ActionListener{

    private CrearCorresponsabilidad crearCorresponsabilidad; 
            
    public ConCrearCorresponsabilidad(CrearCorresponsabilidad crearCorresponsabilidad){
         this.crearCorresponsabilidad = crearCorresponsabilidad;
         this.crearCorresponsabilidad.BtnaAñadirCorresponsabilidad.addActionListener(this);
     }
    
     public void Inicio(){
        crearCorresponsabilidad.setLocation(0, 0);
        crearCorresponsabilidad.setSize(0,0);
     }
     
    public void actionPerformed(ActionEvent e) {
        String name = crearCorresponsabilidad.TxtNewCorName.getText();
        String last_name = crearCorresponsabilidad.TxtNewCorApe.getText();
        String document_number = crearCorresponsabilidad.TxtNewCorDoc.getText();
        String email = crearCorresponsabilidad.TxtNewCorCorreo.getText();
        int joint_responsability_hours = Integer.parseInt(crearCorresponsabilidad.TxtNewCorTime.getText());
        String faculty = crearCorresponsabilidad.BoxNewCorFaculty.getSelectedItem().toString();
        String career = crearCorresponsabilidad.TxtNewCorCareer.getText().toLowerCase();
        crearCorresponsabilidad.ErrorNewCor.setForeground(Color.red);
        
        if (name.isEmpty()|last_name.isEmpty()|document_number.isEmpty()|email.isEmpty()){
            crearCorresponsabilidad.ErrorNewCor.setText("Rellene todos los espacios");
            return;
        }
        
        HashMap <String, Object> body = new HashMap<>();
        
        body.put("name", name);
        body.put("last_name", last_name);
        body.put("document_number", document_number);
        body.put("email", email);
        body.put("joint_responsability_hours", joint_responsability_hours);
        body.put("faculty", faculty);
        body.put("career", career);

        HashMap <String, Object> options = new HashMap<>();
        options.put("body", body);
        options.put("method", "POST");
        
        JSONObject response = Api.fetch("https://k4jkk61h-3000.use2.devtunnels.ms/api/admin/create/user", options);
        System.out.println(response.toString());
        
        crearCorresponsabilidad.ErrorNewCor.setForeground(Color.GREEN);
        crearCorresponsabilidad.ErrorNewCor.setText("Usuario Creado Correctamente");
        crearCorresponsabilidad.TxtNewCorName.setText("");
        crearCorresponsabilidad.TxtNewCorApe.setText("");
        crearCorresponsabilidad.TxtNewCorTime.setText("");
        crearCorresponsabilidad.TxtNewCorDoc.setText("");
        crearCorresponsabilidad.TxtNewCorCorreo.setText("");
        crearCorresponsabilidad.TxtNewCorCareer.setText("");
    }
}
