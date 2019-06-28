package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.Connection_Postgres;
import entity.Participante;

public class DAO_PARTICIPANTE {
	private Connection connection;
	private Connection_Postgres connection_Postgres;

	public DAO_PARTICIPANTE(Connection_Postgres connection_Postgres) {
		this.connection_Postgres = connection_Postgres;
	}

	public boolean CadastrarParticipante(Participante participante, int id_celula) {

		System.out.println(participante);
		String sql = "INSERT INTO usuarios (nome, matricula) VALUES (?,?)";
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, participante.getNome());
			stmt.setInt(2, participante.getMatricula_participante());

			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();

			if (qtdRowsAffected > 0) {
				CadParticipante(participante, id_celula);
				return true;
			}
			return false;

		} catch (SQLException e) {
			System.out.println("Houve um erro no dao cadastra celula" + e);
			return false;
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public boolean CadParticipante(Participante participante, int id_celula) {

		System.out.println(participante);
		String sql = "INSERT INTO participante (nome_participante, matricula_participante, curso, semestre) VALUES (?,?,?,?)";
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, participante.getNome());
			stmt.setInt(2, participante.getMatricula_participante());
			stmt.setString(3, participante.getCurso());
			stmt.setInt(4, participante.getSemestre());

			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();

			if (qtdRowsAffected > 0) {
				int ddd = participante.getTelefone().getDDD(), num = participante.getTelefone().getNumero();
				SaveNumberParticipante(participante, ddd, num);
				saveParticipanteNaCelula(participante, id_celula);
				return true;
			}
			return false;

		} catch (SQLException e) {
			System.out.println("Houve um erro no dao cadastra celula" + e);
			return false;
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean saveParticipanteNaCelula(Participante participante, int id_celula) {
		String sql = "INSERT INTO celula_participante (id_celula, matricula_participante) VALUES (?,?)";
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, id_celula);
			stmt.setInt(2, participante.getMatricula_participante());

			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();

			if (qtdRowsAffected > 0) {
				return true;
			}
			return false;

		} catch (SQLException e) {
			System.out.println("Houve um erro ao cadastrar participante na celula" + e);
			return false;
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Participante BuscaParticipante(int matricula_participante) {
		String sql = "select * from participante where matricula_participante=? ";
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, matricula_participante);
			Participante part = new Participante();
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				part.setNome(rs.getString("nome_participante"));
				part.setEmail_participante("email_participante");
				part.setMatricula_participante(rs.getInt("matricula_participante"));
				part.setCurso(rs.getString("curso"));
				part.setSemestre(rs.getInt("semestre"));
				return part;
			}
			stmt.close();
			return null;

		} catch (SQLException e) {

		} finally {
			try {
				this.connection.close();
				System.out.println("desconectou do banco");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public void SaveNumberParticipante(Participante participante, int ddd, int num) {
		String sql = "INSERT INTO telefone (matricula_participante, ddd, numero) VALUES (?,?,?)";
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			int matricula_participante = participante.getMatricula_participante();
			stmt.setInt(1, matricula_participante);
			stmt.setInt(2, ddd);
			stmt.setInt(3, num);

			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();

			if (qtdRowsAffected > 0) {
				JOptionPane.showMessageDialog(null, "num salvo");
			}

		} catch (SQLException e) {
			System.out.println("" + e);
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
