import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.TipoConta;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {

        //Instanciar uma ContaCorrete
        var cc = new ContaCorrente(1, 123,
                new GregorianCalendar(2000,Calendar.APRIL, 5), 0.0, TipoConta.COMUM);
        //Instanciar uma ContaPoupanca

        //Criar uma lista de ContaCorrente

        //Adicionar 3 contas

        //Exibir os saldos das contas

    }
}