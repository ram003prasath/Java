import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Remote Interface
interface Addition extends java.rmi.Remote {
    int add(int x, int y) throws RemoteException;
}

// Implementation of the remote interface
class AdditionImpl extends UnicastRemoteObject implements Addition {

    protected AdditionImpl() throws RemoteException {
        super();
    }

    @Override
    public int add(int x, int y) throws RemoteException {
        return x + y;
    }
}

// Server Class
public class AdditionServerXMLRPC {
    public static void main(String[] args) {
        try {
            // Create the implementation object
            AdditionImpl addition = new AdditionImpl();

            // Start the RMI registry
            Registry registry = LocateRegistry.createRegistry(1099);

            // Bind the remote object in the registry
            registry.rebind("AdditionService", addition);

            System.out.println("Addition Server is running...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
