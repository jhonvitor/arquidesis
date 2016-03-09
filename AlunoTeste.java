package arqdesis_aula02b;

import javax.swing.JOptionPane;


public class AlunoTeste {
	public static void main(String[] args) {
		AlunoEntidade ae = new AlunoEntidade(0, "Carlos", "Rua Qualquer", "109",
				"casa 1", "23/10/1980", "carlos@gmail.com", "11111111",
				"9655344255", "122113848", "09170825751");
		
		//Cria objeto AlunoEntidadeTO e manda para o DAO incluir no Banco
		ae.criar();
		
		//Realiza uma busca de aluno por CPF, o DAO instancia AlunoEntidadeTO, retorna para AlunoEntidade e faz o espelhamento 
		ae.carregar();
		//System.out.println(ae);
		JOptionPane.showMessageDialog(null, "Codigo = " + ae.getCod() + "\nNome = " + ae.getNome() + "\nCPF = " + ae.getCpf() + "\nTelefone = " + ae.getTelRes());
		
		//Altera o telefone em AlunoEntidade
		ae.setTelRes("22222222");
		
		//Realiza um UPDATE no banco, alterando o numero telefonico
		ae.atualizar();
		JOptionPane.showMessageDialog(null, "Codigo = " + ae.getCod() + "\nNome = " + ae.getNome() + "\nCPF = " + ae.getCpf() + "\nTelefone = " + ae.getTelRes());
		
		
		ae.carregar();
		//System.out.println(ae);
		JOptionPane.showMessageDialog(null, "Codigo = " + ae.getCod() + "\nNome = " + ae.getNome() + "\nCPF = " + ae.getCpf() + "\nTelefone = " + ae.getTelRes());
		
		ae.excluir();
		JOptionPane.showMessageDialog(null, "excluido do banco");
		
		ae.carregar();
		JOptionPane.showMessageDialog(null, "Codigo = " + ae.getCod() + "\nNome = " + ae.getNome() + "\nCPF = " + ae.getCpf() + "\nTelefone = " + ae.getTelRes());
		
		
		
		
		
		CursoEntidade ce = new CursoEntidade(0, "Informatica", "6/3/16", "5/4/16", "08:00", "15:00", 30, "apostilas", "Notebook", 300.00);
		
		//Cria objeto CursoEntidadeTO e manda para o DAO incluir no Banco
		ce.criar();
		
		//Realiza uma busca do curso por ID, o DAO instancia CursoEntidadeTO, retorna para CursoEntidade e faz o espelhamento 
		ce.carregar(4);
		JOptionPane.showMessageDialog(null, "Codigo = " + ce.getCodCurso() + "\nCurso = " + ce.getCurso() + "\nMateriais = " + ce.getMateriais());
		
		//Altera o material em CursoEntidade
		ce.setMateriais("Caderno");
		
		//Realiza um UPDATE no banco, alterando o material
		ce.atualizar();
		JOptionPane.showMessageDialog(null, "Codigo = " + ce.getCodCurso() + "\nCurso = " + ce.getCurso() + "\nMateriais = " + ce.getMateriais());
		
		
		ce.carregar(4);
		//System.out.println(ae);
		JOptionPane.showMessageDialog(null, "Codigo = " + ce.getCodCurso() + "\nCurso = " + ce.getCurso() + "\nMateriais = " + ce.getMateriais());
		
		ce.excluir();
		JOptionPane.showMessageDialog(null, "excluido do banco");
		
		ce.carregar(4);
		JOptionPane.showMessageDialog(null, "Codigo = " + ce.getCodCurso() + "\nCurso = " + ce.getCurso() + "\nMateriais = " + ce.getMateriais());
	}
}
