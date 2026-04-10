import java.sql.*;

public class ejercicio11 {
    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String usuario = "RIBERA";
        String contraseña = "ribera";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {

            String sql = "SELECT * FROM EMPLEADO ORDER BY salario DESC";
            PreparedStatement ps = conexion.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String nombre=rs.getString("nombre");
                Double salario=rs.getDouble("salario");
                    //SE GUARDAN LAS VARIABLES SALIDAS DEL SQL PARA USARLAS EN EL PRINT
                System.out.println(nombre + " - " + salario);
            }

        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}