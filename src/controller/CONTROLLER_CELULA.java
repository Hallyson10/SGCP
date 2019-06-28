package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import connection.Connection_Postgres;
import dao.DAO_CELULA;
import dao.DAO_COLABORADOR;
import entity.Celula;
import entity.DataCelula;

public class CONTROLLER_CELULA {
	Connection_Postgres connection_Postgres = new Connection_Postgres();
	DAO_CELULA celuladao = new DAO_CELULA(connection_Postgres);
	DAO_COLABORADOR colaboradorA = new DAO_COLABORADOR(connection_Postgres);

	public boolean CadastrarCelula(int id, int matricula_colaborador, String nome, String descricao, String bloco,
			String sala, int qtdHora) {

		Celula celula = new Celula();
		celula.setId_celula(id);
		celula.setNome(nome);
		celula.setMatricula_colaborador(matricula_colaborador);
		celula.setDescricao(descricao);
		celula.setBloco(bloco);
		celula.setSala(sala);
		celula.setQtdHora(qtdHora);
		System.out.println(celula);

		String d = JOptionPane.showInputDialog(null, "Quantos dias na semana ocorrerá a célula?");
		int newDias = Integer.parseInt(d);
		int i = 1;
		while (i <= newDias) {
			String dia = JOptionPane.showInputDialog(i + "º dia");
			String hora = JOptionPane.showInputDialog("Apenas a Hora sem minutos");
			String minuto = JOptionPane.showInputDialog("Apenas o minuto em que inicia");
			int newHora = Integer.parseInt(hora), newMinuto = Integer.parseInt(minuto);

			DataCelula data = new DataCelula(0, dia, newHora, newMinuto);
			if (i <= newDias) {
				celula.date.add(data);
			}
			i++;
		}

		celuladao.cadastraCelula(celula, newDias);

		return true;

	}

	public ArrayList<Celula> findCelula() {

		return celuladao.findCelula();

	}

	public boolean VerificaCelula(int id_celula) {
		return celuladao.VerificaCelula(id_celula);
	}

	public boolean RemoveCelula(int id_celula) {
		return celuladao.RemoveCelula(id_celula);
	}

}
