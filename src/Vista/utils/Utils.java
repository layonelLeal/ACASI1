package Vista.utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


public class Utils {
    public static void changeBackgroundColor(Component component, Color endColor, int duration) {
        if (duration <= 0) {
            throw new IllegalArgumentException("La duación tiene que ser mayor a 0.");
        }

        Color startColor = component.getBackground();
        int delay = 10; // Tiempo entre cada actualización (en milisegundos)
        int steps = Math.max(1, duration / delay); // Número de pasos para la transición

        int startRed = startColor.getRed();
        int startGreen = startColor.getGreen();
        int startBlue = startColor.getBlue();

        int endRed = endColor.getRed();
        int endGreen = endColor.getGreen();
        int endBlue = endColor.getBlue();

        Timer timer = new Timer(delay, new ActionListener() {
            int currentStep = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                float ratio = (float) currentStep / (float) steps;
                int red = (int) (startRed + ratio * (endRed - startRed));
                int green = (int) (startGreen + ratio * (endGreen - startGreen));
                int blue = (int) (startBlue + ratio * (endBlue - startBlue));

                component.setBackground(new Color(red, green, blue));

                currentStep++;
                if (currentStep > steps) {
                    component.setBackground(endColor); // Establecer el color final
                    ((Timer) e.getSource()).stop(); // Detener el timer al completar la transición
                }
            }
        });

        timer.start(); // Iniciar la transición
    }
}
