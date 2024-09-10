package acasi_supabaseconnection;

import Controlador.LoginController;
import Vista.Login;

public class ACASI_SupabaseConnection {
    
    public static void main(String[] args) {
        Login loginPage = new Login();
        LoginController lcrt = new LoginController(loginPage);
        lcrt.StartView();
        loginPage.setVisible(true);
    }
    
}
