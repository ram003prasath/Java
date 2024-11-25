import java.rmi.Remote;
import java.rmi.RemoteException;

// Remote Interface
public interface AdditionRMI extends Remote {
    int add(int x, int y) throws RemoteException;
}
