package com.example.graffx;

import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GraphInit {

    public static void graph(Stage stage) {
        CategoryAxis x = new CategoryAxis();
        NumberAxis y = new NumberAxis();
        x.setLabel("words");
        y.setLabel("count");
        BarChart barchart = new BarChart<>(x, y);

        XYChart.Series series = new XYChart.Series<>();

        //words
        for (String key: HelloController.wordMap.keySet()) {
            series.getData().add(new XYChart.Data<>(key, HelloController.wordMap.get(key)));
        }

        /* chars
        for (Character key: HelloController.charCounter.keySet()) {
            System.out.println(key);
            System.out.println(HelloController.charCounter.get(key));
            series.getData().add(new XYChart.Data<>(key, HelloController.charCounter.get(key)));
        }

         */

        series.setName("WORDS");
        barchart.getData().add(series);
        BorderPane bpane = new BorderPane();
        bpane.setCenter(barchart);

        stage.setTitle("Words");
        Scene scene2 = new Scene(bpane, 800, 500);
        stage.setScene(scene2);
        stage.show();

    }
}
