// ww  w .  j a  va 2  s .  c o  m
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {
    private final int WIDTH = 400;
    private final int HEIGHT = 300;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Peenar");
        final Flower flower = new Flower(10, 200, 150, Color.PINK);
        Group root = new Group();
        flower.drawFlower(root);
        final Flower flower2 = new Flower(15, 100, 100, Color.ORANGE);
        flower2.drawFlower(root);
        final Scene scene = new Scene(root, WIDTH, HEIGHT, Color.LIGHTGREEN);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}