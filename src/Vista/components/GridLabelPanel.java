package Vista.components;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class GridLabelPanel extends JPanel {

    private int rows;
    private int cols;
    private JLabel[][] labels;
    private final ImageIcon icon;
    private Consumer<Integer> iconClickListener; // Listener para clicks en etiquetas con icono
    private final Map<JLabel, Integer> labelToKeyMap = new HashMap<>(); // Mapa de JLabel a Integer key

    public GridLabelPanel() {
        super();
        this.icon = new ImageIcon(getClass().getResource("../recursos/imagenes/ordenador.png"));
    }

    public GridLabelPanel(int rows, int cols, Map<Integer, int[]> iconPositions) {
        this.rows = rows;
        this.cols = cols;
        this.icon = new ImageIcon(getClass().getResource("../recursos/imagenes/ordenador.png"));
        initializeGrid(iconPositions);
    }

    private void initializeGrid(Map<Integer, int[]> iconPositions) {
        setLayout(new GridLayout(rows, cols));
        labels = new JLabel[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                JLabel label = new JLabel();
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setVerticalAlignment(SwingConstants.CENTER);
                label.setOpaque(true);
                label.setBackground(Color.WHITE);

                // Añadir borde gris a cada celda
                label.setBorder(new LineBorder(Color.GRAY, 1));

                // Verificar si esta posición debería tener un icono
                Integer key = getIconKey(row, col, iconPositions);
                if (key != null) {
                    label.setIcon(icon);
                    labelToKeyMap.put(label, key); // Mapear JLabel a su clave

                    // Agregar listener solo a etiquetas con icono
                    label.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            if (iconClickListener != null) {
                                iconClickListener.accept(labelToKeyMap.get(label)); // Obtener la clave correspondiente
                            }
                        }
                    });
                }

                labels[row][col] = label;
                add(label);
            }
        }
    }

    private Integer getIconKey(int row, int col, Map<Integer, int[]> iconPositions) {
        for (Map.Entry<Integer, int[]> entry : iconPositions.entrySet()) {
            int[] position = entry.getValue();
            if (position[0] == row && position[1] == col) {
                return entry.getKey(); // Devolver la clave si la posición coincide
            }
        }
        return null;
    }

    // Método para establecer el listener para clicks en etiquetas con icono
    public void setIconClickListener(Consumer<Integer> iconClickListener) {
        this.iconClickListener = iconClickListener;
    }

    public void setRows(int rows) {
        this.rows = rows;
        initializeGrid(null);
    }

    public int getRows() {
        return rows;
    }

    public void setCols(int cols) {
        this.cols = cols;
        initializeGrid(null);
    }

    public int getCols() {
        return cols;
    }
}
