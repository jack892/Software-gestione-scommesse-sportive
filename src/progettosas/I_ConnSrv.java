/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package progettosas;

/**
 *
 * @author Michelino
 */

import java.rmi.Remote;
import java.rmi.RemoteException;

import utils.*;


public interface I_ConnSrv extends Remote {

	public Message echoMe(Message m) throws RemoteException;
	public Login loginUtente(Login login) throws RemoteException;
        public Login loginGestore(Login login) throws RemoteException;
}
