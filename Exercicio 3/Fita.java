public class Fita {
	
	public static final int NORMAL = 0;
	public static final int LANCAMENTO = 1;
	public static final int INFANTIL = 2;
	
	private String titulo;
	private TipoPreco tipoPreco;
	
	public Fita(String titulo, TipoPreco tipoPreco) {
		this.titulo = titulo;
		this.tipoPreco = tipoPreco;
	}
	
	public Fita(String titulo, int codigoDePreco) {
		this.titulo = titulo;
		this.tipoPreco = converterCodigoParaTipo(codigoDePreco);
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public TipoPreco getTipoPreco() {
		return tipoPreco;
	}
	
	public int getCodigoDePreco() {
		switch (tipoPreco) {
			case NORMAL:
				return NORMAL;
			case LANCAMENTO:
				return LANCAMENTO;
			case INFANTIL:
				return INFANTIL;
			default:
				throw new IllegalStateException("Tipo de preço inválido: " + tipoPreco);
		}
	}
	
	public void setTipoPreco(TipoPreco tipoPreco) {
		this.tipoPreco = tipoPreco;
	}
	public void setcodigoDePreco(int codPreco) {
		this.tipoPreco = converterCodigoParaTipo(codPreco);
	}
	
	private TipoPreco converterCodigoParaTipo(int codigo) {
		switch (codigo) {
			case NORMAL:
				return TipoPreco.NORMAL;
			case LANCAMENTO:
				return TipoPreco.LANCAMENTO;
			case INFANTIL:
				return TipoPreco.INFANTIL;
			default:
				throw new IllegalArgumentException("Código de preço inválido: " + codigo);
		}
	}
}