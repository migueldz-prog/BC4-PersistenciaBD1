import java.sql.*;
import java.util.Scanner;

public class ejercicio7 {
    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String usuario = "RIBERA";
        String contraseña = "ribera";

        Scanner sc = new Scanner(System.in);
        int opcion;

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {

      //CON UN switch-case HACEMOS EL MENU CRUD, PONIENDO LA SENTENCIA SQL EN CADA CASE Y SUS VARIABLES
            do {
                System.out.println("menu CRUD");
                System.out.println("1. Mostrar empleados");
                System.out.println("2. Insertar empleado");
                System.out.println("3. Actualizar salario");
                System.out.println("4. Eliminar empleado");
                System.out.println("0. Salir");
                System.out.print("Elige una opcion: ");
                opcion = sc.nextInt();

                switch (opcion) {

                    case 1:
                        String sql = "SELECT * FROM EMPLEADO";
                        Statement st = conexion.createStatement();
                        ResultSet rs = st.executeQuery(sql);

                        while (rs.next()) {
                            int id=rs.getInt("id");
                            String nombre=rs.getString("nombre");
                            double salario=rs.getDouble("salario");
                                //RELLENAMOS LAS VARIABLES PARA USARLAS EN EL PRINT

                            System.out.println("ID: " + id + " Nombre: " + nombre+ " Salario: " + salario);
                        }
                        break;

                    case 2:
                        System.out.print("ID: ");
                        int ID = sc.nextInt();      //PIDO LOS DATOS DEL NUEVO EMPLEADO

                        System.out.print("Nombre: ");
                        sc.nextLine();
                        String nombre = sc.nextLine();

                        System.out.print("Salario: ");
                        double salario = sc.nextDouble();

                        String sqlI = "INSERT INTO EMPLEADO (ID,nombre, salario) VALUES (?, ?,?)";
                        PreparedStatement psInsert = conexion.prepareStatement(sqlI);
                        psInsert.setString(2, nombre);
                        psInsert.setDouble(3, salario);
                        psInsert.setInt(1, ID);


                        int filasInsertadas = psInsert.executeUpdate();
                        System.out.println("Filas insertadas: " + filasInsertadas);
                        break;

                    case 3:
                        System.out.print("ID del empleado: ");
                        int idActu = sc.nextInt();
                        System.out.print("Nuevo salario: ");
                        double nuevoSalario = sc.nextDouble();
                                //PIDO EL ID Y EL NUEVO SALARIO PARA HACER EL UPDATE CON LA SQL

                        String sqlU = "UPDATE EMPLEADO SET salario = ? WHERE id = ?";
                        PreparedStatement psUpdate = conexion.prepareStatement(sqlU);
                        psUpdate.setDouble(1, nuevoSalario);
                        psUpdate.setInt(2, idActu);

                        int filasActualizadas = psUpdate.executeUpdate();
                        System.out.println("Filas actualizadas: " + filasActualizadas);
                        break;


                    case 4:
                        System.out.print("ID del empleado a eliminar: ");
                        int idE = sc.nextInt();

                        String sqlD = "DELETE FROM EMPLEADO WHERE id = ?";
                        PreparedStatement psDelete = conexion.prepareStatement(sqlD);
                        psDelete.setInt(1, idE);

                        int filasEliminadas = psDelete.executeUpdate();
                        System.out.println("Filas eliminadas: " + filasEliminadas);
                        break;

                    case 0:
                        System.out.println("Saliendo");
                        break;

                    default:
                        System.out.println("Opcion no valida");
                }

            } while (opcion != 0);

        } catch (SQLException e) {
            System.out.println("Error al conectar " + e.getMessage());
        }

        sc.close();
    }
}