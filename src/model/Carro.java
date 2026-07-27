package model;

import enums.CategoriaVeiculo;

public class Carro extends Veiculo {

    private int quantidadePortas;

    public Carro(int anoFabricacao, String modelo, String placaVeiculo, boolean disponibilidade, CategoriaVeiculo categoria, int quantidadePortas) {
        super(anoFabricacao, modelo, placaVeiculo, disponibilidade, categoria);
        this.quantidadePortas = quantidadePortas;
    }

    public int getQuantidadePortas() {
        return quantidadePortas;
    }

    public void setQuantidadePortas(int quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }
}
