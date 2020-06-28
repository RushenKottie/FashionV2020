package logics;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LayerLoaders {

    private static Stage currentStage;

    public void introLoad() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Layer0.fxml"));
        AnchorPane load = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Fashion game");
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.show();
        if(currentStage != null){
            currentStage.close();
        }
        currentStage = stage;

        }

    public void firstLoad() throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Layer1.fxml"));
        AnchorPane load = loader.load();
        Stage stage = new Stage();
        stage.setTitle("First level");
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.show();
        if(currentStage != null){
            currentStage.close();
        }
        currentStage = stage;

    }

    public void secondLoad() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Layer2.fxml"));
        AnchorPane load = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Second level");
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.show();
        if(currentStage != null){
            currentStage.close();
        }
        currentStage = stage;

    }

    public Stage getCurrentStage() {
        return currentStage;
    }


}
