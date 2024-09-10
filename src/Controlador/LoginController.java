package Controlador;

import Modelo.Servicio;
import Vista.Aplication;
import Vista.Login;
import Vista.utils.UIConfig;
import Vista.utils.Utils;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import org.json.JSONObject;

public class LoginController{
    private Login login;

    public LoginController(Login login) {
        this.login = login;
        this.login.btnLogin.addActionListener((java.awt.event.ActionEvent evt) -> {
            btnLoginActionPerformed();
        });
        this.login.password.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == 10){
                    btnLoginActionPerformed();
                }
            }
        });
        this.login.btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLoginMouseEntered(evt);
            }
            
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoginMouseEntered(evt);
            }
            
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt){
                 btnLoginMouseEntered(evt);
            }
            
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt){
                btnLoginMouseEntered(evt);
            }
            
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLoginMouseExited(evt);
            }
        });
    }
    
    public void StartView(){
        login.setTitle("Login ACASI");
        login.setLocationRelativeTo(null);
    }
    
    private void btnLoginActionPerformed(){
        login.isLoading(true);
        String passwordFormated = new String(login.password.getPassword());
        String usernameText = login.username.getText();

        if (usernameText.isEmpty() | passwordFormated.isEmpty()){
            login.errorMessage.setText("Recuerda completar todos los campos.");
            login.isLoading(false);
            return;
        }

        if (!usernameText.contains("@")){
            login.errorMessage.setText("El usuario no es valido.");
            login.isLoading(false);
            return;
        }

        JSONObject data = Servicio.iniciarSesion(usernameText, passwordFormated);

        if (data.has("errorMessage")){
            login.errorMessage.setText(data.getString("errorMessage"));
            login.isLoading(false);
            return;
        }       

        Aplication application = new Aplication();
        application.setVisible(true);
        login.setVisible(false);
        login.errorMessage.setText("");
        login.isLoading(false);
    }
        
    private void btnLoginMouseExited(java.awt.event.MouseEvent evt) {
        if (UIConfig.darkMode){
            Utils.changeBackgroundColor(login.panelRound7, UIConfig.getPrimaryColor(700), 100);
            Utils.changeBackgroundColor(login.btnLogin, UIConfig.getPrimaryColor(700), 100);
        }else{
            Utils.changeBackgroundColor(login.panelRound7, UIConfig.getPrimaryColor(500), 100);
            Utils.changeBackgroundColor(login.btnLogin, UIConfig.getPrimaryColor(500), 100);
        }
        
    }                                    

    private void btnLoginMouseEntered(java.awt.event.MouseEvent evt) {     
        if (UIConfig.darkMode){
            Utils.changeBackgroundColor(login.panelRound7, UIConfig.getPrimaryColor(500), 100);
            Utils.changeBackgroundColor(login.btnLogin, UIConfig.getPrimaryColor(500), 100);
        }else{
            Utils.changeBackgroundColor(login.panelRound7, UIConfig.getPrimaryColor(900), 100);
            Utils.changeBackgroundColor(login.btnLogin, UIConfig.getPrimaryColor(900), 100);
        }
    }  
}
