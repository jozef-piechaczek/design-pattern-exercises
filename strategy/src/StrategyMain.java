interface SendStrategy {
    void send(String message);
}

interface TranslateStrategy {
    String translate(String message);
}

class SendSMS implements SendStrategy {

    @Override
    public void send(String message) {
        System.out.println("Sent by SMS: "+message);
    }
}

class SendMail implements SendStrategy {

    @Override
    public void send(String message) {
        System.out.println("Sent by MAIL: "+message);
    }
}

class SpanishTranslate implements TranslateStrategy {

    @Override
    public String translate(String message) {
        return "(Spanish)"+message;
    }
}

class SuahiliTranslate implements TranslateStrategy {

    @Override
    public String translate(String message) {
        return "(Suahili)"+message;
    }
}

class TranslateContext {
    private TranslateStrategy translateStrategy;

    public TranslateContext(TranslateStrategy translateStrategy) {
        this.translateStrategy = translateStrategy;
    }

    public String executeTranslate(String message) {
        return translateStrategy.translate(message);
    }
}

class SendContext {
    private SendStrategy sendStrategy;

    public SendContext(SendStrategy sendStrategy) {
        this.sendStrategy = sendStrategy;
    }

    public void executeSend(String message) {
        sendStrategy.send(message);
    }
}

public class StrategyMain {
    public static void main(String[] args) {
        String message = "this is a message";
        TranslateContext translateContext = new TranslateContext(new SpanishTranslate());
        SendContext sendContext = new SendContext(new SendSMS());
        message = translateContext.executeTranslate(message);
        sendContext.executeSend(message);
    }
}
