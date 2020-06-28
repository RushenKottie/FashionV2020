package logics;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.util.Timer;
import java.util.TimerTask;



public class Controller {
    private final LayerLoaders layerLoaders = new LayerLoaders();
    @FXML
    Button finish;
    @FXML
    ImageView inswimsuit;
    @FXML
    Text message2;
    @FXML
    ImageView doll2;
    @FXML
    ImageView yellow_dress;
    @FXML
    ImageView greenDress;
    @FXML
    ImageView swimsuit;

    @FXML
    Button next;
    @FXML
    Text message1;
    @FXML
    ImageView blue;
    @FXML
    ImageView arlekin;
    @FXML
    ImageView doll;
    @FXML
    ImageView indress;


    @FXML
    public void buttonClick(ActionEvent event) throws Exception {
        Button button = (Button)event.getSource();
        String buttonID = button.getId();
        switch (buttonID){
            case "start":
                layerLoaders.firstLoad();
                break;
            case "restart":
                layerLoaders.introLoad();
                break;
            case "next":
                if (next.getOpacity() > 0d) {
                    layerLoaders.secondLoad();
                }
                break;
            case "finish":
                layerLoaders.getCurrentStage().close();
                System.exit(0);
                break;
        }

    }

    @FXML
    public void chooseDress(MouseEvent event){
        ImageView img = (ImageView) event.getSource();
        String id = img.getId();

        if(layerLoaders.getCurrentStage().getTitle().equals("First level")){
            String dflt1 = message1.getText();
            TimerTask task1 = new TimerTask() {
                @Override
                public void run() {
                    message1.setText(dflt1);
                }
            };
            switch (id){
                case("arlekin"):
                case("blue"):
                    message1.setText("Кажется,это не очень подходящий наряд");
                    new Timer().schedule(task1,2000);
                    break;

                case("red_dress"):
                    doll.setOpacity(0d);
                    arlekin.setOpacity(0d);
                    blue.setOpacity(0d);
                    indress.setOpacity(1d);
                    message1.setText("Это правильный ответ!");
                    next.setOpacity(1d);
                    break;
            }
        }
        else if(layerLoaders.getCurrentStage().getTitle().equals("Second level")){
            String dflt2 = message2.getText();
            TimerTask task2 = new TimerTask() {
                @Override
                public void run() {
                    message2.setText(dflt2);
                }
            };

            switch (id){
                case("swimsuit"):
                    doll2.setOpacity(0d);
                    yellow_dress.setOpacity(0d);
                    greenDress.setOpacity(0d);
                    message2.setText("Это правильный ответ!");
                    inswimsuit.setOpacity(1d);
                    finish.setOpacity(1d);
                    break;
                case("green_dress"):
                case("yellow_dress"):
                    message2.setText("Кажется,это не очень подходящий наряд");
                    new Timer().schedule(task2,2000);
                    break;

            }
        }

    }

}
