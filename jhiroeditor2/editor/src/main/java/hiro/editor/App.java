package hiro.editor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        // ウィンドウのタイトルを設定
        primaryStage.setTitle("Hello, JavaFX!");

        // ラベルを作成
        Label helloLabel = new Label("Hello, JavaFX!");

        // レイアウトを設定
        StackPane root = new StackPane();
        root.getChildren().add(helloLabel);

        // シーンを作成
        Scene scene = new Scene(root, 300, 200);

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

