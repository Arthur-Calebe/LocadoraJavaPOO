package model;

public class Carro extends Veiculo {

    private int quantidadePortas;

    public Carro(String nome, int anoFabricacao, String modelo, String placaVeiculo, boolean disponibilidadae) {
        super(nome, anoFabricacao, modelo, placaVeiculo, disponibilidadae);
        this.quantidadePortas = quantidadePortas;
    }

    public int getQuantidadePortas() {
        return quantidadePortas;
    }

    public void setQuantidadePortas(int quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }
}
