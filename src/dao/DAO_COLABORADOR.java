package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import connection.Connection_Postgres;
import entity.Celula;
import entity.Colaborador;

public class DAO_COLABORADOR implements CelulaDao {

	private Connection connection;
	private Connection_Postgres connection_Postgres;

	public DAO_COLABORADOR(Connection_Postgres connection_Postgres) {
		this.connection_Postgres = connection_Postgres;
	}

	public Colaborador FindColaboradorAtual(int matricula_colaborador) {
		String sql = "select * from colaborador where matricula_colaborador=? ";
		Colaborador colaborador = null;
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, matricula_colaborador);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				colaborador = new Colaborador();
				colaborador.setNome(rs.getString("nome_colaborador"));
				colaborador.setEmail(rs.getString("email_colaborador"));
				colaborador.setMatricula(rs.getInt("matricula_colaborador"));
				colaborador.setCurso(rs.getString("curso"));
				colaborador.setSemestre(rs.getInt("semestre"));

			}
			stmt.close();

		} catch (SQLException e) {

		} finally {
			try {
				this.connection.close();
				System.out.println("desconectou do banco");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return colaborador;
	}

	public boolean EfetuarLogin(String email, int matricula) {
		String sql = "select * from colaborador where email_colaborador=? and matricula_colaborador=? ";
		try {
			JOptionPane.showMessageDialog(null, "Carregando...");
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, email);
			stm.setInt(2, matricula);

			ResultSet rs = stm.executeQuery();

			if (rs.next())

			{

				return true;

			} else {
				return false;

			}

		} catch (SQLException e) {

			System.out.println("deu erro no dao Login" + e);

		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		System.out.println("retornando falso dao supervisor");

		return false;

	}

	public ArrayList<Colaborador> BuscaColaboradores() {
		System.out.println("entrou no dao busca colas");
		String sql = "SELECT * FROM colaborador ";
		Colaborador col;
		ArrayList<Colaborador> colaborador = new ArrayList<Colaborador>();
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				col = new Colaborador();
				col.setNome(rs.getString("nome_colaborador"));
				col.setEmail(rs.getString("email_colaborador"));
				col.setCurso(rs.getString("curso"));
				col.setSemestre(rs.getInt("semestre"));
				col.setMatricula(rs.getInt("matricula_colaborador"));
				col.setMatricula_supervisor(rs.getInt("matricula_supervisor"));
				colaborador.add(col);
			}

			stmt.close();

			return colaborador;

		} catch (SQLException e) {
			System.out.println("");
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return colaborador;

	}

	public Celula BuscaCelula(Celula celula) {
		String sq = "SELECT * FROM celula WHERE nome= ?";
		Celula cell = null;
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sq);
			stmt.setString(1, celula.getNome());

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				cell = new Celula();
				cell.setId_celula(rs.getInt("id_celula"));
				return cell;
			}

			stmt.close();

		} catch (SQLException e) {
			System.out.println("");
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cell;

	}

	@Override
	public boolean CadastrarCelula(String celula) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean DeleteCelula(int id_celula) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean UpdateCelula(int celula) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void FindCelula(int id_celula) {
		// TODO Auto-generated method stub

	}

	@Override
	public void FindMysCelula() {
		// TODO Auto-generated method stub

	}

}
