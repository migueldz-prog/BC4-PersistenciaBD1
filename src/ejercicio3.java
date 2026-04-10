import java.sql.*;

public class ejercicio3 {
    public static void main(String[] args) {

        String url ="jdbc:oracle:thin:@localhost:1521:xe";
        String usuario = "RIBERA";
        String contraseña = "ribera";

        try(Connection conn = DriverManager.getConnection(url, usuario, contraseña);
            Statement statement = conn.createStatement();){

            String sql = "SELECT * FROM EMPLEADO";
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){
                    //METEMOS TODOS LOS DATOS DE LOS EMPLEADOS DENTRO DE VARIABLES PARA SACARLOS EN EL PRINT
                int id=rs.getInt("id");
                String nombre=rs.getString("nombre");
                Double salario=rs.getDouble("salario");
                    System.out.println("ID: " + id + " Nombre: " + nombre + " Salario: " + salario);

            }



        }catch(SQLException e ){
            System.out.println("Error al conectar" + e.getMessage());
        }

    }
}