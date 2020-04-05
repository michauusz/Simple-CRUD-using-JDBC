import java.sql.*;
import java.sql.Statement;

class JDBCServices {

    static Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employes?serverTimezone=UTC", "root", "NalesnikiQwerty");
            System.out.println(con);
            return con;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    static void printTable(Statement stmt) throws SQLException {
        ResultSet rs = stmt.executeQuery("select firstName, lastName, salary, employeID from employes");
        while (rs.next()) {
            System.out.print(" id: " + rs.getInt("employeID"));
            System.out.print(" first name: " + rs.getString("firstName"));
            System.out.print(" last name: " + rs.getString("lastName"));
            System.out.println(" salary: " + rs.getString("salary"));
        }
    }

    static void insert(String table, String fName, String lName, int salary, int id, Statement stmt) throws SQLException {


        String sql = "insert into " + table + " Values ('" + fName + "', '" + lName + "', " + salary + ", " + id + ");";
        int result = stmt.executeUpdate(sql);
        System.out.println(result + " records affected");
    }

    static void delete(String table, int id, Statement stmt) throws SQLException {
        String sql = "delete from " + table + " where employeID=" + id + ";";
        int result = stmt.executeUpdate(sql);
        System.out.println(result + " records affected");
    }

    static void edit(String table, String fName, String lName, int salary, int id, Statement stmt) throws SQLException {
        String sql = "update " + table + " set firstName = '" + fName + "',lastName = '" + lName + "', salary = " + salary + " where employeID = " + id + ";";
        int result = stmt.executeUpdate(sql);
        System.out.println(result + " records affected");
    }
    static void printDataBaseMetaData(Connection con) throws SQLException {
        DatabaseMetaData dbmd = con.getMetaData();
        System.out.println("Driver Name: "+dbmd.getDriverName());
        System.out.println("Driver Version: "+dbmd.getDriverVersion());
        System.out.println("UserName: "+dbmd.getUserName());
        System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());
        System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());
    }
}
