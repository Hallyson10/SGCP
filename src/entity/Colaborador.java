package entity;

public class Colaborador extends Usuarios{
	protected String curso;
	protected int semestre;
	protected int matricula_supervisor;
	public Colaborador() {
		
	}
	public Colaborador(String nome,String email, int matricula,int matricula_supervisor,String curso,int semestre) {
		super(nome,email,matricula);
		this.curso = curso;
		this.semestre = semestre;
		this.matricula_supervisor = matricula_supervisor;
	}
	
	public int getMatricula_supervisor() {
		return matricula_supervisor;
	}
	public void setMatricula_supervisor(int matricula_supervisor) {
		this.matricula_supervisor = matricula_supervisor;
	}
	@Override
	public String toString() {
		return "Colaborador [curso=" + curso + ", semestre=" + semestre + ", getNome()=" + getNome() + ", getEmail()="
				+ getEmail() + ", getMatricula()=" + getMatricula() + "]";
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
	
}
