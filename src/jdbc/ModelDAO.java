package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelDAO {
	private Connection con;
	
	public int incluir(String sql, Object... atributos) {
		
		try {
			PreparedStatement stmt = getCon().prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
			addAtributos(stmt,atributos);
			
			if(stmt.executeUpdate() > 0) {
				ResultSet res = stmt.getGeneratedKeys();
				if (res.next()) return res.getInt(1);
			}
			return -1;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void close() {
		try {
			getCon().close();
		} catch (SQLException e) {
			
		} finally {
			con=null;
		}
	}
	private void addAtributos(PreparedStatement stmt, Object[] atributos) throws SQLException{
		int indice = 1;
		for(Object atributo: atributos) {
			if(atributo instanceof String) {
				stmt.setString(indice,(String)atributo);
			}else if(atributo instanceof Integer) {
				stmt.setInt(indice,(Integer)atributo);
			}else if(atributo instanceof Double) {
				stmt.setDouble(indice,(Double)atributo);
			}else if(atributo instanceof Date) {
				stmt.setDate(indice,(Date)atributo);
			}else if(atributo instanceof Boolean) {
				stmt.setBoolean(indice,(Boolean)atributo);
			}
			indice++;
		}
	}
	
	private Connection getCon() {
		try {
			if(con != null && !con.isClosed()) return con;
		} catch (Exception e) {
			
		}
		con = FactoryConection.getConection();
		return con;
	}
}
