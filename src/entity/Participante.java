package entity;

public class Participante {
	private String nome;
	private String email_participante;
	private int matricula_participante;
	private String curso;
	private int semestre;
	private int qtdHorasComplementares;
	private Telefone telefone;

	public Participante() {

	}

	public Participante(String nome, String email, int matricula, String curso, int semestre,int ddd,int num) {
		this.nome = nome;
		this.email_participante = email;
		this.matricula_participante = matricula;
		this.curso = curso;
		this.semestre = semestre;
		this.telefone.setDDD(ddd);
		this.telefone.setNumero(num);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail_participante() {
		return email_participante;
	}

	public void setEmail_participante(String email_participante) {
		this.email_participante = email_participante;
	}

	public int getMatricula_participante() {
		return matricula_participante;
	}

	public void setMatricula_participante(int matricula_participante) {
		this.matricula_participante = matricula_participante;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public int getQtdHorasComplementares() {
		return qtdHorasComplementares;
	}

	public void setQtdHorasComplementares(int qtdHorasComplementares) {
		this.qtdHorasComplementares = qtdHorasComplementares;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Participante [nome=" + nome + ", email_participante=" + email_participante + ", matricula_participante="
				+ matricula_participante + ", curso=" + curso + ", semestre=" + semestre + ", qtdHorasComplementares="
				+ qtdHorasComplementares + ", telefone=" + telefone + "]";
	}
	

}
