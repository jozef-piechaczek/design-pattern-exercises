abstract class Advertisement {
    abstract void translate(String language);
    abstract void send();
    void deliver(String language) {
        translate(language);
        send();
    }
}

class SMSAdvertisement extends Advertisement {

    @Override
    void translate(String language) {
        System.out.println("Tłumaczę na "+language);
    }

    @Override
    void send() {
        System.out.println("Wysyłam za pośrednictwem SMS");
    }
}

class MailAdvertisement extends Advertisement {

    @Override
    void translate(String language) {
        System.out.println("Tłumaczę na "+language);
    }

    @Override
    void send() {
        System.out.println("Wysyłam za pośrednictwem email");
    }
}

class VoiceAdvertisement extends Advertisement {

    @Override
    void translate(String language) {
        System.out.println("Tłumaczę na "+language);
    }

    @Override
    void send() {
        System.out.println("Wysyłam za pośrednictwem wiadomości głosowej");
    }
}

public class TemplateMethodMain {
    public static void main(String[] args) {
        Advertisement advertisement = new VoiceAdvertisement();
        advertisement.deliver("ENGLISH");
        advertisement = new SMSAdvertisement();
        advertisement.deliver("SPANISH");
        advertisement = new MailAdvertisement();
        advertisement.deliver("SUAHILI");
    }
}
