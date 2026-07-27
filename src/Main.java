import enums.CategoriaVeiculo;
import enums.FormaPagamento;
import model.*;
import service.Locadora;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Locadora locadora = new Locadora();

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n=== LOCADORA DE VEICULOS ===");
            System.out.println("1 - Cadastrar veiculo");
            System.out.println("2 - Cadastrar cliente");
            System.out.println("3 - Alugar veiculo");
            System.out.println("4 - Devolver veiculo");
            System.out.println("5 - Listar veiculos disponiveis");
            System.out.println("6 - Listar locações ativas");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opçãoo: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarVeiculo();
                    break;
                case 2:
                    cadastrarCliente();
                    break;
                case 3:
                    alugarVeiculo();
                    break;
                case 4:
                    devolverVeiculo();
                    break;
                case 5:
                    locadora.listarVeiculosDisponiveis();
                    break;
                case 6:
                    locadora.listarLocacoesAtivas();
                    break;
                case 0:
                    System.out.println("Ate mais!");
                    break;
                default:
                    System.out.println("Opção invalida!");
            }
        } while (opcao != 0);

        scanner.close();
        }

    private static void cadastrarVeiculo() {
        System.out.print("Placa: ");
        String placa = scanner.next();

        System.out.print("Modelo: ");
        String modelo = scanner.next();

        System.out.print("Ano de fabricação: ");
        int ano = scanner.nextInt();

        System.out.println("Categoria (1-ECONOMICO, 2-INTERMEDIARIO, 3-LUXO): ");
        int opcaoCategoria = scanner.nextInt();
        CategoriaVeiculo categoria = CategoriaVeiculo.values()[opcaoCategoria - 1];

        System.out.println("Tipo (1-Carro, 2-Moto): ");
        int tipo = scanner.nextInt();

        if (tipo == 1) {
            System.out.print("Quantidade de portas: ");
            int portas = scanner.nextInt();
            Carro carro = new Carro(ano, modelo, placa, true, categoria, portas);
            locadora.cadastrarVeiculo(carro);
        } else {
            System.out.print("Cilindrada: ");
            int cilindrada = scanner.nextInt();
            Moto moto = new Moto(ano, modelo, placa, true, categoria, cilindrada);
            locadora.cadastrarVeiculo(moto);
        }

        System.out.println("Veiculo cadastrado com sucesso!");
    }
    private static void cadastrarCliente() {
        System.out.print("Nome: ");
        String nome = scanner.next();

        System.out.print("CPF: ");
        String cpf = scanner.next();

        System.out.print("Telefone: ");
        String telefone = scanner.next();

        Cliente cliente = new Cliente(nome, cpf, telefone);
        locadora.cadastrarClientes(cliente);

        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void alugarVeiculo() {
        System.out.print("Placa do veiculo: ");
        String placa = scanner.next();

        System.out.print("CPF do cliente: ");
        String cpf = scanner.next();

        System.out.print("Quantidade de dias: ");
        int dias = scanner.nextInt();

        System.out.println("Forma de pagamento (1-DINHEIRO, 2-CARTAO_CREDITO, 3-CARTAO_DEBITO, 4-PIX): ");
        int opcaoPagamento = scanner.nextInt();
        FormaPagamento formaPagamento = FormaPagamento.values()[opcaoPagamento - 1];

        Veiculo veiculo = locadora.buscarVeiculoPorPlaca(placa);
        Cliente cliente = locadora.buscarClientePorCpf(cpf);

        if (veiculo == null) {
            System.out.println("Veiculo nao encontrado!");
            return;
        }

        if (cliente == null) {
            System.out.println("Cliente nao encontrado!");
            return;
        }

        Locacao locacao = locadora.alugar(cliente, veiculo, dias, formaPagamento);

        if (locacao != null) {
            System.out.println("Locacao realizada com sucesso! ID: " + locacao.getId());
        }
    }

    private static void devolverVeiculo() {
        System.out.print("ID da locacao: ");
        int id = scanner.nextInt();

        System.out.print("Dias de atraso (0 se nao houve atraso): ");
        int diasAtraso = scanner.nextInt();

        Locacao locacao = locadora.buscarLocacaoPorId(id);

        if (locacao == null) {
            System.out.println("Locacao nao encontrada!");
            return;
        }

        locadora.devolver(locacao, diasAtraso);
        System.out.println("Devolucao registrada! Valor total: " + locacao.calcularValorTotal());
    }

}

