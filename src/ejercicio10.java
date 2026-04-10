import java.sql.*;

public class ejercicio10 {
    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String usuario = "RIBERA";
        String contraseña = "ribera";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {

            conexion.setAutoCommit(false);  //QUITAMOS EL AUTOCOMMIT PARA PODER HACER EL ROLLBACK

            try {
                String sql = "INSERT INTO EMPLEADO (nombre, salario,id) VALUES (?, ?, ?)";
                PreparedStatement ps = conexion.prepareStatement(sql);

                ps.setString(1, "Juan");
                ps.setDouble(2, 2000);
                ps.setInt(3, 20);

                ps.executeUpdate();

                ps.setString(1, "Ana");
                ps.setDouble(2, 2500);
                ps.setInt(3, 21);

                ps.executeUpdate();

                conexion.commit();
                System.out.println("Transacción realizada");

            } catch (SQLException e) {
                conexion.rollback();
                System.out.println("Error, rollback");
            }

        } catch (SQLException e) {
            System.out.println("Error conexión " + e.getMessage());
        }
    }
}