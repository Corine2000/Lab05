package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagramDAO {
	
	public AnagramDAO() {
		
	}
	
	public boolean isCorrect(String parola) {
		String sql="SELECT * "
				+ "FROM parola "
				+ "WHERE nome=? ";
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, parola);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				
				st.close();
				conn.close();
				
				return true;
			}else {
				st.close();
				conn.close();
				return false;
			}
			
		}catch(SQLException e) {
			throw new RuntimeException("errore nel dataBase");
		}
		
	}

}
