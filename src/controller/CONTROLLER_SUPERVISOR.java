package controller;

import entity.Colaborador;
import entity.Supervisor;

import javax.swing.JOptionPane;
import connection.Connection_Postgres;

import dao.DAO_SUPERVISOR;

public class CONTROLLER_SUPERVISOR implements Celula, Login {
	Connection_Postgres connection_Postgres = new Connection_Postgres();
	DAO_SUPERVISOR supervisordao = new DAO_SUPERVISOR(connection_Postgres);

	public boolean CadastrarColaborador(Colaborador colaborador) {
		try {
			if (supervisordao.CadastrarColaborador(colaborador)) {
				return true;
			} else {
				System.out.println("houve um erro no else cadastraColaborador");
				return false;
			}

		} catch (Exception e) {
			System.out.println("houve um erro no controler cadastrocolaborador");
			return false;
		}
	}

	public boolean deleteColaborador(int id_colaborador) {
		supervisordao.RemoveColaborador(id_colaborador);
		return true;
	}

	public boolean EditeColaborador(String nome, String email, int matricula, int matricula_supervisor, String curso,
			int semestre, int oldMatricula) {
		Colaborador coll = new Colaborador(nome, email, matricula, matricula_supervisor, curso, semestre);
		supervisordao.updateColaborador(coll, oldMatricula);
		return true;
	}

	public void FindColaborador(int matricula) {
		// retorno do tipo colaborador, informações do colaborador
	}

	public void FindMysColaboradores() {
		// retorno do tipo arraylist de colaboradores, todos os colaboradores
		// que tem o supervisor
	}

	@Override
	public boolean CadastrarCelula(String nome, int supervisor, String descricao, String dia, int hora, int minuto) {
		return false;

	}

	@Override
	public boolean DeleteCelula(int id_celula) {
		return false;
	}

	@Override
	public boolean UpdateCelula(int id, String nome, String email, String matricula, String curso, String semestre) {
		return false;
	}

	@Override
	public void FindCelula(int matricula) {
		// retorno do tipo celula, informações da celula
	}

	@Override
	public void FindMysCelula() {
		// retorno do tipo arraylist de celulas, todas as celulas
		// que tem o supervisor
	}

	@Override
	public boolean EfetuarLogin(String email, int matricula) {
		boolean teste = false;
		if (supervisordao.EfetuarLogin(email, matricula)) {
			teste = true;
			System.out.println(teste);
			return teste;
		}
		JOptionPane.showMessageDialog(null, "Usuario não encontrado, tente novamente!");
		return false;

	}

	public Supervisor findSupervisorAtual(String email) {
		try {
			Supervisor user = supervisordao.findSupervisorAtual(email);
			return user;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "erro, tente novamente!");
			return null;
		}

	}

}
