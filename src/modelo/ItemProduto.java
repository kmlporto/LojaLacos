package modelo;

public class ItemProduto {
	private Produto produto;
	private int quantidade;
	private double preco;
	private Carrinho carrinho;
	

	//.............. Contructs & toString ..................
	public ItemProduto(Produto produto, int quantidade) {
		super();
		this.produto = produto;
		this.quantidade = quantidade;
		this.preco = this.produto.getPreco();
	}
	
	public ItemProduto(Produto produto, int quantidade, double preco) {
		super();
		this.produto = produto;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	@Override
	public String toString() {
		return "Item:"+
				"\n- produto: " +
				"\n   descriao: " + produto.getDescricao() + 
				"\n   modelo: " + produto.getModelo() +
				"\n   cor: " + produto.getCor() +
				"\n- quantidade:" + quantidade +
				"\n- preço(und):" + preco;
	}
	
	//.............. get's & set's..................
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public Produto getProduto() {
		return produto;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}
}
