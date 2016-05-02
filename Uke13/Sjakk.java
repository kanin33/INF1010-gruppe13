import javafx.application.Application;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;

public class Sjakk extends Application {
    @Override
    public void start(Stage vindu) {
        GridPane brett = new GridPane();

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                StackPane pane = new StackPane();

                Color farge;
                if((i+j) % 2 == 0) {
                    farge = Color.DARKGREY;
                } else {
                    farge = Color.WHITE;
                }
                // bakgrunn uten hjorneavrunding
                pane.setBackground(new Background(new BackgroundFill(
                                   farge, CornerRadii.EMPTY, Insets.EMPTY)));
                // sett kant rundt ruten
                pane.setBorder(new Border(new BorderStroke(
                                Color.BLACK, BorderStrokeStyle.SOLID,
                                CornerRadii.EMPTY, new BorderWidths(1, 1, 0, 0))));
                brett.add(pane, i, j);
            }
        }

        int storrelse = 40;
        for(int i = 0; i < 8; i++) {
            // endre storrelse paa kolonne og rad
            brett.getColumnConstraints().add(new ColumnConstraints(storrelse));
            brett.getRowConstraints().add(new RowConstraints(storrelse));
        }

        Scene scene = new Scene(brett);

        vindu.setScene(scene);
        vindu.setTitle("Sjakkbrett");
        vindu.show();
    }
}
