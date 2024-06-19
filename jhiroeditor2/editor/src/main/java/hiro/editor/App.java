package hiro.editor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        // ウィンドウのタイトルを設定
        primaryStage.setTitle("Hello, JavaFX!");

        // ボタンを作成
        Button button1 = new Button("Button1");
        Button button2 = new Button("Button2");
		
        // レイアウトを設定
        HBox hbox = new HBox(10);
        hbox.getChildren().addAll(button1, button2);

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

