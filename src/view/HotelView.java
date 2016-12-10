
package view;

import controllers.FuncionarioController;
import hotel_ranon.Hotel_Ranon;
import java.util.Scanner;
import models.Funcionario;
import static view.FuncionarioView.scan;

public class HotelView {
    
    
    static Scanner scan = new Scanner(System.in);
    
    public static void realizarLogin() {
        System.out.println("Digite seu usuário:");
        String usuario = scan.nextLine();
        


        System.out.println("Digite sua senha:");
        String senha = scan.nextLine();
 
        
        Funcionario f = FuncionarioController.fazerLogin(usuario.toLowerCase(), senha);
        
        if(f == null){
        System.out.println("");
        System.out.println("Usuário ou senha incorretos.");
        System.out.println("");
        realizarLogin();
        }
    }
    
    public static void exibirMainMenu() {
        System.out.println("Escolha o menu:");
        System.out.println("1 - Gerenciar Funcionários");
        System.out.println("2 - Gerenciar Quartos");
        System.out.println("3 - Gerenciar Clientes");
        System.out.println("4 - Check-in e Check-out");
        System.out.println("5 - Fazer Logoff");
        
        try{
        int opcao = scan.nextInt();
        

       
        switch (opcao) {
            case 1:
                FuncionarioView.exibirFuncionarioMenu();
                break;
            case 2:
                QuartosView.exibirQuartosMenu();
                break;
            case 3:
                ClienteView.exibirClienteMenu();
                break;
            case 4:
                CheckInView.exibirMenuCheckIn();
                break;
            case 5:
                scan.nextLine();
                realizarLogin();
                break;
            default:
                System.out.println("");
                System.out.println("Opção Inválida");
                System.out.println("");
                exibirMainMenu();
        }

        }
        catch(Exception e){
            System.out.println("Por favor digite um dos números da lista.");
            scan.nextLine();
            realizarLogin();
            
        }
    }    
                
}

            
