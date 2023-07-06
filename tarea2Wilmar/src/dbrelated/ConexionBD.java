package dbrelated;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

	String nombre = "jdbc:h2:~/baseDatosPractica2Wilmar";
	String userName = "";
	String passWd = "";
	Connection conx = null;

	public ConexionBD() {

		try {

			Class.forName("org.h2.Driver");
			conx = DriverManager.getConnection(nombre + userName + passWd);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public Connection getConx() {
		return conx;
	}
	
	public void closeConx() {
		conx = null; 
	}

}
