import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;


public class Flower {
    private int radius;
    private int centerX;
    private int centerY;
    private Color color;
    private double constant = Math.sqrt(3);

    public Flower(int radius, int centerX, int centerY, Color color) {
        this.radius = radius;
        this.centerX = centerX;
        this.centerY = centerY;
        this.color = color;
    }


    /**
     * Makes a flower
     *
     * @param root A root group component to hold the entire flower when it's done
     * @return the root
     */
    Group drawFlowerVariablePetals(Group root) {
        int numberOfPetals = 7;
        int petalCloserBy = 5;
        int petalRadius = 30;
        int degreesPerPetal = 360 / numberOfPetals;

        int radiusCombined = petalRadius + this.radius - petalCloserBy;
        ArrayList<Circle> petals = new ArrayList<>();
        int degree = 0;
        for (int i = 0; i < numberOfPetals; i++) {
            double petalX = radiusCombined * Math.sin(Math.toRadians(degree));
            double petalY = radiusCombined * Math.cos(Math.toRadians(degree));
            final Circle petal1 = new Circle(petalRadius, this.color);
            root.getChildren().add(petal1);
            petal1.setCenterX(this.centerX + petalX);
            petal1.setCenterY(this.centerY + petalY);
            petals.add(petal1);
            degree += degreesPerPetal;
        }

        final Circle circle = new Circle(this.radius, Color.YELLOW);
        circle.setCenterX(this.centerX);
        circle.setCenterY(this.centerY);
        root.getChildren().add(circle);
        return null;
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
