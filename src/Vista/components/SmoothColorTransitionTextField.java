package Vista.components;

import javax.swing.JTextField;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SmoothColorTransitionTextField extends JTextField {
    private Color startColor;
    private Color endColor;
    private int duration;
    private Timer timer;

    public SmoothColorTransitionTextField() {
        super();  // Llama al constructor de JTextField
    }

    public void setColors(Color startColor, Color endColor, int duration) {
        this.startColor = startColor;
        this.endColor = endColor;
        this.duration = duration;

        // Reinicia el temporizador si ya estaba en ejecución
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }

        timer = new Timer(10, new ActionListener() {
            private long startTime = -1;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (startTime == -1) {
                    startTime = System.currentTimeMillis();
                }
                long elapsedTime = System.currentTimeMillis() - startTime;
                float progress = Math.min(1.0f, (float) elapsedTime / duration);

                int r = (int) (startColor.getRed() + progress * (endColor.getRed() - startColor.getRed()));
                int g = (int) (startColor.getGreen() + progress * (endColor.getGreen() - startColor.getGreen()));
                int b = (int) (startColor.getBlue() + progress * (endColor.getBlue() - startColor.getBlue()));
                
                setBackground(new Color(r, g, b));

                if (progress >= 1.0f) {
                    timer.stop();
                }
            }
        });
        timer.start();
    }
    
    
}
