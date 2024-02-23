package br.com.fiap.exception;

public class SaldoNegativoException extends Exception {

    public SaldoNegativoException(String message){
        super(message);
    }

    public SaldoNegativoException(double valor){
        super("Saldo insuficiente, valor disponível: " + valor);
    }

}
