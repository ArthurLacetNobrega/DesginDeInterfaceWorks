package br.com.model;

public class Usuario {
	
	private String id;

	private String telefone;

	private String email;

	private String nome;
	
	private String  senha;

	public Usuario(String id, String telefone, String email, String nome, String senha) {
		super();
		this.id = id;
		this.telefone = telefone;
		this.email = email;
		this.nome = nome;
		this.senha = senha;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
