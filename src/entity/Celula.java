package entity;

import java.util.ArrayList;

public class Celula {
	private String nome;
	private String descricao;
	private int id_celula = 0;
	private int matricula_colaborador;
	private String bloco;
	private String sala;
	private int qtdHora;
	public ArrayList<DataCelula> date;
	public ArrayList<Participante> participantes;

	public Celula() {
		this.date = new ArrayList<DataCelula>();
	}

	public Celula(int id, int matricula_colaborador, String nome, String descricao, String bloco, String sala) {
		this.id_celula = id;
		this.matricula_colaborador = matricula_colaborador;
		this.nome = nome;
		this.descricao = descricao;
		this.bloco = bloco;
		this.sala = sala;
	}

	public void addDate(DataCelula dt) {
		date.add(dt);
	}

	public int getMatricula_colaborador() {
		return matricula_colaborador;
	}

	public void setMatricula_colaborador(int matricula_colaborador) {
		this.matricula_colaborador = matricula_colaborador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getId_celula() {
		return id_celula;
	}

	public void setId_celula(int id_celula) {
		this.id_celula = id_celula;
	}

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public int getQtdHora() {
		return qtdHora;
	}

	public void setQtdHora(int qtdHora) {
		this.qtdHora = qtdHora;
	}

	public ArrayList<DataCelula> getDate() {
		return date;
	}

	public void setDate(ArrayList<DataCelula> date) {
		this.date = date;
	}

	public ArrayList<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(ArrayList<Participante> participantes) {
		this.participantes = participantes;
	}

	@Override
	public String toString() {
		return "Celula [nome=" + nome + ", descricao=" + descricao + ", id_celula=" + id_celula +" qtd Horas "+qtdHora
				+ ", matricula_colaborador=" + matricula_colaborador + ", bloco=" + bloco + ", sala=" + sala + ", date=" + date + "]";
	}
	

}
