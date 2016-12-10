package controllers;

import banco.BancoDadosHotel;
import models.Quartos;
import models.CheckIn;

public class QuartosController {
    
        public static void adicionarQuartos(int codigo, String status){

        Quartos q = new Quartos();
        
        q.setCodigo(codigo);
        q.setStatus(status);

        BancoDadosHotel.getTabelaQuartos().add(q);
    }
        
        public static void gerarMassaQuartos(){
        
            int i;
        
            for (i = 1; i < 15; i++){

                int cod = i;
                String status = "Livre";

                QuartosController.adicionarQuartos(cod, status);
            }
            
        }
    
        public static Quartos buscarQuartosPorCodigo(int codigo) {
           
            for(Quartos q : BancoDadosHotel.getTabelaQuartos()){
                if(q.getCodigo() == codigo){
                    return q;
                    
                }
            }
            return null;
        }
    
}
                