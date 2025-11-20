package co.edu.poli.parcial.vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Clase principal de la aplicación de Producciones Audiovisuales.
 * <p>
 * Extiende {@link javafx.application.Application} y se encarga de inicializar
 * la ventana principal cargando el archivo FXML correspondiente.
 * </p>
 * 
 * <p>Proporciona métodos auxiliares para cambiar la raíz de la escena.</p>
 * 
 * @author Felipe Parra
 */
public class App extends Application {

    /** Escena principal de la aplicación */
    private static Scene scene;

    /**
     * Método que se ejecuta al iniciar la aplicación.
     * Configura la ventana principal, carga el FXML y muestra la escena.
     *
     * @param stage ventana principal de JavaFX
     * @throws IOException si ocurre un error al cargar el archivo FXML
     */
    @Override
    public void start(Stage stage) throws IOException {
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/co/edu/poli/parcial/vista/formulario.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Producciones Audiovisuales");
        stage.show();
    }

    /**
     * Cambia la raíz de la escena actual a un nuevo FXML.
     *
     * @param fxml nombre del archivo FXML (sin la extensión ".fxml")
     * @throws IOException si ocurre un error al cargar el archivo FXML
     */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * Carga un archivo FXML y devuelve su raíz.
     *
     * @param fxml nombre del archivo FXML (sin la extensión ".fxml")
     * @return raíz del FXML cargado
     * @throws IOException si ocurre un error durante la carga
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     * Punto de entrada principal de la aplicación.
     * 
     * @param args argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        launch();
    }
}
