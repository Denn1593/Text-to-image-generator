import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.image.WritableImage;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;
import javafx.scene.effect.DropShadow;
import javafx.embed.swing.SwingFXUtils;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import java.io.*;
import javax.imageio.ImageIO;
import javafx.scene.text.Font;


public class Run extends Application
{
   private int index = 0;
   private Stage window;
   private Button add = new Button("+");
   private Button generate = new Button("Generate");
   private WritableImage wi = new WritableImage(420, 420);
   
   public static void main(String[] args)
   {
      launch(args);
   }
   
   public void start(Stage s)
   {
      window = s; 
      window.setTitle("Useless text to ugly image generator");
      Pane p = new Pane();
      
      PixelWriter pi = wi.getPixelWriter();
      for(int x = 0; x < 420; x++)
      {
         for(int y = 0; y < 420; y++)
         {
            pi.setColor(x, y, Color.color(1, 1, 1, 1));
         }
      }      
      
      //HIGLIGHT
      DropShadow glow = new DropShadow();
      glow.setColor(Color.RED);
      glow.setOffsetX(0f);
      glow.setOffsetY(0f);
      glow.setHeight(5);
      glow.setWidth(5);
      
      //SLIDERS
      Slider redScale = new Slider(0, 2, 1);
      redScale.setPrefWidth(100);
      redScale.setLayoutX(490);
      redScale.setLayoutY(495);
      
      Slider blueScale = new Slider(0, 2, 1);
      blueScale.setPrefWidth(100);
      blueScale.setLayoutX(490);
      blueScale.setLayoutY(555);
      
      Slider greenScale = new Slider(0, 2, 1);
      greenScale.setPrefWidth(100);
      greenScale.setLayoutX(490);
      greenScale.setLayoutY(525);
            
      //COMBOBOXES      
      ComboBox<String> red = new ComboBox<>();
      red.getItems().addAll("sinus", "cosinus", "tangent");
      red.setLayoutX(400);
      red.setLayoutY(490);
      red.setValue("sinus");
            
      ComboBox<String> green = new ComboBox<>();
      green.getItems().addAll("sinus", "cosinus", "tangent");
      green.setLayoutX(400);
      green.setLayoutY(520);
      green.setValue("sinus");
      
      ComboBox<String> blue = new ComboBox<>();
      blue.getItems().addAll("sinus", "cosinus", "tangent");
      blue.setLayoutX(400);
      blue.setLayoutY(550);
      blue.setValue("sinus");
      
      ComboBox<Integer> skip = new ComboBox<>();
      skip.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9);
      skip.setLayoutY(460);
      skip.setValue(1);
      
      //TRIPLE INCREMENT
      CheckBox triple = new CheckBox();
      triple.setLayoutX(460);
      triple.setLayoutY(464);
      
      //CHECKBOXES
      CheckBox xr = new CheckBox();
      xr.setLayoutX(620);
      xr.setLayoutY(494);
      
      CheckBox xg = new CheckBox();
      xg.setLayoutX(620);
      xg.setLayoutY(524);
      
      CheckBox xb = new CheckBox();
      xb.setLayoutX(620);
      xb.setLayoutY(554);
      
      CheckBox yr = new CheckBox();
      yr.setLayoutX(655);
      yr.setLayoutY(494);
      
      CheckBox yg = new CheckBox();
      yg.setLayoutX(655);
      yg.setLayoutY(524);
      
      CheckBox yb = new CheckBox();
      yb.setLayoutX(655);
      yb.setLayoutY(554);
      
      CheckBox postProcess = new CheckBox();
      postProcess.setLayoutX(360);
      postProcess.setLayoutY(464);
      postProcess.setSelected(true);
      
      //LABELS
      
      Label postLabel = new Label("Trigonometry");
      postLabel.setLayoutX(380);
      postLabel.setLayoutY(464);
      
      Label x1 = new Label("X");
      x1.setLayoutX(642);
      x1.setLayoutY(495);
      
      Label x2 = new Label("X");
      x2.setLayoutX(642);
      x2.setLayoutY(525);
      
