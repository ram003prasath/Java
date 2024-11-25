// https://repo1.maven.org/maven2/org/apache/xmlrpc/xmlrpc-client/3.1.3/

// https://repo1.maven.org/maven2/org/apache/ws/commons/ws-commons-util/1.0.1/

// https://repo1.maven.org/maven2/org/apache/xmlrpc/xmlrpc-server/3.1.3/

// https://repo1.maven.org/maven2/org/apache/xmlrpc/xmlrpc-common/3.1.3/

// https://repo1.maven.org/maven2/commons-logging/commons-logging/1.2/

import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.webserver.WebServer;

public class ServerXMLRPC {

    // Define the sum method that will be accessible to XML-RPC clients
    public Integer sum(int x, int y) {
        return x + y;
    }

    public static void main(String[] args) {
        try {
            // Start the XML-RPC server on port 8080
            System.out.println("Attempting to start XML-RPC Server...");
            WebServer server = new WebServer(8080);
            XmlRpcServer xmlRpcServer = server.getXmlRpcServer();

            // Create a PropertyHandlerMapping to register the handler
            PropertyHandlerMapping mapping = new PropertyHandlerMapping();
            mapping.addHandler("sample", ServerXMLRPC.class);

            // Set the handler mapping to the server
            xmlRpcServer.setHandlerMapping(mapping);
            server.start();

            System.out.println("Server started successfully on port 8080.");
            System.out.println("Accepting requests. (Press Ctrl+C to stop the server)");

        } catch (Exception e) {
            System.err.println("ServerXMLRPC: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
