package controllers;

import banco.BancoDadosHotel;
import models.Cliente;

public class ClienteController {
    
        public static void adicionarCliente(int codigo, String nome, String cpf){

        Cliente c = new Cliente();
        
        c.gerarIdCliente(codigo);
        c.setNome(nome);
        c.setCpf(cpf);

        BancoDadosHotel.getTabelaCliente().add(c);
    }
    
    public static Cliente buscarClientePorCodigo(int codigo){
        
        for(Cliente c : BancoDadosHotel.getTabelaCliente()){
            if(c.getCodigo() == codigo){
                return c;
            }
        }
        
        return null;
    }
    
}