      Label x3 = new Label("X");
      x3.setLayoutX(642);
      x3.setLayoutY(555);
      
      Label y1 = new Label("Y");
      y1.setLayoutX(677);
      y1.setLayoutY(495);
      
      Label y2 = new Label("Y");
      y2.setLayoutX(677);
      y2.setLayoutY(525);
      
      Label y3 = new Label("Y");
      y3.setLayoutX(677);
      y3.setLayoutY(555);
      
      Label inputHere = new Label("Enter text");
      inputHere.setLayoutX(20);
      inputHere.setLayoutY(10);
      
      Label total = new Label("Total characters: 0");
      total.setLayoutY(10);
      
      Label imgText = new Label("Generated Image: 420x420");
      imgText.setLayoutX(360);
      imgText.setLayoutY(10);
      
      Label skipText = new Label("Increment ");
      skipText.setLayoutY(464);
      
      Label redText = new Label("Red");
      redText.setLayoutX(360);
      redText.setLayoutY(495);
      
      Label greenText = new Label("Green");
      greenText.setLayoutX(360);
      greenText.setLayoutY(525);
      
      Label blueText = new Label("Blue");
      blueText.setLayoutX(360);
      blueText.setLayoutY(555);
      
      Label tripleText = new Label("Triple increment per pixel");
      tripleText.setLayoutX(480);
      tripleText.setLayoutY(464);
      
      //IMAGE
      ImageView iv = new ImageView();
      iv.setImage(wi);
      iv.setLayoutX(360);
      iv.setLayoutY(30);
      
      TextArea ta = new TextArea();
      ta.setPrefWidth(320);
      ta.setPrefHeight(550);
      ta.setLayoutX(20);
      ta.setLayoutY(30);
      ta.setWrapText(true);
      
      //SETSAMEBUTTONS
      
      Button rSet = new Button("S");
      rSet.setLayoutX(590);
      rSet.setLayoutY(490);
      
      Button gSet = new Button("S");
      gSet.setLayoutX(590);
      gSet.setLayoutY(520);
      
      Button bSet = new Button("S");
      bSet.setLayoutX(590);
      bSet.setLayoutY(550);
      
      //MENU
      TextField name = new TextField();
      name.setPromptText("image name...");
      name.setPrefWidth(80);
      name.setLayoutX(700);
      name.setLayoutY(490);
      
      Button bu = new Button("Generate");
      bu.setLayoutX(700);
      bu.setLayoutY(550);
      bu.setPrefWidth(80);
      
      Button save = new Button("Export");
      save.setLayoutX(700);
      save.setLayoutY(520);
      save.setPrefWidth(80);
      
      //Update total
      
      ta.textProperty().addListener(new ChangeListener<String>()
      {
         public void changed(final ObservableValue<? extends String> observable, final String oldValue, final String newValue)
         {
            total.setText("Total characters: "+ta.getText().length());  
            total.setLayoutX(340 - total.getWidth());
         }
      });  
      
      postProcess.setOnAction(eeeee ->
      {
         if(postProcess.isSelected() == false)
         {
            rSet.setDisable(true);
            gSet.setDisable(true);
            bSet.setDisable(true);
            
            xr.setDisable(true);
            xg.setDisable(true);
            xb.setDisable(true);
            yr.setDisable(true);
            yg.setDisable(true);
            yb.setDisable(true);
            
            red.setDisable(true);
            green.setDisable(true);
            blue.setDisable(true);
            
            redScale.setDisable(true);
            greenScale.setDisable(true);
            blueScale.setDisable(true);
         }
         else
         {
            rSet.setDisable(false);
            gSet.setDisable(false);
            bSet.setDisable(false);
            
            xr.setDisable(false);
            xg.setDisable(false);
            xb.setDisable(false);
            yr.setDisable(false);
            yg.setDisable(false);
            yb.setDisable(false);
            
            red.setDisable(false);
            green.setDisable(false);
            blue.setDisable(false);
            
            redScale.setDisable(false);
            greenScale.setDisable(false);
            blueScale.setDisable(false);
         }
      });   
       
