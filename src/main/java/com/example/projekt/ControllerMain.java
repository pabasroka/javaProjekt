package com.example.projekt;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ControllerMain {

    @FXML
    private Pane titlePane;

    @FXML
    private Label result;

    @FXML
    private ImageView closeBtn;

    @FXML
    private TextField nNumber, real1, real2, imag1, imag2;

    private double x, y;
    private double r1, r2, i1, i2, n;

    public void init(Stage stage) {
        titlePane.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });
        titlePane.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX() - x);
            stage.setY(mouseEvent.getScreenY() - y);
        });
        closeBtn.setOnMouseDragged(mouseEvent -> stage.close());
    }

    @FXML
    public void onSymbolClicked(MouseEvent event) {
        String symbol = ((Pane)event.getSource()).getId();
        i1 = 0.0;
        i2 = 0.0;
        try {
            r1 = Double.parseDouble(real1.getText());
            i1 = Double.parseDouble(imag1.getText());
            n = Double.parseDouble(nNumber.getText());
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            r2 = Double.parseDouble(real2.getText());
            i2 = Double.parseDouble(imag2.getText());
        } catch (Exception e) {
            System.out.println(e);
        }

        switch(symbol) {
            case "sum" -> sum();
            case "sub" -> sub();
            case "mul" -> mul();
            case "div" -> div();
            case "pow" -> pow();
        }
    }

    private void sum() {
        double sumReal = r1 + r2;
        double sumImag = i1 + i2;
        String imag = sumImag >= 0 ? " + " + Math.floor(sumImag) : " - " + Math.floor(Math.abs(sumImag));
        result.setText(Math.floor(sumReal) + " " + imag + "i");
    }

    private void sub() {
        double subReal = r1 - r2;
        double subImag = i1 - i2;
        String imag = subImag >= 0 ? " + " + Math.floor(subImag) : " - " + Math.floor(Math.abs(subImag));
        result.setText(Math.floor(subReal) + " " + imag + "i");
    }

    private void mul() {
        double mulReal = (r1 * r2) - (i1 * i2);
        double mulImag = (i1 * r2) + (r1 * i2);
        String imag = mulImag >= 0 ? " + " + Math.floor(mulImag) : " - " + Math.floor(Math.abs(mulImag));
        result.setText(Math.floor(mulReal) + " " + imag + "i");
    }

    private void div() {
        double m = Math.pow(r2, 2) + Math.pow(i2, 2);
        double divReal = (r1 * r2 + i1 * i2) / m;
        double divImag = (i1 * r2 - r1 * i2) / m;
        String imag = divImag >= 0 ? " + " + Math.floor(divImag) : " - " + Math.floor(Math.abs(divImag));
        result.setText(Math.floor(divReal) + " " + imag + "i");
    }

    private void pow() {
        System.out.println("n: ");
        System.out.println(n);
        double r = Math.pow(Math.hypot(r1, i1), n);
        double phi = n * ((Math.PI / 2 - Math.atan2(r1, i1)) % (Math.PI * 2));
        result.setText(Math.floor((Math.cos(phi) * r)) + " " + Math.floor((Math.sin(phi) * r)) + "i");
    }

}