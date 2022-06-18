package inicial.excecao.personalizadaA;

import inicial.excecao.Aluno;

public class TesteValidacoes {
	
	public static void main(String[] args) {
		
		Aluno a = null;

		
		try {
			Aluno b = new Aluno("s",6);
			Validar.aluno(b);
			Validar.aluno(a);
		} catch (StringVaziaException | NumeroNegativoException e) {
			System.out.println(e.getMessage());
		} catch(IllegalArgumentException e) {
			System.out.println("Ilegal " + e.getMessage());
		}
		
		System.out.println("FIM :)");
	}
}
