package mainPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    private final String userName = "root";
    private final String password = "12345";

    private final String dbURL = "jdbc:mysql://localhost:3306";

    public Connection getConnection() throws SQLException, ClassNotFoundException,
            InstantiationException, IllegalAccessException {
        //Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(dbURL, userName, password);
    }

    public void showErrorMessage(SQLException exception){
        System.out.println("Error: "+exception.getMessage());
    }

    public void showErrorMessage(ClassNotFoundException exception){
        System.out.println("Error: "+exception.getMessage());
    }

    public void showErrorMessage(InstantiationException exception){
        System.out.println("Error: "+exception.getMessage());
    }

    public void showErrorMessage(IllegalAccessException exception){
        System.out.println("Error: "+exception.getMessage());
    }

}


