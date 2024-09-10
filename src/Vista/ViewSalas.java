package Vista;

import Modelo.Sala;
import Modelo.Servicio;
import Vista.components.ComponentSala;
import Vista.utils.UIConfig;
import Vista.utils.Utils;
import java.awt.Color;
import java.awt.Cursor;

public class ViewSalas extends javax.swing.JPanel {
    private Aplication JFPrincipal;

    public ViewSalas(Aplication JF) {
        this.JFPrincipal = JF;
        Sala[] salas = Servicio.getRooms();
        System.out.println(salas.toString());
        initComponents();
        for (Sala sala : salas) {
            ComponentSala newSala = new ComponentSala(sala, JF);
            contentSalas.add(newSala);
        }
        if(Servicio.role == "estudiante"){
            contAddButton.setVisible(false);
            addButton.setEnabled(false);
            addButton.setVisible(false);
        }
        addButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        contentSalas = new Vista.utils.PanelRound();
        contAddButton = new javax.swing.JPanel();
        addButton = new Vista.utils.PanelRound();
        jLabel1 = new javax.swing.JLabel();

        setBackground(UIConfig.getBgColor());
        setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setLayout(new java.awt.BorderLayout());

        contentSalas.setBackground(UIConfig.getBgColor()
        );
        contentSalas.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 10, 5));
        contentSalas.setOpaque(true);
        contentSalas.setLayout(new java.awt.GridLayout(2, 0, 10, 10));
        add(contentSalas, java.awt.BorderLayout.CENTER);

        contAddButton.setBackground(UIConfig.getBg(300)
        );
        contAddButton.setPreferredSize(new java.awt.Dimension(0, 55));
        contAddButton.setLayout(new java.awt.GridBagLayout());

        addButton.setBackground(new Color(0, 170, 80));
        addButton.setMaximumSize(new java.awt.Dimension(100, 100));
        addButton.setMinimumSize(new java.awt.Dimension(45, 45));
        addButton.setPreferredSize(new java.awt.Dimension(50, 50));
        addButton.setRoundBottomLeft(100);
        addButton.setRoundBottomRight(100);
        addButton.setRoundTopLeft(100);
        addButton.setRoundTopRight(100);
        addButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addButtonMouseExited(evt);
            }
        });
        addButton.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/recursos/imagenes/add24.png"))); // NOI18N
        jLabel1.setFocusable(false);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setPreferredSize(new java.awt.Dimension(25, 32));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        addButton.add(jLabel1, gridBagConstraints);

        contAddButton.add(addButton, new java.awt.GridBagConstraints());

        add(contAddButton, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseExited
        Utils.changeBackgroundColor(addButton, new Color(0, 170, 80), 100);
    }//GEN-LAST:event_addButtonMouseExited

    private void addButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseEntered
        Utils.changeBackgroundColor(addButton, new Color(0, 200, 100), 100);
    }//GEN-LAST:event_addButtonMouseEntered

    private void addButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseClicked
        CreateSala cs = new CreateSala(JFPrincipal);
        JFPrincipal.changeContent(cs);
    }//GEN-LAST:event_addButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Vista.utils.PanelRound addButton;
    private javax.swing.JPanel contAddButton;
    private Vista.utils.PanelRound contentSalas;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
