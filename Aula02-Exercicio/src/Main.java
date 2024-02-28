import br.com.fiap.bean.Conta;
import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.ContaPoupanca;
import br.com.fiap.bean.TipoConta;
import br.com.fiap.exception.SaldoNegativoException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Instanciar uma ContaCorrete
        var cc = new ContaCorrente(1, 123,
                new GregorianCalendar(2000,Calendar.APRIL, 5), 0.0, TipoConta.COMUM);

        //Instanciar uma ContaPoupanca
        var cp = new ContaPoupanca(1, 321, Calendar.getInstance(), 100.0, 5.0f);

        //Criar uma lista de ContaCorrente
        List<ContaCorrente> lista = new ArrayList<>();

        //Adicionar 3 contas
        lista.add(cc);
        lista.add(new ContaCorrente(1,2, Calendar.getInstance(), 500.0, TipoConta.ESPECIAL));
        lista.add(new ContaCorrente(1,3, Calendar.getInstance(), 500.0, TipoConta.PREMIUM));

        //Exibir os saldos das contas
        for (ContaCorrente item : lista){
            System.out.println(item.getSaldo());
        }
        //Exibir o valor da conta
        System.out.println("Saldo atual: " + cc.getSaldo());
        //Retirar um valor da conta corrente
        try {
            cc.retirar(2000);
            //Exibir o valor
            System.out.println("Novo saldo:" + cc.getSaldo());
        }catch(SaldoNegativoException e){
            System.out.println(e.getMessage());
        }
    }
}