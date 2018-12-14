package modelo;

public class Pagamento {
	private String tipo;
	private String data;
	private double valor;
	private boolean finalizado;
	
	public Pagamento(String tipo, String data, double valor, boolean finalizado) {
		super();
		this.tipo = tipo;
		this.data = data;
		this.valor = valor;
		this.finalizado = finalizado;
	}
	
	@Override
	public String toString() {
		return "Pagamento "
				+ "\n tipo: " + tipo 
				+ "\n data: " + data 
				+ "\n valor: " + valor
				+ "\n finalizado: " + finalizado;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public boolean isFinalizado() {
		return finalizado;
	}
	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
}
