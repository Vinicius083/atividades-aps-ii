# Projeto Locadora - Refatorações Aplicadas

## Estrutura do Projeto

- `Locadora.java` - Classe principal com método main
- `Cliente.java` - Representa um cliente da locadora
- `Fita.java` - Representa uma fita de filme
- `Aluguel.java` - Representa um aluguel de fita
- `TipoPreco.java` - Enum criado para substituir códigos mágicos

## Refatorações Realizadas

### 1. **Extract Method** - Extração de Métodos

#### Problema Original

A classe `Cliente` possuía um método `extrato()` muito longo e complexo (35+ linhas) que violava o **Princípio da Responsabilidade Única (SRP)**. Este método estava fazendo múltiplas tarefas:

- Calculando o valor do aluguel
- Calculando pontos de frequência
- Formatando o extrato

#### Solução Implementada

Extraímos a lógica complexa em métodos menores e mais focados:

```java
private double calcularValorAluguel(Aluguel aluguel)
private int calcularPontosFrequencia(Aluguel aluguel)
```

#### Benefícios Obtidos

- ✅ **Maior legibilidade**: Cada método tem uma responsabilidade clara
- ✅ **Facilita testes**: Métodos menores são mais fáceis de testar
- ✅ **Manutenibilidade**: Mudanças em regras de cálculo ficam isoladas
- ✅ **Reutilização**: Métodos podem ser usados em outros contextos

### 2. **Replace Magic Numbers with Enum** - Substituição de Números Mágicos

#### Problema Original

O código utilizava constantes numéricas para representar tipos de fita:

```java
public static final int NORMAL = 0;
public static final int LANCAMENTO = 1;
public static final int INFANTIL = 2;
```

Isso causava:

- Código pouco expressivo
- Propensão a erros
- Dificuldade de manutenção

#### Solução Implementada

Criamos o enum `TipoPreco` que encapsula tanto o tipo quanto as regras de negócio:

```java
public enum TipoPreco {
    NORMAL(2.0, 2, 1.5),
    LANCAMENTO(3.0, 0, 3.0),
    INFANTIL(1.5, 3, 1.5);

    private final double precoBase;
    private final int diasGratuitos;
    private final double precoPorDiaExcedente;
}
```

#### Benefícios Obtidos

- ✅ **Type Safety**: Prevenção de erros em tempo de compilação
- ✅ **Expressividade**: `TipoPreco.LANCAMENTO` é muito mais claro que `1`
- ✅ **Encapsulamento**: Regras de negócio centralizadas no enum
- ✅ **Extensibilidade**: Fácil adição de novos tipos de preço

## Comparação: Antes vs Depois

### Cálculo de Valor - ANTES

```java
switch (aluguel.getFita().getCodigoDePreco()) {
    case Fita.NORMAL:
        valorCorrente += 2;
        if (aluguel.getDiasAlugada() > 2)
            valorCorrente += (aluguel.getDiasAlugada() - 2) * 1.5;
        break;
    case Fita.LANCAMENTO:
        valorCorrente += aluguel.getDiasAlugada() * 3;
        break;
    // ...
}
```

### Cálculo de Valor - DEPOIS

```java
private double calcularValorAluguel(Aluguel aluguel) {
    TipoPreco tipo = aluguel.getFita().getTipoPreco();
    int diasAlugada = aluguel.getDiasAlugada();

    double valorCorrente = tipo.getPrecoBase();

    if (tipo == TipoPreco.LANCAMENTO) {
        valorCorrente = diasAlugada * tipo.getPrecoPorDiaExcedente();
    } else {
        int diasExcedentes = Math.max(0, diasAlugada - tipo.getDiasGratuitos());
        valorCorrente += diasExcedentes * tipo.getPrecoPorDiaExcedente();
    }

    return valorCorrente;
}
```

## Princípios de Design Aplicados

### SOLID Principles

- **S** - Single Responsibility Principle: Cada método tem uma única responsabilidade
- **O** - Open/Closed Principle: Facilita extensão sem modificar código existente

### Clean Code Practices

- **Meaningful Names**: Nomes de métodos e variáveis expressivos
- **Small Functions**: Métodos pequenos e focados
- **No Magic Numbers**: Substituição por enums expressivos

## Compatibilidade

As refatorações foram implementadas mantendo **compatibilidade total** com o código existente:

- A classe `Fita` mantém os métodos legados
- Constantes numéricas ainda funcionam
- Interface pública permanece inalterada

## Dupla

```bash
touch Vinícius_Almeida.aluno
touch Kauã_Oliveira.aluno
```
