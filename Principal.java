import java.util.Scanner;
import java.lang.Math;
import java.util.List;

public class Principal {
	
	public static void main(String [] args) {
		int op;
		
		Scanner sc = new Scanner(System.in);
		Agencia ag = new Agencia();
		Conta conta= null;
		//Conta conta = new ContaCorrente();		
		
		 //System.out.println(" \n  "+ numSort);
		
		 do {
			   op= menu(sc);
			   
			 switch(op){
			 
			 case 1:
				 try {
					 conta = new ContaCorrente();				 
					 cadastrarConta(conta,sc);
					 ag.inserirConta(conta);
					 
				 }catch(IllegalArgumentException e) {
					 System.out.println(" \n"+ e.getMessage());		
				 }
				 
				 
				 break;
				 
			 case 2:
				 try {
					 conta = new ContaPoupanca();				 
					 cadastrarConta(conta,sc);
					 ag.inserirConta(conta);
				 }catch(IllegalArgumentException e) {
					 System.out.println(" \n"+ e.getMessage());		
				 }
				  
				 break;
				 
			 case 3:
				 try {
				 List<Conta> listaContas = ag.retornaListaContas(); // retorna a lista de contas
				 exibirListaContas(listaContas);
				 }catch(NullPointerException e) {
					 System.out.println(" \n"+ e.getMessage());					 
				 }
				 break;
				 
			 case 4:
				 try {
				 pesquisarConta(sc, ag);
				 }catch(NullPointerException e) {					
					 System.out.println(e.getMessage());
				 }
				 
				 break;
			 case 5:
				 try {
				 removerConta(sc, ag);
				 }catch(NullPointerException e) {
					 System.out.println(" \n"+ e.getMessage());				
				 }
				 break;
				 
			 case 6:
				    try {
				    	 alterarConta(sc, conta, ag);	
				    }catch(NullPointerException e) {
				    	System.out.println(" \n"+ e.getMessage());			
				    }			 
					
				 break;
				 
			 case 7:
				 try {
				 atualizarConta(sc, conta, ag);
				 }catch(NullPointerException e) {
					 System.out.println(" \n"+ e.getMessage());	
				 }
				 break;
				 
			 case 8:
				 try {
					 realizarDeposito(sc, conta, ag);
				 }catch(IllegalArgumentException e) {
					 System.out.println(" \n"+ e.getMessage());	
				 }catch(NullPointerException e) {
					 System.out.println(" \n"+ e.getMessage());	
				 }
				
				 break;
				 
			 case 9:
				 try {
					 realizarSaque(sc, conta, ag);
				 }catch(SaldoInsuficienteException e) {
					 System.out.println(" \n"+ e.getMessage());	
					 System.out.println(" \n"+ e.getMensagem());	 /*Somente no método saca da classe ContaPoupanca
					   é passado uma String no parametro do construtor  SaldoInsuficienteException. 
					   Criei um método personalizado getMensagem() para retornar essa mensagem */  
				 }catch(NullPointerException e) {
					 System.out.println(" \n"+ e.getMessage());	
				 }
				
				 break;
				 
			 case 10:
				 System.out.println(" \n Programa encerrado ! \n");
				 break;
				 
				 default:
					 System.out.println(" \n Opção invalida !");
					 break;
		 }			 
			
			 
		 }while(op !=10);
		 
		
		 
		 
		
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
		  		            +"(8)- Depositar : \n"
		  		            +"(9)- Sacar : \n"
		  		            +"(10)- Sair");		  
		 op = sc.nextInt();
		  
		return op;
	}
	
	public static void  atualizarConta(Scanner sc, Conta conta, Agencia ag) {
		
		System.out.println(" Entre com o numero da conta : \n");
		int numeroConta = sc.nextInt();
		
		System.out.println(" Entre com o endereço atual do titular da conta : \n");
		String endereco = sc.next();
		
		if(! ag.atualizarEndereco(numeroConta, endereco)) {// se o retorno igual a falso
			System.out.println(" Conta inexistente ou numero da conta invalido ! \n");
		}
		
	}
	
	public static void alterarConta(Scanner sc, Conta conta, Agencia ag) {
		
		 removerConta(sc,ag);	
		
		  System.out.println(" \n Deseja inserir uma Conta (1-Corrente) (2- Poupança) :\n");
		    if(sc.nextInt()==1) {
		    	conta = new ContaCorrente();
		    	cadastrarConta(conta,sc);
		    	ag.inserirConta(conta);
		    }else {
		    	conta = new ContaPoupanca();
		    	cadastrarConta(conta,sc);
		    	ag.inserirConta(conta);
		    }
			
		
	}
	
	
	public static void cadastrarConta(Conta conta, Scanner sc) {
		
		int numConta = (int)(Math.random()*1000)+1;	
		
		 conta.setNumero(numConta);
		
		 System.out.println("\n Entre com o nome do titular :");
		 conta.setNome(sc.next());   
		
		 System.out.println("\n Entre com o endereço do titular :");
		 conta.setEndereco(sc.next());	
		 
		 System.out.println("\n Entre com o valor do deposito :");
		 conta.deposita(sc.nextDouble());			 
		 exibirConta(conta);
		
	}
	
	public static void removerConta(Scanner sc, Agencia ag) {
		
		
		System.out.println(" \n Remover pelo (1-numero da conta) ou (2-index) ? : \n");	
		if(sc.nextInt()==1) {
			System.out.println(" \n Informe o numero da conta : \n");		 
			  if(ag.removerContaPeloNumero(sc.nextInt())) {
				  System.out.println("\n Conta removida com sucesso ! \n");
			  }
			  else {
				  System.out.println("\n Conta não foi encontrada ! \n");
			  }
			
			
		}else {
			System.out.println(" \n Informe o index : \n");	
			 ag.removerConta(sc.nextInt()-1);			
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
	
	public static void  realizarDeposito(Scanner sc, Conta conta, Agencia ag) {
		
		 System.out.println("\n Entre com o numero da Conta : \n");
		  conta = ag.pesquisarContaPeloNumero(sc.nextInt());
		  if(conta != null) {
			  
		 System.out.println("\n Entre com o valor do deposito : \n");
			  conta.deposita(sc.nextDouble());
		  }else {
			  System.out.println("\n Conta não encontrada ou inexistente : \n");
		  }
		
		
	}
	
	public static void  realizarSaque(Scanner sc, Conta conta, Agencia ag) {
		
		 System.out.println("\n Entre com o numero da Conta : \n");
		  conta = ag.pesquisarContaPeloNumero(sc.nextInt());
		  if(conta != null) {
			  
		 System.out.println("\n Entre com o valor do saque : \n");
			  conta.saca(sc.nextDouble()); 
		  }else {
			  System.out.println("\n Conta não encontrada ou inexistente : \n");
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





