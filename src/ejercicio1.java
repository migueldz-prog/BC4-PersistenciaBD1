import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ejercicio1 {
    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String usuario = "RIBERA";
        String password = "ribera";

        try(Connection conn = DriverManager.getConnection(url,usuario,password);){
            System.out.println("Conexion establecida con oracle.");

        }catch (SQLException e){

            System.out.println("Error al conectar con el servidor." + e.getMessage());
        }
    }
}