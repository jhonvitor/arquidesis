package arqdesis_aula02b;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CursoDAO {

	public void incluir(CursoEntidadeTO to) {
		String sqlInsert = "INSERT INTO curso (curso, dataIni, dataFim, horaIni, horaFim, qtdVagas, livros, materiais, valor) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlInsert);) {
			st.setString(1, to.getCurso());
			st.setString(2, to.getDataIni());
			st.setString(3, to.getDataFim());
			st.setString(4, to.getHoraIni());
			st.setString(5, to.getHoraFim());
			st.setInt(6, to.getQtdVagas());
			st.setString(7, to.getLivros());
			st.setString(8, to.getMateriais());
			st.setDouble(9, to.getValor());
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(CursoEntidadeTO to) {
		String sqlUpdate = "UPDATE curso SET curso= ?, dataIni= ?, dataFim= ?, horaIni= ?, horaFim= ?, qtdVagas= ?, livros= ?, materiais= ?, valor= ? WHERE codigoCurso = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlUpdate);) {
			st.setString(1, to.getCurso());
			st.setString(2, to.getDataIni());
			st.setString(3, to.getDataFim());
			st.setString(4, to.getHoraIni());
			st.setString(5, to.getHoraFim());
			st.setInt(6, to.getQtdVagas());
			st.setString(7, to.getLivros());
			st.setString(8, to.getMateriais());
			st.setDouble(9, to.getValor());
			st.setInt(10, to.getCodCurso());
			st.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(CursoEntidadeTO to) {
		String sqlDelete = "DELETE FROM curso WHERE codigoCurso LIKE ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlDelete);) {
			st.setInt(1, to.getCodCurso());
			st.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public CursoEntidadeTO carregar(int cod) {
		CursoEntidadeTO to = new CursoEntidadeTO();
		String sqlSelect = "SELECT * FROM curso WHERE codigoCurso = ?";
		System.out.print(cod);
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlSelect);) {
			st.setInt(1, cod);
			System.out.print(st);
			try (ResultSet rs = st.executeQuery();) {
				if (rs.next()) {
					to.setCodCurso(rs.getInt("codigoCurso"));
					System.out.print(to.getCodCurso());
					to.setCurso(rs.getString("curso"));
					to.setDataIni(rs.getString("dataIni"));
					to.setDataFim(rs.getString("dataFim"));
					to.setHoraIni(rs.getString("horaIni"));
					to.setHoraFim(rs.getString("horaFim"));
					to.setQtdVagas(rs.getInt("qtdVagas"));
					to.setLivros(rs.getString("livros"));
					to.setMateriais(rs.getString("materiais"));
					to.setValor(rs.getDouble("valor"));
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
