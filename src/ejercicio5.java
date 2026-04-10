import java.sql.*;


public class ejercicio5 {
    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String usuario = "RIBERA";
        String contraseña = "ribera";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {

            String sql = "UPDATE EMPLEADO SET salario = ? WHERE id = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setDouble(1, 123);
            ps.setInt(2, 2);
            // PRIMERO INDICAMOS EL SALARIO Y DESPUES EL ID, EN EL ORDEN DE LAS ? PUESTAS
            int filasActualizadas = ps.executeUpdate();

            System.out.println("Salario y filas actilizadas: " + filasActualizadas);
        } catch (SQLException e) {
            System.out.println("Error al conectar   " + e.getMessage());
        }

    }
}
