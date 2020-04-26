import java.util.Scanner;
import java.lang.Math;
import java.util.List;

public class Principal {
	
	public static void main(String [] args) {
		int op;
		
		Scanner sc = new Scanner(System.in);
		Agencia ag = new Agencia();
		Conta conta;
		//Conta conta = new ContaCorrente();		
		
		 //System.out.println(" \n  "+ numSort);
		
		 do {
			   op= menu(sc);
			   
			 switch(op){
			 
			 case 1:
				  conta = new ContaCorrente();				 
				 cadastrarConta(conta,sc);
				 ag.inserirConta(conta);
				 
				 break;
				 
			 case 2:
				 
				  conta = new ContaPoupanca();				 
				 cadastrarConta(conta,sc);
				 ag.inserirConta(conta);
				 break;
				 
			 case 3:
				 
				 List<Conta> listaContas = ag.retornaListaContas(); // retorna a lista de contas
				 exibirListaContas(listaContas);
				 
				 break;
				 
			 case 4:
				 
				 pesquisarConta(sc, ag);		  
				 
				 break;
			 case 5:
				 removerConta(sc, ag);
				 break;
				 
			 case 6:
				 
				 break;
		 }			 
			
			 
		 }while(op !=8);
		 
		 System.out.println(" \n Programa encerrado !");
		 
		 
		
	}
	
	
	
	static int menu(Scanner sc) {
		int op=0;
		
		  System.out.println("    Menu de opçoes : \n");
		  
		  System.out.println("(1)- Criar Conta Corrente : \n"
		  		            +"(2)- Criar Conta Poupança : \n"
		  		            +"(3)- Exibir a lista de contas : \n"
		  		            +"(4)- Pesquisar Conta : \n"
		  		            +"(5)- Remover Conta: \n"
		  		            +"(6)- Alterar Conta na lista: \n" 
		  		            +"(7)- Atualizar Conta : \n"
		  		            +"(8)- Sair");		  
		 op = sc.nextInt();
		  
		return op;
	}
	
	public static void cadastrarConta(Conta conta, Scanner sc) {
		
		int numConta = (int)(Math.random()*1000)+1;	
		
		 conta.setNumero(numConta);
		
		 System.out.println("\n Entre com o nome do titular :");
		 conta.setNome(sc.next());   
		
		 System.out.println("\n Entre com o endereço do titular :");
		 conta.setEndereco(sc.next());	
		 
		 System.out.println("\n Entre com o valor do deposito :");
		 conta.setEndereco(sc.next());	
		 
		 exibirConta(conta);
		
	}
	
	public static void removerConta(Scanner sc, Agencia ag) {
		
		System.out.println(" \n Informe o numero da conta : \n");		 
		  if(ag.removerContaPeloNumero(sc.nextInt())) {
			  System.out.println("\n Conta removida com sucesso ! \n");
		  }
		  else {
			  System.out.println("\n Conta não foi encontrada ! \n");
		  }
		
	}
	
	public static void pesquisarConta(Scanner sc, Agencia ag) {
		
		 System.out.println(" \n Informe o numero da conta : \n");		 
		 Conta conta = ag.pesquisarContaPeloNumero(sc.nextInt());
		 
		  if(conta != null) {
			  exibirConta(conta);
		  }else {
			  System.out.println("\n Conta não foi encontrada ! \n");
		  }
	}
	
	public static void exibirConta(Conta conta) {
		
	 System.out.println("\n Dados da Conta : \n");
	 
	 System.out.println("\n Numero : "+ conta.getNumero()+ "- Titular : "+ conta.getNome()+ " - Endereço : "+ conta.getEndereco()+ " - Saldo : "+ conta.getSaldo());
	}
	
	public static void exibirListaContas(List<Conta> listaContas) {
		for(Conta conta : listaContas) {
			System.out.println("\n Numero : "+ conta.getNumero()+ "- Titular : "+ conta.getNome()+ " - Endereço : "+ conta.getEndereco()+ " - Saldo : "+ conta.getSaldo());	
		}
	}
	
	

}





