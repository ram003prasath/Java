import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AdditionClientXMLRPC {
    public static void main(String[] args) {
        try {
            // Connect to the RMI registry
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Look up the remote object in the registry
            Addition addition = (Addition) registry.lookup("AdditionService");

            // Call the remote method
            int result = addition.add(10, 20);
            System.out.println("The result of addition is: " + result);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
