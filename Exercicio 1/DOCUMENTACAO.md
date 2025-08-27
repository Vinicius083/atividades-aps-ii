# Sistema de Agenda de Aniversários

## Diagrama de Classes

```
┌─────────────────────────────────────┐
│           <<interface>>             │
│        AgendaDeAniversarios         │
├─────────────────────────────────────┤
│ + adicionarAniversariante(String,   │
│   int, int): void                   │
│ + obterAniversariantesDoDia(int,    │
│   int): ArrayList<String>           │
│ + removerAniversariante(String):    │
│   void                              │
└─────────────────────────────────────┘
                    △
                    │ implements
                    │
┌─────────────────────────────────────┐
│     MinhaAgendaDeAniversarios       │
├─────────────────────────────────────┤
│ - aniversariantes: ArrayList<       │
│   Aniversariante>                   │
├─────────────────────────────────────┤
│ + MinhaAgendaDeAniversarios()       │
│ + adicionarAniversariante(String,   │
│   int, int): void                   │
│ + obterAniversariantesDoDia(int,    │
│   int): ArrayList<String>           │
│ + removerAniversariante(String):    │
│   void                              │
│ + getTotalAniversariantes(): int    │
│ + contemAniversariante(             │
│   Aniversariante): boolean          │
│ + listarTodosAniversariantes():     │
│   ArrayList<Aniversariante>         │
│ + toString(): String                │
└─────────────────────────────────────┘
                    │
                    │ contains
                    │ 1..*
                    ▼
┌─────────────────────────────────────┐
│          Aniversariante             │
├─────────────────────────────────────┤
│ - nome: String                      │
│ - dataAniversario: DataAniversario  │
├─────────────────────────────────────┤
│ + Aniversariante(String, int, int)  │
│ + Aniversariante(String,            │
│   DataAniversario)                  │
│ + equals(Object): boolean           │
│ + getNome(): String                 │
│ + setNome(String): void             │
│ + getDataAniversario():             │
│   DataAniversario                   │
│ + setDataAniversario(               │
│   DataAniversario): void            │
│ + toString(): String                │
└─────────────────────────────────────┘
                    │
                    │ has
                    │ 1
                    ▼
┌─────────────────────────────────────┐
│          DataAniversario            │
├─────────────────────────────────────┤
│ - dia: int                          │
│ - mes: int                          │
├─────────────────────────────────────┤
│ + DataAniversario(int, int)         │
│ + getDia(): int                     │
│ + setDia(int): void                 │
│ + getMes(): int                     │
│ + setMes(int): void                 │
│ + equals(Object): boolean           │
│ + toString(): String                │
└─────────────────────────────────────┘
```

## Relacionamentos entre as Classes

1. **AgendaDeAniversarios** (Interface)

   - Define o contrato para implementações de agenda de aniversários
   - Métodos obrigatórios para adicionar, consultar e remover aniversariantes

2. **MinhaAgendaDeAniversarios** (Classe Concreta)

   - Implementa a interface `AgendaDeAniversarios`
   - Mantém uma lista (`ArrayList`) de objetos `Aniversariante`
   - Relacionamento de **composição** com `Aniversariante` (1 para muitos)

3. **Aniversariante** (Classe)

   - Representa uma pessoa com nome e data de aniversário
   - Possui relacionamento de **composição** com `DataAniversario` (1 para 1)
   - Implementa método `equals` baseado no nome e data de aniversário

4. **DataAniversario** (Classe)
   - Encapsula dia e mês do aniversário
   - Fornece método `equals` para comparação de datas
   - Classe auxiliar utilizada por `Aniversariante`

## Características Implementadas

### 1. Método equals na classe Aniversariante

- Compara nome e data de aniversário
- Retorna `true` apenas se ambos os atributos forem iguais

### 2. Construtores da classe Aniversariante

- **Construtor 1**: Recebe nome, dia e mês (cria DataAniversario internamente)
- **Construtor 2**: Recebe nome e objeto DataAniversario

### 3. Classe MinhaAgendaDeAniversarios

- Implementa todos os métodos da interface
- Utiliza `ArrayList` para armazenar aniversariantes
- Métodos adicionais para funcionalidades extras
- Tratamento adequado para remoção de elementos durante iteração

## Funcionalidades do Sistema

- **Adicionar aniversariantes** com nome e data
- **Consultar aniversariantes** por dia e mês específicos
- **Remover aniversariantes** pelo nome
- **Listar todos** os aniversariantes
- **Verificar presença** de aniversariante específico
- **Contar total** de aniversariantes cadastrados
