interface Person {
    void accept(Visitor visitor);
}

interface Visitor {
    void visit(Marzena marzena);
    void visit(Bozena bozena);
    void visit(Grazyna grazyna);
}

class Marzena implements Person {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Marzena";
    }
}

class Bozena implements Person {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Bożena";
    }
}

class Grazyna implements Person {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Grażyna";
    }
}

class SundayVisitor implements Visitor {

    @Override
    public void visit(Marzena marzena) {
        System.out.println("Odwiedzono Marzenę w niedzielę");
    }

    @Override
    public void visit(Bozena bozena) {
        System.out.println("Odwiedzono Bożenę w niedzielę");
    }

    @Override
    public void visit(Grazyna grazyna) {
        System.out.println("Odwiedzono Grażynę w niedzielę");
    }
}

class MondayVisitor implements Visitor {

    @Override
    public void visit(Marzena marzena) {
        System.out.println("Odwiedzono Marzenę w poniedziałek");
    }

    @Override
    public void visit(Bozena bozena) {
        System.out.println("Odwiedzono Bożenę w poniedziałek");
    }

    @Override
    public void visit(Grazyna grazyna) {
        System.out.println("Odwiedzono Grażynę w poniedziałek");
    }
}

public class VisitorMain {
    public static void main(String[] args) {
        Person[] people = new Person[]{new Marzena(), new Grazyna(), new Bozena()};
        Visitor visitor = new SundayVisitor();
        for (Person person : people) {
            person.accept(visitor);
        }
        visitor = new MondayVisitor();
        for (Person person : people) {
            person.accept(visitor);
        }
    }
}
