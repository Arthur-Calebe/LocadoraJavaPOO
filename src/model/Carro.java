package model;

import enums.CategoriaVeiculo;

    // Todas as caracteristicas da classe Veiculo são transferidas para essa classe por meio do "Extends"
public class Carro extends Veiculo {

    private int quantidadePortas;

    // O "Super" é usado aqui, pois também meio que "puxa" o construtor da classe Veiculo
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
