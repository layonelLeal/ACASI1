package Vista.components;

import Vista.utils.PanelRound;
import Vista.utils.UIConfig;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;

public class CustomInput extends javax.swing.JPanel {

    private PanelRound outerPanel;
    private PanelRound innerPanel;
    public JTextField field;

    public CustomInput() {
        super();
        initComponents();
    }

    private void initComponents() {
        // Outer panel configuration
        setBackground(UIConfig.getBg(300));
        setOpaque(false);
        UIConfig.generateFontBySize(UIConfig.text_sm);
        outerPanel = new PanelRound();
        outerPanel.setBackground(UIConfig.getPrimaryColor(900));
        outerPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        outerPanel.setRoundBottomLeft(20);
        outerPanel.setRoundBottomRight(20);
        outerPanel.setRoundTopLeft(20);
        outerPanel.setRoundTopRight(20);
        outerPanel.setLayout(new BoxLayout(outerPanel, BoxLayout.LINE_AXIS));

        // Inner panel configuration
        innerPanel = new PanelRound();
        innerPanel.setBackground(UIConfig.getBg(300));
        innerPanel.setBorder(BorderFactory.createEmptyBorder(5, 7, 5, 7));
        innerPanel.setPreferredSize(new java.awt.Dimension(164, 25));
        innerPanel.setRoundBottomLeft(15);
        innerPanel.setRoundBottomRight(15);
        innerPanel.setRoundTopLeft(15);
        innerPanel.setRoundTopRight(15);
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.LINE_AXIS));

        // Username field configuration
        field = new JTextField();
        field.setBackground(UIConfig.getBg(300));
        field.setColumns(15);
        field.setFont(UIConfig.getDefaultFont());
        field.setText("");
        field.setBorder(null);
        field.setForeground(UIConfig.getForeground());

        // Add the username field to the inner panel
        innerPanel.add(field);

        // Add the inner panel to the outer panel
        outerPanel.add(innerPanel);

        // Add the outer panel to this component
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.add(outerPanel);
    }

    public JTextField getField() {
        return field;
    }

    // Método para establecer el texto del JTextField
    public void setText(String text) {
        field.setText(text);
    }

    // Método para obtener el texto del JTextField
    public String getText() {
        return field.getText();
    }
}
