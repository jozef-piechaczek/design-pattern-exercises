import java.util.ArrayList;
import java.util.List;

interface Mediator {
    void send(String client, String message);
    void addClient(Client client);
}

interface Client {
    void setMediator(Mediator mediator);
    void send(String client, String message);
    void receive(String message);
    String getName();
}

class ChatMediator implements Mediator {
    private List<Client> clientList;

    ChatMediator() {
        clientList = new ArrayList<>();
    }

    @Override
    public void send(String client, String message) {
        for (Client c : clientList) {
            if (c.getName().equals(client))
                c.receive(message);
        }
    }

    @Override
    public void addClient(Client client) {
        clientList.add(client);
    }
}

class ChatClient implements Client {
    private String name;
    private Mediator mediator;

    ChatClient(String name, Mediator mediator) {
        this.name = name;
        setMediator(mediator);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
        mediator.addClient(this);
    }

    @Override
    public void send(String client, String message) {
        System.out.println("INFO: Sending message \""+message+"\" from "+name+" to "+client);
        mediator.send(client, message);
    }

    @Override
    public void receive(String message) {
        System.out.println("INFO: Client "+name+" received message \""+message+"\".");
    }
}

public class MediatorMain {
    public static void main(String[] args) {
        ChatMediator chatMediator = new ChatMediator();
        ChatClient bozena = new ChatClient("Bożena", chatMediator);
        ChatClient marzena = new ChatClient("Marzena", chatMediator);
        ChatClient grazyna = new ChatClient("Grażena", chatMediator);

        bozena.send("Marzena", "Bla bla bla plotki");
        marzena.send("Bożena", "Wow cóż za ciekawe plotki bla bla bla");
        grazyna.send("Marzena", "Weź nie plotkuj tak");
    }
}








//import java.util.ArrayList;
//import java.util.List;
//
//interface Mediator {
//    void addBidder(Bidder bidder);
//    void closeAuction();
//}
//
//class AuctionMediator implements Mediator {
//    private List<Bidder> bidderList;
//
//    public AuctionMediator() {
//        this.bidderList = new ArrayList<>();
//    }
//
//    @Override
//    public void addBidder(Bidder bidder) {
//        bidder.setMediator(this);
//        this.bidderList.add(bidder);
//    }
//
//    @Override
//    public void closeAuction() {
//        Bidder auctionWinner;
//        for (Bidder bidder : bidderList) {
//
//        }
//    }
//}
//
//interface Bidder {
//    void bid(int price);
//    void setMediator(Mediator mediator);
//}
//
//class AuctionBidder implements Bidder {
//    private int price;
//    private String name;
//    private Mediator mediator;
//
//    public AuctionBidder(String name, Mediator mediator) {
//        this.name = name;
//        mediator.addBidder(this);
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    @Override
//    public void bid(int price) {
//        this.price = price;
//    }
//
//    @Override
//    public void setMediator(Mediator mediator) {
//        this.mediator = mediator;
//    }
//}
//
//
//
//
//public class MediatorMain {
//    public static void main(String[] args) {
//
//    }
//}
