/*
 Aluno: Joshua Victor
 Matricula: 789339
 */
package maven.project;
import java.util.*;

public class Aplicacao {
	
	public static void main(String[] args) throws Exception {
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = new Pessoa();
		
		Scanner sc = new Scanner(System.in);
		int opcao = 0;
		

		do {
			
			System.out.println("1 - Listar\n2 - Inserir\n3 - Excluir\n4 - Atualizar\n5 - Sair\n");
			System.out.print("\nEscolha: ");
			opcao = sc.nextInt();
			
			while (opcao < 1 || opcao > 5) {
				System.out.println("\nOpcao Invalida!\n");
				System.out.println("1 - Listar\n2 - Inserir\n3 - Excluir\n4 - Atualizar\n5 - Sair\n");
				System.out.print("\nEscolha: ");
				opcao = sc.nextInt();
			}
		    switch (opcao) {
		      case 1: pessoaDAO.get("id"); break;
		      case 2: pessoaDAO.inserirPessoa(pessoaDAO); break;
		      case 3: pessoaDAO.deletarPessoa(pessoaDAO); break;
		      case 4: pessoaDAO.update(pessoa); break;
		      case 5: pessoaDAO.finalize(); break;
	        }
		} while (opcao != 5 );
		
		sc.close();
	
	}
}