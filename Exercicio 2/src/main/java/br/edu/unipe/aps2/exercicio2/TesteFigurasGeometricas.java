package br.edu.unipe.aps2.exercicio2;

public class TesteFigurasGeometricas {
    public static void main(String[] args) {
        System.out.println("=== TESTE DAS FIGURAS GEOMÉTRICAS ===\n");

        System.out.println("1. TESTANDO TRIÂNGULO:");
        Triangulo triangulo = new Triangulo(5.0, 4.0);
        System.out.println("   " + triangulo);
        System.out.println("   Nome: " + triangulo.getNomeFigura());
        System.out.println("   Área calculada: " + triangulo.calculaArea());
        System.out.println();

        System.out.println("2. TESTANDO LOSANGO:");
        Losango losango = new Losango(6.0, 8.0);
        System.out.println("   " + losango);
        System.out.println("   Nome: " + losango.getNomeFigura());
        System.out.println("   Área calculada: " + losango.calculaArea());
        System.out.println();

        System.out.println("3. TESTANDO GERENTE DE FIGURAS:");
        GerenteDeFiguras gerente = new GerenteDeFiguras();

        gerente.adicionaFigura(triangulo);
        gerente.adicionaFigura(losango);
        gerente.adicionaFigura(new Triangulo(3.0, 6.0));
        gerente.adicionaFigura(new Losango(10.0, 4.0));
        
        System.out.println("   Figuras adicionadas ao gerente:");
        gerente.imprimeFiguras();
        
        System.out.println("   Quantidade de figuras: " + gerente.getQuantidadeFiguras());
        System.out.println("   Maior área: " + gerente.getMaiorAreaDeFigura());
        System.out.println("   Área total: " + gerente.getAreaTotalDeFiguras());
        System.out.println();
        
        System.out.println("4. DETALHES DE TODAS AS FIGURAS:");
        gerente.imprimeFigurasDetalhadas();

        System.out.println("5. DEMONSTRANDO POLIMORFISMO:");
        FiguraGeometrica[] figuras = {
            new Triangulo(2.0, 3.0),
            new Losango(4.0, 5.0),
            new Triangulo(7.0, 2.0),
            new Losango(6.0, 3.0)
        };
        
        System.out.println("   Processando array de FiguraGeometrica:");
        for (int i = 0; i < figuras.length; i++) {
            FiguraGeometrica fig = figuras[i];
            System.out.printf("   %d. %s - Área: %.2f%n", 
                            (i + 1), fig.getNomeFigura(), fig.calculaArea());
        }
        
        System.out.println("\n=== FIM DOS TESTES ===");
    }
}
