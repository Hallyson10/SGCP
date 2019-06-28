package entity;

public class Supervisor extends Usuarios{
	
	public Supervisor() {
		
	}
	public Supervisor(String nome,String email,int matricula) {
		super(nome, email, matricula);

	}
	

	@Override
	public String toString() {
		return "Supervisor Nome : " + getNome() + ", Email : " + getEmail() + "";
	}
	
}
