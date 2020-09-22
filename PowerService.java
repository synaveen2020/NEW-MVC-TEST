//import java.math.BigInteger;
import java.rmi.*;
import java.io.*;
import java.sql.*;
import java.util.*;

//
// PowerService Interface
//
// Interface for a RMI service that calculates powers
//
public interface PowerService extends java.rmi.Remote
{
	// Calculate the square of a number
	public String retreive(String query)
		throws RemoteException,ClassNotFoundException,SQLException;

	public void delete(String query)
		throws RemoteException,ClassNotFoundException,SQLException;

	public void update(String query)
		throws RemoteException,ClassNotFoundException,SQLException;


	public void adding(String query1)
		throws RemoteException,ClassNotFoundException,SQLException;






	// Calculate the power of a number
	//public BigInteger power  ( int num1, int num2)
	//	throws RemoteException;
}
