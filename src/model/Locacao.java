package model;

import enums.FormaPagamento;
import enums.StatusLocacao;

public class Locacao {

    // Aqui criei uma forma de colocar um ID em todas as movimentações que ocorrer: alugar um veículo, devolver...
    private static int contadorId = 1;
    // utilizei o "final" para a multa só ser definida aqui
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

    // Aqui utilizei o toString para definir como os dados da locação serão exibidos em formato de texto
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

    // aqui fiz uma lógica para calcular quanto o cliente ira pagar conforme o uso do veiculo
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

    // Quando o veiculo for devolvido automáticamente ele podera ser alugado de novo
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
