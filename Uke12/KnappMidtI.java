import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class KnappMidtI extends Application {
    @Override
    public void start(Stage vindu) {
        StackPane stackPane = new StackPane();
        Button knapp = new Button("ikke trykk her");
        knapp.setStyle("-fx-font: 22 arial; -fx-base: #334455;");
        knapp.setOnAction(new KnappEvent());
        stackPane.getChildren().add(knapp);

        Scene scene = new Scene(stackPane, 500, 500);
        vindu.setScene(scene);
        vindu.show();
        vindu.setTitle("hallo");
    }
    private class KnappEvent implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent ae) {
            System.out.println("hello");
        }
    }
    public static void main(String args) {
        launch(args);
    }
}
