import javafx.scene.paint.Color;

public class FlowerBuilder {
    private int radius = 30;
    private int centerX = 100;
    private int centerY = 100;
    private Color color = Color.ORANGE;
    private int layers = 1;
    private int petalRadius = 30;
    private int numberOfPetals = 7;
    private int pullPetalsBy = 5;
    private boolean enableStroke = false;

    public FlowerBuilder setLayers(int layers) {
        this.layers = layers;
        return this;
    }

    public FlowerBuilder setEnableStroke(boolean enableStroke) {
        this.enableStroke = enableStroke;
        return this;
    }

    public FlowerBuilder setNumberOfPetals(int numberOfPetals) {
        this.numberOfPetals = numberOfPetals;
        return this;
    }

    public FlowerBuilder setPullPetalsBy(int pullPetalsBy) {
        this.pullPetalsBy = pullPetalsBy;
        return this;
    }

    public FlowerBuilder setRadius(int radius) {
        this.radius = radius;
        return this;
    }

    public FlowerBuilder setPetalRadius(int radius) {
        this.petalRadius = radius;
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
        return new Flower(radius, centerX,
                centerY, color, numberOfPetals, pullPetalsBy,
                petalRadius, enableStroke);
    }
}