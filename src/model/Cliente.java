package model;

public class Cliente {
    private String nome;
    private String cpf;
    private String Endereco;

    public Cliente(String nome, String cpf, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        Endereco = endereco;
    }

    // Aqui aparece o toString para definir como o objeto será representado em texto
    @Override
    public String toString() {
        return "Cliente{" +
                "nome = '" + nome + '\'' +
                ", cpf = '" + cpf + '\'' +
                ", Endereco = '" + Endereco + '\'' +
                '}';
    }

    // O get e set servem para controlar o acesso aos objetos
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }
}
