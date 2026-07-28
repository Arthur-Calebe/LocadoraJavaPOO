package model;

import enums.CategoriaVeiculo;

// Moto como também é um veículo usa o "extends" para herdar as características da classe Veiculo
public class Moto extends Veiculo{

    private int cilindrada;

    public Moto(int anoFabricacao, String modelo, String placaVeiculo, boolean disponibilidade, CategoriaVeiculo categoria, int cilindrada) {
        super(anoFabricacao, modelo, placaVeiculo, disponibilidade, categoria);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
}
