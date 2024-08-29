package Vista.components;
import Vista.utils.UIConfig;
import javax.swing.JLabel;

public class Title extends JLabel{

    public Title() {
        super();
        setForeground(UIConfig.getForeground());
        setFont(UIConfig.getTitleFont());
    }
}
