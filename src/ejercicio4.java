import java.sql.*;

public class ejercicio4 {
    public static void main(String[] args) {

        String url ="jdbc:oracle:thin:@localhost:1521:xe";
        String usuario = "RIBERA";
        String contraseña = "ribera";

        try(Connection conn = DriverManager.getConnection(url, usuario, contraseña)){
            String sql = "INSERT INTO EMPLEADO (id, nombre, salario) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 5);          //EL PRIMER NUMERO ES EL ORDEN DE LAS ? HACIENDO REF AL ORDEN DE LOS DATOS DE LA TABLA
            stmt.setString(2, "Olmar");
            stmt.setDouble(3, 500);
            stmt.executeUpdate();
            System.out.println("Insertado correctamente");




        }catch(SQLException e ){
            System.out.println("Error al conectar" + e.getMessage());
        }

    }
}