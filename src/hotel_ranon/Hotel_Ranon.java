
package hotel_ranon;

import banco.BancoDadosHotel;
import controllers.FuncionarioController;
import controllers.QuartosController;
import view.HotelView;


public class Hotel_Ranon {
    
    

    public static void main(String[] args) {
        
     startProgram();

    }
    
    public static void startProgram(){
     
     BancoDadosHotel.inicializarBanco();
     FuncionarioController.adicionarAdministrador();
     QuartosController.gerarMassaQuartos();
     HotelView.realizarLogin();
   
     }

    
}
