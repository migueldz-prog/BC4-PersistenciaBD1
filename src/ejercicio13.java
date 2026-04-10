import java.sql.*;

public class ejercicio13 {
    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String usuario = "RIBERA";
        String contraseña = "ribera";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {

            Statement st = conexion.createStatement();

            String sql = "CREATE TABLE departamento (id NUMBER PRIMARY KEY, nombre VARCHAR2(50))";
            st.executeUpdate(sql);

            String emp = "CREATE TABLE empleado (id NUMBER PRIMARY KEY, nombre VARCHAR2(50), salario NUMBER, departamento_id NUMBER, " +
                        "FOREIGN KEY (departamento_id) REFERENCES departamento(id))";
                            //CREAMOS LA TABLA EMPLEADO SABIENDO QUE EL DEP_ID REFERENCIA EL ID DE LA TABLA DEPARTAMENTO
            st.executeUpdate(emp);

            System.out.println("Tablas creadas");

        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}