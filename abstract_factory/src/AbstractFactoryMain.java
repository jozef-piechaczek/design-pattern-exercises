interface Header  {
    void action();
}

interface Body {
    void action();
}

interface Footer {
    void action();
}

class JSONHeader implements Header {
    @Override
    public void action() {
        System.out.println("JSONHeader");
    }
}


class JSONBody implements Body {
    @Override
    public void action() {
        System.out.println("JSONBody");
    }
}


class JSONFooter implements Footer {
    @Override
    public void action() {
        System.out.println("JSONFooter");
    }
}


class XMLHeader implements Header {
    @Override
    public void action() {
        System.out.println("XMLHeader");
    }
}


class XMLBody implements Body {
    @Override
    public void action() {
        System.out.println("XMLBody");
    }
}


class XMLFooter implements Footer {
    @Override
    public void action() {
        System.out.println("XMLFooter");
    }
}

abstract class AbstractFactory {
    abstract Header getHeader();
    abstract Body getBody();
    abstract Footer getFooter();
}

class JSONFactory extends AbstractFactory{
    @Override
    Header getHeader() {
        return new JSONHeader();
    }

    @Override
    Body getBody() {
        return new JSONBody();
    }

    @Override
    Footer getFooter() {
        return new JSONFooter();
    }
}

class XMLFactory extends AbstractFactory {

    @Override
    Header getHeader() {
        return new XMLHeader();
    }

    @Override
    Body getBody() {
        return new XMLBody();
    }

    @Override
    Footer getFooter() {
        return new XMLFooter();
    }
}

class FactoryProducer {
    AbstractFactory getFactory(String name) {
        switch (name) {
            case "XML": return new XMLFactory();
            case "JSON": return new JSONFactory();
        }
        return null;
    }
}

public class AbstractFactoryMain {
    public static void main(String[] args) {
        FactoryProducer factoryProducer = new FactoryProducer();
        AbstractFactory abstractFactory = factoryProducer.getFactory("XML");
        Header header = abstractFactory.getHeader();
        header.action();
    }
}
