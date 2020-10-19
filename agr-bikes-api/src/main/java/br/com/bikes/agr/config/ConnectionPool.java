package br.com.bikes.agr.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionPool {

	protected static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/agrbikes", "root", "mysql5.7");
	}
	
	protected ResultSet getResultSet(String sql) {
        return getResultSet(sql, null, null, null, null, null, null);
    }  
	
    protected ResultSet getResultSet(String sql, String p1) {
        return getResultSet(sql, p1, null, null, null, null, null);
    }  
    
    protected ResultSet getResultSet(String sql, String p1, String p2) {
        return getResultSet(sql, p1, p2, null, null, null, null);
    }  
    
    protected ResultSet getResultSet(String sql, String p1, String p2, String p3) {
        return getResultSet(sql, p1, p2, p3, null, null, null);
    }
    
    protected ResultSet getResultSet(String sql, String p1, String p2, String p3, String p4) {
        return getResultSet(sql, p1, p2, p3, p4, null, null);
    }
    
    protected ResultSet getResultSet(String sql, String p1, String p2, String p3, String p4, String p5) {
        return getResultSet(sql, p1, p2, p3, p4, p5, null);
    }  
    
    protected ResultSet getResultSet(String sql, String p1, String p2, String p3, String p4, String p5, String p6) {
        try {            
            PreparedStatement pstm = getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            if (p1 != null && !"".equals(p1)) {                
                pstm.setString(1, p1);
            }
            if (p2 != null && !"".equals(p2)) {                
                pstm.setString(2, p2);
            }
            if (p3 != null && !"".equals(p3)) {                
                pstm.setString(3, p3);
            }
            if (p4 != null && !"".equals(p4)) {                
                pstm.setString(4, p4);
            }
            if (p5 != null && !"".equals(p5)) {                
                pstm.setString(5, p5);
            }
            if (p6 != null && !"".equals(p6)) {                
                pstm.setString(6, p6);
            }            
            return pstm.executeQuery();
        }
        catch (SQLException sqle) {
            System.out.println("Erro SQL: "+sqle.getMessage()+" com a string: "+sql);
            return null;
        }
        catch (Exception ex){
            System.out.println("Erro SQL: "+ex.getMessage()+" com a string: "+sql);
            return null;
        }
    }
	
}
