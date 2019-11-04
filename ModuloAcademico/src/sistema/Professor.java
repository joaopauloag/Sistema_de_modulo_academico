package sistema;

public class Professor extends Usuario {

	private int qtdDisciplinas;
	private String[] disciplinas;
	
	
	public Professor() {
		super();
		qtdDisciplinas = 0;
		disciplinas = new String[4];
	}

	public int getQtdDisciplinas() {
		return qtdDisciplinas;
	}

	public void setQtdDisciplinas(int qtdDisciplinas) {
		this.qtdDisciplinas = qtdDisciplinas;
	}

	public String[] getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(String[] disciplinas) {
		this.disciplinas = disciplinas;
	}

	
	@Override
	public void criarConta() {
		// TODO Auto-generated method stub
		super.criarLogin();
		System.out.println("");
	}

	
	@Override
	public void menu() {
		// TODO Auto-generated method stub
		
	}

	
}
