package dao;

public interface CelulaDao {
	public boolean CadastrarCelula(String celula);
	public boolean DeleteCelula(int id_celula);
	public boolean UpdateCelula(int celula);
	public void FindCelula(int id_celula);
	public void FindMysCelula();
}
