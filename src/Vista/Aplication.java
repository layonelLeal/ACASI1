package Vista;
import Controlador.Estadísticas.ControladorEstadisticas;
import Vista.components.componentCorresponsabilidad;
import Vista.utils.UIConfig;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Aplication extends javax.swing.JFrame {
    final Color primary = new Color(75,186,197);
    final Color primary100 = new Color(57,167,178);
    public Aplication() {
        initComponents();
        ViewSalas vs = new ViewSalas(this);
        changeContent(vs);
        
    }
    
    public void changeContent(JPanel JP){
        JP.setSize(0, 0);
        JP.setLocation(0, 0);
        content.removeAll();
        content.add(JP);
        content.revalidate();
        content.repaint();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        leftMenu = new javax.swing.JPanel();
        title1 = new Vista.components.Title();
        jPanel2 = new javax.swing.JPanel();
        customButton2 = new Vista.components.CustomButton();
        customButton3 = new Vista.components.CustomButton();
        customButton4 = new Vista.components.CustomButton();
        customButton1 = new Vista.components.CustomButton();
        jPanel1 = new javax.swing.JPanel();
        topMenu = new javax.swing.JPanel();
        customLabel1 = new Vista.components.CustomLabel();
        content = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ACASI LOGIN");
        setExtendedState(MAXIMIZED_BOTH);
        setMinimumSize(new java.awt.Dimension(600, 700));

        leftMenu.setBackground(UIConfig.getPrimaryColor(100)
        );
        leftMenu.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 5, 10, 5));
        leftMenu.setMinimumSize(new java.awt.Dimension(1600, 311));
        leftMenu.setPreferredSize(new java.awt.Dimension(200, 0));

        title1.setText("ACASI");
        title1.setAlignmentX(0.5F);
        leftMenu.add(title1);

        jPanel2.setMinimumSize(new java.awt.Dimension(180, 220));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(180, 300));
        jPanel2.setLayout(new java.awt.GridLayout(4, 0, 0, 5));

        customButton2.setText("Salas");
        customButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        customButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(customButton2);

        customButton3.setText("Usuarios");
        customButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        customButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(customButton3);

        customButton4.setText("Analiticas");
        customButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        customButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(customButton4);

        customButton1.setText("Configuración");
        customButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        customButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(customButton1);

        leftMenu.add(jPanel2);

        getContentPane().add(leftMenu, java.awt.BorderLayout.WEST);

        jPanel1.setPreferredSize(new java.awt.Dimension(0, 70));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        topMenu.setBackground(UIConfig.getPrimaryColor(100)
        );
        topMenu.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        topMenu.setMaximumSize(new java.awt.Dimension(32767, 130));
        topMenu.setPreferredSize(new java.awt.Dimension(300, 50));
        topMenu.setLayout(new java.awt.GridLayout(1, 0));

        customLabel1.setText("SALAS");
        topMenu.add(customLabel1);

        jPanel1.add(topMenu);

        content.setBackground(UIConfig.getBgColor());
        content.setPreferredSize(jPanel1.getSize());
        content.setLayout(new javax.swing.BoxLayout(content, javax.swing.BoxLayout.LINE_AXIS));
        jPanel1.add(content);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void customButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customButton1ActionPerformed
        Config config = new Config();
        changeContent(config);
    }//GEN-LAST:event_customButton1ActionPerformed

    private void customButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customButton2ActionPerformed
        ViewSalas vs = new ViewSalas(this);
        changeContent(vs);
    }//GEN-LAST:event_customButton2ActionPerformed

    private void customButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customButton3ActionPerformed
        AdministrarUsuarios AU = new AdministrarUsuarios();
        changeContent(AU);
    }//GEN-LAST:event_customButton3ActionPerformed

    private void customButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customButton4ActionPerformed
        VistaEstadisticas va = new VistaEstadisticas();
        ControladorEstadisticas ce = new ControladorEstadisticas(va);
        changeContent(va);
    }//GEN-LAST:event_customButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel content;
    private Vista.components.CustomButton customButton1;
    private Vista.components.CustomButton customButton2;
    private Vista.components.CustomButton customButton3;
    private Vista.components.CustomButton customButton4;
    private Vista.components.CustomLabel customLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel leftMenu;
    private Vista.components.Title title1;
    private javax.swing.JPanel topMenu;
    // End of variables declaration//GEN-END:variables

}
