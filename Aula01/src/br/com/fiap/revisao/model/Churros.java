package br.com.fiap.revisao.model;

public class Churros extends Produto {

    //Criar o atributo sabor
    private String sabor;

    private TipoChurros tipo;

    //Construtores
    public Churros() {
    }

    public Churros(Integer id, String nome, Double valor, String sabor) {
        super(id, nome, valor);
        this.sabor = sabor;
    }

    //Sobrescrita de método
    //Criar o método que calcula o valor final
    //Adicionar o cupom "CHURROSTDS" que dá 40% de desconto
    @Override
    public Double calcularValorFinal(String cupom){
        if (cupom.equals("CHURROSTDS")){
            return super.calcularValorFinal(-40);
        }
        return super.calcularValorFinal(cupom);
    }

    //Getters e Setters
    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public TipoChurros getTipo() {
        return tipo;
    }

    public void setTipo(TipoChurros tipo) {
        this.tipo = tipo;
    }

}
