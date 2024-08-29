package Controlador.Usuarios;

import ControladoresVisMod.ConAU_InfoUsuario;
import Modelo.Servicio;
import Vista.AU_BuscarUsuario;
import Vista.AU_InfoUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.json.JSONObject;

public class ConAU_BuscarUsuario implements ActionListener{

     private AU_BuscarUsuario VerBusUsuario;
     JSONObject findUser = new JSONObject();
     
     public ConAU_BuscarUsuario(AU_BuscarUsuario VerBusUsuario){
         this.VerBusUsuario = VerBusUsuario;
         this.VerBusUsuario.BtoBuscar.addActionListener(this);
     }
     
     public void Inicio(){
        VerBusUsuario.setLocation(0, 0);
        VerBusUsuario.setSize(0,0);

     }
     

    @Override
    public void actionPerformed(ActionEvent e) {
        String NomUsuario = VerBusUsuario.TxtSearchName.getText();
        String ApeUsuario = VerBusUsuario.TxtSearchApe.getText();
        String DocUsuario = VerBusUsuario.TxtSearchDoc.getText();
        if ((NomUsuario.isEmpty())&&(ApeUsuario.isEmpty())&&(DocUsuario.isEmpty())){
            VerBusUsuario.errorSearch.setText("Ingrese un dato en algno de los espacios");
            return;
        }
        findUser = Servicio.searchUser(NomUsuario, ApeUsuario, DocUsuario);
        
        AU_InfoUsuario ViewInfoUser = new AU_InfoUsuario(findUser);
        ConAU_InfoUsuario ConInUser = new ConAU_InfoUsuario(ViewInfoUser, findUser);
        ConInUser.Inicio();
        
        VerBusUsuario.PanBuscarUsu.removeAll();
        VerBusUsuario.PanBuscarUsu.add(ViewInfoUser);
        VerBusUsuario.PanBuscarUsu.revalidate();
        VerBusUsuario.PanBuscarUsu.repaint();
    }

}
