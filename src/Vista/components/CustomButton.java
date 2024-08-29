package Vista.components;

import Vista.utils.UIConfig;
import Vista.utils.Utils;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicButtonUI;

public class CustomButton extends JButton {
    int style = 0;
    
    public CustomButton() {
        super();
        configureButton();
    }

    public CustomButton(String text) {
        super(text);
        configureButton();
    }
    
    public CustomButton(String text, int style) {
        super(text);
        this.style = style;
        configureButton();
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }
    
    private Color getPrimaryColor(){
        if (style == 0){
            return UIConfig.getPrimaryColor(500);
        }
        if (style == 1){
            return UIConfig.getSeccessColor(100);
        }
        if (style == 2){
            return UIConfig.getDangerColor(100);
        }
        return UIConfig.getPrimaryColor(500);
    }
    
    private Color getSecondaryColor(){
        if (style == 0){
            return UIConfig.getPrimaryColor(700);
        }
        if (style == 1){
            return UIConfig.getSeccessColor(200);
        }
        if (style == 2){
            return UIConfig.getDangerColor(200);
        }
        return UIConfig.getPrimaryColor(700);
    }
    
    private void configureButton() {
        setUI(new BasicButtonUI() {
            @Override
            protected void installDefaults(javax.swing.AbstractButton b) {
                super.installDefaults(b);
                b.setFocusPainted(false);
                b.setContentAreaFilled(false);
                b.setOpaque(true);
            }
        });

        setBackground(getPrimaryColor());
        setFont(UIConfig.getDefaultFont());
        setForeground(UIConfig.BGWHITECOLOR);
        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setMargin(new java.awt.Insets(5, 20, 5, 20));
        setMaximumSize(new java.awt.Dimension(600, 150));

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLoginMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLoginMouseExited(evt);
            }
        });
    }

    private void btnLoginMouseExited(java.awt.event.MouseEvent evt) {                     
        Utils.changeBackgroundColor(this, getPrimaryColor(), 100);
    }                                    

    private void btnLoginMouseEntered(java.awt.event.MouseEvent evt) { 
        Utils.changeBackgroundColor(this, getSecondaryColor(), 100);
    }  

    public void setLoadingState(boolean isLoading) {
        if (isLoading) {
            setCursor(new Cursor(Cursor.WAIT_CURSOR));
            setEnabled(false);
        } else {
            setCursor(new Cursor(Cursor.HAND_CURSOR));
            setEnabled(true);
        }
    }
}
