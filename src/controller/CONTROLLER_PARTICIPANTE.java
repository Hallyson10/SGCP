package controller;

import connection.Connection_Postgres;
import dao.DAO_PARTICIPANTE;
import entity.Participante;

public class CONTROLLER_PARTICIPANTE {
	Connection_Postgres connection_Postgres = new Connection_Postgres();
	DAO_PARTICIPANTE colaboradordao = new DAO_PARTICIPANTE(connection_Postgres);
	
	public boolean CadastrarParticipante(Participante participante,int id_celula) {
		System.out.println("controller parti");
		return colaboradordao.CadastrarParticipante(participante,id_celula);
	}
}
