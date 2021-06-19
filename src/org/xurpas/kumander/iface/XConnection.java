/**
 * @author Michael Cuison 2020.12.21
 */
package org.xurpas.kumander.iface;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Timestamp;

public interface XConnection {
    public void setProperty(XProperty foValue);
    public void setCrypt(XCrypt foValue);
    public XCrypt getCrypt();
    
    public void IsOnline(boolean fbValue);
    public boolean IsOnline();
    
    public void setUserID(String fsValue);
    public String getUserID();
    
    public Timestamp getServerDate();
    
    public boolean connect();
    public boolean beginTrans();
    public boolean commitTrans();
    public boolean rollbackTrans();
    public Connection getConnection();
    public ResultSet executeQuery(String fsValue);
    public long executeUpdate(String fsValue);
   
    public String getMessage();

}