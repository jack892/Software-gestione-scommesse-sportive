/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

/**
 *
 * @author Michelino
 */


import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import progettosas.I_ConnSrv;
import progettosas.Login;
import utils.FunzioniDB;
import utils.Message;

import utils.Message;

public class ConnSrv extends UnicastRemoteObject implements I_ConnSrv{


	public ConnSrv() throws RemoteException {
			super();
                        Registry r = LocateRegistry.createRegistry(1099);
                        //bisognerebbe controllare che il registro esista
			r.rebind("ConnSrv", this );
	}

	public Message echoMe(Message m) throws RemoteException {
		m.setContent("Echo: " + m.getContent());
		return m;
	}

	public static void main(String[] args){
		System.out.println("server partito");
	}

    public Login loginUtente(Login l) throws RemoteException {
        if (FunzioniDB.loginUtenti(l.getNome(), l.getPassword() )== true) return l;
        else return null;
    }

    public Login loginGestore(Login l) throws RemoteException {
        if (FunzioniDB.loginGestore(l.getNome(),l.getPassword() ) == true) return l;
        else return null;
    }
}
