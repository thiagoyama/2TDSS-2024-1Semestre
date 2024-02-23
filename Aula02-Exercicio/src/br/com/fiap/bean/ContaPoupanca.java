package br.com.fiap.bean;

import br.com.fiap.exception.SaldoNegativoException;

import java.util.Calendar;

public class ContaPoupanca extends Conta implements ContaInvestimento {
    private Float taxa;

    //Constante
    public static final float RENDIMENTO = 0.07f;

    //verifica se o saldo é suficiente, se for deve descontar também a Taxa de retirada;
    @Override
    public double retirar(double valor) throws SaldoNegativoException {
        if (valor + taxa > saldo) {
            throw new SaldoNegativoException(saldo - taxa);
        }
        return saldo -= valor + taxa;
    }

    @Override
    public double calculaRetornoInvestimento() {
        return saldo * RENDIMENTO;
    }

    public ContaPoupanca(){}

    public ContaPoupanca(Integer agencia, Integer numero, Calendar dataAbertura, Double saldo, Float taxa) {
        super(agencia, numero, dataAbertura, saldo);
        this.taxa = taxa;
    }

    public Float getTaxa() {
        return taxa;
    }

    public void setTaxa(Float taxa) {
        this.taxa = taxa;
    }
}
