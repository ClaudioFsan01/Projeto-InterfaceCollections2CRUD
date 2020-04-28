
public class ContaCorrente extends Conta implements  Transacao{
		
     
	public void deposita(double valor)
	{
		if(valor<0) {
			throw new IllegalArgumentException(" Voce tentou depositar um valor negativo na conta corrente !");
			
		}else {
			this.saldo += valor;
		}
		
		
	}
		

	public void saca(double valor)
	{
		if(valor > this.saldo)
		{	
			throw new SaldoInsuficienteException(valor);		
		}
		else
		{
			this.saldo -= valor;
			
		}
		 
	}
	
	

	
	

}
