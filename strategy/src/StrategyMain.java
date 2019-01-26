interface SendInterface {
    void send(String message);
}

interface TranslateInterface {
    String translate(String message);
}

class SendSMS implements SendInterface {

    @Override
    public void send(String message) {
        System.out.println("Sent by SMS: "+message);
    }
}

class SendMail implements SendInterface {

    @Override
    public void send(String message) {
        System.out.println("Sent by MAIL: "+message);
    }
}

class SpanishTranslate implements TranslateInterface {

    @Override
    public String translate(String message) {
        return "(Spanish)"+message;
    }
}

class SuahiliTranslate implements TranslateInterface {

    @Override
    public String translate(String message) {
        return "(Suahili)"+message;
    }
}

public class StrategyMain {
    public static void main(String[] args) {
        String message = "this is a message";
        SuahiliTranslate suahiliTranslate = new SuahiliTranslate();
        message = suahiliTranslate.translate(message);
        SendMail sendMail = new SendMail();
        sendMail.send(message);
    }
}
