package view;

import banco.BancoDadosHotel;
import controllers.ClienteController;
import java.util.Scanner;
import models.Cliente;
import static view.HotelView.exibirMainMenu;
import static view.HotelView.scan;


public class ClienteView {
    
        static Scanner scan = new Scanner(System.in);
        
        public static void exibirClienteMenu(){
            
            System.out.println("Escolha a sua opção: ");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Buscar Cliente por Código");
            System.out.println("4 - Retornar ao Menu Principal");
            
            try{
            int opcao = scan.nextInt();
            scan.nextLine();
            
            
            switch(opcao) {
                case 1:
                   cadastrarClientes();
                    break;
                case 2:
                    listarCliente();
                    break;
                case 3:
                    buscarClientePorCodigo();
                    break;
                case 4:
                    HotelView.exibirMainMenu();
                    break;
                default:
                    System.out.println("");
                    System.out.println("Opção Inválida");
                    System.out.println("");
                    exibirClienteMenu();
            }
            }
            catch(Exception e){
                System.out.println("Por favor digite um dos números da lista.");
                scan.nextLine();
                exibirMainMenu();
            }
            
        }
        
    private static void cadastrarClientes() {
        
        System.out.println("Digite o nome do cliente");
        String nome = scan.nextLine();
        
        System.out.println("Digite o CPF do cliente");
        String cpf = scan.nextLine();

        ClienteController.adicionarCliente(0, nome, cpf);
        
        System.out.println("");
        System.out.println("Usuário Cadastrado com sucesso!");
        System.out.println("");
        exibirClienteMenu();

    }
        
    
    
    private static void listarCliente() {
        
        System.out.println("");
        System.out.println(" ----- ");
        
        if(BancoDadosHotel.getTabelaCliente().size() != 0){
            
            for (Cliente c : BancoDadosHotel.getTabelaCliente()){
            System.out.println("Codigo do Cliente: " + c.getCodigo()+ ".");
            System.out.println("Nome do Cliente: " + c.getNome() + ".");
            System.out.println("CPF do Cliente: " + c.getCpf() + ".");
            System.out.println(" ----- ");
            }
        
        }
        else{
            System.out.println("");
            System.out.println("Nenhum Cliente foi Cadastrado.");
            System.out.println("");
        }
        
        
        
        exibirClienteMenu();
    }

    private static void buscarClientePorCodigo() {
        System.out.println("");
        System.out.print("Digite o código do cliente: ");
        int cod = scan.nextInt();
        scan.nextLine();
        
        Cliente c = ClienteController.buscarClientePorCodigo(cod);
        
        if(c != null){
            System.out.println("");
            System.out.println(" ----- ");
            System.out.println("Código do Cliente: " + c.getCodigo()+".");
            System.out.println("Nome do Cliente: " + c.getNome()+".");
            System.out.println("Cpf do Cliente: " + c.getCpf()+".");
            System.out.println(" ----- ");
        }
        else{
            System.out.println("");
            System.out.println("Não foi possivel encontrar este código");
            System.out.println("");
        }
        exibirClienteMenu();
        }
    }