
package kata5.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class Kata5 {


    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
        
        Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\ALE\\Documents\\NetBeansProjectsm\\Kata5P1\\KATA5.DB");	
        
        Statement st= con.createStatement();
        
        String query2 ="CREATE TABLE IF NOT EXISTS MAIL ('Id' INTEGER PRIMARY KEY AUTOINCREMENT, Mail TEXT	NOT NULL);";
        st.execute(query2);
        String fileName = "C:\\Users\\ALE\\Documents\\NetBeansProjectsm\\Kata5P1\\emailsfile.txt";
        try{
            BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
            String mail;
            while((mail = reader.readLine()) != null){
                if(!mail.contains("@")){
                    continue;
                }
                query2 = "INSERT INTO MAIL (Mail) VALUES ('"+mail+"');";	
                st.executeUpdate(query2);
              
            }
            System.out.println("Fin OK");



        }catch(FileNotFoundException ex){
            ex.printStackTrace( );
        }


        
    }
}
