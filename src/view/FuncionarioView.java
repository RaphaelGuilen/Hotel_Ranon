
package view;

import banco.BancoDadosHotel;
import controllers.FuncionarioController;
import hotel_ranon.Hotel_Ranon;
import java.util.InputMismatchException;
import java.util.Scanner;
import models.Cliente;
import models.Quartos;
import models.CheckIn;
import models.Funcionario;
import static view.CheckInView.exibirMenuCheckIn;
import static view.HotelView.exibirMainMenu;
import static view.HotelView.scan;

public  class FuncionarioView {
    
    static Scanner scan = new Scanner(System.in);

    public static void exibirFuncionarioMenu() {
        System.out.println("Escolha a opção:");
        System.out.println("1 - Cadastrar Funcionario");
        System.out.println("2 - Alterar Senha");
        System.out.println("3 - Listar Funcionários");
        System.out.println("4 - Buscar Funcionário por código");
        System.out.println("5 - Voltar ao Menu Principal");
        
        try{
        int opcao = scan.nextInt();
        scan.nextLine();

        
        switch (opcao) {
            case 1:
                cadastrarFuncionario();
                break;
            case 2:
                alterarSenha();
                break;
            case 3:
                listarFuncionario();
                break;
            case 4:
                buscarCodigoFuncionario();
                break;
            case 5:
                HotelView.exibirMainMenu();
                break;
            default:
                System.out.println("");
                System.out.print("Opção Inválida");
                System.out.println("");
                exibirFuncionarioMenu();
            }
        }   
        catch(Exception e){
            System.out.println("Por favor digite um dos números da lista.");
            scan.nextLine();
            exibirMainMenu();
        }
    }    
    
    private static void cadastrarFuncionario(){
        System.out.println("");
        System.out.println("Digite o nome do funcionário: ");
        String nome = scan.nextLine();
        
        System.out.println("Digite o CPF do funcionário: ");
        String cpf = scan.nextLine();
        
        System.out.println("Digite o Login do Funcionário: ");
        String login = scan.nextLine();
        
        Funcionario f = FuncionarioController.buscarUsuarioJaCadastrado(login);
        
        if (f != null){
             System.out.println("");
             System.out.println("Usuário já cadastrado.");
             System.out.println("");
             FuncionarioView.exibirFuncionarioMenu();
        }
         
        System.out.println("Digite a senha do Funcionário: ");
        String senha = scan.nextLine();
        
        FuncionarioController.adicionarFuncionario(0, nome, cpf, login, senha);
        
        System.out.println("");
        System.out.println("Usuário Cadastrado com sucesso!");
        System.out.println("");
        exibirFuncionarioMenu();

    }
    
        private static void alterarSenha(){
        System.out.println("");
        System.out.println("Digite sua senha antiga: ");
        String senha = scan.nextLine();
        
        Funcionario f = FuncionarioController.alterarSenha(senha);
        
        if(f != null){
            System.out.println("Digite sua nova senha: ");
            String nsenha = scan.nextLine();
            f.setSenha(nsenha);
            System.out.println("");
            System.out.println("Senha alterada com sucesso!");
            System.out.println("");
            
        }else{
           System.out.println("");
           System.out.println("Senha Inválida!");
           System.out.println("");
           
        }
        exibirFuncionarioMenu();

    }
        
        private static void listarFuncionario() {
        System.out.println("");
        System.out.println(" ----- ");
        
        if(BancoDadosHotel.getTabelaFuncionario().size() != 0){
        
            for (Funcionario f : BancoDadosHotel.getTabelaFuncionario()){
                System.out.println("Codigo do funcionario: " + f.getCodigo()+ ".");
                System.out.println("Nome do funcionario: " + f.getNome() + ".");
                System.out.println("CPF do funcionario: " + f.getCpf() + ".");
                System.out.println(" ----- ");
            }
        }
        else{
            System.out.println("");
            System.out.println("Nenhum Cliente foi Cadastrado.");
            System.out.println("");
        }
        
        exibirFuncionarioMenu();
    }
        
        private static void buscarCodigoFuncionario(){
        
        System.out.print("Digite o código do funcionário: ");
        int cod = scan.nextInt();
        scan.nextLine();
        
        Funcionario f = FuncionarioController.buscarFuncionarioPorCodigo(cod);
        
        if(f != null){
            System.out.println("");
            System.out.println(" ----- ");
            System.out.println("Código do funcionário: " + f.getCodigo()+".");
            System.out.println("Nome do funcionário: " + f.getNome()+".");
            System.out.println("Cpf do Funcionário: " + f.getCpf()+".");
            System.out.println(" ----- ");
        
        }
        else{
            System.out.println("");
            System.out.println("Não foi possivel encontrar este código");
            System.out.println("");
        }
        exibirFuncionarioMenu();
        }
    
    
                
}

            
