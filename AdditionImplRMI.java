import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

// Implementation of the remote interface
public class AdditionImplRMI extends UnicastRemoteObject implements AdditionRMI {

    protected AdditionImplRMI() throws RemoteException {
        super();
    }

    @Override
    public int add(int x, int y) throws RemoteException {
        return x + y;
    }
}
