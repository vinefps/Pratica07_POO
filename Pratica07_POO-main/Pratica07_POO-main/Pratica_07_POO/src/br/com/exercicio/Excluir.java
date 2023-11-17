package br.com.exercicio;

import java.sql.*;

public class Excluir {
    private final String url = "jdbc:postgresql://localhost/BDlivrariaUniversitaria";
    private final String user = "postgres";
    private final String password = "123456";

    private static final String DELETE_USERS_SQL = "delete from livro where id_isbn = ?;";
    public Excluir (String cod_excluir)
            throws SQLException {
        System.out.println(DELETE_USERS_SQL);
// Step 1: Estabelecendo a conexão
        try (Connection connection = DriverManager.getConnection(url, user, password);

//Step 2: Criar link de conexão
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL))
        {
            preparedStatement.setString(1, cod_excluir);

            System.out.println(preparedStatement);

// Step 3: Executar ou atualizar o query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
// print SQL exception information
            printSQLException(e);
        }

// Step 4: try-with-resource statement will auto close the connection.
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
