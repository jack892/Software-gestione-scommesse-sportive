/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package progettosas;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/**
 *
 * @author Michelino
 */
public class ConnClient {

    private static I_ConnSrv connection=null;

    public static I_ConnSrv getConn() {
        if (connection != null) return connection;
        else {
            try {
                Registry r = LocateRegistry.getRegistry("127.0.0.1", 1099);
                connection = (I_ConnSrv) r.lookup("ConnSrv");
                return connection;
            }  catch (Exception e) {e.printStackTrace();}
       }
        return null; // non voglio restituire null !
    }
}
