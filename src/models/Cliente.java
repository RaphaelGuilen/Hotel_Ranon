package models;

import banco.BancoDadosHotel;

public class Cliente extends Pessoa{
    
    private int codigo;
    
    public int getCodigo(){
        return codigo;
    }
    
    public void gerarIdCliente (int codigo) {
        this.codigo = BancoDadosHotel.getTabelaCliente().size() +1;
    }
}
