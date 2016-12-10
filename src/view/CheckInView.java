package view;

import banco.BancoDadosHotel;
import java.util.Scanner;
import models.Quartos;
import controllers.CheckInController;
import controllers.ClienteController;
import controllers.QuartosController;
import models.CheckIn;
import models.Cliente;
import static view.HotelView.exibirMainMenu;
import static view.HotelView.scan;

public class CheckInView {
    
    static Scanner scan = new Scanner(System.in);

    public static void exibirMenuCheckIn() {
        
        
        System.out.println("Escolha a sua opção: ");
        System.out.println("1 - Fazer Check-In");
        System.out.println("2 - Fazer Check-Out");
        System.out.println("3 - Retornar ao Menu Principal");
        
        try{
        int opcao = scan.nextInt();
        scan.nextLine();
        
        
        switch(opcao){
            case 1:
                fazerCheckIn();
            case 2:
                fazerCheckOut();
            case 3:
                HotelView.exibirMainMenu();
                break;
            default:
                System.out.println("");
                System.out.println("Opção Inválida");
                System.out.println("");
                exibirMenuCheckIn();
            }
        }       
        catch(Exception e){
            System.out.println("Por favor digite um dos números da lista.");
            scan.nextLine();
            exibirMainMenu();
        }
        
        
    }

    private static void fazerCheckIn() {
        System.out.println("");
        System.out.println("Digite o código do quarto: ");
        int cod = scan.nextInt();
        scan.nextLine();
        
        Quartos q = QuartosController.buscarQuartosPorCodigo(cod);
        
        if (q != null){
            
            if(q.getStatus().equals("Livre")){
                
            System.out.println("");    
            System.out.println("Digite o código do cliente: ");
            int codCli = scan.nextInt();
            scan.nextLine();
            
            Cliente c = ClienteController.buscarClientePorCodigo(codCli);
           
            CheckInController.fazerNovoCheckIn(q, c);
            q.setStatus("Ocupado");
            System.out.println("");
            System.out.println("Check-in feito com sucesso!");
            System.out.println("");
        }   
            else if (q.getStatus().equals("Ocupado")){
                System.out.println("");
                System.out.println("Este quarto está ocupado.");
                System.out.println("");
            }
            
        }
        
        else{
            System.out.println("");
            System.out.println("Quarto não encontrado");
            System.out.println("");
        }
        
        exibirMenuCheckIn();
        
    }

    private static void fazerCheckOut() {
        System.out.println("");
        System.out.println("Digite o código do quarto: ");
        int codQuarto = scan.nextInt();
        scan.nextLine();
        
        Quartos q = QuartosController.buscarQuartosPorCodigo(codQuarto);
        
        if (q != null) {
            
            if(q.getStatus().equals("Ocupado")){
            CheckIn ci = CheckInController.buscarDadosCheckIn(q);
            CheckInController.fazerCheckout(ci);
            System.out.println("");
            System.out.println("Check-out realizado com sucesso!");
            System.out.println("");
            q.setStatus("Livre");
            }
            else if(q.getStatus().equals("Livre")){
                System.out.println("");
                System.out.println("Não houve Check-in neste quarto.");
                System.out.println("");
            }
        } 
        
        else {
            System.out.println("");
            System.out.println("Quarto não encontrado");
            System.out.println("");
        }
        exibirMenuCheckIn();
    }
    
}
