package br.com.fiap.bean;

import br.com.fiap.exception.SaldoNegativoException;

import java.util.Calendar;

//Classe abstrata: não pode ser instanciada e  pode conter métodos abstratos
public abstract class Conta {
    private Integer agencia;
    private Integer numero;
    private Calendar dataAbertura;
    protected Double saldo;

    public double depositar(double valor){
        return saldo += valor;
    }
    public abstract double retirar(double valor) throws SaldoNegativoException;

    //ALT + Insert (Getters Setters/Construtores)
    public Conta() {
    }

    public Conta(Integer agencia, Integer numero, Calendar dataAbertura, Double saldo) {
        this.agencia = agencia;
        this.numero = numero;
        this.dataAbertura = dataAbertura;
        this.saldo = saldo;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Calendar getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Calendar dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Double getSaldo() {
        return saldo;
    }
//CTRL + /
//    public void setSaldo(Double saldo) {
//        this.saldo = saldo;
//    }
}
