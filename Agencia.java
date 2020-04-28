import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Agencia {
	/*
	Tamb�m declaramos atributos como List em vez de nos comprometer como uma ou outra
	implementa��o. Dessa forma obtemos um baixo acoplamento: podemos trocar a implementa��o, j� que
	estamos programando para a interface! Por exemplo: */
   /*
	private List<ContaCorrente> contasCorrentes;
	private List<ContaPoupanca> constasPoupancas;
	*/
	
	private List<Conta> contas;
	
	/*
	 � boa pr�tica trabalhar com a interface em todos os lugares poss�veis:
    m�todos que precisam receber, retornar uma lista de objetos ou add objetos em uma lista t�m List como par�metro em vez de uma
    implementa��o em espec�fico como ArrayList , deixando o m�todo mais flex�vel:
	 */
	
	// tanto a classe ArrayList quanto a LinkedList implementam a interface List
	
	public void inserirConta(Conta conta) {
		contas = new ArrayList<>(); // criando a lista de conta corrente ou poupan�a
		
		if(contas.add(conta)==true) {
			System.out.println(" Conta inserida com sucesso ! \n");
		}else {
			System.out.println(" Conta n�o foi inserida com sucesso ! \n");
		}
		
	}
	
	/*
	public void inserirContaPoupanca(ContaPoupanca conta) {
		
		constasPoupancas = new LinkedList<>();
		
		constasPoupancas.add(conta);
		
	}
	*/
	public List<Conta> retornaListaContas(){
		tratarListaVazia();
		return contas;  // retonra a lista de conta corrente
	}
	
	/*
	public List<ContaPoupanca> retornaListaContaPoupanca(){
		return constasPoupancas;  // retonra a lista de conta poupan�as
	}*/
	
	public Conta pesquisarContaPeloNumero(int numero) {
		
		tratarListaVazia();
		
		for(Conta conta : contas) {// percorrendo cada item da lista contas e atribuindo cada objeto a variavel conta  // forEch em java
			if(conta.numero == numero) { // verificando se o numero da conta de cada objeto acessado na lista contas � igual ao numero passado no parametro
				
				return conta;// caso possua na lista uma conta com o numero igual passado no parametro essa conta sera retornada
			}		
			
		}		
		
		return null;	// caso n�o possua uma conta com o numero igual ao pesquisado	
		
	}
	
	// pesquisar conta pelo index
	
	
	
	// remover uma conta da lista
	
	public void removerConta(int index ) {
		tratarListaVazia();
		
		  if(contas.remove(index) !=null) {
			  System.out.println(" Elemento removido com sucesso !");
		  }else {
			  System.out.println(" Elemento n�o foi removido com sucesso !");
		  }
	}
	
	public boolean removerContaPeloNumero(int numero) {
		tratarListaVazia();
		
		for(Conta conta : contas) { // percorrendo cada item da lista contas e atribuindo cada objeto a variavel conta  // forEch em java
			
			if(conta.numero == numero) { // verificando se o numero da conta de cada objeto acessado � igual ao numero passado no parametro
				contas.remove(conta); // se o numero da conta do objeto acessado for igual ao numero passado no parametro 
				// o objeto em questao ser� removido da lista
				return true;
			}
		}
		
		return false;		
		
		
	}
	
	// alterar contas na lista 
	
	/*public void alterarContas(int numeroContaAntiga, Conta nova) {
		
		if(removerContaPeloNumero(numeroContaAntiga)) {
			System.out.println("Conta antiga removida com sucesso ! \n");
		}else {
			System.out.println("Conta antiga n�o foi removida com sucesso ! \n");
		}
		
		inserirConta(nova);
		
	}*/
	
	
	// atualizar endere�o da conta
	
	
	public boolean atualizarEndereco(int numeroConta, String endereco) {
		tratarListaVazia();
		
		for(Conta conta : contas) {
			if(conta.numero == numeroConta) {
				conta.setEndereco(endereco);
				return true;
			}
			
		}
		
		return false;
	}
	
	
	public void tratarListaVazia() { // verifica se a lista est� vazia caso sim lan�a a exce��o de ponteiro nulo
		if(contas == null) {
			throw new NullPointerException(" Lista vazia ! \n"); 
		}
		
	}
	
}
