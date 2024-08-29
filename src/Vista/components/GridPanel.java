package Vista.components;

import Vista.utils.UIConfig;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;
import java.util.Map;

public class GridPanel extends JPanel {

    private int rows;
    private int cols;
    private final boolean[][] clickedPanels;
    private final Color hoverColor;
    private final Color defaultColor;
    private JPanel gridPanel;
    private final Map<Integer, int[]> selectedPanels;

    public GridPanel() {
        this(10, 10, UIConfig.getBg(500), UIConfig.getPrimaryColor(500));
    }

    public GridPanel(int rows, int cols, Color defaultColor, Color hoverColor) {
        super();
        this.rows = rows;
        this.cols = cols;
        this.hoverColor = hoverColor;
        this.defaultColor = defaultColor;
        this.clickedPanels = new boolean[rows][cols];
        this.selectedPanels = new LinkedHashMap<>();
        setLayout(new BorderLayout());
        createGrid(rows, cols);
    }

    private void createGrid(int rows, int cols) {
        if (gridPanel != null) {
            remove(gridPanel);
        }
        gridPanel = new JPanel(new GridLayout(rows, cols));
        gridPanel.setBackground(UIConfig.getBg(500));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        Color lightGrayBorder = UIConfig.getBg(300);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                CustomPanel panel = new CustomPanel(row, col);
                panel.setBackground(defaultColor);
                panel.setBorder(BorderFactory.createLineBorder(lightGrayBorder));
                gridPanel.add(panel);
            }
        }

        add(gridPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void setRows(int rows) {
        this.rows = rows;
        createGrid(rows, this.cols);
    }

    public int getRows() {
        return rows;
    }

    public void setCols(int cols) {
        this.cols = cols;
        createGrid(this.rows, cols);
    }

    public int getCols() {
        return cols;
    }

    public Map<Integer, int[]> getClickedPoints() {
        return new LinkedHashMap<>(selectedPanels);
    }

    private void togglePanelClicked(int row, int col, CustomPanel panel) {
        if (clickedPanels[row][col]) {
            clickedPanels[row][col] = false;
            selectedPanels.entrySet().removeIf(entry -> entry.getValue()[0] == row && entry.getValue()[1] == col);
            panel.clearNumber();
            updatePanelNumbers();
        } else {
            clickedPanels[row][col] = true;
            int order = selectedPanels.size() + 1;
            selectedPanels.put(order, new int[]{row, col});
            panel.setNumber(order);
        }
    }

    private boolean isPanelClicked(int row, int col) {
        return clickedPanels[row][col];
    }

    private void updatePanelNumbers() {
        int index = 1;
        for (Map.Entry<Integer, int[]> entry : selectedPanels.entrySet()) {
            int[] coordinates = entry.getValue();
            CustomPanel panel = (CustomPanel) gridPanel.getComponent(coordinates[0] * cols + coordinates[1]);
            panel.setNumber(index++);
        }
    }

    private class CustomPanel extends JPanel {

        private final int row;
        private final int col;
        private final JLabel numberLabel;

        public CustomPanel(int row, int col) {
            this.row = row;
            this.col = col;
            this.numberLabel = new JLabel("", SwingConstants.CENTER);
            addMouseListener(new PanelMouseListener());
            setLayout(new BorderLayout());
            add(numberLabel, BorderLayout.CENTER);
            this.setPreferredSize(new Dimension(40, 40));
        }

        public void setNumber(int number) {
            numberLabel.setText(String.valueOf(number));
        }

        public void clearNumber() {
            numberLabel.setText("");
        }

        private class PanelMouseListener extends MouseAdapter {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!isPanelClicked(row, col)) {
                    setBackground(hoverColor);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!isPanelClicked(row, col)) {
                    setBackground(defaultColor);
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                togglePanelClicked(row, col, CustomPanel.this);
                setBackground(isPanelClicked(row, col) ? hoverColor : defaultColor);
            }
        }
    }
}
