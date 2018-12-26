package modelo;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
	private Pagamento pagamento;
	private List<ItemProduto> itens = new ArrayList<ItemProduto>();
	private double frete;
	private double total;
	private Cliente cliente;
	
	// ........... construtor e toString .............	
	public Carrinho() {
		super();
	}
	
	@Override
	public String toString() {
		return "Carrinho: \n  cliente: "+ cliente.getNome() + (pagamento != null ? "\n  pagamento: " + pagamento + ", " : "")
				+ (itens != null ? "\n  itens: " + itens : "") + "\n  frete: " + frete + "\n  total: " + total;
	}

	// .............. gets e sets ..............
	public List<ItemProduto> getItens() {
		return itens;
	}

	public void setItens(List<ItemProduto> itens) {
		this.itens = itens;
	}
	
	public double getFrete() {
		return frete;
	}
	
	public void setFrete(double frete) {
		this.frete = frete;
	}
	
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	// ................ adicionar, remover, localizar ..........
	public void adicionar(ItemProduto item) {
		itens.add(item);
	}
	public void remover(ItemProduto item) {
		itens.remove(item);
	}
	
	public ItemProduto localizar(Produto produto) {
		for (ItemProduto i: itens)
			if(i.getProduto().equals(produto)) 
				return i;
		return null;
	}
	// ......... outros ......
	public boolean isVazio() {
		return itens.isEmpty();
	}


}