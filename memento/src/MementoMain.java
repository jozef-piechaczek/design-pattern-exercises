class Memento {
    private State state;

    public Memento(State state) {
        this.state = state;
    }

    public State getState() {
        return this.state;
    }
}

interface State {
    void toggleOnOff(Toaster toaster);
}

class OffState implements State {

    @Override
    public String toString() {
        return "off";
    }

    @Override
    public void toggleOnOff(Toaster toaster) {
        toaster.setState(new OnState());
    }
}

class OnState implements State {

    @Override
    public String toString() {
        return "on";
    }

    @Override
    public void toggleOnOff(Toaster toaster) {
        toaster.setState(new OffState());
    }
}

class Toaster {
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public Toaster(State state) {
        this.state = state;
    }

    public void goNext() {
        this.state.toggleOnOff(this);
    }

    public Memento saveToMemento() {
        System.out.println("State: "+this.state.toString()+" saved to memento.");
        return new Memento(this.state);
    }

    public void restoreFromMemento(Memento memento) {
        this.state = memento.getState();
    }

    public String getStateString() {
        return state.toString();
    }
}

public class MementoMain {
    public static void main(String[] args) {
        Toaster toaster = new Toaster(new OnState());
        Memento memento = toaster.saveToMemento();
        System.out.println("Toaster is: "+toaster.getStateString());
        toaster.goNext();
        System.out.println("Toaster is: "+toaster.getStateString());
        toaster.restoreFromMemento(memento);
        System.out.println("Toaster is: "+toaster.getStateString());
    }
}
