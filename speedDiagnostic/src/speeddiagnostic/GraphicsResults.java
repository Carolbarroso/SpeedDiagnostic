/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package speeddiagnostic;

import java.awt.Dimension;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author natan
 */

public class GraphicsResults {
    
    
    public CategoryDataset createDataset(ArrayList<PingResult> List){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for(PingResult result : List){
            dataset.addValue(result.getTIME_MS(),"time",result.getICMP_SEQ());
        }
        return dataset;
    }
    
    public JFreeChart createGraphic(CategoryDataset dataset){
        JFreeChart grafico = ChartFactory.createLineChart("Relatório de atraso para " + PingTest.getIpOrURL(), "icmp", "ms", dataset, PlotOrientation.VERTICAL, true, true, true);
        //JFreeChart grafico = ChartFactory.createBarChart("Relatório para ", " ", "ms", dataset,PlotOrientation.VERTICAL,true,false,false);
        return grafico;
    }
    
    public ChartPanel createGraphicComplete(ArrayList<PingResult> List){
        CategoryDataset dataset = this.createDataset(List);
        JFreeChart grafico = this.createGraphic(dataset);
        
        ChartPanel painelDoGrafico = new ChartPanel(grafico);
        painelDoGrafico.setPreferredSize(new Dimension(400,400));
        return painelDoGrafico;
    }
    
}
