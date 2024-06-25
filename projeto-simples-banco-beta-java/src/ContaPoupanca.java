public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
        
    }
    
    @Override
    public void depositar() {
        
        
    }

    @Override
    public void sacar() {
        
        
    }

    @Override
    public void transferir() {
        
        
    }

    @Override
    public void imprimirExtrato(){
        System.out.println("=== Extrato Conta Poupança ===");
        super.imprimirInfosComuns();
    }

    

    
    
}
