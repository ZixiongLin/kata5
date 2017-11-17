
package kata5.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Kata5 {


    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
        
        Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\ALE\\Documents\\NetBeansProjectsm\\Kata5P1\\KATA5.DB");	
        
        Statement st= con.createStatement();
        
        String query = "SELECT * FROM PEOPLE";
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            System.out.println(rs.getInt(1));
            System.out.println(rs.getString(2));
        }
        String query2 ="CREATE TABLE IF NOT EXISTS MAIL ('Id' INTEGER PRIMARY KEY AUTOINCREMENT, Mail TEXT	NOT NULL);";
        st.execute(query2);
        
        
        
    }
}
