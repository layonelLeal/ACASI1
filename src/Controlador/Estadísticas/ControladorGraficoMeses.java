package Controlador.Estadísticas;

import Modelo.Servicio;
import Vista.VistaGrafico;
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
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class ControladorGraficoMeses {
    private VistaGrafico vistaGraficoMeses;
    private Date start_time;
    private Date finish_time;
    private Integer sala_id;
    private String tipoDeGrafico;
    
    
    public ControladorGraficoMeses(VistaGrafico vistaGraficoMeses, Date start_time, Date finish_time,Integer sala_id) {
        this.vistaGraficoMeses = vistaGraficoMeses;
        this.start_time = start_time;
        this.finish_time = finish_time;
        this.sala_id = sala_id;
       
        try {
            showBarChartMonth();
        } catch (ParseException ex) {
            Logger.getLogger(ControladorGraficoMeses.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("no hay grafico para ti");
        }  
    }

    public ControladorGraficoMeses(VistaGrafico vistaGraficoMeses, Date start_time, Date finish_time, Integer sala_id, String tipoDeGrafico) {
        this.vistaGraficoMeses = vistaGraficoMeses;
        this.start_time = start_time;
        this.finish_time = finish_time;
        this.sala_id = sala_id;
        this.tipoDeGrafico = tipoDeGrafico;
        
        if (this.tipoDeGrafico.equals("Gráfico de Barras")){
            try {
                showBarChartMonth();
            } catch (ParseException ex) {
                Logger.getLogger(ControladorGraficoMeses.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (this.tipoDeGrafico.equals("Gráfico de Líneas")){
            try {
                showLinechartMonth();
            } catch (ParseException ex) {
                Logger.getLogger(ControladorGraficoMeses.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
    public JFreeChart showBarChartMonth() throws ParseException{
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        LinkedHashMap<String, Integer> monthData = Servicio.getMonth(start_time, finish_time, sala_id);
        
        for(Map.Entry<String, Integer> month : monthData.entrySet()){
            String key = month.getKey();
            Integer value = month.getValue();
            
            // Imprimir la clave y el valor
            System.out.println("Clave: " + key + ", Valor: " + value);
            dataset.setValue(value, "Amount", key);
        }
        
        JFreeChart chart = ChartFactory.createBarChart("Sesiones/Mes","Meses","Sesiones", 
                dataset, PlotOrientation.VERTICAL, false,true,false);
        
        CategoryPlot categoryPlot = chart.getCategoryPlot();
        //categoryPlot.setRangeGridlinePaint(Color.BLUE);
        categoryPlot.setBackgroundPaint(Color.WHITE);
        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
        Color clr3 = new Color(204,0,51);
        renderer.setSeriesPaint(0, clr3);
        ChartPanel barpChartPanel = new ChartPanel(chart);
        vistaGraficoMeses.panelGraficoMes.removeAll();
        vistaGraficoMeses.panelGraficoMes.add(barpChartPanel, BorderLayout.CENTER);
        vistaGraficoMeses.panelGraficoMes.validate();
        
        return chart;
    }
    

    public JFreeChart showLinechartMonth() throws ParseException{
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        LinkedHashMap<String, Integer> monthData = Servicio.getMonth(start_time, finish_time, sala_id);
        
        for(Map.Entry<String, Integer> month : monthData.entrySet()){
            String key = month.getKey();
            Integer value = month.getValue();
            
            // Imprimir la clave y el valor
            System.out.println("Clave: " + key + ", Valor: " + value);
            dataset.setValue(value, "Amount", key);
        }
 
        //create chart
        JFreeChart linechart = ChartFactory.createLineChart("Sesiones/Mes", "Meses", "Sesiones", 
                dataset, PlotOrientation.VERTICAL, false, true, false);
        
        //create plot object
        CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
        lineCategoryPlot.setBackgroundPaint(Color.white);

        //create render object to change the modify the line properties like color
        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
        Color lineChartColor = new Color(204, 0, 51);
        lineRenderer.setSeriesPaint(0, lineChartColor);
        
        //create chart panel to display chart(graph)
        ChartPanel lineChartPanel = new ChartPanel(linechart);
        vistaGraficoMeses.panelGraficoMes.removeAll();
        vistaGraficoMeses.panelGraficoMes.add(lineChartPanel, BorderLayout.CENTER);
        vistaGraficoMeses.panelGraficoMes.validate();
    
        return linechart;
    }
}
