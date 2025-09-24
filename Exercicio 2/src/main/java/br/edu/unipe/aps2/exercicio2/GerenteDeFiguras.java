package br.edu.unipe.aps2.exercicio2;

import java.util.List;
import java.util.ArrayList;

public class GerenteDeFiguras {
    private List<FiguraGeometrica> figuras;
    
    public GerenteDeFiguras() {
        figuras = new ArrayList<FiguraGeometrica>();
    }

    public void adicionaFigura(FiguraGeometrica figura) {
        if (figura != null) {
            figuras.add(figura);
        }
    }

    public boolean removeFigura(FiguraGeometrica figura) {
        return figuras.remove(figura);
    }

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

    public double getAreaTotalDeFiguras() {
        double areaTotal = 0.0;
        for (FiguraGeometrica figura : figuras) {
            areaTotal += figura.calculaArea();
        }
        return areaTotal;
    }

    public int getQuantidadeFiguras() {
        return figuras.size();
    }

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

    public List<FiguraGeometrica> getFiguras() {
        return new ArrayList<>(figuras);
    }
}
