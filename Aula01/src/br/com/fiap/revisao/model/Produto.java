package br.com.fiap.revisao.model;

public class Produto {

    //modificadores de acesso: private, public, protected, default/package
    private Integer id;
    private String nome;
    private Double valor;

    public Produto() {
    }

    public Produto(Integer id, String nome, Double valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }

    //Calcular o valor final de acordo com a taxa em % (10, -10)
    public Double calcularValorFinal(double taxa){
        return valor + (valor * taxa)/100;
    }

    //Sobrecarga: métodos com o mesmo nome mas parametros diferentes
    public Double calcularValorFinal(String cupom){
        //Cupom "TDS20" da 20% de desconto
        if (cupom.equals("TDS20")){
            return calcularValorFinal(-20);
        }
        return valor;
    }

    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
