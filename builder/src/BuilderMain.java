interface PizzaRecipe {
    void setDough(String dough);
    void setMainIngredient(String mainIngredient);
    void setSauce(String sauce);
}

class Pizza implements PizzaRecipe{
    private String dough;
    private String mainIngredient;
    private String sauce;

    public void setDough(String dough) {
        this.dough = dough;
    }

    public void setMainIngredient(String mainIngredient) {
        this.mainIngredient = mainIngredient;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    @Override
    public String toString() {
        return "Dough: "+dough+", MainIngredient: "+mainIngredient+", Sauce: "+sauce;
    }
}

interface PizzaBuilder {
    void buildDough();
    void buildMainIngredient();
    void buildSauce();
    Pizza getPizza();
}

class PepperoniPizzaBuilder implements PizzaBuilder {
    private Pizza pizza;

    PepperoniPizzaBuilder() {
        pizza = new Pizza();
    }

    @Override
    public void buildDough() {
        pizza.setDough("Cienkie włoskie ciasto");
    }

    @Override
    public void buildMainIngredient() {
        pizza.setMainIngredient("Ostra włoska pepperoni");
    }

    @Override
    public void buildSauce() {
        pizza.setSauce("Pomidorowy sos z bazylią i oregano");
    }

    @Override
    public Pizza getPizza() {
        return pizza;
    }
}

class HawaiianPizzaBuilder implements PizzaBuilder {
    private Pizza pizza;

    HawaiianPizzaBuilder() {
        this.pizza = new Pizza();
    }

    @Override
    public void buildDough() {
        pizza.setDough("Niezbyt smaczne ciasto");
    }

    @Override
    public void buildMainIngredient() {
        pizza.setMainIngredient("Niepotrzebny ananas");
    }

    @Override
    public void buildSauce() {
        pizza.setSauce("Sos z paczki");
    }

    @Override
    public Pizza getPizza() {
        return pizza;
    }
}

class PizzaEngineer {
    private PizzaBuilder pizzaBuilder;

    public PizzaEngineer(PizzaBuilder pizzaBuilder) {
        this.pizzaBuilder = pizzaBuilder;
    }

    public Pizza getPizza() {
        return this.pizzaBuilder.getPizza();
    }

    public void buildPizza() {
        this.pizzaBuilder.buildDough();
        this.pizzaBuilder.buildMainIngredient();
        this.pizzaBuilder.buildSauce();
    }
}

public class BuilderMain {
    public static void main(String[] args) {
        PizzaBuilder pepperoniPizzaBuilder = new PepperoniPizzaBuilder();
        PizzaBuilder hawaiianPizzaBuilder = new HawaiianPizzaBuilder();

        PizzaEngineer pepperoniPizzaEngineer = new PizzaEngineer(pepperoniPizzaBuilder);
        PizzaEngineer hawaiianPizzaEngineer = new PizzaEngineer(hawaiianPizzaBuilder);

        pepperoniPizzaEngineer.buildPizza();
        hawaiianPizzaEngineer.buildPizza();

        System.out.println(pepperoniPizzaBuilder.getPizza());
        System.out.println(hawaiianPizzaBuilder.getPizza());
    }
}
