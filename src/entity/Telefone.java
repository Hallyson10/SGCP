package entity;

public class Telefone {
	private int DDD;
	private int numero;
	public Telefone() {
		
	}
	public Telefone(int ddd, int numero) {
		this.DDD = ddd;
		this.numero = numero;
	}
	public int getDDD() {
		return DDD;
	}
	public void setDDD(int dDD) {
		DDD = dDD;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	@Override
	public String toString() {
		return "Telefone ("+DDD+") "+numero;
	}
	
}
