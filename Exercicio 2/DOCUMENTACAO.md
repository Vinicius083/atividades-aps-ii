# Exercício 2 - Figuras Geométricas

## Descrição

Este exercício implementa um sistema de gerenciamento de figuras geométricas usando conceitos de interface e polimorfismo em Java.

## Estrutura do Projeto

### Interface FiguraGeometrica

- Define o contrato que todas as figuras geométricas devem seguir
- Métodos:
  - `calculaArea()`: calcula e retorna a área da figura
  - `getNomeFigura()`: retorna o nome da figura

### Classes Implementadas

#### Triangulo

- Implementa `FiguraGeometrica`
- Atributos: base e altura
- Fórmula da área: (base × altura) / 2

#### Losango

- Implementa `FiguraGeometrica`
- Atributos: diagonal1 e diagonal2
- Fórmula da área: (diagonal1 × diagonal2) / 2

#### GerenteDeFiguras

Classe responsável por gerenciar uma lista de figuras geométricas.

**Métodos implementados:**

1. `adicionaFigura(FiguraGeometrica figura)` - Adiciona uma figura à lista
2. `removeFigura(FiguraGeometrica figura)` - Remove uma figura da lista
3. `imprimeFiguras()` - Imprime os nomes de todas as figuras cadastradas
4. `getMaiorAreaDeFigura()` - Retorna a maior área entre todas as figuras
5. `getAreaTotalDeFiguras()` - Calcula a área total de todas as figuras
6. `getQuantidadeFiguras()` - Retorna o número de figuras cadastradas
7. `imprimeFigurasDetalhadas()` - Imprime informações detalhadas das figuras

#### ProgramaDasFiguras

Classe principal que demonstra o uso do sistema:

- Cria um GerenteDeFiguras
- Adiciona um triângulo e dois losangos
- Imprime todas as figuras cadastradas
- Calcula e exibe a área total das figuras

## Como Executar

1. Compile o projeto:

```bash
mvn compile
```

2. Execute o programa principal:

```bash
mvn exec:java -Dexec.mainClass="br.edu.unipe.aps2.exercicio2.ProgramaDasFiguras"
```

## Exemplo de Saída

```
=== Figuras Cadastradas ===
1. Triângulo
2. Losango
3. Losango
===========================
Área total de todas as figuras: 35.00

=== Informações Adicionais ===
Quantidade de figuras cadastradas: 3
Maior área entre as figuras: 20.00

=== Detalhes das Figuras ===
1. Triângulo - Área: 3.00
2. Losango - Área: 12.00
3. Losango - Área: 20.00
============================
```

## Conceitos Demonstrados

- **Interface**: Define um contrato comum para todas as figuras
- **Polimorfismo**: Permite tratar diferentes tipos de figuras de forma uniforme
- **Encapsulamento**: Cada classe mantém seus atributos privados
- **Herança de Interface**: As classes concretas implementam a interface
- **Lista Genérica**: Uso de `List<FiguraGeometrica>` para armazenar diferentes tipos de figuras
