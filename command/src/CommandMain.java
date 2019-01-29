import java.util.ArrayList;
import java.util.List;

interface Command {
    void execute();
}

class Partition {

    void mount() {
        System.out.println("Mount");
    }

    void unmount() {
        System.out.println("Unmount");
    }

}

class MountCommand implements Command {
    private Partition partition;

    MountCommand(Partition partition) {
        this.partition = partition;
    }

    @Override
    public void execute() {
        partition.mount();
    }
}

class UnmountCommand implements Command {
    private Partition partition;

    UnmountCommand(Partition partition) {
        this.partition = partition;
    }

    @Override
    public void execute() {
        partition.unmount();
    }
}

class PartitionManager {
    private List<Command> commandList;

    PartitionManager() {
        this.commandList = new ArrayList<>();
    }

    void setCommand(Command command) {
        commandList.add(command);
    }

    void executeCommands() {
        for (Command command : commandList) {
            command.execute();
        }
        commandList.clear();
    }
}


public class CommandMain {
    public static void main(String[] args) {
        Partition partition = new Partition();
        PartitionManager partitionManager = new PartitionManager();

        Command mountCommand = new MountCommand(partition);
        Command unmountCommand = new UnmountCommand(partition);

        partitionManager.setCommand(mountCommand);
        partitionManager.setCommand(unmountCommand);

        partitionManager.executeCommands();
    }
}
