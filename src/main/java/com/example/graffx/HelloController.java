package com.example.graffx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class HelloController {

    static File file;
    static String inputStringChar;
    static String inputStringWord;
    static String[] wordCounter;
    static Map<String, Double> wordMap = new HashMap<>();
    static Map<Character, Double> charCounter = new HashMap<>();
    static int countSumWord;
    static int countSumChar;
    static double countChar;
    static double countWord;

    @FXML
    protected void onHelloButtonClick(ActionEvent event) {
        Window window = ((Node) event.getTarget()).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        file = fileChooser.showOpenDialog(window);

        System.out.println(ConvertFile.read(file));
        inputStringChar = ConvertFile.read(file);
        inputStringWord = ConvertFile.read(file);
        inputStringWord = inputStringWord.replace("\n", " ").replace("\r", " ");
        inputStringChar = inputStringChar.replace("\n", " ").replace("\r", " ").replaceAll("\\s+", "");

        wordCounter = inputStringWord.split(" ");

        for (int i = 0; i < inputStringChar.length(); i++) {
            Character character = inputStringChar.charAt(i);
            if (charCounter.containsKey(character)) {
                countChar = (charCounter.get(character)) * inputStringChar.length() / 100;
                countChar = countChar + 1;
                charCounter.put(character, countChar);
                charCounter.put(character, countChar / inputStringChar.length() * 100);
            } else {
                countChar = 1.0 / inputStringChar.length() * 100;
                charCounter.put(character, countChar);
            }
        }

        //System.out.println("countSumChar " + countSumChar);
        //System.out.println("charCounter " + charCounter);

        for (int i = 0; i < wordCounter.length; i++) {
            String word = wordCounter[i];
            if (wordMap.containsKey(word)) {
                countWord = (wordMap.get(word)) * wordCounter.length / 100;
                countWord = countWord + 1;
                wordMap.put(word, countWord);
                wordMap.put(word, countWord / wordCounter.length * 100);
            } else {
                countWord = 1.0 / wordCounter.length * 100;
                wordMap.put(word, countWord);
            }
            countSumWord += countWord;
        }
        System.out.println(wordMap);
        GraphInit.graph(new Stage());
    }
}