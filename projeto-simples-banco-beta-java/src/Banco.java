import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Locale;

public class Banco {
    private List<Conta> contas;
    private List<Cliente> clientes;
    
    public Banco(){
        this.contas = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    

    public Cliente cadastroCliente(){

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Digite o seu nome: ");
        String nomeScanner = scanner.nextLine();
        System.out.println("Digite o seu cpf: ");
        String cpfScanner = scanner.nextLine();
        System.out.println("Digite o seu telefone: ");
        String telefoneScanner = scanner.nextLine();
        
        Cliente cliente = new Cliente(nomeScanner, cpfScanner, telefoneScanner);
        clientes.add(cliente);
        return cliente;
        
    }

    public void exibirContas(){
        System.out.println(contas);
    }

    
    public void criarConta(){
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("1. Conta Corrente");
        System.out.println("2. Conta Poupança");
        System.out.print("Escolha uma opção: ");
        int tipoConta = scanner.nextInt();
        System.out.println();

        if(tipoConta == 1){
            Conta cc = new ContaCorrente(cadastroCliente());
            contas.add(cc);
            System.out.println("Conta corrente criada com sucesso!");
            while(true){
                System.out.printf("=== Bem vindo ===");
                System.out.println("Escolha a ação para executar no banco: 1-Sacar;\n2-Depositar;\n3-Transferir;\n4-Voltar.");
                int opcao = scanner.nextInt();
    
                switch(opcao){
                    case 1:
                    System.out.println("Qual o valor que deseja sacar?");
                    double saque = scanner.nextDouble();
                    cc.sacar(saque);
                    cc.imprimirExtrato();
                    break;
    
                    case 2:
                    System.out.println("Qual o valor que deseja depositar?");
                    double deposito = scanner.nextDouble();
                    cc.depositar(deposito);
                    cc.imprimirExtrato();
                    break;
    
                    case 3:
                    System.out.println("Informe o nome do titular para transferir: ");
                    String nome = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Informe o valor que deseja transferir: ");
                    double valor = scanner.nextDouble();
                    cc.transferir(valor, pesquisarPorTitular(nome));
                    break;

                    case 4:
                    return;
                    
                }
                
            }

        } else if(tipoConta == 2){
            Conta pp = new ContaPoupanca(cadastroCliente());
            contas.add(pp);
            System.out.println("Conta poupanca criada com sucesso!");
            while(true){
                System.out.printf("=== Bem vindo ===");
                System.out.println("Escolha a ação para executar no banco: 1-Sacar;\n2-Depositar;\n3-Transferir;\n4-Voltar.");
                int opcao = scanner.nextInt();
    
                switch(opcao){
                    case 1:
                    System.out.println("Qual o valor que deseja sacar?");
                    double saque = scanner.nextDouble();
                    pp.sacar(saque);
                    pp.imprimirExtrato();
                    break;
    
                    case 2:
                    System.out.println("Qual o valor que deseja depositar?");
                    double deposito = scanner.nextDouble();
                    pp.depositar(deposito);
                    pp.imprimirExtrato();
                    break;
                    
                    case 3:
                    System.out.println("Informe o nome do titular para transferir: ");
                    String nome = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Informe o valor que deseja transferir: ");
                    double valor = scanner.nextDouble();
                    pp.transferir(valor, pesquisarPorTitular(nome));

                    case 4:
                    return;
                    
                }
                
            }
        } else{
            System.out.println("Informe um dado válido");
        }
    }

    public Conta pesquisarPorTitular(String nome){
        Conta contaPorTitular = null;
        if(!contas.isEmpty()){
            for(Conta conta : contas){
                Cliente clienteTitular = conta.getCliente(); // Assumindo que Conta tem um método getCliente()
                if(clienteTitular.getNome().equalsIgnoreCase(nome)){
                    contaPorTitular = conta;
                    break;
                }
            }
        }
        return contaPorTitular;
    }
    
}
