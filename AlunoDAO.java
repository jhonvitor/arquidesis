package arqdesis_aula02b;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlunoDAO {

	public void incluir(AlunoEntidadeTO to) {
		String sqlInsert = "INSERT INTO aluno (nomeAlu, endereco, numero, complemento, dataNasc, email, telRes, telCel, rg, cpf) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlInsert);) {
			st.setString(1, to.getNome());
			st.setString(2, to.getEnd());
			st.setString(3, to.getNum());
			st.setString(4, to.getComp());
			st.setString(5, to.getDataNasc());
			st.setString(6, to.getEmail());
			st.setString(7, to.getTelRes());
			st.setString(8, to.getTelCel());
			st.setString(9, to.getRg());
			st.setString(10, to.getCpf());
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(AlunoEntidadeTO to) {
		String sqlUpdate = "UPDATE aluno SET nomeAlu = ?, endereco = ?, numero = ?, complemento = ?, dataNasc = ?, email = ?, telRes = ?, telCel = ?, rg = ?, cpf = ? WHERE cpf = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlUpdate);) {
			st.setString(1, to.getNome());
			st.setString(2, to.getEnd());
			st.setString(3, to.getNum());
			st.setString(4, to.getComp());
			st.setString(5, to.getDataNasc());
			st.setString(6, to.getEmail());
			st.setString(7, to.getTelRes());
			st.setString(8, to.getTelCel());
			st.setString(9, to.getRg());
			st.setString(10, to.getCpf());
			st.setString(11, to.getCpf());
			st.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(AlunoEntidadeTO to) {
		String sqlDelete = "DELETE FROM aluno WHERE cpf LIKE ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlDelete);) {
			st.setString(1, to.getCpf());
			st.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public AlunoEntidadeTO carregar(String cpf) {
		AlunoEntidadeTO to = new AlunoEntidadeTO();
		String sqlSelect = "SELECT * FROM aluno WHERE cpf LIKE ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlSelect);) {
			st.setString(1, cpf);
			try (ResultSet rs = st.executeQuery();) {
				if (rs.next()) {
					to.setCod(rs.getInt("codAlu"));
					to.setNome(rs.getString("nomeAlu"));
					to.setEnd(rs.getString("endereco"));
					to.setNum(rs.getString("numero"));
					to.setComp(rs.getString("complemento"));
					to.setDataNasc(rs.getString("dataNasc"));
					to.setEmail(rs.getString("email"));
					to.setTelRes(rs.getString("telRes"));
					to.setTelCel(rs.getString("telCel"));
					to.setRg(rs.getString("rg"));
					to.setCpf(rs.getString("cpf"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
	}
}