      bu.setOnAction(e -> 
      {
         int index = 0;
         String input = ta.getText();
         if(input.length() > 0)
         {
            ta.setEffect(null);
            for(int x = 0; x < 420; x++)
            {
               for(int y = 0; y < 420; y++)
               {
                  int xrVal = 0;
                  int yrVal = 0;
                  
                  int xgVal = 0;
                  int ygVal = 0;
                  
                  int xbVal = 0;
                  int ybVal = 0;
                  
                  if(xr.isSelected() == true)
                  {
                     xrVal = x;
                  }
                  
                  if(xg.isSelected() == true)
                  {
                     xgVal = x;
                  }
                  
                  if(xb.isSelected() == true)
                  {
                     xbVal = x;
                  }
                  
                  if(yr.isSelected() == true)
                  {
                     yrVal = y;
                  }
                  
                  if(yg.isSelected() == true)
                  {
                     ygVal = y;
                  }
                  
                  if(yb.isSelected() == true)
                  {
                     ybVal = y;
                  }   
                  
                  double r = 0;
                  double g = 0;
                  double b = 0;
                  if(postProcess.isSelected() == true)
                  {
                     if(red.getValue() == "sinus")
                     {
                        r = Math.abs(Math.sin(((int) input.charAt(index) + yrVal + xrVal) * redScale.getValue()));
                     }
                     if(red.getValue() == "cosinus")
                     {
                        r = Math.abs(Math.cos(((int) input.charAt(index) + yrVal + xrVal) * redScale.getValue()));
                     }  
                     if(red.getValue() == "tangent")
                     {
                        r = Math.abs(Math.tan(((int) input.charAt(index) + yrVal + xrVal) * redScale.getValue()));
                        if(r > 1)
                        {
                           r = 1;
                        }   
                     }
                  }
                  else
                  {
                     r = (int) input.charAt(index);
                     while(r > 100)
                     {
                        r = r - 100;
                     }  
                     r = r / 100; 
                  }     
                  if(index < input.length() - 1)
                  {
                     index = index + skip.getValue();
                     while(index >= input.length())
                     {
                        index = index - input.length();
                     }
                  }
                  else
                  {
                     index = 0;
                  }   
                  if(postProcess.isSelected() == true)
                  {   
                     if(green.getValue() == "sinus")
                     {
                        g = Math.abs(Math.sin(((int) input.charAt(index) + ygVal + xgVal) * greenScale.getValue()));
                     }
                     if(green.getValue() == "cosinus")
                     {
                        g = Math.abs(Math.cos(((int) input.charAt(index) + ygVal + xgVal) * greenScale.getValue()));
                     }
                     if(green.getValue() == "tangent")
                     {
                        g = Math.abs(Math.tan(((int) input.charAt(index) + ygVal + xgVal) * greenScale.getValue()));
                        if(g > 1)
                        {
                           g = 1;
                        }   
                     }
                  }
                  else
                  {
                     g = (int) input.charAt(index);
                     while(g > 100)
                     {
                        g = g - 100;
                     }   
                     g = g / 100;
                  }    
                  if(triple.isSelected())
                  {
                     if(index < input.length() - 1)
                     {
                        index = index + skip.getValue();
                        while(index >= input.length())
                        {
                           index = index - input.length();
                        }
                     }
                     else
                     {
                        index = 0;
                     }
                  }   
                  if(postProcess.isSelected() == true)
                  { 
                     if(blue.getValue() == "sinus")
                     {
                        b = Math.abs(Math.sin(((int) input.charAt(index) + ybVal + xbVal) * blueScale.getValue()));
                     }
                     if(blue.getValue() == "cosinus")
                     {
                        b = Math.abs(Math.cos(((int) input.charAt(index) + ybVal + xbVal) * blueScale.getValue()));
                     }
                     if(blue.getValue() == "tangent")
                     {
                        b = Math.abs(Math.tan(((int) input.charAt(index) + ybVal + xbVal) * blueScale.getValue()));
                        if(b > 1)
                        {
                           b = 1;
                        }   
                     } 
                  }    
                  else
                  {
                     b = (int) input.charAt(index);
                     while(b > 100)
                     {
                        b = b - 100;
                     }   
                     b = b / 100;
                  } 
                  if(triple.isSelected())
                  {
                     if(index < input.length() - 1)
                     {
                        index = index + skip.getValue();
                        while(index >= input.length())
                        {
                           index = index - input.length();
                        }  
                     }
                     else
                     {
                        index = 0;
                     }
                  }   
                  pi.setColor(x, y, Color.color(r, g, b, 1));
               }
            }
         }   
         else
         {
            ta.setEffect(glow);
         }      
      } );
      
