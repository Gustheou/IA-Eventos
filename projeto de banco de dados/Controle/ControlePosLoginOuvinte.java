package Controle;

import Visao.Principal;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class ControlePosLoginOuvinte {

    @FXML
    void seInscrever(MouseEvent event) {
        Principal.changeScreenOuvinteInscreverEmEventos(event);
    }

    @FXML
    void verEventos(MouseEvent event) {
        
    }

}
