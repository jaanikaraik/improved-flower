import javafx.scene.paint.Color;

public class FlowerBuilder {
    private int radius = 30;
    private int centerX = 100;
    private int centerY = 100;
    private Color color = Color.ORANGE;

    public FlowerBuilder setRadius(int radius) {
        this.radius = radius;
        return this;
    }

    public FlowerBuilder setCenterX(int centerX) {
        this.centerX = centerX;
        return this;
    }

    public FlowerBuilder setCenterY(int centerY) {
        this.centerY = centerY;
        return this;
    }

    public FlowerBuilder setColor(Color color) {
        this.color = color;
        return this;
    }

    public Flower createFlower() {
        return new Flower(radius, centerX, centerY, color);
    }
}