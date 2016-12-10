package controllers;

import banco.BancoDadosHotel;
import models.Cliente;
import models.Funcionario;
import view.FuncionarioView;
import view.HotelView;

public class FuncionarioController {
    
        public static void adicionarFuncionario(int codigo, String nome, String cpf, String usuario, String senha){

        Funcionario f = new Funcionario();
        
        
        f.gerarIdFuncionario(codigo);
        f.setNome(nome);
        f.setCpf(cpf);
        f.setUsuario(usuario.toLowerCase());
        f.setSenha(senha);
        
        BancoDadosHotel.getTabelaFuncionario().add(f);
    }
             
    public static void adicionarAdministrador(){
      
        int cod = BancoDadosHotel.getTabelaFuncionario().size() +1;
        String nome = "Administrador";
        String cpf = "99999999900";
        String usuario = "admin";
        String senha = "Admin";
                
        FuncionarioController.adicionarFuncionario(cod, nome, cpf, usuario, senha);
                
        }
    
    public static Funcionario fazerLogin(String usuario, String senha){
        
        for(Funcionario f : BancoDadosHotel.getTabelaFuncionario()){
            if(f.getUsuario().equals(usuario) && f.getSenha().equals(senha)){
                HotelView.exibirMainMenu();
                return f;
            }
            
        }
        
        return null;
    }
    
    public static Funcionario alterarSenha(String senha){
        
        for(Funcionario f : BancoDadosHotel.getTabelaFuncionario()){
                if(f.getSenha().equals(senha)){
                   return f; 
                }
        }
        return null;
        
    }
    
    public static Funcionario buscarFuncionarioPorCodigo(int codigo){
        
        for(Funcionario f : BancoDadosHotel.getTabelaFuncionario()){
            if(f.getCodigo() == codigo){
                return f;
            }
        }
        
        return null;
    }
      public static Funcionario buscarUsuarioJaCadastrado(String usuario){
        
        for(Funcionario f : BancoDadosHotel.getTabelaFuncionario()){
            if(f.getUsuario().equals(usuario)){
               return f;
            }
    
        }
        return null;
    } 
    
}
    

