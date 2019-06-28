package controller;

import entity.Colaborador;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import connection.Connection_Postgres;
import dao.DAO_COLABORADOR;

public class CONTROLLER_COLABORADOR implements Celula, Login {

	Connection_Postgres connection_Postgres = new Connection_Postgres();
	DAO_COLABORADOR colaboradordao = new DAO_COLABORADOR(connection_Postgres);

	@Override
	public boolean CadastrarCelula(String nome, int supervisor, String descricao, String dia, int hora, int minuto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean DeleteCelula(int id_celula) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean UpdateCelula(int id, String nome, String email, String matricula, String curso, String semestre) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void FindCelula(int celula) {
		// TODO Auto-generated method stub

	}

	@Override
	public void FindMysCelula() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean EfetuarLogin(String email, int matricula) {
		boolean teste = false;
		if (colaboradordao.EfetuarLogin(email, matricula)) {
			teste = true;
			System.out.println(teste);
			return teste;
		}
		JOptionPane.showMessageDialog(null, "Usuario não encontrado, tente novamente!");
		return false;
	}

	public Colaborador FindColaboradorAtual(int matricula_colaborador) {
		try {
			Colaborador user = colaboradordao.FindColaboradorAtual(matricula_colaborador);
			return user;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "erro, tente novamente!");
			return null;
		}
	}

	public ArrayList<Colaborador> BuscaColaboradores() {

		return colaboradordao.BuscaColaboradores();

	}

}
