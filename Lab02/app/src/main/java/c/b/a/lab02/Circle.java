package c.b.a.lab02;

public final class Circle {
    // Geometrical variables
    private float x;
    private float y;
    public final float radius;
    // Singleton pattern
    private static final Circle INSTANCE = new Circle();

    public static Circle getInstance() {
        return INSTANCE;
    }

    // A private constructor to guarantee a single instance
    private Circle() {
        x = 100f;
        y = 100f;
        radius = 50f;
    }

    public void addX(float a) { x += a; }

    public void addY(float a) { y += a; }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getRadius() {
        return radius;
    }
}