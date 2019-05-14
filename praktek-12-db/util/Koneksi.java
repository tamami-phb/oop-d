package util;

import java.sql.*;

public class Koneksi {

    private Connection connection;
    private Statement statement;

    public Koneksi(){}

    public void openKoneksi() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mariadb://localhost/phb",
                "root",
                "rahasia"
        );
        statement = connection.createStatement();
    }

    // SELECT
    public ResultSet eksekusiQuery(String query) throws SQLException {
        openKoneksi();
        ResultSet result = statement.executeQuery(query);
        closeKoneksi();
        return result;
    }

    // INSERT, UPDATE, dan DELETE
    public int eksekusiUpdate(String query) throws SQLException {
        openKoneksi();
        int result = statement.executeUpdate(query);
        closeKoneksi();
        return result;
    }

    public void closeKoneksi() throws SQLException {
        connection.close();
    }

}