package acasi_supabaseconnection;

import Controlador.LoginController;
import Vista.Login;
import Vista.utils.UIConfig;

public class ACASI_SupabaseConnection {
    
    public static void main(String[] args) {
        UIConfig.updateSize(16);
        Login loginPage = new Login();
        LoginController lcrt = new LoginController(loginPage);
        lcrt.StartView();
        loginPage.setVisible(true);
    }
    
}
