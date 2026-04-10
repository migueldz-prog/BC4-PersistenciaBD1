import java.sql.*;

public class ejercicio14 {
    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String usuario = "RIBERA";
        String contraseña = "ribera";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {

            String sqlDep = "INSERT INTO departamento VALUES (?, ?)";
            PreparedStatement psDep = conexion.prepareStatement(sqlDep);

            psDep.setInt(1, 1);
            psDep.setString(2, "Ventas");
            psDep.executeUpdate();

            psDep.setInt(1, 2);
            psDep.setString(2, "Marketing");
            psDep.executeUpdate();

            psDep.setInt(1, 3);
            psDep.setString(2, "Recursos");
            psDep.executeUpdate();

            String sqlEmp = "INSERT INTO empleado VALUES (?, ?, ?, ?)";
            PreparedStatement psEmp = conexion.prepareStatement(sqlEmp);

            psEmp.setInt(1, 1);
            psEmp.setString(2, "Luis");
            psEmp.setDouble(3, 1200);
            psEmp.setInt(4, 1);
            psEmp.executeUpdate();


            psEmp.setInt(1, 2);
            psEmp.setString(2, "Mariam");
            psEmp.setDouble(3, 3001);
            psEmp.setInt(4, 2);
            psEmp.executeUpdate();


            psEmp.setInt(1, 3);
            psEmp.setString(2, "Pablo");
            psEmp.setDouble(3, 300);
            psEmp.setInt(4, 3);
            psEmp.executeUpdate();

            System.out.println("Datos insertados"); //RELLENAMOS LAS TABLAS CON ESTOS DATOS

        } catch (SQLException e) {

            System.out.println("Error " + e.getMessage());
        }
    }
}