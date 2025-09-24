public enum TipoPreco {
    NORMAL(2.0, 2, 1.5),
    LANCAMENTO(3.0, 0, 3.0),
    INFANTIL(1.5, 3, 1.5);
    
    private final double precoBase;
    private final int diasGratuitos;
    private final double precoPorDiaExcedente;
    
    TipoPreco(double precoBase, int diasGratuitos, double precoPorDiaExcedente) {
        this.precoBase = precoBase;
        this.diasGratuitos = diasGratuitos;
        this.precoPorDiaExcedente = precoPorDiaExcedente;
    }
    
    public double getPrecoBase() {
        return precoBase;
    }
    
    public int getDiasGratuitos() {
        return diasGratuitos;
    }
    
    public double getPrecoPorDiaExcedente() {
        return precoPorDiaExcedente;
    }
}