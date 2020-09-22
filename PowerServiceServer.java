//import java.math.*;
import java.rmi.*;
import java.rmi.server.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class PowerServiceServer extends UnicastRemoteObject implements PowerService {

Connection connection;
Statement statement;
PreparedStatement ps;

public PowerServiceServer ( ) throws RemoteException {


super ( );
	try{

		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	 connection=DriverManager.getConnection("jdbc:odbc:logindsn");
	statement=connection.createStatement();
		}
	catch(ClassNotFoundException cnf){}
	catch(SQLException se){}


}



public void delete(String query) throws RemoteException,ClassNotFoundException,SQLException

	{

	ps=connection.prepareStatement(query);
	ps.execute();
}


public void update(String query1) throws RemoteException,ClassNotFoundException,SQLException

	{

	ps=connection.prepareStatement(query1);
	ps.execute();
}


public void adding(String query1) throws RemoteException,ClassNotFoundException,SQLException

	{
	ps=connection.prepareStatement(query1);
	ps.execute();


}




public String retreive(String query) throws RemoteException,ClassNotFoundException,SQLException

{	String res=new String();
	ResultSet rs=statement.executeQuery(query);
	ResultSetMetaData metadata=rs.getMetaData();
	int columns=metadata.getColumnCount();
		while(rs.next())
		{
			for(int i=1;i<=columns;i++)
				{

					res+=rs.getString(i);
				}

		}
	return res;
}










public static void main(String[] args) throws Exception {
/*
if (System.getSecurityManager( ) == null)
System.setSecurityManager(new RMISecurityManager( ));
*/
PowerServiceServer svr = new PowerServiceServer( );

Naming.bind("rmi://localhost:1099/PowerService", svr);
System.out.println("Service bound...");

}


}

