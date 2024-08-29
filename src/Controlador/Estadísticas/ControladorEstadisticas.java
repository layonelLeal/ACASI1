package Controlador.Estadísticas;

import Modelo.Sala;
import Modelo.Servicio;
import Vista.VistaEstadisticas;
import Vista.VistaGraficoFacultades;
import Vista.VistaGrafico;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Date;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;


/**
 *
 * @author Lenovo
 */
public class ControladorEstadisticas {
    private final VistaEstadisticas vistaEstadisticas;
    private final Sala[] currentSalas;
    private ControladorGraficoAño controladorGraficoAño;
    private ControladorGraficoMeses controladorGraficoMeses;
    private ControladorGraficoDiasDelAño controladorGraficoDiasDelAño;
    private ControladorGraficoFacultades controladorGraficoFacultades;

    public ControladorEstadisticas(VistaEstadisticas vistaEstadisticas) {
        this.vistaEstadisticas = vistaEstadisticas;
        this.currentSalas = Servicio.getRooms();


        String[] keySalas = new String[this.currentSalas.length];
        Integer contador = 0;
        for (Sala sala : this.currentSalas) { 
            keySalas[contador] = sala.getName();
            contador++;
            System.out.println("-------------------");
            System.out.println(Arrays.toString(keySalas));
        }

        ComboBoxModel cbm = new DefaultComboBoxModel(keySalas);
        vistaEstadisticas.comboBoxSelecciónSala.setModel(cbm);

        this.vistaEstadisticas.buttonGenerarGrafico.addActionListener((java.awt.event.ActionEvent evt) -> {
            buttonCreateChartActionPerformed(evt);
        });
        this.vistaEstadisticas.comboBoxSeleccionTipoGrafico.addActionListener((java.awt.event.ActionEvent evt) -> {
            comboBoxChangeTypeOFChartActionPerformed(evt);
        });

    }


    // Método para obtener la sala seleccionada
    private Integer obtenerSalaSeleccionada(String selectedSala) {
        for (Sala sala : currentSalas) {
            if (sala.getName().equals(selectedSala)) {
                return sala.getId();
            }
        }
        return null;
    }


    // Método para configurar un gráfico
    private void configurarVistaGrafico(VistaGrafico VG, VistaGraficoFacultades VGF) {
        VG.setSize(0, 0);
        VG.setLocation(0, 0);
        VG.setSize(0, 0);
        VG.setLocation(0, 0);

        vistaEstadisticas.panelSolicitaRango.removeAll();
        vistaEstadisticas.panelSolicitaRango.add(VG);
        vistaEstadisticas.panelSolicitaRango.revalidate();
        vistaEstadisticas.panelSolicitaRango.repaint();

        vistaEstadisticas.panelSolicitaSala.removeAll();
        vistaEstadisticas.panelSolicitaSala.add(VGF);
        vistaEstadisticas.panelSolicitaSala.revalidate();
        vistaEstadisticas.panelSolicitaSala.repaint();
    }


    
    // Método para manejar la creación y configuración del gráfico
    

    public void buttonCreateChartActionPerformed(ActionEvent e) {
        System.out.println("Se presionó el botón");
        Date start_time = vistaEstadisticas.fechaInicialDateChooser.getDate();
        Date finish_time = vistaEstadisticas.fechaFinalDateChooser.getDate();
        String selectedSala = vistaEstadisticas.comboBoxSelecciónSala.getSelectedItem().toString();
        Integer sala_id = obtenerSalaSeleccionada(selectedSala);
        String selectedVisualization = vistaEstadisticas.comboBoxSeleccionVisualizacion.getSelectedItem().toString();
        VistaGrafico VG = new VistaGrafico();
        VistaGraficoFacultades VGF = new VistaGraficoFacultades();
        
        switch (selectedVisualization) {
            case "Año" ->                 {
                    controladorGraficoAño = new ControladorGraficoAño(VG, start_time, finish_time, sala_id);
                    controladorGraficoFacultades = new ControladorGraficoFacultades(VGF, start_time, finish_time, sala_id);
                    configurarVistaGrafico(VG, VGF);
                }
            case "Meses" ->                 {
                    controladorGraficoMeses = new ControladorGraficoMeses(VG, start_time, finish_time, sala_id);
                    controladorGraficoFacultades = new ControladorGraficoFacultades(VGF, start_time, finish_time, sala_id);
                    configurarVistaGrafico(VG,VGF);
                }
            case "Días del Año" ->                 {
                    controladorGraficoDiasDelAño = new ControladorGraficoDiasDelAño(VG, start_time, finish_time, sala_id);
                    controladorGraficoFacultades = new ControladorGraficoFacultades(VGF, start_time, finish_time, sala_id);
                    configurarVistaGrafico(VG,VGF);
                }
            default -> {
            }
        }
        
    }

    public void comboBoxChangeTypeOFChartActionPerformed(ActionEvent e) {
        System.out.println("Se presionó el botón para cambiar de gráfico");
        Date start_time = vistaEstadisticas.fechaInicialDateChooser.getDate();
        Date finish_time = vistaEstadisticas.fechaFinalDateChooser.getDate();
        String selectedSala = vistaEstadisticas.comboBoxSelecciónSala.getSelectedItem().toString();
        Integer sala_id = obtenerSalaSeleccionada(selectedSala);
        String selectedVisualization = vistaEstadisticas.comboBoxSeleccionVisualizacion.getSelectedItem().toString();
        String selectedChartVisualization = vistaEstadisticas.comboBoxSeleccionTipoGrafico.getSelectedItem().toString();
        
        VistaGrafico VG = new VistaGrafico();
        VistaGraficoFacultades VGF = new VistaGraficoFacultades();
        
        switch (selectedVisualization) {
            case "Año" -> {
                controladorGraficoAño = new ControladorGraficoAño(VG, start_time, finish_time, sala_id, selectedChartVisualization);
                controladorGraficoFacultades = new ControladorGraficoFacultades(VGF, start_time, finish_time, sala_id);
                configurarVistaGrafico(VG, VGF);
            }
            case "Meses" -> {
                controladorGraficoMeses = new ControladorGraficoMeses(VG, start_time, finish_time, sala_id, selectedChartVisualization);
                controladorGraficoFacultades = new ControladorGraficoFacultades(VGF, start_time, finish_time, sala_id);
                configurarVistaGrafico(VG, VGF);
            }
            case "Días del Año" -> {
                controladorGraficoDiasDelAño = new ControladorGraficoDiasDelAño(VG, start_time, finish_time, sala_id, selectedChartVisualization);
                controladorGraficoFacultades = new ControladorGraficoFacultades(VGF, start_time, finish_time, sala_id);
                configurarVistaGrafico(VG, VGF);
            }
            default -> {}
        }

    }
   
}