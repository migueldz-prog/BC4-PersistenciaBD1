import java.sql.*;

public class ejercicio16 {
    public static void main(String[] args) {

        String url ="jdbc:oracle:thin:@localhost:1521:xe";
        String usuario = "RIBERA";
        String contraseña = "ribera";

        try(Connection conn = DriverManager.getConnection(url, usuario, contraseña);
            Statement statement = conn.createStatement();){

            int idDep = 2; //ID DEL DEPARTAMENTO QUE QUEREMOS MOSTRAR LOS NOMBRES

            String sql = "SELECT nombre FROM empleado WHERE departamento_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idDep);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String nombre=rs.getString("nombre");

                System.out.println(nombre);
            }


        }catch(SQLException e ){
            System.out.println("Error al conectar" + e.getMessage());
        }

    }
}