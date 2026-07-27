package service;

import enums.FormaPagamento;
import enums.StatusLocacao;
import model.Cliente;
import model.Locacao;
import model.Veiculo;

public class Locadora {
    public static final int CAPACIDADE_MAXIMA = 50;

    private Veiculo[] veiculos = new Veiculo[CAPACIDADE_MAXIMA];
    private Cliente[] clientes = new Cliente[CAPACIDADE_MAXIMA];
    private Locacao[] locacoes = new Locacao[CAPACIDADE_MAXIMA];

    private int totalVeiculos = 0;
    private int totalClientes = 0;
    private int totalLocacoes = 0;

    public void cadastrarVeiculo(Veiculo veiculo){
        if (totalVeiculos >= CAPACIDADE_MAXIMA){
            System.out.println("Capacidade máxima de veiculos alcançada");
            return;
        }
        veiculos[totalVeiculos] = veiculo;
        totalVeiculos++;
    }

    public void cadastrarClientes(Cliente cliente){
        if (totalClientes >= CAPACIDADE_MAXIMA){
            System.out.println("A capacidade máxima de clientes foi alcançada!!");
            return;
        }
        clientes[totalClientes] = cliente;
        totalClientes++;
    }

    public Locacao alugar(Cliente cliente, Veiculo veiculo, int quantidadeDias, FormaPagamento formaPagamento) {
        if (!veiculo.isDisponibilidade()) {
            System.out.println("Veiculo indisponivel para locação!");
            return null;
        }

        if (totalLocacoes >= CAPACIDADE_MAXIMA) {
            System.out.println("Capacidade máxima de locações atingida!");
            return null;
        }

        Locacao locacao = new Locacao(cliente, veiculo, quantidadeDias, formaPagamento);
        veiculo.setDisponibilidade(false);
        locacoes[totalLocacoes] = locacao;
        totalLocacoes++;

        return locacao;
    }
    public void devolver(Locacao locacao, int diasAtraso) {
        if (diasAtraso > 0) {
            locacao.setDiasAtraso(diasAtraso);
            locacao.setStatus(StatusLocacao.ATRASADA);
        }
        locacao.finalizar();
    }

    public void listarVeiculosDisponiveis() {
        for (int i = 0; i < totalVeiculos; i++) {
            if (veiculos[i].isDisponibilidade()) {
                System.out.println(veiculos[i]);
            }
        }
    }

    public void listarLocacoesAtivas() {
        for (int i = 0; i < totalLocacoes; i++) {
            if (locacoes[i].getStatus() == StatusLocacao.ATIVA) {
                System.out.println(locacoes[i]);
            }
        }
    }
    public Veiculo buscarVeiculoPorPlaca(String placa) {
        for (int i = 0; i < totalVeiculos; i++) {
            if (veiculos[i].getPlacaVeiculo().equals(placa)) {
                return veiculos[i];
            }
        }
        return null;
    }
    public Cliente buscarClientePorCpf(String cpf) {
        for (int i = 0; i < totalClientes; i++) {
            if (clientes[i].getCpf().equals(cpf)) {
                return clientes[i];
            }
        }
        return null;
    }
    public Locacao buscarLocacaoPorId(int id) {
        for (int i = 0; i < totalLocacoes; i++) {
            if (locacoes[i].getId() == id) {
                return locacoes[i];
            }
        }
        return null;
    }
}
