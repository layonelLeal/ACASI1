package Vista;
import Controlador.Corresponsabilidad.ConCrearCorresponsabilidad;
import Controlador.Estadísticas.ControladorEstadisticas;
import Controlador.LoginController;
import Modelo.Servicio;
import Modelo.Users.Estudiante;
import Vista.utils.UIConfig;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class Aplication extends javax.swing.JFrame {
    final Color primary = new Color(75,186,197);
    final Color primary100 = new Color(57,167,178);
    public Aplication() {
        initComponents();
        ViewSalas vs = new ViewSalas(this);
        changeContent(vs);
        setIconImage(getIconImage());
        contHours.setVisible(false);
        if ("estudiante".equals(Servicio.role)){
            Estudiante currentStudent = Servicio.getStudent();
            btnAnalitics.setEnabled(false);
            btnAnalitics.setVisible(false);
            btnCorresponsability.setEnabled(false);
            btnCorresponsability.setVisible(false);
            contHours.setVisible(true);
            hoursLabel.setText(currentStudent.getJoint_responsability_hours().toString());
        }
        
    }
    
    public void changeContent(JPanel JP){
        JP.setSize(0, 0);
        JP.setLocation(0, 0);
        content.removeAll();
        content.add(JP);
        content.revalidate();
        content.repaint();
    }
    
    @Override
    public Image getIconImage() {
        Image newImage = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Vista/recursos/imagenes/LOGO.png"));
        return newImage;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        leftMenu = new javax.swing.JPanel();
        title1 = new Vista.components.Title();
        jPanel2 = new javax.swing.JPanel();
        customButton2 = new Vista.components.CustomButton();
        customButton3 = new Vista.components.CustomButton();
        btnAnalitics = new Vista.components.CustomButton();
        btnCorresponsability = new Vista.components.CustomButton();
        customButton1 = new Vista.components.CustomButton();
        jPanel1 = new javax.swing.JPanel();
        topMenu = new javax.swing.JPanel();
        currentPage = new Vista.components.CustomLabel();
        contOptions = new javax.swing.JPanel();
        contHours = new Vista.utils.PanelRound();
        customLabel2 = new Vista.components.CustomLabel();
        hoursLabel = new Vista.components.CustomLabel();
        btnClouse = new Vista.components.CustomButton("Cerrar Sesión", 2);
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
        jPanel2.setLayout(new java.awt.GridLayout(5, 0, 0, 5));

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

        btnAnalitics.setText("Analiticas");
        btnAnalitics.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAnalitics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnaliticsActionPerformed(evt);
            }
        });
        jPanel2.add(btnAnalitics);

        btnCorresponsability.setText("Corresponsabilidad");
        btnCorresponsability.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCorresponsability.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCorresponsabilityActionPerformed(evt);
            }
        });
        jPanel2.add(btnCorresponsability);

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
        java.awt.GridBagLayout topMenuLayout = new java.awt.GridBagLayout();
        topMenuLayout.columnWeights = new double[] {100.5};
        topMenu.setLayout(topMenuLayout);

        currentPage.setText("SALAS");
        topMenu.add(currentPage, new java.awt.GridBagConstraints());

        contOptions.setOpaque(false);
        contOptions.setLayout(new java.awt.GridBagLayout());

        contHours.setBackground(UIConfig.getPrimaryColor(700)
        );
        contHours.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        contHours.setForeground(UIConfig.getForeground());
        contHours.setRoundBottomLeft(10);
        contHours.setRoundBottomRight(10);
        contHours.setRoundTopLeft(10);
        contHours.setRoundTopRight(10);
        contHours.setLayout(new java.awt.GridLayout(1, 0, 5, 0));

        customLabel2.setForeground(UIConfig.getForeground());
        customLabel2.setText("Horas Pendientes:");
        contHours.add(customLabel2);

        hoursLabel.setForeground(UIConfig.getForeground());
        hoursLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hoursLabel.setText("0");
        contHours.add(hoursLabel);

        contOptions.add(contHours, new java.awt.GridBagConstraints());

        btnClouse.setText("Cerrar Sesión");
        btnClouse.setToolTipText("");
        btnClouse.setStyle(2);
        btnClouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClouseActionPerformed(evt);
            }
        });
        contOptions.add(btnClouse, new java.awt.GridBagConstraints());

        topMenu.add(contOptions, new java.awt.GridBagConstraints());

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
        currentPage.setText("Configuración");
    }//GEN-LAST:event_customButton1ActionPerformed

    private void customButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customButton2ActionPerformed
        ViewSalas vs = new ViewSalas(this);
        changeContent(vs);
        currentPage.setText("Salas");
    }//GEN-LAST:event_customButton2ActionPerformed

    private void customButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customButton3ActionPerformed
        AdministrarUsuarios AU = new AdministrarUsuarios();
        changeContent(AU);
        currentPage.setText("Usuarios");
    }//GEN-LAST:event_customButton3ActionPerformed

    private void btnAnaliticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnaliticsActionPerformed
        VistaEstadisticas va = new VistaEstadisticas();
        ControladorEstadisticas ce = new ControladorEstadisticas(va);
        changeContent(va);
        currentPage.setText("Estadisticas");
    }//GEN-LAST:event_btnAnaliticsActionPerformed

    private void btnCorresponsabilityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCorresponsabilityActionPerformed
        CrearCorresponsabilidad create = new CrearCorresponsabilidad();
        ConCrearCorresponsabilidad contol = new ConCrearCorresponsabilidad(create);
        contol.Inicio();
        changeContent(create);
        currentPage.setText("Corresponsabilidad");
    }//GEN-LAST:event_btnCorresponsabilityActionPerformed

    private void btnClouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClouseActionPerformed
        Servicio.cerrarSesion();
        btnClouse.setEnabled(false);
        this.removeAll();
        this.dispose();
        Login loginPage = new Login();
        LoginController lcrt = new LoginController(loginPage);
        lcrt.StartView();
        loginPage.setVisible(true);
    }//GEN-LAST:event_btnClouseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Vista.components.CustomButton btnAnalitics;
    private Vista.components.CustomButton btnClouse;
    private Vista.components.CustomButton btnCorresponsability;
    private Vista.utils.PanelRound contHours;
    private javax.swing.JPanel contOptions;
    private javax.swing.JPanel content;
    private Vista.components.CustomLabel currentPage;
    private Vista.components.CustomButton customButton1;
    private Vista.components.CustomButton customButton2;
    private Vista.components.CustomButton customButton3;
    private Vista.components.CustomLabel customLabel2;
    private Vista.components.CustomLabel hoursLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel leftMenu;
    private Vista.components.Title title1;
    private javax.swing.JPanel topMenu;
    // End of variables declaration//GEN-END:variables

}
