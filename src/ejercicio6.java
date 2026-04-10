import java.sql.*;


public class ejercicio6 {
    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String usuario = "RIBERA";
        String contraseña = "ribera";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {

            String sql = "DELETE FROM EMPLEADO WHERE id = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, 2);
            //INTRODUCIMOS EL ID DEL EMPLEADO A ELIMINAR
            int filasActualizadas = ps.executeUpdate();

            System.out.println("Empleados eliminados: " + filasActualizadas);
        } catch (SQLException e) {
            System.out.println("Error al conectar   " + e.getMessage());
        }

    }
}
