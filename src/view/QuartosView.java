
package view;

import banco.BancoDadosHotel;
import controllers.CheckInController;
import controllers.QuartosController;
import java.util.Scanner;
import models.CheckIn;
import models.Quartos;
import static view.HotelView.exibirMainMenu;
import static view.HotelView.scan;




public class QuartosView {
       
    static Scanner scan = new Scanner(System.in);
    
        public static void exibirQuartosMenu() {
        System.out.println("Escolha a opção:");
        System.out.println("1 - Listar Todos os Quartos");
        System.out.println("2 - Quartos Disponiveis");
        System.out.println("3 - Exibir Dados do Quarto");
        System.out.println("4 - Voltar ao Menu Principal");
        
        try{
        int opcao = scan.nextInt();
        scan.nextLine();

        
        switch (opcao) {
            case 1:
                listarTodosQuartos();
                break;
            case 2:
                listarQuartosDiponiveis();
                break;
            case 3:
                exibirPorCodigo();
                break;
            case 4:
                HotelView.exibirMainMenu();
                break;
            default:
              System.out.println("");
              System.out.print("Opção Inválida");
              System.out.println("");
              exibirQuartosMenu();
            }
        }

        catch(Exception e){
            System.out.println("Por favor digite um dos números da lista.");
            exibirMainMenu();
            scan.nextLine();
        }
        
    }
    

        private static void listarTodosQuartos() {
        System.out.println("");
        System.out.println(" ----- ");
        
        for(Quartos q : BancoDadosHotel.getTabelaQuartos()){
            if(q.getStatus().equals("Ocupado")){
                
            CheckIn ci = CheckInController.buscarDadosCheckIn(q);
                        
            System.out.println("Quarto número: " + ci.getQuartos().getCodigo()+".");
            System.out.println("Data do check-in: " + ci.getData()+".");
            System.out.println("Disponibilidade: " + ci.getQuartos().getStatus()+".");
            System.out.println("Código do cliente: " + ci.getCliente().getCodigo()+".");
            System.out.println("Nome do cliente: " + ci.getCliente().getNome()+".");
            System.out.println(" ----- ");
                
            } else if(q.getStatus().equals("Livre")){
                    
              System.out.println("Quarto número: " + q.getCodigo()+".");
              System.out.println("Disponibilidade: " + q.getStatus()+".");
              System.out.println(" ----- ");
 
              }
                    
        }
        exibirQuartosMenu();
        
    }
        private static void listarQuartosDiponiveis() {
        System.out.println("");
        System.out.println(" ----- ");
            
        for(Quartos q : BancoDadosHotel.getTabelaQuartos()){
            if(q.getStatus().equals("Livre")){

            System.out.println("Quarto número: " + q.getCodigo()+".");
            System.out.println("Disponibilidade: " + q.getStatus()+".");
            System.out.println(" ----- ");
                
            } 
            else if(q.getStatus().equals("Ocupado")){  
              System.out.println("Quarto ocupado.");
              System.out.println(" ----- ");
                
            }
       
        }
             exibirQuartosMenu(); 
        
        
        
    }
     
        
        
        private static void exibirPorCodigo() {
        System.out.print("Digite o codigo do quarto: ");
        int cod = scan.nextInt();
        scan.nextLine();

        Quartos q = QuartosController.buscarQuartosPorCodigo(cod);
        
        if(q != null){
            if(q.getStatus().equals("Livre")){
            System.out.println("");
            System.out.println(" ----- ");    
            System.out.println("Quarto número: " + q.getCodigo()+".");
            System.out.println("Disponibilidade: " + q.getStatus()+".");
            System.out.println(" ----- ");
 
            } 
            else if(q.getStatus().equals("Ocupado")){
                
              CheckIn ci = CheckInController.buscarDadosCheckIn(q);
              System.out.println("");
              System.out.println(" ----- ");           
              System.out.println("Quarto número: " + ci.getQuartos().getCodigo()+".");
              System.out.println("Data do check-in: " + ci.getData()+".");
              System.out.println("Disponibilidade: " + ci.getQuartos().getStatus()+".");
              System.out.println("Código do cliente: " + ci.getCliente().getCodigo()+".");
              System.out.println("Nome do cliente: " + ci.getCliente().getNome()+".");
              System.out.println(" ----- ");
              
             }
            
        }
        else{ 
        System.out.println("");    
        System.out.print("Não foi possivel encontrar o quarto informado");
            
        }
        exibirQuartosMenu();
    }
    
}
