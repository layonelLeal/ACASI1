package Controlador.Estadísticas;

import Modelo.Servicio;
import Vista.VistaGraficoFacultades;
import java.awt.BorderLayout;
import java.awt.Color;
import java.text.ParseException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Lenovo
 */
public class ControladorGraficoFacultades {
    private VistaGraficoFacultades vistaGraficoFacultades;
    private Date start_time;
    private Date finish_time;
    private Integer sala_id;

    public ControladorGraficoFacultades(VistaGraficoFacultades vistaGraficoFacultades, Date start_time, Date finish_time, Integer sala_id) {
        this.vistaGraficoFacultades = vistaGraficoFacultades;
        this.start_time = start_time;
        this.finish_time = finish_time;
        this.sala_id = sala_id;
        try {
            showPieChart();
        } catch (ParseException ex) {
            Logger.getLogger(ControladorGraficoFacultades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public JFreeChart showPieChart() throws ParseException{
        
        //create dataset
        DefaultPieDataset barDataset = new DefaultPieDataset( );
        LinkedHashMap<String, Integer> facultyData = Servicio.getFaculty(start_time, finish_time, sala_id);
        
        for(Map.Entry<String, Integer> month : facultyData.entrySet()){
            String key = month.getKey();
            Integer value = month.getValue();
            
            // Imprimir la clave y el valor
            System.out.println("Clave: " + key + ", Valor: " + value);
            barDataset.setValue(key, value);
        }

        //create chart
        JFreeChart piechart = ChartFactory.createPieChart("Sesiones/Facultad",barDataset, false,true,false);//explain
      
        PiePlot piePlot =(PiePlot) piechart.getPlot();
      
        //changing pie chart blocks colors
        piePlot.setSectionPaint("IPhone 5s", new Color(255,255,102));
        piePlot.setSectionPaint("SamSung Grand", new Color(102,255,102));
        piePlot.setSectionPaint("MotoG", new Color(255,102,153));
        piePlot.setSectionPaint("Nokia Lumia", new Color(0,204,204));

        piePlot.setBackgroundPaint(Color.white);
        
        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        vistaGraficoFacultades.panelGraficoFacultades.removeAll();
        vistaGraficoFacultades.panelGraficoFacultades.add(barChartPanel, BorderLayout.CENTER);
        vistaGraficoFacultades.panelGraficoFacultades.validate();
        return piechart;
    }
    
}
