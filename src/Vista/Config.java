/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Vista.utils.UIConfig;
import javax.swing.JOptionPane;

/**
 *
 * @author layonel
 */
public class Config extends javax.swing.JPanel {

    /**
     * Creates new form Config
     */
    public Config() {
        initComponents();
    }
    
    private void confirm(){
        String[] buttons = {"Aceptar", "Cancelar"};
        int optionSelected = JOptionPane.showOptionDialog(null, "¿Desea reiniciar la aplicación para efectuar los cambios?", "Reiniciar Aplicación", 0, JOptionPane.QUESTION_MESSAGE, null, buttons, "Aceptar");
        if (optionSelected == 0){
            System.out.println("Cerrando...");
            System.exit(0);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel4 = new javax.swing.JPanel();
        panelRound1 = new Vista.utils.PanelRound();
        title1 = new Vista.components.Title();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        customLabel1 = new Vista.components.CustomLabel();
        fontSize = new Vista.components.CustomInput();
        customButton2 = new Vista.components.CustomButton();
        customLabel2 = new Vista.components.CustomLabel();
        jPanel3 = new javax.swing.JPanel();
        customButton1 = new Vista.components.CustomButton();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(200, 150));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.GridBagLayout());

        panelRound1.setBackground(UIConfig.getBg(300)
        );
        panelRound1.setBorder(javax.swing.BorderFactory.createEmptyBorder(25, 25, 25, 25));
        panelRound1.setMaximumSize(new java.awt.Dimension(800, 400));
        panelRound1.setPreferredSize(new java.awt.Dimension(350, 150));
        panelRound1.setRoundBottomLeft(30);
        panelRound1.setRoundBottomRight(30);
        panelRound1.setRoundTopLeft(30);
        panelRound1.setRoundTopRight(30);
        panelRound1.setLayout(new javax.swing.BoxLayout(panelRound1, javax.swing.BoxLayout.PAGE_AXIS));

        title1.setText("Configuración");
        title1.setAlignmentX(0.5F);
        panelRound1.add(title1);

        jLabel1.setText(" ");
        panelRound1.add(jLabel1);

        jPanel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 25));
        jPanel1.setLayout(new java.awt.GridLayout(2, 2, 5, 5));

        customLabel1.setText("Tamaño de letra (16): ");
        jPanel1.add(customLabel1);

        fontSize.setMaximumSize(new java.awt.Dimension(25, 40));
        fontSize.setPreferredSize(new java.awt.Dimension(170, 35));
        jPanel1.add(fontSize);

        customButton2.setText("Confirmar");
        customButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(customButton2);

        customLabel2.setText("Cambiar Modo");
        jPanel1.add(customLabel2);

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.GridBagLayout());

        customButton1.setText("Cambiar");
        customButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(customButton1, new java.awt.GridBagConstraints());

        jPanel1.add(jPanel3);

        panelRound1.add(jPanel1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 227;
        gridBagConstraints.ipady = 32;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(154, 14, 154, 15);
        jPanel4.add(panelRound1, gridBagConstraints);

        add(jPanel4);
    }// </editor-fold>//GEN-END:initComponents

    private void customButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customButton1ActionPerformed
        UIConfig.changeMode();
        confirm();
    }//GEN-LAST:event_customButton1ActionPerformed

    private void customButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customButton2ActionPerformed
        int size = Integer.parseInt(fontSize.getText());
        UIConfig.changeTextSize(size);
        updateUI();
        revalidate();
        repaint();
        confirm();
    }//GEN-LAST:event_customButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Vista.components.CustomButton customButton1;
    private Vista.components.CustomButton customButton2;
    private Vista.components.CustomLabel customLabel1;
    private Vista.components.CustomLabel customLabel2;
    private Vista.components.CustomInput fontSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private Vista.utils.PanelRound panelRound1;
    private Vista.components.Title title1;
    // End of variables declaration//GEN-END:variables
}
