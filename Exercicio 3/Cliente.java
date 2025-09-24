import java.util.*;

public class Cliente {
    private String nome;
    private List<Aluguel> alugueis = new ArrayList<>();

    public Cliente(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }

    public void adicionaAluguel(Aluguel aluguel) {
        alugueis.add(aluguel);
    }

    public String extrato() {
        double valorTotal = 0;
        int pontosDeAlugadorFrequente = 0;
        String resultado = "Registro de Alugueis de " + getNome() + "\n";

        for (Aluguel aluguel : alugueis) {
            double valorCorrente = calcularValorAluguel(aluguel);

            pontosDeAlugadorFrequente += calcularPontosFrequencia(aluguel);

            resultado += "\t" + aluguel.getFita().getTitulo() + "\t" + valorCorrente + "\n";
            valorTotal += valorCorrente;
        }

        resultado += "Valor total devido: " + valorTotal + "\n";
        resultado += "Você ganhou " + pontosDeAlugadorFrequente + " pontos de alugador frequente";
        return resultado;
    }

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

    private int calcularPontosFrequencia(Aluguel aluguel) {
        int pontos = 1; 
        
        if (aluguel.getFita().getTipoPreco() == TipoPreco.LANCAMENTO 
            && aluguel.getDiasAlugada() > 1) {
            pontos++; 
        }
        
        return pontos;
    }
}
