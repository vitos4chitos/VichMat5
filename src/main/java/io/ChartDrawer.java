
package io;

import javafx.util.Pair;
import methods.Method;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.Range;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ChartDrawer extends JFrame {

    public ChartDrawer(Method method, double x) {
        XYSeries originalSeries = new XYSeries("original");
        XYSeries approxSeries = new XYSeries("interpolation");
        XYSeries findValue = new XYSeries("FindValue");
        ArrayList<Pair<Double, Double>> listOfValue = method.getStaticValues();
        double min = listOfValue.get(0).getKey();
        double max = listOfValue.get(0).getKey();
        for (int i = 0; i < listOfValue.size(); i++) {
            originalSeries.add(listOfValue.get(i).getKey(), listOfValue.get(i).getValue());
            min = Math.min(min, listOfValue.get(i).getKey());
            max = Math.max(max, listOfValue.get(i).getKey());
        }
        double length = max - min;
        for (double i = min - length / 100; i < max + length / 100; i += length / 100) {
            approxSeries.add(i, method.getValue(i));
        }
        findValue.add(x, method.getValue(x));
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(originalSeries);
        dataset.addSeries(approxSeries);
        dataset.addSeries(findValue);
        JFreeChart chart = ChartFactory.createXYLineChart(method.toString(), "x", "y",
                dataset, PlotOrientation.VERTICAL, false, false, false);
        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(2f));
        renderer.setSeriesLinesVisible(0, false);
        renderer.setSeriesShapesVisible(0,true);
        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesShapesVisible(1, false);
        renderer.setSeriesStroke(1, new BasicStroke(1.3f));
        renderer.setSeriesPaint(2, Color.ORANGE);
        renderer.setSeriesStroke(2, new BasicStroke(2f));
        renderer.setSeriesLinesVisible(2, false);
        renderer.setSeriesShapesVisible(2,true);
        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.WHITE);
        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.GRAY);
        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.GRAY);
        plot.getDomainAxis().setRange(new Range(min - length / 10, max + length / 10));
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);
        pack();
        setTitle("LineChart");
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}