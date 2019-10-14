package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HelpStage
{
    public static void helpDisplay()
    {
        Stage helpStage = new Stage();
        helpStage.initModality(Modality.APPLICATION_MODAL);
        helpStage.setTitle("Help");

        helpStage.setMaxWidth(250);

        Label label = new Label();

        String helpText = "This program takes a date as input from the user and returns the corresponding day of the week. The month field only takes three letters, eg. Feb for February";

        label.setText(helpText);

        Button close = new Button("OK");

        close.setOnAction(e -> helpStage.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, close);

        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);

        helpStage.setScene(scene);
        helpStage.showAndWait();
    }
}
