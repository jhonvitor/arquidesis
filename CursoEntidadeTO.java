package arqdesis_aula02b;


public class CursoEntidadeTO {

	private int codCurso;
	private String curso;
	private String dataIni;
	private String dataFim;
	private String horaIni;
	private String horaFim;
	private int qtdVagas;
	private String livros;
	private String materiais;
	private double valor;
	
	public CursoEntidadeTO(){
		this(0, "", "", "", "", "", 0, "", "", 0.0);
	}

	public CursoEntidadeTO(int codCurso, String curso, String dataIni,
			String dataFim, String horaIni, String horaFim, int qtdVagas,
			String livros, String materiais, double valor) {

		setCodCurso(codCurso);
		setCurso(curso);
		setDataIni(dataIni);
		setDataFim(dataFim);
		setHoraIni(horaIni);
		setHoraFim(horaFim);
		setQtdVagas(qtdVagas);
		setLivros(livros);
		setMateriais(materiais);
		setValor(valor);
	}

	public int getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getDataIni() {
		return dataIni;
	}

	public void setDataIni(String dataIni) {
		this.dataIni = dataIni;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	public String getHoraIni() {
		return horaIni;
	}

	public void setHoraIni(String horaIni) {
		this.horaIni = horaIni;
	}

	public String getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(String horaFim) {
		this.horaFim = horaFim;
	}

	public int getQtdVagas() {
		return qtdVagas;
	}

	public void setQtdVagas(int qtdVagas) {
		this.qtdVagas = qtdVagas;
	}

	public String getLivros() {
		return livros;
	}

	public void setLivros(String livros) {
		this.livros = livros;
	}

	public String getMateriais() {
		return materiais;
	}

	public void setMateriais(String materiais) {
		this.materiais = materiais;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
