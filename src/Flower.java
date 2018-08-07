import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;


public class Flower extends Group {
    int numberOfPetals = 7;
    int petalCloserBy = 2;
    int petalRadius = 30;
    int layers = 1;
    private int radius = 30;
    private int centerX;
    private int centerY;
    private Color color;
    private double constant = Math.sqrt(3);
    private boolean enableStroke = false;
    private Rectangle boundingBox;
    private Rectangle selectionBox;

    public Flower(int radius, int centerX, int centerY, Color color,
                  int numberOfPetals,
                  int petalCloserBy,
                  int petalRadius,
                  boolean enableStroke) {
        this.radius = radius;
        this.centerX = centerX;
        this.centerY = centerY;
        this.color = color;
        this.numberOfPetals = numberOfPetals;
        this.petalCloserBy = petalCloserBy;
        this.petalRadius = petalRadius;
        this.enableStroke = enableStroke;
        this.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> {
            showBoundingBox();
        });
        this.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
            removeBoxes();
        });
        this.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            showSelectionBox();
        });
        this.addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> {
            this.setLayoutX(event.getSceneX());
            this.setLayoutY(event.getSceneY());
        });
        this.setOnMouseReleased(event -> {
            System.out.println("Mouse released");
        });
    }


    /**
     * Makes a flower
     *
     * @return the root
     */
    Group drawFlowerVariablePetals() {

        int degreesPerPetal;

        int radiusCombined = this.radius - petalCloserBy;
        ArrayList<Circle> petals = new ArrayList<>();
        for (int j = 0; j < layers; j++) {
            int degree = 0;
            int actualNumberOfPetals = numberOfPetals + j * 2;
            degreesPerPetal = 360 / actualNumberOfPetals;
            radiusCombined += petalRadius;
            for (int i = 0; i < actualNumberOfPetals; i++) {
                double petalX = radiusCombined * Math.sin(Math.toRadians(degree));
                double petalY = radiusCombined * Math.cos(Math.toRadians(degree));
                final Circle petal1 = new Circle(petalRadius, this.color);
                if (enableStroke) {
                    petal1.setStyle("-fx-stroke: black");
                }
                this.getChildren().add(petal1);
                petal1.setCenterX(this.centerX + petalX);
                petal1.setCenterY(this.centerY + petalY);
                petals.add(petal1);
                degree += degreesPerPetal;
            }
        }


        final Circle circle = new Circle(this.radius, Color.YELLOW);
        circle.setCenterX(this.centerX);
        circle.setCenterY(this.centerY);
        if (enableStroke) {
            circle.setStyle("-fx-stroke: black");
        }
        this.getChildren().add(circle);
        return this;
    }

    void showBoundingBox() {
        removeBoxes();
        Rectangle rectangle = new Rectangle();
        rectangle.setX(this.getBoundsInParent().getMinX());
        rectangle.setY(this.getBoundsInParent().getMinY());
        rectangle.setWidth(this.getBoundsInParent().getWidth());
        rectangle.setHeight(this.getBoundsInParent().getHeight());
        rectangle.setStyle("-fx-fill: rgba(0,0,0,0); -fx-stroke: black");
        boundingBox = rectangle;
        this.getChildren().add(rectangle);
    }

    void showSelectionBox() {
        removeBoxes();
        Rectangle rectangle = new Rectangle();
        rectangle.setX(this.getBoundsInParent().getMinX());
        rectangle.setY(this.getBoundsInParent().getMinY());
        rectangle.setWidth(this.getBoundsInParent().getWidth());
        rectangle.setHeight(this.getBoundsInParent().getHeight());
        rectangle.setStyle("-fx-stroke-dash-array: 12 5; -fx-fill: rgba(0,0,0,0); -fx-stroke: black;");
        this.getChildren().add(rectangle);
        this.selectionBox = rectangle;
    }

    void removeBoxes() {
        if (boundingBox != null) {
            this.getChildren().remove(boundingBox);
            boundingBox = null;
        }
        if (selectionBox != null) {
            this.getChildren().remove(selectionBox);
            selectionBox = null;
        }
    }


    Group drawFlower(Group root) {
        final Circle circle = new Circle(this.radius, Color.YELLOW);
        circle.setCenterX(this.centerX);
        circle.setCenterY(this.centerY);

        final Circle petal1 = new Circle(this.radius, this.color);
        petal1.setCenterX(this.centerX - radius);
        petal1.setCenterY(this.centerY - constant * radius);

        final Circle petal2 = new Circle(this.radius, this.color);
        petal2.setCenterX(this.centerX + radius);
        petal2.setCenterY(this.centerY - constant * radius);

        final Circle petal3 = new Circle(this.radius, this.color);
        petal3.setCenterX(this.centerX + 2 * radius);
        petal3.setCenterY(this.centerY);

        final Circle petal4 = new Circle(this.radius, this.color);
        petal4.setCenterX(this.centerX + radius);
        petal4.setCenterY(this.centerY + constant * radius);

        final Circle petal5 = new Circle(this.radius, this.color);
        petal5.setCenterX(this.centerX - radius);
        petal5.setCenterY(this.centerY + constant * radius);

        final Circle petal6 = new Circle(this.radius, this.color);
        petal6.setCenterX(this.centerX - 2 * radius);
        petal6.setCenterY(this.centerY);

        root.getChildren().add(circle);
        root.getChildren().add(petal1);
        root.getChildren().add(petal2);
        root.getChildren().add(petal3);
        root.getChildren().add(petal4);
        root.getChildren().add(petal5);
        root.getChildren().add(petal6);
        return root;
    }
}
