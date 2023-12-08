package com.swing;

import java.awt.BasicStroke;
import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class Chart {
    private static DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(0, "GDP", "1");
        dataset.addValue(4, "GDP", "2");
        dataset.addValue(7, "GDP", "3");
        dataset.addValue(2, "GDP", "4");
        dataset.addValue(8.92, "GDP", "5");
        dataset.addValue(3.66, "GDP", "6");
        dataset.addValue(7.74, "GDP", "7");
        dataset.addValue(8.92, "GDP", "8");
        dataset.addValue(3.66, "GDP", "9");
        dataset.addValue(7.74, "GDP", "10");
        dataset.addValue(3.66, "GDP", "11");
        dataset.addValue(7.74, "GDP", "12");
        return dataset;

    }

    public static JFreeChart createLineChart() {
        JFreeChart lineChart = ChartFactory.createLineChart(
                "Biểu đồ thống kê doanh thu".toUpperCase(),
                "Tháng", "VND", createDataset(),
                PlotOrientation.VERTICAL, false, false, false);
        CategoryPlot plot = (CategoryPlot) lineChart.getPlot();
        // Thiết lập màu nền của Plot
        plot.setBackgroundPaint(Color.white);
        plot.setRangeGridlinePaint(Color.gray);
        plot.setOutlineVisible(false);

        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, Color.red); // Màu của đường line (0 là index của dòng)
        renderer.setSeriesStroke(0, new BasicStroke(3.0f));
        
        renderer.setSeriesShapesVisible(0, false);
        renderer.setSeriesShapesFilled(0, false);
        
        return lineChart;
    }
    
}
