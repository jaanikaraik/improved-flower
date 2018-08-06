import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    private final int WIDTH = 1000;
    private final int HEIGHT = 600;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Peenar");
        Group root = new Group();
        /*final Flower flower = new FlowerBuilder()
                .setRadius(30)
                .setCenterX(200)
                .setCenterY(150)
                .setColor(Color.PINK)
                .createFlower();
        flower.drawFlowerVariablePetals(root);*/
        final Flower flower2 = new FlowerBuilder()
                .setRadius(50)
                .setCenterX(200)
                .setCenterY(420)
                .setColor(Color.ORANGE)
                .setPetalRadius(50)
                .setNumberOfPetals(12)
                .setLayers(1)
                .setEnableStroke(false)
                .createFlower();
        flower2.drawFlowerVariablePetals(root);
        final Scene scene = new Scene(root, WIDTH, HEIGHT, Color.LIGHTGREEN);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}