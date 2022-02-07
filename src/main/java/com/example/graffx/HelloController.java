package com.example.graffx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class HelloController {

    static File file;
    static String inputString;

    @FXML
    protected void onHelloButtonClick(ActionEvent event) {
        Window window = ((Node) event.getTarget()).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        file = fileChooser.showOpenDialog(window);
        System.out.println(ConvertFile.read(file));

        Map<Character, Integer> charCounter = new HashMap<>();
        inputString = ConvertFile.read(file);
        inputString.toCharArray();

        for (int i = 0; i < inputString.length(); i++) {
            Character character = inputString.charAt(i);
            if (charCounter.containsKey(character)) {
                Integer count = charCounter.get(character);
                count = count + 1;
                charCounter.put(character, count);
            } else {
                charCounter.put(character, 1);
            }
        }
        System.out.println(charCounter);

    }

}