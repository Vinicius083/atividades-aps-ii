package br.edu.unipe.aps2.exercicio1;

import java.util.ArrayList;

public class TesteAgendaAniversarios {
    
    public static void main(String[] args) {
        MinhaAgendaDeAniversarios agenda = new MinhaAgendaDeAniversarios();
        
        System.out.println("=== TESTE DO SISTEMA DE AGENDA DE ANIVERSÁRIOS ===\n");
        
        System.out.println("1. Adicionando aniversariantes:");
        agenda.adicionarAniversariante("João", 15, 3);
        agenda.adicionarAniversariante("Maria", 20, 7);
        agenda.adicionarAniversariante("Pedro", 15, 3);
        agenda.adicionarAniversariante("Ana", 10, 12);
        
        System.out.println("Aniversariantes adicionados com sucesso!");
        System.out.println("Total de aniversariantes: " + agenda.getTotalAniversariantes());
        System.out.println();
       
        System.out.println("2. Consultando aniversariantes do dia 15/3:");
        ArrayList<String> aniversariantesMarco15 = agenda.obterAniversariantesDoDia(15, 3);
        for (String nome : aniversariantesMarco15) {
            System.out.println("- " + nome);
        }
        System.out.println();
        
        System.out.println("3. Consultando aniversariantes do dia 25/12:");
        ArrayList<String> aniversariantesNatal = agenda.obterAniversariantesDoDia(25, 12);
        if (aniversariantesNatal.isEmpty()) {
            System.out.println("Nenhum aniversariante encontrado nesta data.");
        }
        System.out.println();
        
        System.out.println("4. Testando método equals:");
        Aniversariante joao1 = new Aniversariante("João", 15, 3);
        Aniversariante joao2 = new Aniversariante("João", 15, 3);
        Aniversariante joao3 = new Aniversariante("João", 16, 3);
        
        System.out.println("João(15/3) equals João(15/3): " + joao1.equals(joao2));
        System.out.println("João(15/3) equals João(16/3): " + joao1.equals(joao3));
        System.out.println();
    
        System.out.println("5. Testando construtor com DataAniversario:");
        DataAniversario dataCarlos = new DataAniversario(5, 8);
        Aniversariante carlos = new Aniversariante("Carlos", dataCarlos);
        System.out.println("Aniversariante criado: " + carlos.toString());
        System.out.println();
        
        System.out.println("6. Lista completa de aniversariantes:");
        System.out.println(agenda.toString());
        
        System.out.println("7. Removendo aniversariante 'João':");
        agenda.removerAniversariante("João");
        System.out.println("Total após remoção: " + agenda.getTotalAniversariantes());
        System.out.println();
    
        System.out.println("8. Consultando novamente aniversariantes do dia 15/3:");
        ArrayList<String> aniversariantesMarco15Apos = agenda.obterAniversariantesDoDia(15, 3);
        for (String nome : aniversariantesMarco15Apos) {
            System.out.println("- " + nome);
        }
        System.out.println();
        
        System.out.println("=== TESTE CONCLUÍDO ===");
    }
}
