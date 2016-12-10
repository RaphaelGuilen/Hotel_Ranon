
package models;

import banco.BancoDadosHotel;


public class Funcionario extends Pessoa {
    
    private int codigo;
    private String usuario;
    private String senha;
    Funcionario logado;
    
    public int getCodigo() {
        return codigo;
    }
    
    public void gerarIdFuncionario(int codigo) {
        this.codigo = BancoDadosHotel.getTabelaFuncionario().size() + 1;
    }

    public String getUsuario() {
        return usuario;
    }


    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }


    public String getSenha() {
        return senha;
    }


    public void setSenha(String senha) {
        this.senha = senha;
    }
    

}
