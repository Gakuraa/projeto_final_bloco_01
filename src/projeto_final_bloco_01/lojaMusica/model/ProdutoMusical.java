package projeto_final_bloco_01.lojaMusica.model;

public abstract class ProdutoMusical {
	
	private int id;
	private String nome;
	private double preco;
	private int tipo;
	
	public ProdutoMusical(int id, String nome, double preco, int tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public void visualizar() {
		String tipo = "";

		switch (this.tipo) {
		case 1:
			tipo = "Intrumento Musical";
			break;
		case 2:
			tipo = "CDs";
			break;
		default:
			tipo = "Tipo desconhecido";
			break;
		}
		
		System.out.println("ID: " + id);
		System.out.println("Nome: " + nome);
		System.out.println("Tipo: " + tipo);
		System.out.println("Preço: " + preco);

	}
	
}
