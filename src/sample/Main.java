package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class Main extends Application {

    private Label titleLb,firstNameLb,lastNameLb,yearLb,monthLb,dayLb,outputLb;
    private TextField firstNameTf,lastNameTf,yearTf,monthTf,dayTf;
    private VBox root,yearVBox,monthVBox,dayVBox;
    private HBox dateHBox;
    @Override
    public void start(Stage primaryStage) {
        titleLb = new Label("Heart Rate Calculator");
        titleLb.setStyle("-fx-font:26px Arial");
        firstNameLb = new Label("first Name");
        lastNameLb = new Label("last Name");
        yearLb = new Label("year");
        monthLb = new Label("month");
        dayLb = new Label("day");
        outputLb = new Label();
        outputLb.setStyle("-fx-font:24px Arial;-fx-text-fill:blue;");
        firstNameTf = new TextField();
        lastNameTf= new TextField();
        yearTf = new TextField();
        monthTf = new TextField();
        dayTf = new TextField();
        Button calculateHeartRateBtn = new Button("Calculate Heart Rate");
        yearVBox = new VBox();
        yearVBox.getChildren().addAll(yearLb,yearTf);
        monthVBox = new VBox();
        monthVBox.getChildren().addAll(monthLb,monthTf);
        dayVBox = new VBox();
        dayVBox.getChildren().addAll(dayLb,dayTf);
        dateHBox = new HBox();
        dateHBox.getChildren().addAll(yearVBox,monthVBox,dayVBox);
        dateHBox.setSpacing(20);
        root = new VBox();
        root.getChildren().addAll(titleLb,firstNameLb,firstNameTf,lastNameLb,lastNameTf, dateHBox,calculateHeartRateBtn,outputLb);
        calculateHeartRateBtn.setOnAction(e->{
            int year = Integer.parseInt(yearTf.getText());
            String monthText = monthTf.getText();
            int day = Integer.parseInt(dayTf.getText());
            String fullName = firstNameTf.getText() + " " + lastNameTf.getText();
            Month month = getMonth(monthText);
            int ageInYear = getAgeInYears(year,month,day);
            double maximumHeartRate = getHeartRate(ageInYear);
            String targetHeartRate = getTargetHeartRate(maximumHeartRate);
            String result;
            result = "Name:" + fullName + "\n"
                    + "Age:" + ageInYear + "\n"
                    + "Maximum heart rate:" + maximumHeartRate + "\n"
                    + "Target heart rate:" + targetHeartRate;
            outputLb.setText(result);
        });
        root.setSpacing(20);
        root.setPadding(new Insets(20));
        Scene scene = new Scene(root,500,500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Heart Rate Calculator");
        primaryStage.show();

    }

    private int getAgeInYears(int year, Month m,int day) {
        LocalDate today = LocalDate.now();
        LocalDate bd = LocalDate.of(year,m,day);
        Period period = Period.between(bd,today);
        return (period.getYears());
    }

    private Month getMonth(String month){
        Month m;
        if(month.equalsIgnoreCase("January")){
            m = Month.JANUARY;
        }else if(month.equalsIgnoreCase("February")){
            m = Month.FEBRUARY;
        }else if(month.equalsIgnoreCase("March")){
            m = Month.MARCH;
        }else if(month.equalsIgnoreCase("april")){
            m = Month.APRIL;
        }
        else if(month.equalsIgnoreCase("may")){
            m = Month.MAY;
        }
        else if(month.equalsIgnoreCase("june")){
            m = Month.JUNE;
        }
        else if(month.equalsIgnoreCase("July")){
            m = Month.JULY;
        }
        else if(month.equalsIgnoreCase("August")){
            m = Month.AUGUST;
        }
        else if(month.equalsIgnoreCase("September")){
            m = Month.SEPTEMBER;
        }
        else if(month.equalsIgnoreCase("October")){
            m = Month.OCTOBER;
        }
        else if(month.equalsIgnoreCase("NOVEMBER")){
            m = Month.NOVEMBER;
        }
        else if(month.equalsIgnoreCase("DECEMBER")){
            m = Month.DECEMBER;
        }
        else {
            m = Month.JANUARY;
        }
        return m;
    }

    private double getHeartRate(int year)
    {

        return  220 - year;
    }
    private String getTargetHeartRate(double heartRate)
    {
        return  (int)(heartRate * 0.5) + " - " + (int)(heartRate * 0.85);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
