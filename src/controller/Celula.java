package controller;

public interface Celula {
	public boolean CadastrarCelula(String nome,int supervisor,String descricao,String dia,int hora,int minuto);
	public boolean DeleteCelula(int id_celula);
	public boolean UpdateCelula(int id,String nome,String email,String matricula,String curso,String semestre);
	public void FindCelula(int celula);
	public void FindMysCelula();
}
