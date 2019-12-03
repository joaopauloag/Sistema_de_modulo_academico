package sistema;

import java.util.Scanner;

public abstract class Usuario {

	private String cpf;
	private String nome;
	private String email;
	private String senha;
	protected Scanner entrada;
	
	
	public Usuario() {
		this.cpf = null;
		this.nome = null;
		this.email = null;
		this.senha = null;
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
	
	
	public void criarPerfil() {
		
		String confirmaSenha;
		entrada = new Scanner(System.in);
		
		while(true) {
			do {
				System.out.print("\nCrie uma senha com no minimo 6 digitos: ");
				senha = entrada.nextLine();
			} while(senha.length() < 6);
			System.out.print("\nConfirme a sua senha: ");
			confirmaSenha = entrada.nextLine();
			if(senha.equals(confirmaSenha)) {
				break;
			}
			System.out.println("\nSenha incorreta!");
		}
		System.out.println("\nBem vindo ao Modulo Academico! Agora informe os seguintes dados:");
		System.out.print("\nNome completo: ");
		nome = entrada.nextLine();

		while(true) {
			System.out.print("\nCPF (somente os 11 digitos): ");
			try {
				cpf = String.valueOf(entrada.nextLong());
			} catch(NumberFormatException e) {
				System.out.println("\nEntrada invalida!");
				continue;
			} finally {
				if(cpf.length() != 11) {
					System.out.println("\nVoce nao digitou os 11 digitos do cpf.");
					continue;
				}
			}
			break;
		}
	}
	
	public void alterarSenha() {
		
		String confirmaSenha;
		entrada = new Scanner(System.in);
		
		System.out.println("\nEntre com sua senha atual: ");
		confirmaSenha = entrada.nextLine();
		if(!senha.equals(confirmaSenha)) {
			System.out.println("\nSenha incorreta!");
			return;
		}
		while(true) {
			do {
				System.out.print("\nEntre com sua nova senha (minimo de 6 digitos): ");
				senha = entrada.nextLine();
			} while(senha.length() < 6);
			System.out.print("\nConfirme a sua nova senha: ");
			confirmaSenha = entrada.nextLine();
			if(senha.equals(confirmaSenha)) {
				System.out.println("\nSenha alterada!");
				break;
			}
			System.out.println("\nSenha incorreta!");
		}
	}
	
	
	public abstract void criarConta();
	
	public abstract void menu();
	
}
