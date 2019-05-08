package util;

import java.sql.*;

public class Koneksi {

    private Connection connection;
    private Statement statement;

    public Koneksi() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mariadb://localhost/phb",
                "root",
                "rahasia"
        );
        statement = connection.createStatement();
        String query = "select * from mahasiswa";
        ResultSet result = statement.executeQuery(query);
        while(result.next()) {
            System.out.println("NIM : " + result.getString(1));
            System.out.println("NAMA : " + result.getString(2));
            System.out.println("KELAS : " + result.getString(3));
        }
    }

}