# LocadoraJavaPOO
## 🚗 Locadora de Veículos

Projeto de estudos criado durante a **Maratona Java (DevDojo)**, aplicando os conceitos
vistos até a aula 78+ (POO, herança, associação entre objetos e enumerações).

Sistema de console para gerenciar o cadastro de veículos, clientes e locações de uma
locadora fictícia.

## 🎯 Objetivo

Praticar, um projeto único, os seguintes conceitos de Java:

- [x] Classes, objetos, atributos e métodos
- [x] Encapsulamento (`private` + getters/setters)
- [x] Construtores
- [x] Herança (`extends`, `super`, `protected`)
- [x] Associação entre objetos
- [x] Atributos e métodos `static`
- [x] Modificador `final` (constantes)
- [x] Enumerações (`enum`), inclusive com construtor e atributo
- [x] Entrada de dados via `Scanner`
- [ ] *(próximos passos, fora do escopo por enquanto)*: classes abstratas, interfaces,
  polimorfismo, exceções, coleções

## 📁 Estrutura do Projeto

O projeto foi organizado em pacotes para separar as responsabilidades de cada parte da aplicação, facilitando a manutenção e a compreensão do código.

```text
src
├── enums
│   ├── CategoriaVeiculo.java
│   ├── FormaPagamento.java
│   └── StatusLocacao.java
│
├── model
│   ├── Carro.java
│   ├── Cliente.java
│   ├── Locacao.java
│   ├── Moto.java
│   └── Veiculo.java
│
├── service
│   └── Locadora.java
│
└── Main.java
```

### 📦 Pacotes

- **`enums`**
  - Contém as enumerações utilizadas pelo sistema.
  - `CategoriaVeiculo`: categorias dos veículos e seus valores de diária.
  - `FormaPagamento`: formas de pagamento aceitas.
  - `StatusLocacao`: controla o status da locação.

- **`model`**
  - Contém as entidades (modelos) da aplicação.
  - `Veiculo`: classe base para os veículos.
  - `Carro` e `Moto`: especializações de `Veiculo` utilizando herança.
  - `Cliente`: representa um cliente cadastrado.
  - `Locacao`: representa uma locação realizada entre cliente e veículo.

- **`service`**
  - Contém a lógica de negócio do sistema.
  - `Locadora`: responsável pelo gerenciamento dos cadastros, locações, devoluções e consultas.

- **`Main`**
  - Ponto de entrada da aplicação.
  - Responsável pela interação com o usuário através do menu no console.