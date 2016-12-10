
package controllers;

import banco.BancoDadosHotel;
import models.CheckIn;
import models.Cliente;
import models.Quartos;



public class CheckInController {
    
    public static void fazerNovoCheckIn (Quartos quartos, Cliente cliente){
    
        CheckIn ci = new CheckIn();
        
        ci.setQuartos(quartos);
        ci.setCliente(cliente);
        ci.getData();
        
        BancoDadosHotel.getTabelaCheckIn().add(ci);
    }   
    
        public static CheckIn buscarDadosCheckIn(Quartos q) {
           
            for(CheckIn ci : BancoDadosHotel.getTabelaCheckIn()){
                if(ci.getQuartos().getCodigo() == q.getCodigo()){
                    return ci;  
                }
            }
            return null;
        }
        
        public static void fazerCheckout(CheckIn ci){
            BancoDadosHotel.getTabelaCheckIn().remove(ci);
            
        }
    }


