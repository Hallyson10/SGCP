package entity;

public class DataCelula {
	protected String dia;
	protected int id_celula;
	protected int hora;
	protected int minuto;
	public DataCelula() {
		
	}
	public DataCelula(int id_celula,String dia,int hora,int minuto) {
		this.id_celula = id_celula;
		this.dia = dia;
		this.hora = hora;
		this.minuto = minuto;
		
	}

	@Override
	public String toString() {
		return "DataCelula [dia=" + dia + ", id_celula=" + id_celula+" " +hora +":"+ minuto + "]";
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public int getId_celula() {
		return id_celula;
	}

	public void setId_celula(int id_celula) {
		this.id_celula = id_celula;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}
	
}
