package Database;

public class Pokemon {
	private int id;
	private String nome;
	private int vida;
	private int tipo;

	public Pokemon(int id, String nome, int vida, int tipo1) {
		this.id = id;
		this.nome = nome;
		this.vida = vida;
		this.tipo = tipo1;

	}

	// Getters e Setters
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

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo1(int tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", nome=" + nome + ", vida=" + vida + ", tipo=" + tipo + "]";
	}
}
