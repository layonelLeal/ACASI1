package Controlador.Usuarios;

import Modelo.Servicio;
import Vista.AU_CrearUsuario;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author User
 */
public class ConAU_CrearUsuario implements ActionListener{
    
    private AU_CrearUsuario crearUser; 
            
    public ConAU_CrearUsuario(AU_CrearUsuario crearUser){
         this.crearUser = crearUser;
         this.crearUser.BtnaAñadirUsuario.addActionListener((ActionListener) this);
     }
    
     public void Inicio(){
        crearUser.setLocation(0, 0);
        crearUser.setSize(0,0);

     }
     
     //se capturan los datos de la visual de Au_CrearUsuario
     //captura TextFields Y ComBoxes los transforma a Strings y
     //los envia a el metodo Createuser en el modelo Service
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = crearUser.TxtNewUserName.getText();
        String last_name = crearUser.TxtNewUserApe.getText();
        String document_number = crearUser.TxtNewUserDoc.getText();
        String email = crearUser.TxtNewUserCorreo.getText();
        String vinculation = crearUser.BoxNewUserVin.getSelectedItem().toString();
        String faculty = crearUser.BoxNewUserFaculty.getSelectedItem().toString();
        String career = crearUser.TxtNewUserCareer.getText().toLowerCase();
        crearUser.ErrorNewUser.setForeground(Color.red);
        
        if (name.isEmpty()|last_name.isEmpty()|document_number.isEmpty()|email.isEmpty()){
            //crearUser.ErrorNewUser.setText("Rellene todos los espacios");
            return;
        }

        Servicio.createUser(name, last_name, document_number, email, vinculation, faculty, career);
        crearUser.ErrorNewUser.setForeground(Color.GREEN);
        crearUser.ErrorNewUser.setText("Usuario Creado Correctamente");
        crearUser.TxtNewUserName.setText("");
        crearUser.TxtNewUserApe.setText("");
        crearUser.TxtNewUserDoc.setText("");
        crearUser.TxtNewUserCorreo.setText("");
        crearUser.TxtNewUserCareer.setText("");
    }
    
    
}
