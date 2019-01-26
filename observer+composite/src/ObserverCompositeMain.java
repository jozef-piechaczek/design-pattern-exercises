import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(int value, String name);
}

class Client implements Observer{
    private String name;
    private List<Client> clientList;

    Client(String name) {
        this.name = name;
        this.clientList = new ArrayList<>();
    }

    void add(Client c) {
        this.clientList.add(c);
    }

     void remove(Client c) {
        this.clientList.remove(c);
    }

    List<Client> getSubClients() {
        return this.clientList;
    }

    String getName() {
        return this.name;
    }

    @Override
    public void update(int value, String name) {
        System.out.println(this.name+": Hey! "+name+" value changed to: "+value);
        for (Client client : clientList) {
            client.update(value, name);
        }
    }
}

interface Observable {
    void notifyObservers();
    void changeValue(int value);
}

class CompanyStock implements Observable {
    private List<Client> clientList;
    private int value;
    private String name;

    CompanyStock(String name) {
        this.name = name;
        this.clientList = new ArrayList<>();
    }

    void addObserver(Client client) {
        this.clientList.add(client);
    }

    @Override
    public void notifyObservers() {
        for (Client client : clientList) {
            client.update(value, name);
        }
    }

    @Override
    public void changeValue(int value) {
        this.value = value;
        notifyObservers();
    }
}

public class ObserverCompositeMain {
    public static void main(String[] args) {
        Client subClient = new Client("subClient");
        Client upClient = new Client("upClient");
        upClient.add(subClient);

        CompanyStock companyStock = new CompanyStock("Big Company");
        companyStock.addObserver(upClient);
        companyStock.changeValue(10);
    }
}

//
//class Stock {
//    private List<CompanyStock> companyStockList;
//
//    public Stock() {
//        this.companyStockList = new ArrayList<>();
//    }
//
//    public void addCompany(CompanyStock companyStock) {
//        this.companyStockList.add(companyStock);
//    }
//
//
//}
