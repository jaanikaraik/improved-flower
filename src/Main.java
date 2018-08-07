import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    private Random random = new Random();

    private int radius1 = random.nextInt(30) + 10;
    private int radius2 = random.nextInt(30) + 10;

    private int x1 = random.nextInt(400) + 100;
    private int y1 = random.nextInt(400) + 100;
    private int x2 = random.nextInt(400) + 100;
    private int y2 = random.nextInt(400) + 100;

    private int colorInt1 = random.nextInt(5);
    private int colorInt2 = random.nextInt(5);

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Peenar");
        Group root = new Group();
        final Flower flower = new FlowerBuilder()
                .setRadius(radius1)
                .setCenterX(x1)
                .setCenterY(y2)
                .setColor(generateColor(colorInt1))
                .createFlower();
        flower.drawFlowerVariablePetals();
        final Flower flower2 = new FlowerBuilder()
                .setRadius(radius2)
                .setCenterX(x2)
                .setCenterY(y2)
                .setColor(generateColor(colorInt2))
                .createFlower();
        flower2.drawFlowerVariablePetals();
        root.getChildren().add(flower);
        root.getChildren().add(flower2);

        final Scene scene = new Scene(root, WIDTH, HEIGHT, Color.LIGHTGREEN);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public Color generateColor(int number) {
        Color color;
        if (number == 1) {
            color = Color.ORANGE;
        } else if (number == 2) {
            color = Color.PINK;
        } else if (number == 3) {
            color = Color.LIGHTBLUE;
        } else if (number == 4){
            color = Color.DARKBLUE;
        } else {
            color = Color.ORANGERED;
        }
        return color;
    }
}