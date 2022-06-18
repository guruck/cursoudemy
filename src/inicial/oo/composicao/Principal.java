package inicial.oo.composicao;

public class Principal {
	public static void main(String[] args) {
		
		// relacao 1 pra 1 
		Carro carro = new Carro();
		System.out.println(carro.estaLigado());
		carro.ligar();
		System.out.println(carro.estaLigado());
		
		System.out.println(carro.motor.giros());
		
		// relacao 1 pra muitos
		
		Compra compra = new Compra();
		compra.cliente = "Joao Doriana";
		compra.adicionarItem("batata", 3, 3.23);
		compra.adicionarItem(new Item("feijao", 3, 6.23));
		compra.adicionarItem("Caderno", 1, 4.23);
		
		System.out.println(compra.itens.size());
		System.out.println(compra.obterValorTotal());
		
		// relacao muitos pra muitos
		Aluno aluno1 = new Aluno("João"); 
		Aluno aluno2 = new Aluno("Maria");
		Aluno aluno3 = new Aluno("Pedro");
		
		Curso curso1 = new Curso("java completo");
		Curso curso2 = new Curso("spring boot");
		Curso curso3 = new Curso("Node React");
		
		curso1.adicionarAluno(aluno1);
		curso1.adicionarAluno(aluno2);
		
		curso2.adicionarAluno(aluno3);
		curso2.adicionarAluno(aluno2);
		
		aluno1.adicionarCurso(curso3);
		aluno2.adicionarCurso(curso3);
		aluno3.adicionarCurso(curso3);
		
		for (Aluno aluno: curso1.alunos) {
			System.out.println("Curso1: " + curso1.nome);
			System.out.println(aluno.nome);
		}
		
	}
}
