package br.edu.unipe.aps2.exercicio2;

public class ProgramaDasFiguras {
    public static void main(String[] args) {
        GerenteDeFiguras gerente = new GerenteDeFiguras();
        Triangulo t1 = new Triangulo(2.0, 3.0);
        gerente.adicionaFigura(t1);
        
        // a) Adicione mais dois losangos ao GerenteDeFiguras representado pela variável gerente
        Losango l1 = new Losango(4.0, 6.0);
        Losango l2 = new Losango(8.0, 5.0);
        gerente.adicionaFigura(l1);
        gerente.adicionaFigura(l2);
        
        // b) Imprima por meio do método apropriado da classe GerenteDeFiguras todas as figuras cadastradas
        gerente.imprimeFiguras();
        
        // c) Calcule e imprima a área total de todas as figuras cadastradas no GerenteDeFiguras gerente
        double areaTotal = gerente.getAreaTotalDeFiguras();
        System.out.printf("Área total de todas as figuras: %.2f%n", areaTotal);
        
        // Informações adicionais para demonstração
        System.out.println("\n=== Informações Adicionais ===");
        System.out.printf("Quantidade de figuras cadastradas: %d%n", gerente.getQuantidadeFiguras());
        System.out.printf("Maior área entre as figuras: %.2f%n", gerente.getMaiorAreaDeFigura());
        
        System.out.println("\n=== Detalhes das Figuras ===");
        gerente.imprimeFigurasDetalhadas();
    }
}
