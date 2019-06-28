package dao;

import entity.Colaborador;
import entity.Supervisor;
import connection.Connection_Postgres;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DAO_SUPERVISOR implements CelulaDao {
	private Connection connection;
	private Connection_Postgres connection_Postgres;

	public DAO_SUPERVISOR(Connection_Postgres connection_Postgres) {
		this.connection_Postgres = connection_Postgres;
	}

	public boolean EfetuarLogin(String email, int matricula) {
		String sql = "select * from supervisor where email=? and matricula_supervisor=? ";
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

	public Supervisor findSupervisorAtual(String email) {
		String sql = "select * from supervisor where email=? ";
		Supervisor supervisor = null;
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, email);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				supervisor = new Supervisor();
				supervisor.setNome(rs.getString("nome_supervisor"));
				supervisor.setMatricula(rs.getInt("matricula_supervisor"));

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
		return supervisor;
	}

	public boolean CadastrarColaborador(Colaborador colaborador) {
		String sql = "INSERT INTO usuarios (nome,email,matricula) VALUES (?,?,?)";
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			System.out.println(colaborador.getNome());
			stmt.setString(1, colaborador.getNome());
			stmt.setString(2, colaborador.getEmail());
			stmt.setInt(3, colaborador.getMatricula());
			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if (qtdRowsAffected > 0) {
				CadastraCol(colaborador);
				return true;
			}
			return false;

		} catch (SQLException e) {
			System.out.println("Houve um erro no dao cadastra user" + e);
			return false;
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public boolean CadastraCol(Colaborador colaborador) {
		String sql = "INSERT INTO colaborador (nome_colaborador,email_colaborador,matricula_colaborador,matricula_supervisor,curso,semestre) VALUES (?,?,?,?,?,?)";
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			System.out.println(colaborador.getNome());
			stmt.setString(1, colaborador.getNome());
			stmt.setString(2, colaborador.getEmail());
			stmt.setInt(3, colaborador.getMatricula());
			stmt.setInt(4, colaborador.getMatricula_supervisor());
			stmt.setString(5, colaborador.getCurso());
			stmt.setInt(6, colaborador.getSemestre());
			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if (qtdRowsAffected > 0) {
				System.out.println("colaborador cadastrado com sucesso!");
				return true;
			}
			return false;

		} catch (SQLException e) {
			System.out.println("Houve um erro no dao cadastra user" + e);
			return false;
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean RemoveColaborador(int matricula_colaborador) {
		String sql = "DELETE FROM colaborador WHERE matricula_colaborador = ?";
		try {
			this.connection = connection_Postgres.getConnection();

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, matricula_colaborador);

			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if (qtdRowsAffected > 0) {
				System.out.println("Removeu com sucesso");
				return true;
			}
			return false;
		} catch (SQLException e) {
			System.out.println("erro ao tentar excluir colaborador" + e);
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean updateColaborador(Colaborador colaborador, int id) {
		System.out.println("entrou no upcad dao" + colaborador.getMatricula());
		String sql = "UPDATE colaborador SET nome_colaborador = ?,email_colaborador = ?,matricula_colaborador = ?,matricula_supervisor=?, curso = ?, semestre = ? WHERE matricula_colaborador = ?";
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, colaborador.getNome());
			stmt.setString(2, colaborador.getEmail());
			stmt.setInt(3, colaborador.getMatricula());
			stmt.setInt(4, colaborador.getMatricula_supervisor());
			stmt.setString(5, colaborador.getCurso());
			stmt.setLong(6, colaborador.getSemestre());
			stmt.setLong(7, id);

			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if (qtdRowsAffected > 0)
				System.out.println("editado com sucesso!");
			return true;
		} catch (SQLException e) {
			System.out.println("houve um erro ao atualizar os dados do colaborador" + e);
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;

	}
	public boolean UpColaborador(Colaborador colaborador, int id) {
		System.out.println("entrou no upcad dao" + colaborador.getMatricula());
		String sql = "UPDATE colaborador SET nome_colaborador = ?,email_colaborador = ?,matricula_colaborador = ?,matricula_supervisor=?, curso = ?, semestre = ? WHERE matricula_colaborador = ?";
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, colaborador.getNome());
			stmt.setString(2, colaborador.getEmail());
			stmt.setInt(3, colaborador.getMatricula());
			stmt.setInt(4, colaborador.getMatricula_supervisor());
			stmt.setString(5, colaborador.getCurso());
			stmt.setLong(6, colaborador.getSemestre());
			stmt.setLong(7, id);

			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if (qtdRowsAffected > 0)
				System.out.println("editado com sucesso!");
			return true;
		} catch (SQLException e) {
			System.out.println("houve um erro ao atualizar os dados do colaborador" + e);
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
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
