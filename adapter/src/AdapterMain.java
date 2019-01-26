interface Shape {
    double getArea();
    double getPerimeter();
}

class Rectangle implements Shape {
    private double w, h;
    public Rectangle(int w, int h) {
        this.w = w;
        this.h = h;
    }

    @Override
    public double getArea() {
        return w*h;
    }

    @Override
    public double getPerimeter() {
        return 2*w+2*h;
    }
}

class Circle implements Shape {
    private double r;

    Circle(double r) {
        this.r = r;
    }

    @Override
    public double getArea() {
        return Math.PI*r*r;
    }

    @Override
    public double getPerimeter() {
        return 2*r*Math.PI;
    }
}

interface WeirdShape {
    double getHalfOfArea();
    double getHalfOfPerimeter();
}

class WeirdCircle implements WeirdShape {
    private int r;

    WeirdCircle(int r) {
        this.r = r;
    }

    @Override
    public double getHalfOfArea() {
        return 0.5*Math.PI*r*r;
    }

    @Override
    public double getHalfOfPerimeter() {
        return r*Math.PI;
    }
}

class WeirdCircleAdapter implements Shape {
    private WeirdCircle weirdCircle;

    WeirdCircleAdapter(WeirdCircle weirdCircle) {
        this.weirdCircle = weirdCircle;
    }

    @Override
    public double getArea() {
        return weirdCircle.getHalfOfArea()*2;
    }

    @Override
    public double getPerimeter() {
        return weirdCircle.getHalfOfPerimeter()*2;
    }
}
public class AdapterMain {
    public static void main(String[] args) {
        Shape circle = new Circle(1);
        System.out.println(circle.getArea());
        System.out.println(circle.getPerimeter());
        Shape weirdCircleAdapter = new WeirdCircleAdapter(new WeirdCircle(1));
        System.out.println(weirdCircleAdapter.getArea());
        System.out.println(weirdCircleAdapter.getPerimeter());
    }
}
