package enums;

public enum CategoriaVeiculo {
    ECONOMICO(80.0),
    INTERMEDIARIO(120),
    LUXO(250);

    private final double ValorDiaria;

    CategoriaVeiculo(double valorDiaria) {
        ValorDiaria = valorDiaria;
    }

    public double getValorDiaria() {
        return ValorDiaria;
    }
}
