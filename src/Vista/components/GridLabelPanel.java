package Vista.components;

import Modelo.Sesion;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class GridLabelPanel extends JPanel {

    private int rows;
    private int cols;
    private JLabel[][] labels;
    private final ImageIcon iconOcupado;
    private final ImageIcon iconLibre;
    private Consumer<Integer> iconClickListener;
    private final Map<JLabel, Integer> labelToKeyMap = new HashMap<>();
    private final Map<Integer, Sesion> formatedSession;
    private Map<Integer, int[]> iconPositions;
    private final Map<Point, JLabel> positionToLabelMap = new HashMap<>();
    private JLabel selectedLabel = null;

    // Constructor por defecto
    public GridLabelPanel() {
        super();
        this.iconOcupado = new ImageIcon(getClass().getResource("/Vista/recursos/imagenes/ordenador.png"));
        this.iconLibre = new ImageIcon(getClass().getResource("/Vista/recursos/imagenes/ordenadorFree.png"));
        this.formatedSession = new HashMap<>();
        setFocusable(true);
    }

    // Constructor con parámetros
    public GridLabelPanel(int rows, int cols, Map<Integer, int[]> iconPositions, Map<Integer, Sesion> formatedSession) {
        this.rows = rows;
        this.cols = cols;
        this.iconPositions = iconPositions;
        this.iconOcupado = new ImageIcon(getClass().getResource("/Vista/recursos/imagenes/ordenador.png"));
        this.iconLibre = new ImageIcon(getClass().getResource("/Vista/recursos/imagenes/ordenadorFree.png"));
        this.formatedSession = formatedSession;
        setFocusable(true); // Permite que el panel reciba el foco
        initializeGrid(this.iconPositions);
    }
    
    public void updateIcons(Map<Integer, Sesion> sesiones) {
        for (Map.Entry<JLabel, Integer> entry : labelToKeyMap.entrySet()) {
            JLabel label = entry.getKey();
            Integer key = entry.getValue();
            label.setIcon(sesiones.containsKey(key) ? iconOcupado : iconLibre);
        }
        this.repaint();
    }

    private void initializeGrid(Map<Integer, int[]> iconPositions) {
        setLayout(new GridLayout(rows, cols));
        labels = new JLabel[rows][cols];
        positionToLabelMap.clear();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                JLabel label = new JLabel();
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setVerticalAlignment(SwingConstants.CENTER);
                label.setOpaque(true);
                label.setBackground(Color.WHITE);
                label.setBorder(new LineBorder(Color.GRAY, 1));
                label.setFocusable(false);
                label.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                Integer key = getIconKey(row, col, iconPositions);
                if (key != null) {
                    label.setIcon(formatedSession.containsKey(key) ? iconOcupado : iconLibre);
                    labelToKeyMap.put(label, key);
                    positionToLabelMap.put(new Point(row, col), label);

                    label.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            if (SwingUtilities.isLeftMouseButton(e)) {
                                handleLabelClick(label);
                                if (iconClickListener != null) {
                                    iconClickListener.accept(labelToKeyMap.get(label));
                                }
                            }
                        }
                    });

                    label.addFocusListener(new FocusAdapter() {
                        @Override
                        public void focusGained(FocusEvent e) {
                            label.setBackground(Color.LIGHT_GRAY);
                        }

                        @Override
                        public void focusLost(FocusEvent e) {
                            label.setBackground(Color.WHITE);
                        }
                    });

                    //label.setFocusable(true);
                }

                labels[row][col] = label;
                add(label);
            }
        }
    }

    private void handleLabelClick(JLabel clickedLabel) {
        if (selectedLabel != null && selectedLabel != clickedLabel) {
            selectedLabel.setBackground(Color.WHITE);
        }
        clickedLabel.setBackground(Color.LIGHT_GRAY);
        selectedLabel = clickedLabel;
    }

    public void clearSelections() {
        if (selectedLabel != null) {
            selectedLabel.setBackground(Color.WHITE);
            selectedLabel = null;
        }
    }

    private Integer getIconKey(int row, int col, Map<Integer, int[]> iconPositions) {
        for (Map.Entry<Integer, int[]> entry : iconPositions.entrySet()) {
            int[] position = entry.getValue();
            if (position[0] == row && position[1] == col) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void setIconClickListener(Consumer<Integer> iconClickListener) {
        this.iconClickListener = iconClickListener;
    }

    public void setRows(int rows) {
        this.rows = rows;
        initializeGrid(iconPositions);
    }

    public int getRows() {
        return rows;
    }

    public void setCols(int cols) {
        this.cols = cols;
        initializeGrid(iconPositions);
    }

    public int getCols() {
        return cols;
    }
    
    private int getLabelRow(JLabel label) {
        return labelToKeyMap.entrySet().stream()
                .filter(entry -> entry.getKey() == label)
                .map(entry -> positionToLabelMap.entrySet().stream()
                        .filter(e -> e.getValue() == label)
                        .map(e -> e.getKey().x)
                        .findFirst().orElse(-1))
                .findFirst().orElse(-1);
    }

    private int getLabelCol(JLabel label) {
        return labelToKeyMap.entrySet().stream()
                .filter(entry -> entry.getKey() == label)
                .map(entry -> positionToLabelMap.entrySet().stream()
                        .filter(e -> e.getValue() == label)
                        .map(e -> e.getKey().y)
                        .findFirst().orElse(-1))
                .findFirst().orElse(-1);
    }
}
