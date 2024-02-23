package br.com.fiap.bean;

import br.com.fiap.exception.SaldoNegativoException;

import java.util.Calendar;

//ALT + ENTER - sugestão de correção de erros
public class ContaCorrente extends Conta {

    private TipoConta tipo;

    //Se a conta for comum e o saldo fica negativo depois do saque deve lançar
    // uma exceção e não permitir a retirada.
    @Override
    public double retirar(double valor) throws SaldoNegativoException {
        if (valor > saldo && tipo == TipoConta.COMUM){
            throw new SaldoNegativoException(saldo);
        }
        saldo -= valor;
        return saldo;
    }

    public ContaCorrente() {
    }

    public ContaCorrente(Integer agencia, Integer numero, Calendar dataAbertura, Double saldo, TipoConta tipo) {
        super(agencia, numero, dataAbertura, saldo);
        this.tipo = tipo;
    }

    public TipoConta getTipo() {
        return tipo;
    }

    public void setTipo(TipoConta tipo) {
        this.tipo = tipo;
    }
}
