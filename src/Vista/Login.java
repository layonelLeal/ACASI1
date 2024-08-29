package Vista;

import java.awt.Cursor;
import java.awt.Toolkit;
import Vista.utils.UIConfig;
import java.awt.Image;
import javax.swing.plaf.basic.BasicButtonUI;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        btnLogin.setUI(new BasicButtonUI() {
            @Override
            protected void installDefaults(javax.swing.AbstractButton b) {
                super.installDefaults(b);
                b.setFocusPainted(false);
                b.setContentAreaFilled(false);
                b.setOpaque(true);
            }
        });
        setIconImage(getIconImage());
    } 
    
    public void isLoading(Boolean state){
        if (state){
            btnLogin.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            btnLogin.setEnabled(false);
            setCursor(new Cursor(Cursor.WAIT_CURSOR));
        }else{
            btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btnLogin.setEnabled(true);
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }

    @Override
    public Image getIconImage() {
        Image newImage = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Vista/recursos/imagenes/LOGO.png"));
        return newImage;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelRound1 = new Vista.utils.PanelRound();
        jPanel4 = new javax.swing.JPanel();
        panelRound2 = new Vista.utils.PanelRound();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        panelRound4 = new Vista.utils.PanelRound();
        panelRound3 = new Vista.utils.PanelRound();
        username = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        panelRound5 = new Vista.utils.PanelRound();
        panelRound6 = new Vista.utils.PanelRound();
        password = new javax.swing.JPasswordField();
        errorMessage = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        panelRound7 = new Vista.utils.PanelRound();
        btnLogin = new javax.swing.JButton();
        panelAcasi = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        title1 = new Vista.components.Title();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        setMinimumSize(new java.awt.Dimension(1100, 700));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.X_AXIS));

        panelRound1.setPreferredSize(new java.awt.Dimension(0, 0));

        jPanel4.setBackground(UIConfig.getBgColor());
        jPanel4.setPreferredSize(panelRound1.getPreferredSize());
        jPanel4.setLayout(new java.awt.GridBagLayout());

        panelRound2.setBackground(UIConfig.getBg(300)
        );
        panelRound2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 20, 20));
        panelRound2.setMinimumSize(new java.awt.Dimension(200, 289));
        panelRound2.setRoundBottomLeft(50);
        panelRound2.setRoundBottomRight(50);
        panelRound2.setRoundTopLeft(50);
        panelRound2.setRoundTopRight(50);
        panelRound2.setLayout(new javax.swing.BoxLayout(panelRound2, javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setBackground(UIConfig.PRIMARY);
        jPanel2.setMinimumSize(new java.awt.Dimension(150, 213));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(350, 231));
        java.awt.GridBagLayout jPanel2Layout = new java.awt.GridBagLayout();
        jPanel2Layout.columnWidths = new int[] {350};
        jPanel2.setLayout(jPanel2Layout);

        jPanel5.setMinimumSize(new java.awt.Dimension(200, 213));
        jPanel5.setOpaque(false);
        jPanel5.setPreferredSize(new java.awt.Dimension(350, 195));
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.Y_AXIS));

        jLabel2.setFont(UIConfig.getTitleXLFont());
        jLabel2.setForeground(UIConfig.getForeground());
        jLabel2.setText("Inciar Sesión");
        jLabel2.setAlignmentX(0.5F);
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 1, 10, 1));
        jPanel5.add(jLabel2);

        jLabel6.setFont(UIConfig.getDefaultFont());
        jLabel6.setForeground(UIConfig.getForeground());
        jLabel6.setText("Bienvenido a ACASI, la mejor aplicación ");
        jLabel6.setAlignmentX(0.5F);
        jPanel5.add(jLabel6);

        jLabel7.setFont(UIConfig.getDefaultFont());
        jLabel7.setForeground(UIConfig.getForeground());
        jLabel7.setText("para la gestión de aulas informáticas.");
        jLabel7.setAlignmentX(0.5F);
        jLabel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 1));
        jPanel5.add(jLabel7);

        jPanel6.setMinimumSize(new java.awt.Dimension(200, 0));
        jPanel6.setOpaque(false);
        jPanel6.setPreferredSize(new java.awt.Dimension(350, 250));
        java.awt.GridBagLayout jPanel6Layout = new java.awt.GridBagLayout();
        jPanel6Layout.columnWidths = new int[] {100};
        jPanel6Layout.rowHeights = new int[] {50};
        jPanel6.setLayout(jPanel6Layout);

        jLabel3.setFont(UIConfig.getDefaultFont());
        jLabel3.setForeground(UIConfig.getForeground());
        jLabel3.setText("Usuario: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel6.add(jLabel3, gridBagConstraints);

        panelRound4.setBackground(UIConfig.PRIMARY900);
        panelRound4.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        panelRound4.setRoundBottomLeft(20);
        panelRound4.setRoundBottomRight(20);
        panelRound4.setRoundTopLeft(20);
        panelRound4.setRoundTopRight(20);
        panelRound4.setLayout(new javax.swing.BoxLayout(panelRound4, javax.swing.BoxLayout.LINE_AXIS));

        panelRound3.setBackground(UIConfig.getBg(300));
        panelRound3.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 5));
        panelRound3.setPreferredSize(new java.awt.Dimension(164, 25));
        panelRound3.setRoundBottomLeft(15);
        panelRound3.setRoundBottomRight(15);
        panelRound3.setRoundTopLeft(15);
        panelRound3.setRoundTopRight(15);
        panelRound3.setLayout(new javax.swing.BoxLayout(panelRound3, javax.swing.BoxLayout.LINE_AXIS));

        username.setBackground(UIConfig.getBg(300));
        username.setColumns(15);
        username.setFont(UIConfig.getDefaultFont());
        username.setForeground(UIConfig.getForeground());
        username.setText("lleald@unal.edu.co");
        username.setBorder(null);
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        panelRound3.add(username);

        panelRound4.add(panelRound3);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel6.add(panelRound4, gridBagConstraints);

        jLabel4.setFont(UIConfig.getDefaultFont());
        jLabel4.setForeground(UIConfig.getForeground());
        jLabel4.setText("Contraseña:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel6.add(jLabel4, gridBagConstraints);

        panelRound5.setBackground(UIConfig.PRIMARY900);
        panelRound5.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        panelRound5.setRoundBottomLeft(20);
        panelRound5.setRoundBottomRight(20);
        panelRound5.setRoundTopLeft(20);
        panelRound5.setRoundTopRight(20);
        panelRound5.setLayout(new javax.swing.BoxLayout(panelRound5, javax.swing.BoxLayout.LINE_AXIS));

        panelRound6.setBackground(UIConfig.getBg(300)
        );
        panelRound6.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 5));
        panelRound6.setRoundBottomLeft(15);
        panelRound6.setRoundBottomRight(15);
        panelRound6.setRoundTopLeft(15);
        panelRound6.setRoundTopRight(15);
        panelRound6.setLayout(new javax.swing.BoxLayout(panelRound6, javax.swing.BoxLayout.LINE_AXIS));

        password.setBackground(UIConfig.getBg(300));
        password.setFont(UIConfig.getDefaultFont());
        password.setForeground(UIConfig.getForeground());
        password.setText("acasiadmin");
        password.setBorder(null);
        panelRound6.add(password);

        panelRound5.add(panelRound6);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel6.add(panelRound5, gridBagConstraints);

        jPanel5.add(jPanel6);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 85;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel2.add(jPanel5, gridBagConstraints);

        errorMessage.setFont(UIConfig.getDefaultFont());
        errorMessage.setForeground(new java.awt.Color(255, 51, 51));
        errorMessage.setAlignmentX(0.5F);
        errorMessage.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 1, 10, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        jPanel2.add(errorMessage, gridBagConstraints);

        panelRound2.add(jPanel2);

        jLabel5.setText(" ");
        jLabel5.setMaximumSize(new java.awt.Dimension(3, 18));
        jLabel5.setMinimumSize(new java.awt.Dimension(3, 18));
        jLabel5.setPreferredSize(new java.awt.Dimension(3, 18));
        panelRound2.add(jLabel5);

        panelRound7.setBackground(UIConfig.getPrimaryColor(700)
        );
        panelRound7.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panelRound7.setRoundBottomLeft(20);
        panelRound7.setRoundBottomRight(20);
        panelRound7.setRoundTopLeft(20);
        panelRound7.setRoundTopRight(20);
        panelRound7.setLayout(new javax.swing.BoxLayout(panelRound7, javax.swing.BoxLayout.PAGE_AXIS));

        btnLogin.setBackground(UIConfig.getPrimaryColor(700)
        );
        btnLogin.setFont(UIConfig.getMediumFont());
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Ingresar");
        btnLogin.setAlignmentX(0.5F);
        btnLogin.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 30, 10, 30));
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.setMargin(new java.awt.Insets(5, 20, 5, 20));
        btnLogin.setMaximumSize(new java.awt.Dimension(600, 150));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        panelRound7.add(btnLogin);

        panelRound2.add(panelRound7);

        jPanel4.add(panelRound2, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
        );

        getContentPane().add(panelRound1);

        panelAcasi.setBackground(UIConfig.getBgColor());
        panelAcasi.setOpaque(false);
        panelAcasi.setPreferredSize(new java.awt.Dimension(0, 0));

        jPanel1.setBackground(UIConfig.getBgColor());
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel1.setVerifyInputWhenFocusTarget(false);
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel3.setBackground(UIConfig.getBgColor());
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.PAGE_AXIS));

        title1.setText("ACASI");
        jPanel3.add(title1);

        jPanel1.add(jPanel3, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout panelAcasiLayout = new javax.swing.GroupLayout(panelAcasi);
        panelAcasi.setLayout(panelAcasiLayout);
        panelAcasiLayout.setHorizontalGroup(
            panelAcasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
        );
        panelAcasiLayout.setVerticalGroup(
            panelAcasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
        );

        getContentPane().add(panelAcasi);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLoginActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnLogin;
    public javax.swing.JLabel errorMessage;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel panelAcasi;
    private Vista.utils.PanelRound panelRound1;
    private Vista.utils.PanelRound panelRound2;
    private Vista.utils.PanelRound panelRound3;
    private Vista.utils.PanelRound panelRound4;
    private Vista.utils.PanelRound panelRound5;
    private Vista.utils.PanelRound panelRound6;
    public Vista.utils.PanelRound panelRound7;
    public javax.swing.JPasswordField password;
    private Vista.components.Title title1;
    public javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
