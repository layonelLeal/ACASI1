package Vista.utils;

import java.awt.Color;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class UIConfig {
    // Colores de fondo
    public static final Color BGWHITECOLOR = new Color(242, 242, 242);
    public static final Color BGWHITE300 = new Color(220, 220, 222);
    public static final Color BGWHITE500 = new Color(200, 200, 202);
    public static final Color BGDARKCOLOR = new Color(15, 15, 16);
    public static final Color BGDARK300 = new Color(55, 55, 57);
    public static final Color BGDARK500 = new Color(85, 85, 87);

    // Colores primarios
    public static final Color PRIMARY = new Color(75, 186, 197);
    public static final Color PRIMARY100 = new Color(57, 167, 178); 
    public static final Color PRIMARY300 = new Color(45, 157, 168); 
    public static final Color PRIMARY500 = new Color(35, 147, 158); 
    public static final Color PRIMARY700 = new Color(25, 135, 145); 
    public static final Color PRIMARY900 = new Color(15, 125, 135); 

    // Colores oscuros para modo oscuro
    public static final Color DARKPRIMARY = new Color(55, 166, 177);    // Nivel básico
    public static final Color DARKPRIMARY100 = new Color(10, 75, 85); // Más claro
    public static final Color DARKPRIMARY300 = new Color(20, 95, 105); // Medio
    public static final Color DARKPRIMARY500 = new Color(30, 115, 125); // Oscuro
    public static final Color DARKPRIMARY700 = new Color(40, 135, 145);  // Más oscuro
    public static final Color DARKPRIMARY900 = new Color(50, 155, 165);   // Más oscuro

    // Colores secundarios y complementarios
    public static final Color SECONDARY = new Color(168, 62, 1);
    public static final Color ACCENTCOLOR = new Color(255, 87, 34);

    // Colores de foreground
    public static final Color FOREGROUNDWHITE = new Color(33, 33, 33);
    public static final Color FOREGROUNDBLACK = new Color(242, 242, 242);

    private static final String PRIMARYFONT = "Segoe UI";

    public static Integer text_default = 14;
    public static Integer text_sm = 12;
    public static Integer text_md = 14;
    public static Integer text_lg = 16;
    public static Integer text_xl = 18;
    public static Integer text_2xl = 20;
    public static Integer text_3xl = 22;
    public static Integer text_4xl = 24;

    public static Boolean darkMode = false;

    private static final String CONFIG_FILE = "config.properties";
    private static final String DARK_MODE_KEY = "darkMode";
    private static final String TEXT_SIZE_KEY = "textSize";

    static {
        loadPreferences();
    }

    /**
     * Carga las preferencias desde el archivo de propiedades.
     */
    private static void loadPreferences() {
        Properties properties = new Properties();
        try (FileInputStream in = new FileInputStream(CONFIG_FILE)) {
            properties.load(in);
            darkMode = Boolean.parseBoolean(properties.getProperty(DARK_MODE_KEY, "false"));
            Integer savedTextSize = Integer.parseInt(properties.getProperty(TEXT_SIZE_KEY, text_default.toString()));
            updateSize(savedTextSize);
        } catch (IOException e) {
            System.out.println("No se pudo cargar el archivo de configuración. Usando valores por defecto.");
        }
    }

    /**
     * Guarda las preferencias en el archivo de propiedades.
     */
    private static void savePreferences() {
        Properties properties = new Properties();
        properties.setProperty(DARK_MODE_KEY, darkMode.toString());
        properties.setProperty(TEXT_SIZE_KEY, text_default.toString());
        try (FileOutputStream out = new FileOutputStream(CONFIG_FILE)) {
            properties.store(out, "Configuración de UI");
        } catch (IOException e) {
            System.out.println("No se pudo guardar el archivo de configuración.");
        }
    }

    /**
     * Actualiza los tamaños de texto según el tamaño por defecto.
     *
     * @param defaultSize El tamaño de texto por defecto.
     */
    public static void updateSize(Integer defaultSize) {
        text_default = defaultSize;
        text_sm = text_default - 2;
        text_md = text_default;
        text_lg = text_default + 2;
        text_xl = text_default + 4;
        text_2xl = text_default + 6;
        text_3xl = text_default + 8;
        text_4xl = text_default + 10;
        savePreferences(); // Guarda la preferencia actualizada
    }

    /**
     * Genera una fuente con el peso y tamaño especificado.
     *
     * @param fontWeight
     * @param size
     * @return
     */
    public static Font generateFont(Integer fontWeight, Integer size) {
        return new Font(PRIMARYFONT, fontWeight, size);
    }

    /**
     * Obtiene la fuente por defecto para el texto.
     *
     * @return
     */
    public static Font getDefaultFont() {
        return generateFont(Font.PLAIN, text_md);
    }

    /**
     * Obtiene la fuente por defecto para el subtítulo.
     *
     * @return
     */
    public static Font getSubtitleFont() {
        return generateFont(Font.BOLD, text_xl);
    }

    /**
     * Obtiene la fuente por defecto para el título.
     *
     * @return
     */
    public static Font getTitleFont() {
        return generateFont(Font.BOLD, text_2xl);
    }

    /**
     * Obtiene la fuente para un título extra grande.
     *
     * @return
     */
    public static Font getTitleXLFont() {
        return generateFont(Font.BOLD, text_4xl);
    }

    /**
     * Obtiene la fuente de tamaño medio.
     *
     * @return
     */
    public static Font getMediumFont() {
        return generateFont(Font.BOLD, text_md);
    }

    /**
     * Genera una nueva fuente según el tamaño de texto especificado.
     *
     * @param size
     * @return
     */
    public static Font generateFontBySize(Integer size) {
        return generateFont(Font.PLAIN, size);
    }

    /**
     * Devuelve el color de fondo.
     *    
     * @return
     */
    public static Color getBgColor() {
        return darkMode ? BGDARKCOLOR : BGWHITECOLOR;
    }

    /**
     * Devuelve el color de primer plano (foreground).
     *    
     * @return
     */
    public static Color getForeground() {
        return darkMode ? FOREGROUNDBLACK : FOREGROUNDWHITE;
    }

    /**
     * Devuelve el color primario ajustado para el modo actual.
     *    
     * @param shade El nivel de oscuridad deseado (100, 300, 500, 700, 900)
     * @return El color primario correspondiente.
     */
    public static Color getPrimaryColor(int shade) {
        if (darkMode) {
            switch (shade) {
                case 100:
                    return DARKPRIMARY100;
                case 300:
                    return DARKPRIMARY300;
                case 500:
                    return DARKPRIMARY500;
                case 700:
                    return DARKPRIMARY700;
                case 900:
                    return DARKPRIMARY900;
                default:
                    return DARKPRIMARY;
            }
        } else {
            switch (shade) {
                case 100:
                    return PRIMARY100;
                case 300:
                    return PRIMARY300;
                case 500:
                    return PRIMARY500;
                case 700:
                    return PRIMARY700;
                case 900:
                    return PRIMARY900;
                default:
                    return PRIMARY;
            }
        }
    }
    
    public static Color getBg(int shade) {
        if (darkMode) {
            switch (shade) {
                case 100:
                    return BGDARKCOLOR;
                case 300:
                    return BGDARK300;
                case 500:
                    return BGDARK500;
                default:
                    return BGDARKCOLOR;
            }
        } else {
            switch (shade) {
                case 100:
                    return BGWHITECOLOR;
                case 300:
                    return BGWHITE300;
                case 500:
                    return BGWHITE500;
                default:
                    return BGWHITECOLOR;
            }
        }
    }

    /**
     * Cambia el modo oscuro y guarda la preferencia.
     */
    public static void changeMode() {
        darkMode = !darkMode;
        savePreferences();
    }
    
    
    /**
     * Cambia el tamaño de la letra al tamaño especificado y guarda la preferencia.
     *
     * @param newSize El nuevo tamaño de la letra.
     */
    public static void changeTextSize(Integer newSize) {
        updateSize(newSize);
    }
    
    public static Color getSeccessColor(int shade){
        if (shade == 200){
            return new Color(80,170,80);
        }
        return new Color(90,180,90);
    }
    
    public static Color getDangerColor(int shade){
        if (shade == 200){
            return new Color(160,35,60);
        }
        return new Color(170,45,70);
    }
}
