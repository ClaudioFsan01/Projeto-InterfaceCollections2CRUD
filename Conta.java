
public class Conta {
	
	protected int numero;
	private String nome;		
	protected double saldo;
	protected String endereco;
	
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
	
	public void setEndereco(String endereco) {
		if(endereco != " " && endereco != null) {
			this.endereco = endereco;
			System.out.println(" Endereço inserido com sucesso !");
			
		}
		else {
			System.out.println(" Inserir um endereço valido !");
			}	
		
	}
	
	public String getEndereco() {
		return this.endereco;
	}
	
	
	public double getSaldo() {
		return this.saldo;
	}
     
	

}
