import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AdditionServerRMI {
    public static void main(String[] args) {
        try {
            // Create an instance of the implementation class
            AdditionImplRMI addition = new AdditionImplRMI();

            // Start the RMI registry
            Registry registry = LocateRegistry.createRegistry(1099);

            // Bind the remote object to the registry with a unique name
            registry.rebind("AdditionService", addition);

            System.out.println("Addition Server is running...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
