abstract class Employee {
    private int accessLevel;
    Employee(int al) {
        this.accessLevel = al;
    }
    int getAccessLevel() {
        return accessLevel;
    }
}

class ImportantEmployee extends Employee {
    ImportantEmployee() {
        super(1);
    }
}

class NormalEmployee extends Employee {
    NormalEmployee() {
        super(0);
    }
}

class EmployeeFactory {
    Employee getEmployee(String e) {
        switch (e) {
            case "important" : return new ImportantEmployee();
            case "normal" : return new NormalEmployee();
        }
        return null;
    }
}

interface ManageAccounts {
    String getInfo();
}

class AccountManager implements ManageAccounts {

    @Override
    public String getInfo() {
        return "Getting info about accounts";
    }
}

class ProxyAccountManager implements ManageAccounts {
    private Employee employee;
    @SuppressWarnings("FieldCanBeLocal")
    private AccountManager accountManager;

    ProxyAccountManager(Employee employee) {
        this.employee = employee;
    }


    @Override
    public String getInfo() {
        if (employee.getAccessLevel()>0) {
            accountManager = new AccountManager();
            return accountManager.getInfo();
        }
        else {
            return "Oops. You don't have permissions to get this super secret info.";
        }
    }
}

public class ProxyFactoryMain {
    public static void main(String[] args) {
        EmployeeFactory employeeFactory = new EmployeeFactory();
        Employee employee = employeeFactory.getEmployee("normal");
        ProxyAccountManager proxyAccountManager = new ProxyAccountManager(employee);
        System.out.println(proxyAccountManager.getInfo());
        employee = employeeFactory.getEmployee("important");
        proxyAccountManager = new ProxyAccountManager(employee);
        System.out.println(proxyAccountManager.getInfo());
    }
}
