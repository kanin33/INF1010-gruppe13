import javafx.application.Application;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import java.util.Random;

public class EndreNoder extends Application {
    HBox fraBoks;
    HBox tilBoks;
    @Override
    public void start(Stage vindu) {
        VBox rot = new VBox();

        fraBoks = new HBox(5);
        tilBoks = new HBox(5);

        Random rand = new Random();
        for(int i = 0; i < 20; i++) {
            int randNum = rand.nextInt(100);
            Label l = new Label("" + randNum);
            fraBoks.getChildren().add(l);
        }

        Button knapp = new Button("trykk her");
        knapp.setOnAction(new Flytt());

        rot.getChildren().addAll(fraBoks, knapp, tilBoks);

        Scene scene = new Scene(rot, 500, 500);

        vindu.setScene(scene);
        vindu.setTitle("Flytte noder");
        vindu.show();
    }

    private class Flytt implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent ae) {
            try {
                Label laveste = (Label) fraBoks.getChildren().get(0);
                int lavesteTall = Integer.parseInt(laveste.getText());

                for(Node node : fraBoks.getChildren()) {
                    Label l = (Label) node;
                    int detteTallet = Integer.parseInt(l.getText());

                    if(detteTallet < lavesteTall) {
                        laveste = l;
                        lavesteTall = detteTallet;
                    }
                }
                fraBoks.getChildren().remove(laveste);
                tilBoks.getChildren().add(laveste);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("ikke fler tall");
                return;
            }
        }
    }
}
