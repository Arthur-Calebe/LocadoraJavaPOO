package model;

public class Veiculo {

    private String nome;
    private int anoFabricacao;
    private String modelo;
    private String placaVeiculo;
    private boolean disponibilidadae;

    public Veiculo(String nome, int anoFabricacao, String modelo, String placaVeiculo, boolean disponibilidadae) {
        this.nome = nome;
        this.anoFabricacao = anoFabricacao;
        this.modelo = modelo;
        this.placaVeiculo = placaVeiculo;
        this.disponibilidadae = true;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "nome = '" + nome + '\'' +
                ", anoFabricacao = " + anoFabricacao +
                ", modelo = '" + modelo + '\'' +
                ", placaVeiculo = '" + placaVeiculo + '\'' +
                ", disponibilidadae = " + disponibilidadae +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public boolean isDisponibilidadae() {
        return disponibilidadae;
    }

    public void setDisponibilidadae(boolean disponibilidadae) {
        this.disponibilidadae = disponibilidadae;
    }
}
