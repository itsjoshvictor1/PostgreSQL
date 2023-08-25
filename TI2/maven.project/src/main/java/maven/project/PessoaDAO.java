/*
 Aluno: Joshua Victor
 Matricula: 789339
 */
package maven.project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PessoaDAO extends DAO {
	
	public PessoaDAO() {
		super();
		conectar();
	}

	public void finalize() {
		close();
	}
	
	
	public boolean insert(Pessoa pessoa) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO pessoa (id, nome, idade, sexo) "
				       + "VALUES ("+pessoa.getId()+ ", '" + pessoa.getNome() + "', '"  
				       + pessoa.getIdade() + "', '" + pessoa.getSexo() + "');";
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public void inserirPessoa(PessoaDAO pessoaDAO) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n\n==== Inserir pessoa === ");
		System.out.print("\nDigite o id: ");
		int id = sc.nextInt();
		System.out.print("\nDigite o nome: ");
		String nome = sc.next();
		System.out.print("\nDigite a idade: ");
		int idade = sc.nextInt();
		System.out.print("\nDigite o sexo: ");
		char sexo = sc.next().charAt(0);
		Pessoa pessoa = new Pessoa(id, nome, idade, sexo);
		if(pessoaDAO.insert(pessoa) == true) {
		System.out.println("Inserção com sucesso -> " + pessoa.toString());
		}
		
		sc.close();
	}

	
	public List<Pessoa> get(String orderBy) {	
	
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM pessoa" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Pessoa u = new Pessoa(rs.getInt("id"), rs.getString("nome"), rs.getInt("idade"), rs.getString("sexo").charAt(0));
	            pessoas.add(u);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return pessoas;
	}

	public boolean update(Pessoa pessoa) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			Scanner sc = new Scanner(System.in);
			
			System.out.println("\n\n==== Atualizar pessoa === ");
			System.out.print("\nDigite o id da pessoa a ser alterada: ");
			int id = sc.nextInt();
			System.out.print("\nNovo nome: ");
			String nome = sc.next();
			System.out.print("\nNova idade: ");
			int idade = sc.nextInt();
			System.out.print("\nNovo sexo: ");
			char sexo = sc.next().charAt(0);
			String sql = "UPDATE pessoa SET nome = '" + nome + "', idade = '"  
				       + idade + "', sexo = '" + sexo + "'"
					   + " WHERE id = " + id;
			System.out.println(sql);
			st.executeUpdate(sql);
			sc.close();
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean delete(int id) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM pessoa WHERE id = " + id;
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public void deletarPessoa(PessoaDAO pessoaDAO) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n\n==== Deletar pessoa === ");
		System.out.println("\nDigite o id: ");
		int id = sc.nextInt();
		pessoaDAO.delete(id);
		
     	System.out.println("Deletado com sucesso -> id = " + id );
		
		sc.close();
	}


}
