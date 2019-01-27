interface SocialNetwork {
    String getMessage();
}

class Facebook implements SocialNetwork {
    @Override
    public String getMessage() {
        return "This is a very long message from " +
                "Facebook which contains forbidden words and is going " +
                "to be cut to fit 50 characters.";
    }
}

class Twitter implements SocialNetwork {
    @Override
    public String getMessage() {
        return "Message from Twitter";
    }
}

abstract class SocialNetworkDecorator implements SocialNetwork {
    private SocialNetwork socialNetwork;

    SocialNetworkDecorator(SocialNetwork socialNetwork) {
        this.socialNetwork = socialNetwork;
    }

    @Override
    public String getMessage() {
        return socialNetwork.getMessage();
    }
}

class CensureDecorator extends SocialNetworkDecorator{

    CensureDecorator(SocialNetwork socialNetwork) {
        super(socialNetwork);
    }

    private String censore(String message) {
        return message.replaceAll("from", "***");
    }

    @Override
    public String getMessage() {
        String messageToCensore;
        messageToCensore = super.getMessage();
        return censore(messageToCensore);
    }
}

class CutMessageDecorator extends SocialNetworkDecorator{

    CutMessageDecorator(SocialNetwork socialNetwork) {
        super(socialNetwork);
    }

    private String cut(String message) {
        return message.substring(0, 50);
    }

    @Override
    public String getMessage() {
        String messageToCensore;
        messageToCensore = super.getMessage();
        return cut(messageToCensore);
    }
}



public class DecoratorMain {
    public static void main(String[] args) {
        CensureDecorator c = new CensureDecorator(new Facebook());
        CutMessageDecorator c2 = new CutMessageDecorator(c);
        System.out.println(c2.getMessage());
    }
}
