
//import java.math.*;
import java.rmi.*;
import java.io.*;
import java.sql.*;
import java.util.*;


public class PowerServiceClient {




PowerService server = null;
public PowerServiceClient ( ) throws RemoteException {

super ( );


try {

server = (PowerService)Naming.lookup("rmi://localhost:1099/PowerService");
System.out.println("PowerServer found.");

/*BigInteger sq = server.square(5);
System.out.println(String.valueOf(sq.intValue()));

BigInteger pwr = server.power(5, 2);
System.out.println(String.valueOf(pwr.intValue()));*/


} // try

catch (Exception e) {
System.err.println("PowerServer exception: " + e.getMessage());
e.printStackTrace();

} // catch

}

	public void add() throws RemoteException,ClassNotFoundException,SQLException
		{String str="select * from qudsia where RNO=3";
		System.out.println("the result is:"+server.retreive(str));}


	public void del() throws RemoteException,ClassNotFoundException,SQLException
		{
		server.delete("delete from qudsia where RNO=2");
		System.out.println("record deleted");
		}


	public void edit() throws RemoteException,ClassNotFoundException,SQLException
		{/*BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter the name:");
		String n=br.readLine();
		System.out.println("enter the age:");
		String age=br.readLine();
		int ag=Integer.parseInt(age);
		System.out.println("enter the rno:");
		String rn=br.readLine();
	    int r=Integer.parseInt(rn);*/
		server.update("UPDATE qudsia SET NAME=\'GHOOFY\',AGE=66 WHERE RNO=3");
		System.out.println("record updated");
		}



	public void add1() throws RemoteException,ClassNotFoundException,SQLException
		{
		server.adding("insert into qudsia values (10,\'nida\',45)");
		System.out.println("record added");
		}






	public static void main(String args[]) {
		try
		{	PowerServiceClient psc=new PowerServiceClient();
			psc.add();
			psc.add1();
			psc.del();
			psc.edit();
		}catch(RemoteException re){System.out.println(re);}
		catch(SQLException se){}
		catch(ClassNotFoundException cnfe){System.out.println(cnfe);}



} // main()


} // PowerServiceClient

