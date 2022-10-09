package item1.bridge_pattern;

/**
 * @see <a href="https://ko.wikipedia.org/wiki/%EB%B8%8C%EB%A6%AC%EC%A7%80_%ED%8C%A8%ED%84%B4">brige pattern - wikipedia</a>
 */
interface DrawingAPI {
    public void drawCircle(double x, double y, double radius);
}

public class DrawingAPI1 implements DrawingAPI{
    @Override
    public void drawCircle(double x, double y, double radius) {
        System.out.printf("API1.circle at %f :%F radius %f\n", x, y, radius);
    }
}

class DrawingAPI2 implements DrawingAPI
{
    public void drawCircle(double x, double y, double radius)
    {
        System.out.printf("API2.circle at %f:%f radius %f\n", x, y, radius);
    }
}

interface Shape
{
    public void draw();                                            // low-level
    public void resizeByPercentage(double pct);     // high-level
}

/** "Refined Abstraction" */
class CircleShape implements Shape
{
    private double x, y, radius;
    private DrawingAPI drawingAPI;
    public CircleShape(double x, double y, double radius, DrawingAPI drawingAPI)
    {
        this.x = x;  this.y = y;  this.radius = radius;
        this.drawingAPI = drawingAPI;
    }

    // low-level i.e. Implementation specific
    public void draw()
    {
        drawingAPI.drawCircle(x, y, radius);
    }
    // high-level i.e. Abstraction specific
    public void resizeByPercentage(double pct)
    {
        radius *= pct;
    }
}

class BridgePattern {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[2];
        shapes[0] = new CircleShape(1, 2, 3, new DrawingAPI1());
        shapes[1] = new CircleShape(5, 7, 11, new DrawingAPI2());

        for(Shape shape : shapes){
            shape.resizeByPercentage(2.5);
            shape.draw();
        }
    }
}