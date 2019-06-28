package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import connection.Connection_Postgres;
import entity.Celula;


public class DAO_CELULA {
	private Connection connection;
	private Connection_Postgres connection_Postgres;

	public DAO_CELULA(Connection_Postgres connection_Postgres) {
		this.connection_Postgres = connection_Postgres;
	}

	public boolean cadastraCelula(Celula celula, int dias) {
		System.out.println(celula);
		String sql = "INSERT INTO celula (matricula_colaborador,nome,descricao,bloco,sala,qtdhoras) VALUES (?,?,?,?,?,?)";
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, celula.getMatricula_colaborador());
			stmt.setString(2, celula.getNome());
			stmt.setString(3, celula.getDescricao());
			stmt.setString(4, celula.getBloco());
			stmt.setString(5, celula.getSala());
			stmt.setInt(6, celula.getQtdHora());

			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();

			if (qtdRowsAffected > 0) {
				for (int i = 0; i < dias; i++) {
					int hora, minuto;
					String dia;
					dia = celula.date.get(i).getDia();
					hora = celula.date.get(i).getHora();
					minuto = celula.date.get(i).getMinuto();
					SaveDataCelula(dia, hora, minuto, celula);
				}
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

//	public boolean addDataCelula(int id_celula,String dia,int hora,int minuto) {
//		
//		return false;
//	}
	public boolean SaveDataCelula(String dia, int hora, int minuto, Celula celu) {
		String SQL = "INSERT INTO datacelula (id_celula,dia,hora,minuto) VALUES (?,?,?,?)";
		try {
			System.out.println("entrou no save datas");
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stm = connection.prepareStatement(SQL);
			Celula cel = new Celula();
			cel = BuscaCelula(celu);
			System.out.println("foi no busca celula e voltou");
			stm.setInt(1, cel.getId_celula());
			stm.setString(2, dia);
			System.out.println(dia);
			stm.setInt(3, hora);
			stm.setInt(4, minuto);
			int qtdRowsAffected = stm.executeUpdate();
			stm.close();
			if (qtdRowsAffected > 0) {
				return true;
			}
			return false;

		} catch (SQLException e) {
			System.out.println("Houve um erro no dao cadastra data" + e);
			return false;
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<Celula> findCelula() {
		System.out.println("entrou no dao busca");
		String sql = "SELECT * FROM celula ";
		Celula cell;
		ArrayList<Celula> celular = new ArrayList<Celula>();
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				cell = new Celula();
				cell.setId_celula(rs.getInt("id_celula"));
				cell.setNome(rs.getString("nome"));
				cell.setDescricao(rs.getString("descricao"));
				cell.setBloco(rs.getString("bloco"));
				cell.setSala(rs.getString("sala"));
				cell.setQtdHora(rs.getInt("qtdhoras"));
				cell.setMatricula_colaborador(rs.getInt("matricula_colaborador"));
				celular.add(cell);
			}

			stmt.close();

			return celular;

		} catch (SQLException e) {
			System.out.println("");
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return celular;

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
	public boolean VerificaCelula(int id_celula) {
		String sql = "select * from celula where id_celula=? ";
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id_celula);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return true;

			}
			stmt.close();
			return false;

		} catch (SQLException e) {

		} finally {
			try {
				this.connection.close();
				System.out.println("desconectou do banco");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	public boolean RemoveCelula(int id_celula) {
		String sql = "DELETE FROM celula WHERE id_celula = ?";
		try {
			this.connection = connection_Postgres.getConnection();

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id_celula);

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
}
