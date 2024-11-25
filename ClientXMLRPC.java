import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.URL;
import java.util.Vector;

public class ClientXMLRPC {

    public static void main(String[] args) {
        try {
            // Configure the XML-RPC client with the server URL
            XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
            config.setServerURL(new URL("http://localhost:8080/RPC2"));

            XmlRpcClient client = new XmlRpcClient();
            client.setConfig(config);

            // Prepare the parameters to send to the server
            Vector<Integer> params = new Vector<>();
            params.addElement(17);  // First parameter
            params.addElement(13);  // Second parameter

            // Make the call to the server and receive the result
            Object result = client.execute("sample.sum", params);

            // Cast the result to the appropriate type and print the sum
            int sum = (Integer) result;
            System.out.println("The sum is: " + sum);

        } catch (Exception e) {
            System.err.println("ClientXMLRPC: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
