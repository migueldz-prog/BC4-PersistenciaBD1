import java.sql.*;

public class ejercicio15 {
    public static void main(String[] args) {

        String url ="jdbc:oracle:thin:@localhost:1521:xe";
        String usuario = "RIBERA";
        String contraseña = "ribera";

        try(Connection conn = DriverManager.getConnection(url, usuario, contraseña);
            Statement statement = conn.createStatement();){

            String sql = "SELECT E.NOMBRE, D.NOMBRE as departamento FROM EMPLEADO e " +
                    "JOIN DEPARTAMENTO d ON E.DEPARTAMENTO_ID = D.ID";
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){

                String nombre=rs.getString("nombre");
                String departamento=rs.getString("departamento");

                System.out.println("Nombre: " + nombre + " Departemento: " + departamento );

            }

            //CON EL SQL CONSEGUIMOS LOS NOMBRES Y LOS GUARDAMOS EN LAS VARIABLES
            //PARA CON EL WHILE SACAR A LOS EMPLEADOS Y SUS DEPARTAMENTOS

        }catch(SQLException e ){
            System.out.println("Error al conectar" + e.getMessage());
        }

    }
}