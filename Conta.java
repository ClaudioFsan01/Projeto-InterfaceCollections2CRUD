
public class Conta {
	
	protected int numero;
	private String nome;		
	protected double saldo;
	
	public void setNumero(int numero) {
		if(numero<0) {
			System.out.println("Inserir um numero inteiro maior que zero");
		}
		else {
			this.numero = numero;
		}
		
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public void setNome(String nome) {
		if(nome != " " && nome != null) {
			this.nome = nome;
		}
		else {
			System.out.println(" Inserir um nome valido !");
		}
		
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
     
	

}
