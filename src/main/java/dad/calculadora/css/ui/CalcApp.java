package dad.calculadora.css.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalcApp extends Application {
	
	private CalcController controller;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		controller = new CalcController();
		
		ContextMenu contextMenu = new ContextMenu();
	    MenuItem clasicaStyle = new MenuItem("Estilo clasico");
	    MenuItem modernaStyle = new MenuItem("Estilo moderno");

	    contextMenu.getItems().add(clasicaStyle);
	    contextMenu.getItems().add(modernaStyle);

	    controller.getView().setOnContextMenuRequested(event -> contextMenu.show(primaryStage, event.getScreenX(), event.getScreenY()));

	    clasicaStyle.setOnAction(event -> cambiarEstiloClasica(controller.getView()));
	    modernaStyle.setOnAction(event -> cambiarEstiloModerna(controller.getView()));
	    
		primaryStage.setTitle("Calculadora");
		primaryStage.getIcons().add(new Image("/images/calculator-32x32.png"));
		primaryStage.setScene(new Scene(controller.getView(), 300, 300));
		primaryStage.show();
	}
	
    private void cambiarEstiloClasica(GridPane root) {
        root.getStylesheets().clear();
        root.getStylesheets().add(getClass().getResource("/css/clasica.css").toExternalForm());
    }
    
    private void cambiarEstiloModerna(GridPane root) {
        root.getStylesheets().clear();
        root.getStylesheets().add(getClass().getResource("/css/moderna.css").toExternalForm());
    }
	
	public static void main(String[] args) {
		launch(args);
	}

}
