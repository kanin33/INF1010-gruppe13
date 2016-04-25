import javafx.application.Application;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class Kalkulator extends Application {
    TextField tall1;
    TextField tall2;
    Text resultat;
    @Override
    public void start(Stage vindu) {
        HBox rot = new HBox();
        GridPane knappePlass = new GridPane();
        knappePlass.setPadding(new Insets(20, 20, 20, 20));

        Button plussKnapp = new Button("+");
        Button minusKnapp = new Button("-");
        Button gangeKnapp = new Button("*");
        Button deleKnapp = new Button("/");

        knappePlass.add(plussKnapp, 1, 1);
        knappePlass.add(minusKnapp, 2, 1);
        knappePlass.add(gangeKnapp, 1, 2);
        knappePlass.add(deleKnapp, 2, 2);

        EventHandler<ActionEvent> plussLytt = new KnappEvent('+');
        EventHandler<ActionEvent> minusLytt = new KnappEvent('-');
        EventHandler<ActionEvent> gangeLytt = new KnappEvent('*');
        EventHandler<ActionEvent> deleLytt = new KnappEvent('/');

        plussKnapp.setOnAction(plussLytt);
        minusKnapp.setOnAction(minusLytt);
        gangeKnapp.setOnAction(gangeLytt);
        deleKnapp.setOnAction(deleLytt);

        VBox tekstPlass = new VBox();
        Text tekst1 = new Text("Tall 1:");
        Text tekst2 = new Text("Tall 2:");
        Text tekst3 = new Text("Resultat:");
        resultat = new Text("0");
        tall1 = new TextField("0");
        tall2 = new TextField("0");

        tekstPlass.getChildren().addAll(tekst1, tall1, tekst2, tall2,
                                        tekst3, resultat);

        rot.getChildren().addAll(tekstPlass, knappePlass);

        Scene scene = new Scene(rot, 300, 200);
        vindu.setScene(scene);
        vindu.show();
        vindu.setTitle("Kalkulator");
    }

    private class KnappEvent implements EventHandler<ActionEvent> {
        char regneform;
        public KnappEvent(char regneform) {
            this.regneform = regneform;
        }

        @Override
        public void handle(ActionEvent ae) {
            try {
                double verdi1 = Double.parseDouble(tall1.getText());
                double verdi2 = Double.parseDouble(tall2.getText());
                switch(regneform) {
                    case('+'): resultat.setText(String.valueOf(verdi1 + verdi2));
                               break;
                    case('-'): resultat.setText(String.valueOf(verdi1 - verdi2));
                               break;
                    case('*'): resultat.setText(String.valueOf(verdi1 * verdi2));
                               break;
                    case('/'): resultat.setText(String.valueOf(verdi1 / verdi2));
                               break;
                }
            } catch(Exception e) {
                resultat.setText("Kan ikke gjore om bokstaver til tall");
            }

        }
    }
}
