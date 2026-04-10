import java.sql.*;


public class ejercicio8 {
    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String usuario = "RIBERA";
        String contraseña = "ribera";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            String l = "a";  //AQUI ELEGIMOS LA LETRA QUE QUEREMOS QUE BUSQUE EN LOS NOMBRES

            String sql = "SELECT * FROM EMPLEADO WHERE nombre LIKE ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, "%" + l + "%");
                //AQUI CON LA ? METEMOS LA VARIABLE L DE LA LETRA EN LA SECUENCIA SQL
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String nombre=rs.getString("nombre");

                System.out.println(nombre);
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar   " + e.getMessage());
        }

    }
}
