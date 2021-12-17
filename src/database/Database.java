package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database 
{

    private Connection con;
    private String classname = "com.mysql.cj.jdbc.Driver";
    private String driver = "jdbc:mysql://localhost:";
    private String port = "3306/";
    private String database = "flight_app";
    private String username = "root";
    private String password = "";

    //CONSTRUCTOR
    public Database(){
        try {
            Class.forName(classname);

            con = DriverManager.getConnection(driver+port+database,
                    username,password);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //GET THE CONNECTION
    public Connection getCon() 
    {
        return con;
    }
       
}

    

