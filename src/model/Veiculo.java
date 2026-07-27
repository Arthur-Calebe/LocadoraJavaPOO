package model;

import enums.CategoriaVeiculo;

public class Veiculo {

    protected int anoFabricacao;
    protected String modelo;
    protected String placaVeiculo;
    protected CategoriaVeiculo categoria;
    protected boolean disponibilidade;

    public Veiculo(int anoFabricacao, String modelo, String placaVeiculo, boolean disponibilidade, CategoriaVeiculo categoria) {
        this.anoFabricacao = anoFabricacao;
        this.modelo = modelo;
        this.placaVeiculo = placaVeiculo;
        this.disponibilidade = disponibilidade;
        this.categoria = categoria;
    }

    public double calcularValorDiaria(){
        return categoria.getValorDiaria();
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "anoFabricacao = " + anoFabricacao +
                ", modelo = '" + modelo + '\'' +
                ", placaVeiculo = '" + placaVeiculo + '\'' +
                ", categoria = " + categoria +
                ", disponibilidade = " + disponibilidade +
                '}';
    }

    public CategoriaVeiculo getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaVeiculo categoria) {
        this.categoria = categoria;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}
