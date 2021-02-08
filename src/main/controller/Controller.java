package main.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import main.model.ObstaculoVirus;
import main.model.Rex;
import main.model.Nodo;
import javafx.scene.transform.Translate;

import java.util.Observable;
import java.util.Observer;


public class Controller implements Observer {
    @FXML
    private AnchorPane canvas;
    @FXML
    private ImageView dinosaurio;
    @FXML
    private ImageView virus;
    @FXML
    private Button btIniciar;
    @FXML
    private Button saltar;
    @FXML
    private Button Detener;
    @FXML
    void btIniciar(ActionEvent event) {
        Rex dinosaurio;
        dinosaurio = new Rex(1);
        dinosaurio.addObserver(this);
        new Thread(dinosaurio).start();

        ObstaculoVirus virus;
        virus = new ObstaculoVirus(1);
        virus.addObserver(this);
        new Thread(virus).start();
    }
    @FXML
    void btDetener(ActionEvent event) {
        System.exit(1);
    }
    @FXML
    void btsaltar(ActionEvent event) {
        Translate salto2 = new Translate(0.0,-20.0);
        dinosaurio.getTransforms().add(salto2);
        Translate landing2 = new Translate(0.0,0.0);
        dinosaurio.getTransforms().add(landing2);
    }
    @Override
    public void update(Observable o, Object arg) {
        Nodo nodo = (Nodo)arg;
        Translate t = new Translate(nodo.desplazamiento,0.0);
        Translate t2 = new Translate(nodo.desplazamientoVirus,0.0);
        dinosaurio.getTransforms().add(t);
        virus.getTransforms().add(t2);
    }


}
