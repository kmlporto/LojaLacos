package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String descricao;
	private String modelo;
	private int estoque;
	private String cor;
	private double largura;
	private double preco;
	@OneToMany(mappedBy="produto", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<ItemProduto> itens = new ArrayList<ItemProduto>();

	public Produto () {
		super();
	}
	
	public Produto( String descricao,String modelo, int estoque, String cor, double largura, double preco) {
		super();
		this.descricao = descricao;
		this.modelo = modelo;
		this.estoque = estoque;
		this.cor = cor;
		this.largura = largura;
		this.preco = preco;
	}
	
	@Override
	public String toString() {
		return "\nProduto\n codigo: " + id +
				"\n descricao: " + descricao + 
				"\n modelo: " + modelo +
				"\n estoque: " + estoque +
				"\n cor: " + cor + 
				"\n largura: " + largura +
				"\n preco: " + preco ;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public double getLargura() {
		return largura;
	}
	
	public void setLargura(double largura) {
		this.largura = largura;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public void add(ItemProduto item) {
		this.itens.add(item);
	}
	
	public void remove(ItemProduto item) {
		this.itens.remove(item);
	}

}
