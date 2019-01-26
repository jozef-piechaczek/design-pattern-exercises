interface State {
    void changeToNext(Context context);

}

class FirstState implements State {
    @Override
    public void changeToNext(Context context) {
        context.setState(new SecondState());
    }

    @Override
    public String toString() {
        return "1";
    }
}


class SecondState implements State {
    @Override
    public void changeToNext(Context context) {
        context.setState(new ThirdState());
    }
    @Override
    public String toString() {
        return "2";
    }
}

class ThirdState implements State {
    @Override
    public void changeToNext(Context context) {
        context.setState(new FirstState());
    }
    @Override
    public String toString() {
        return "3";
    }
}

class Context {
    private State state;

    void setState(State state) {
        this.state = state;
        System.out.println("State set to : "+state.toString());
    }

    State getState() {
        return state;
    }

    void goNext() {
        this.state.changeToNext(this);
    }
}


public class StateMain {
    public static void main(String[] args) {
        Context context = new Context();
        context.setState(new FirstState());
        for (int i=0; i<50; i++) {
            context.goNext();
        }
    }
}
