/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Homework_chapter3_part_2;


import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author khalil
 */
public class Q1 extends Application{
/*
b) 
Write a method reference that can be used in place of the following lambda: 
(String s) -> {return s.toUpperCase();}     
*/
    public String converttouppercase(String s)
        {
            return s.toUpperCase();
        }
    
    
    @Override
    public void start(Stage stage) throws Exception {
        /*
        a) Write a lambda that can be used in place of the following anonymous 
        inner class: new IntConsumer() { public void accept(int value) { System.out.printf("%d ", value); }
        }*/
        TextField txtinput=new TextField();
        Button btninput=new Button("Click Here");
        VBox vbox=new VBox(txtinput,btninput);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20,20,20,20));
        btninput.setOnAction((ActionEvent t) -> {
            if(t.getSource()==btninput)
            {
                if(!txtinput.getText().equals(""))
                {
                    IntConsumer intConsumer = value->System.out.println(value);
                    intConsumer.accept(Integer.parseInt(txtinput.getText()));
                    
                }
            }
        });
        //-------------------------------------------------
        //Q1-B:
        TextField txtString=new TextField();
        Label lblString =new Label();
        Button btnUpperCase=new Button("UpperCase");
        VBox vbox2=new VBox(txtString,btnUpperCase,lblString);
        vbox2.setAlignment(Pos.CENTER);
        vbox2.setPadding(new Insets(20,20,20,20));
        btnUpperCase.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
              if(t.getSource()==btnUpperCase)
              {
                  if(!txtString.getText().equals(""))
                  {
                       String input=converttouppercase(txtString.getText());
                        lblString.setText(input);
                  }
              }
            }
        });
       //------------------------------------------------- 
        /*Q1-C:
        Write a no-argument lambda that implicitly returns the String "Welcome to lambdas!". 
        */
        Label lbl3=new Label();
        Callable<String> text=()->{
            System.out.println("Weclome lambda !");
            return null;
        };
        VBox vbox3=new VBox(lbl3);
        String ss=text.call();
        lbl3.setText(ss);
        vbox3.setAlignment(Pos.CENTER);
        vbox3.setPadding(new Insets(20,20,20,20));
        //-------------------------------------------------------
        /*Q1-D Create a one-parameter lambda that returns the cube of its argument. 
        */
        Scanner inputs=new Scanner(System.in);
        double in=inputs.nextDouble();
        UnaryOperator<Double>cube=c->{return Math.cbrt(c);};
        double cc=cube.apply(in);
        System.out.println(cc);
        //-------------------------------------------------
       
       VBox vboxMain=new VBox(vbox,vbox2,vbox3);
        
        
        
        
        
        Scene s=new Scene(vboxMain);
        stage.setScene(s);
       stage.show();
        
    }
    public static void main(String[] args) {
        launch(args);
       
    }

   
    
}
