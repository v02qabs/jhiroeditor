package hiro.editor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        // ウィンドウのタイトルを設定
        primaryStage.setTitle("Hello, JavaFX!");

        // ボタンを作成
       	Button save_button = new Button("保存");
       	save_button.setOnAction(new EventHandler<ActionEvent>(){
       	@Override
       	public void handle(ActionEvent event){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("alert");
		alert.show();
	}
	});        
	TextArea area = new TextArea();	
        // レイアウトを設定
        VBox hbox = new VBox(10);
        hbox.getChildren().addAll(area, save_button);

        // シーンを作成
        Scene scene = new Scene(hbox, 300, 200);

        // シーンをステージに設定
        primaryStage.setScene(scene);

        // ステージを表示
        primaryStage.show();
    }

    public static void main(String[] args) {
        // JavaFXアプリケーションを起動
        launch(args);
    }
}

