import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
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
        final Flower flower = new FlowerBuilder()
                .setRadius(30)
                .setCenterX(200)
                .setCenterY(150)
                .setColor(Color.PINK)
                .createFlower();
        Group root = new Group();
        flower.drawFlowerVariablePetals(root);
        final Flower flower2 = new FlowerBuilder()
                .setRadius(30)
                .setCenterX(100)
                .setCenterY(100)
                .setColor(Color.ORANGE)
                .createFlower();
        flower2.drawFlowerVariablePetals(root);
        final Scene scene = new Scene(root, WIDTH, HEIGHT, Color.LIGHTGREEN);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}