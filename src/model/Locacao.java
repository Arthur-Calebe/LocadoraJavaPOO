package model;

import enums.FormaPagamento;
import enums.StatusLocacao;

public class Locacao {

    private static int contadorId = 1;
    public static final double MULTA_ATRASO_DIARIO = 30.0;

    private final int id;
    private Cliente cliente;
    private Veiculo veiculo;
    private int quantidadeDias;
    private int diasAtraso;
    private FormaPagamento formaPagamento;
    private StatusLocacao status;

    public Locacao(Cliente cliente, Veiculo veiculo, int quantidadeDias, FormaPagamento formaPagamento) {
        this.id = contadorId++;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.quantidadeDias = quantidadeDias;
        this.formaPagamento = formaPagamento;
        this.status = status;
        this.diasAtraso = 0;
    }

    @Override
    public String toString() {
        return "Locacao{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", veiculo=" + veiculo +
                ", quantidadeDias=" + quantidadeDias +
                ", diasAtraso=" + diasAtraso +
                ", formaPagamento=" + formaPagamento +
                ", status=" + status +
                ", valorTotal=" + calcularValorTotal() +
                '}';
    }

    public double calcularValorTotal() {
        double total = veiculo.calcularValorDiaria() * quantidadeDias;

        if (status == StatusLocacao.ATRASADA) {
            total += MULTA_ATRASO_DIARIO * diasAtraso;
        }

        return total;
    }

    public int getDiasAtraso() {
        return diasAtraso;
    }

    public void setDiasAtraso(int diasAtraso) {
        this.diasAtraso = diasAtraso;
    }

    public void finalizar() {
        status = StatusLocacao.FINALIZADA;
        veiculo.setDisponibilidade(true);
    }

    public static int getContadorId() {
        return contadorId;
    }

    public static void setContadorId(int contadorId) {
        Locacao.contadorId = contadorId;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public int getQuantidadeDias() {
        return quantidadeDias;
    }

    public void setQuantidadeDias(int quantidadeDias) {
        this.quantidadeDias = quantidadeDias;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public StatusLocacao getStatus() {
        return status;
    }

    public void setStatus(StatusLocacao status) {
        this.status = status;
    }
}
