interface Paint {
    void applyPaint();
}

abstract class Bike {
    protected Paint paint;

    Bike(Paint p) {
        this.paint = p;
    }

    abstract void applyPaint();
}

class ReallyFastBike extends Bike {

    ReallyFastBike(Paint p) {
        super(p);
    }

    @Override
    void applyPaint() {
        paint.applyPaint();
    }
}

class ReallyOldAndRustyBike extends Bike {

    ReallyOldAndRustyBike(Paint p) {
        super(p);
    }

    @Override
    void applyPaint() {
        paint.applyPaint();
    }
}

class RainbowPaint implements Paint {
    @Override
    public void applyPaint() {
        System.out.println("Bike painted in rainbow colors");
    }
}

class PlatinumPaint implements Paint {
    @Override
    public void applyPaint() {
        System.out.println("Bike painted in platinum colors");
    }
}

public class BridgeMain {
    public static void main(String[] args) {
        Paint paint = new RainbowPaint();
        Bike bike = new ReallyOldAndRustyBike(paint);
        bike.applyPaint();

        paint = new PlatinumPaint();
        bike = new ReallyFastBike(paint);
        bike.applyPaint();
    }
}
