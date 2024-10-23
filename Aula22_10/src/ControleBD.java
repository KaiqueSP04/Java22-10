import java.sql.*;

public class ControleBD {
	
	Connection cg = null;

	public Aluno select(Aluno a1) {

		// Pegar dados do aluno do BD a partir do Id
		long id = a1.getId();

		String k = "SELECT * FROM aluno WHERE id = " + id + ";";
		this.pegaConexao(); //colocanco a conexão no atributo cg
		ResultSet rs = this.pegaResultSet(k);
		// Preenchendo com valores pegos do ResultSet.
		try {
			//rs.next();
			rs.next();
			a1.setNome(rs.getString("nome"));
			a1.setRa(rs.getString("ra"));
			a1.setIdade(rs.getInt("idade"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// retornando o Aluno totalmente preenchido
		return a1;

	}

	public void delete(Aluno a1) {

		// Pegar dados do aluno do BD a partir do Id
		long id = a1.getId();
		String k = "DELETE FROM aluno WHERE id = " + id + ";";
		this.pegaConexao(); //colocanco a conexão no atributo cg
		this.alteraBD(k);
	}

	public void update(Aluno a1) {

		// Pegar dados do aluno do BD a partir do Id
		long id = a1.getId();
		String nome = a1.getNome();
		String ra = a1.getRa();
		int idade = a1.getIdade();
		String k = "UPDATE Aluno SET nome = " + nome + "," +
				" ra = " + ra + "," +
				" idade = " + idade +
				" WHERE id = " + id + ";";
		this.pegaConexao(); //colocanco a conexão no atributo cg
		this.alteraBD(k);
	}
	
	
	public void pegaConexao() {

		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/alpoo";
		url += "?useTimezone=true&serverTimezone=UTC";

		String login = "root";
		String senha = "unip";
		// ......................................................
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cg = null;
		try {
			cg = DriverManager.getConnection(url, login, senha);
			//System.out.println("Conexão Ralizada");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro de Conexão");
			e.printStackTrace();
		}

	}

	public ResultSet pegaResultSet(String query) {

		ResultSet rs = null;
		PreparedStatement stmt = null;
		try {
			stmt = cg.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;

	}

	public void alteraBD(String query) {

		PreparedStatement stmt = null;
		try {
			stmt = cg.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
}
