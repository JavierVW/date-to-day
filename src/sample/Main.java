package sample;

import javafx.application.Application;

import javafx.geometry.Insets;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;
import javafx.scene.control.Button;


/**
 * Name: Date to Day Converter
 * Author: Javier van Wyk
 * The aim of this program is to convert a given date to a day of the week.
 *
 * Inputs:
 * The program takes in a date in a MMM DD YYYY format. For example, 1 Jan 2017
 *
 * Outputs:
 * The program will return the day which the inserted date falls on. The output is in an AAA format, where AAA is the abbreviation of a day of the week. For example, Jan 1 2017 will print out Sun, representing Sunday.
 *
 * Caveats:
 * The program will only accept MMM DD YYYY input and is not case sensitive.
 * The program will also quit after yielding the result.
 */

public class Main extends Application {

    Controller doAlg = new Controller();
    Button button;


    public void runAlg(String m1, int d2, int y3)
    {
            String monStr;
            monStr = m1;

            doAlg.mainAlg(monStr, d2, y3);

    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Date to Day Converter");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));

        grid.setVgap(8);
        grid.setHgap(10);


        //labels
        Label dayLabel = new Label("Day: ");
        Label monthLabel = new Label("Month: ");
        Label yearLabel = new Label("Year: ");
        Label resultLabel = new Label("Result: ");
        Label resultBlock = new Label("");

        //constraints
        GridPane.setConstraints(dayLabel,0,0);
        GridPane.setConstraints(monthLabel,0,1);
        GridPane.setConstraints(yearLabel,0,2);
        GridPane.setConstraints(resultLabel,0,3);

        //text fields

        TextField dayInput = new TextField();
        TextField monthInput = new TextField();
        TextField yearInput = new TextField();

        GridPane.setConstraints(dayInput,1,0);
        GridPane.setConstraints(monthInput,1,1);
        GridPane.setConstraints(yearInput,1,2);
        GridPane.setConstraints(resultBlock,1,3);

        Button execButton = new Button("Find day");
        GridPane.setConstraints(execButton,1,4);

        Button helpButton = new Button("Help");
        GridPane.setConstraints(helpButton,2,4);

        grid.getChildren().addAll(dayLabel, dayInput, monthLabel, monthInput, yearLabel, yearInput, execButton, resultBlock, resultLabel, helpButton);

        //execButton.setOnAction(e -> resultBlock.setText("invalid input"));

        execButton.setOnAction(e -> {


            runAlg(monthInput.getText(), isInt(dayInput.getText()),isInt2(yearInput.getText()));

            resultBlock.setText(doAlg.getResult());

           // monthInput.clear();
           // dayInput.clear();
          //  yearInput.clear();;

        });

        helpButton.setOnAction(e -> HelpStage.helpDisplay());

        Scene scene = new Scene(grid, 300,200);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private int isInt(String textDay)
    {
        try{
            int TextDay = Integer.parseInt(textDay);
            return TextDay;
            //return true;
        }
        catch(Exception e)
        {
            doAlg.errMes();
            return 33333;
        }
    }

    private int isInt2(String textYear)
    {
        try{

            int TextYear = Integer.parseInt(textYear);
            return TextYear;
        }
        catch(Exception e)
        {
            doAlg.errMes();
            return 33333;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
