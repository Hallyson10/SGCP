package connection;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Connection_Postgres {
	Connection drive;
	private final String ip = "localhost";
	private final Integer port = 5432;
	private final String user = "postgres";
	private final String password = "@HMhallyson10";
	private final String database = "CELULAS_PACCE";

	public Connection getConnection() {
		Connection conection = null;
		try {
			// Class.forName("org.postgresql.Driver");
			conection = DriverManager.getConnection("jdbc:postgresql://" + ip + ":" + port + "/" + database, user,
					password);
			System.out.println("conexão ao banco de dados realizada com sucesso!");
			return conection;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro de conexão!");
			throw new RuntimeException(e);
		}
	}

	public void getDesconnect() {
	}
}