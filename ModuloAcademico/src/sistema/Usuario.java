package sistema;

import java.util.Scanner;

public abstract class Usuario {

	private String cpf;
	private String nome;
	private String email;
	private String senha;
	private Scanner entrada;
	
	
	public Usuario() {
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		if(cpf.length() == 11) {
			this.cpf = cpf;
		}
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		if(senha.length() < 6) {
			System.out.println("\nSenha muito curta! Insira novamente.");
		} else {
			this.senha = senha;
		}
	}
	
	
	public void criarLogin() {
		
		String confirmaSenha;
		entrada = new Scanner(System.in);
		
		System.out.print("\nInforme o seu email: ");
		this.email = entrada.nextLine();
		while(true) {
			do {
				System.out.print("\nCrie uma senha com no minimo 6 digitos: ");
				this.senha = entrada.nextLine();
			} while(this.senha.length() < 6);
			System.out.print("\nConfirme a sua senha: ");
			confirmaSenha = entrada.nextLine();
			if(this.senha.equals(confirmaSenha)) {
				break;
			}
			System.out.println("\nSenha incorreta!");
		}
		System.out.println("\nBem vindo ao Modulo Academico! Agora informe os seguintes dados:");
		criarPerfil();
	}
	
	public void criarPerfil() {
		System.out.print("\nNome completo: ");
		this.nome = entrada.nextLine();
		do {
			System.out.print("\nCPF (somente os 11 digitos): ");
			this.cpf = entrada.nextLine();
		} while(this.cpf.length() != 11);
	}
	
	public void alterarSenha() {
		
		String confirmaSenha;
		entrada = new Scanner(System.in);
		
		System.out.println("\nEntre com sua senha atual: ");
		confirmaSenha = entrada.nextLine();
		if(!this.senha.equals(confirmaSenha)) {
			System.out.println("\nSenha incorreta!");
			return;
		}
		while(true) {
			do {
				System.out.print("\nEntre com sua nova senha (minimo de 6 digitos): ");
				this.senha = entrada.nextLine();
			} while(this.senha.length() < 6);
			System.out.print("\nConfirme a sua nova senha: ");
			confirmaSenha = entrada.nextLine();
			if(this.senha.equals(confirmaSenha)) {
				System.out.println("\nSenha alterada!");
				break;
			}
			System.out.println("\nSenha incorreta!");
		}
	}
	
	
	public abstract void criarConta();
	
	public abstract void menu();
	
}
