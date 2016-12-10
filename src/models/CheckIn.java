
package models;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CheckIn {
    
    private Cliente cliente;
    private Quartos quartos;
    private String dcheck;
    
    Date currentDate = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    
    
    
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Quartos getQuartos() {
        return quartos;
    }

    public void setQuartos(Quartos quarto) {
        this.quartos = quarto;
    }

   
    public String getData() {
        dcheck = sdf.format(currentDate);
        return dcheck;
    }

}
