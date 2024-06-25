 import java.util.Scanner;
 import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        int opcao=-1;
        
        while(opcao != 3){
            System.out.println("=== MENU ===");
            System.out.println("Escolha a ação para executar no banco:\n1-Criar conta;\n2-Listar contas\n3-Sair");
            opcao = scanner.nextInt();
            System.out.println();

            if(opcao == 1){
                banco.criarConta();
            } else if(opcao == 2){
                banco.exibirContas();
            } else if(opcao == 3){
                System.out.println("Encerrando o programa");
                break;
            }
                
        }
        scanner.close();
     
    }
}
