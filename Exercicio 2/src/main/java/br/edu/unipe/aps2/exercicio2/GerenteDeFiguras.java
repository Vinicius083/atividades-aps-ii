package br.edu.unipe.aps2.exercicio2;

import java.util.List;
import java.util.ArrayList;

public class GerenteDeFiguras {
    private List<FiguraGeometrica> figuras;
    
    public GerenteDeFiguras() {
        figuras = new ArrayList<FiguraGeometrica>();
    }
    
    /**
     * Adiciona uma figura à lista de figuras gerenciadas
     * @param figura A figura a ser adicionada
     */
    public void adicionaFigura(FiguraGeometrica figura) {
        if (figura != null) {
            figuras.add(figura);
        }
    }
    
    /**
     * Remove uma figura da lista de figuras gerenciadas
     * @param figura A figura a ser removida
     * @return true se a figura foi removida, false caso contrário
     */
    public boolean removeFigura(FiguraGeometrica figura) {
        return figuras.remove(figura);
    }
    
    /**
     * Imprime na saída padrão os nomes de todas as figuras guardadas por esse gerente
     */
    public void imprimeFiguras() {
        System.out.println("=== Figuras Cadastradas ===");
        if (figuras.isEmpty()) {
            System.out.println("Nenhuma figura cadastrada.");
        } else {
            for (int i = 0; i < figuras.size(); i++) {
                System.out.println((i + 1) + ". " + figuras.get(i).getNomeFigura());
            }
        }
        System.out.println("===========================");
    }
    
    /**
     * Retorna a área da figura cadastrada nesse gerente que tem a maior área
     * @return A maior área encontrada, ou 0.0 se não houver figuras
     */
    public double getMaiorAreaDeFigura() {
        if (figuras.isEmpty()) {
            return 0.0;
        }
        
        double maiorArea = figuras.get(0).calculaArea();
        for (FiguraGeometrica figura : figuras) {
            double areaAtual = figura.calculaArea();
            if (areaAtual > maiorArea) {
                maiorArea = areaAtual;
            }
        }
        return maiorArea;
    }
    
    /**
     * Calcula a área total de todas as figuras cadastradas
     * @return A soma das áreas de todas as figuras
     */
    public double getAreaTotalDeFiguras() {
        double areaTotal = 0.0;
        for (FiguraGeometrica figura : figuras) {
            areaTotal += figura.calculaArea();
        }
        return areaTotal;
    }
    
    /**
     * Retorna o número de figuras cadastradas
     * @return O número de figuras na lista
     */
    public int getQuantidadeFiguras() {
        return figuras.size();
    }
    
    /**
     * Imprime informações detalhadas de todas as figuras
     */
    public void imprimeFigurasDetalhadas() {
        System.out.println("=== Detalhes das Figuras ===");
        if (figuras.isEmpty()) {
            System.out.println("Nenhuma figura cadastrada.");
        } else {
            for (int i = 0; i < figuras.size(); i++) {
                FiguraGeometrica figura = figuras.get(i);
                System.out.printf("%d. %s - Área: %.2f%n", 
                                (i + 1), figura.getNomeFigura(), figura.calculaArea());
            }
        }
        System.out.println("============================");
    }
    
    /**
     * Retorna a lista de figuras (cópia para proteção)
     * @return Uma nova lista contendo as figuras
     */
    public List<FiguraGeometrica> getFiguras() {
        return new ArrayList<>(figuras);
    }
}
