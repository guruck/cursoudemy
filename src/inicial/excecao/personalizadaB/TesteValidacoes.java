package inicial.excecao.personalizadaB;

import inicial.excecao.Aluno;

public class TesteValidacoes {
	
	public static void main(String[] args) {
		
		Aluno a = null;
		// Validar.aluno(a); // como as Execptions s�o Checadas nesse exemplo, devem ser obrigatoriamente tratadas 
		
		try {
			Aluno b = new Aluno("s",6);
			Validar.aluno(b);
			Validar.aluno(a);
		} catch (StringVaziaException | NumeroNegativoException e) {
			System.out.println(e.getMessage());
		} catch(IllegalArgumentException e) {
			System.out.println("Ilegal " + e.getMessage());
		} finally {
			System.out.println("Bloco no Finally, sempre � executado mesmo com excess�es");
		}
		
		System.out.println("FIM :)");
	}
}
