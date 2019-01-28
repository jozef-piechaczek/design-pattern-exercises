class SadObject {
    private SadObject(){}
    private static final SadObject instance = new SadObject();
    static SadObject getInstance() {
        return instance;
    }
    void showMessage() {
        System.out.println("That's the only one SadObject");
    }
}

public class SingletonMain {
    public static void main(String[] args) {
        SadObject object = SadObject.getInstance();
        object.showMessage();

//        This cannot be done, because constructor is private
//        object = new SadObject();
    }
}
