import java.sql.*;

public class ejercicio9 {
    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String usuario = "RIBERA";
        String contraseña = "ribera";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {

            String sql = "SELECT AVG(salario) AS mediaSalario FROM EMPLEADO";
            PreparedStatement ps = conexion.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Double mediaSalario=rs.getDouble("mediaSalario");
                //CON EL NOMBRE QUE LE HEMOS DADO A LA MEDIA LO METEMOS EN UNA VARIABLE PARA USARLO EN EL PRINT
                System.out.println("Salario medio: " + mediaSalario);
            }

        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}