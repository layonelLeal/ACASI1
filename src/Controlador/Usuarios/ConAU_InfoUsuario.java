/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControladoresVisMod;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.AU_InfoUsuario;
import org.json.JSONObject;

/**
 *
 * @author User
 */
public class ConAU_InfoUsuario {
    
    private AU_InfoUsuario ViewInfoUser;
    
    public ConAU_InfoUsuario(AU_InfoUsuario ViewInfoUser, JSONObject findUser){
         this.ViewInfoUser = ViewInfoUser;
         
         if (findUser.length()==0){
            ViewInfoUser.ErrorUserNotFound.setText("No se encontro ningun usuario que coincidia con los datos ingresados");
            return;
        }
        
        ViewInfoUser.ShowUserName.setText(findUser.getString("name") + " " + findUser.getString("last_name"));
        Integer docNum = findUser.getInt("document_number");
        ViewInfoUser.ShowUserDoc.setText( docNum.toString());
        ViewInfoUser.ShowUserOtherInfo.setText(findUser.getString("email"));
     }
    
     public void Inicio(){
        ViewInfoUser.setLocation(0, 0);
        ViewInfoUser.setSize(0,0);

     }
     
    
}
