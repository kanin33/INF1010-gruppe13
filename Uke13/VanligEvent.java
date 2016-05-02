import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import java.util.Random;

public class VanligEvent extends Application {
    FlowPane flow;
    @Override
    public void start(Stage vindu) {
        flow = new FlowPane();

        Random rand = new Random();
        for(int i = 0; i < 50; i++) {
            int randNum = rand.nextInt(10);

            Label l = new Label("" + randNum);
            l.setOnMouseClicked(new GiFarge(randNum));

            flow.getChildren().add(l);
        }

        Scene scene = new Scene(flow, 500, 500);

        vindu.setScene(scene);
        vindu.setTitle("Event handlers");
        vindu.show();
    }

    private class GiFarge implements EventHandler<MouseEvent> {
        int tall;
        public GiFarge(int tall) {
            this.tall = tall;
        }
        @Override
        public void handle(MouseEvent me) {
            for(Node node : flow.getChildren()) {
                Label l = (Label) node;

                int nodeTall = Integer.parseInt(l.getText());
                Color farge;
                if(nodeTall % tall == 0) {
                    farge = Color.GREEN;
                } else {
                    farge = Color.WHITE;
                }
                l.setBackground(new Background(new BackgroundFill(
                                farge, CornerRadii.EMPTY, Insets.EMPTY)));
            }
        }
    }
}
