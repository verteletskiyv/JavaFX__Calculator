package com.itproger.calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button clear_btn;

    @FXML
    private Button comma_btn;

    @FXML
    private Button divide_btn;

    @FXML
    private Button equals_btn;

    @FXML
    private Label lablel_res;

    @FXML
    private Button minus_btn;

    @FXML
    private Button multiply_btn;

    @FXML
    private Button percent_btn;

    @FXML
    private Button plus_btn;

    @FXML
    private Button plus_minus_btn;

    String label_text = "";
    float first_num = 0f;
    char operation = '0';

    @FXML
    void addNumber(ActionEvent event) {
        label_text += ((Button) event.getSource()).getText();
        lablel_res.setText(label_text);
    }

    @FXML
    void initialize() {
        plus_btn.setOnAction(event -> {
            mathAction('+');
        });
        minus_btn.setOnAction(event -> {
            mathAction('-');
        });
        multiply_btn.setOnAction(event -> {
            mathAction('*');
        });
        divide_btn.setOnAction(event -> {
            mathAction('/');
        });
        equals_btn.setOnAction(event -> {
            if (operation == '+' || operation == '-' || operation == '*' || operation == '/') {
                equalBtn();
            }
        });

        comma_btn.setOnAction(event -> {
            if (!label_text.contains("."))
                label_text += ".";
            lablel_res.setText(label_text);
        });

        percent_btn.setOnAction(event -> {
            if (!label_text.equals("")) {
                float num = Float.parseFloat(label_text) * 0.1f;
                label_text = Float.toString(num);
                lablel_res.setText(label_text);
            }
        });

        plus_minus_btn.setOnAction(event -> {
            if (!label_text.equals("")) {
                float num = Float.parseFloat(label_text) * -1f;
                label_text = Float.toString(num);
                lablel_res.setText(label_text);
            }
        });

        clear_btn.setOnAction(event -> {
            lablel_res.setText("0");
            label_text = "";
            operation = '0';
            first_num = 0f;
        });
    }

    private void equalBtn() {
        float result = 0f;
        switch (operation) {
            case '+':
                result = first_num + Float.parseFloat(label_text);
                break;
            case '-':
                result = first_num - Float.parseFloat(label_text);
                break;
            case '*':
                result = first_num * Float.parseFloat(label_text);
                break;
            case '/':
                float second_num = Float.parseFloat(label_text);
                if (second_num == 0)
                    result = 0;
                else
                    result = first_num / second_num;
                break;
        }
        lablel_res.setText(Float.toString(result));
        label_text = "";
        operation = '0';
        first_num = 0f;
    }

    private void mathAction(char action) {
        if (operation != '+' && operation != '-' && operation != '*' && operation != '/') {
            first_num = Float.parseFloat(label_text);
            lablel_res.setText(String.valueOf(action));
            label_text = "";
            operation = action;
        }
    }
}