      save.setOnAction(e ->
      {
         if(name.getText().length() > 0)
         {
            name.setEffect(null);
            try
            {
               ImageIO.write(SwingFXUtils.fromFXImage(wi, null), "png", new File(name.getText() +".png"));
            }
            catch(Exception exc)
            {
               System.out.println("shiiiet");
            }
         }
         else
         {
            name.setEffect(glow);
         }      
      });   
      
      rSet.setOnAction(eee ->
      {
         blueScale.setValue(redScale.getValue());
         greenScale.setValue(redScale.getValue());
      });
      
      gSet.setOnAction(eeee ->
      {   
         redScale.setValue(greenScale.getValue());
         blueScale.setValue(greenScale.getValue());
      });
      
      bSet.setOnAction(eeeee ->
      {   
         redScale.setValue(blueScale.getValue());
         greenScale.setValue(blueScale.getValue());
      });   
      
      p.getChildren().addAll(bu, iv, ta, inputHere, total, imgText, triple, tripleText, red, green, blue, redText, greenText, blueText, skip, skipText, redScale, blueScale, greenScale, save, name, rSet, gSet, bSet, xr, xg, xb, yr, yg, yb, x1, x2, x3, y1, y2, y3, postProcess, postLabel);
      Scene scene = new Scene(p, 800, 600);
      window.setScene(scene);
      window.show();
      window.setAlwaysOnTop(false);
      window.setResizable(false);
      
      skip.setLayoutX(780 - skip.getWidth());
      skipText.setLayoutX(skip.getLayoutX() - skipText.getWidth() - 5);
      total.setLayoutX(340 - total.getWidth());
      
      if(System.getProperty("os.name") == "Linux");
      {
         postLabel.setFont(Font.font("arial", 11));
         postLabel.setLayoutY(postLabel.getLayoutY() + 1);
         x1.setFont(Font.font("arial", 11));
         x1.setLayoutY(x1.getLayoutY() + 1);
         x2.setFont(Font.font("arial", 11));
         x2.setLayoutY(x2.getLayoutY() + 1);
         x3.setFont(Font.font("arial", 11));
         x3.setLayoutY(x3.getLayoutY() + 1);
         y1.setFont(Font.font("arial", 11));
         y1.setLayoutY(y1.getLayoutY() + 1);
         y2.setFont(Font.font("arial", 11));
         y2.setLayoutY(y2.getLayoutY() + 1);
         y3.setFont(Font.font("arial", 11));
         y3.setLayoutY(y3.getLayoutY() + 1);
         skipText.setFont(Font.font("arial", 11));
         skipText.setLayoutY(skipText.getLayoutY() + 1);
         redText.setFont(Font.font("arial", 11));
         redText.setLayoutY(redText.getLayoutY() + 1);
         greenText.setFont(Font.font("arial", 11));
         greenText.setLayoutY(greenText.getLayoutY() + 1);
         blueText.setFont(Font.font("arial", 11));
         blueText.setLayoutY(blueText.getLayoutY() + 1);
         tripleText.setFont(Font.font("arial", 11));
         tripleText.setLayoutY(tripleText.getLayoutY() + 1);
         red.setStyle("-fx-font: 11px \"arial\";");
         green.setStyle("-fx-font: 11px \"arial\";");
         blue.setStyle("-fx-font: 11px \"arial\";");
         red.setPrefWidth(90);
         green.setPrefWidth(90);
         blue.setPrefWidth(90);
         skipText.setLayoutX(skip.getLayoutX() - skipText.getWidth());
      }   
   }
}      
         