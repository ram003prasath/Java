import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AdditionClientRMI {
    public static void main(String[] args) {
        try {
            // Get the registry from the server
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Look up the remote object by its name
            AdditionRMI additionRMI = (AdditionRMI) registry.lookup("AdditionService");

            // Call the remote method
            int result = additionRMI.add(5, 3);
            System.out.println("Result of addition: " + result);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
