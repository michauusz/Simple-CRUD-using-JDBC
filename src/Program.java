import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


class Program {
    String firstName, lastName;
    int id, salary, varClose = 0;

    void run() throws SQLException, InterruptedException {

        Connection con = JDBCServices.connect();
        Statement stmt = con.createStatement();
        JDBCServices.printDataBaseMetaData(con);
        JDBCServices.printTable(stmt);
        while (varClose == 0) {
            System.out.println("1-add 2-edit 3-delete");
            int choose = DataGetter.getInt();
            if (choose > 4 || choose < 1) {
                while (choose > 4 || choose < 1) {
                    choose = DataGetter.getInt();
                    System.out.println("Entered variable: " + choose + " is too big or less than 0");
                }
            }
            switch (choose) {
                case 1:
                    System.out.println("Enter first name: ");
                    firstName = DataGetter.getString();
                    System.out.println("Enter last name: ");
                    lastName = DataGetter.getString();
                    System.out.println("Enter salary: ");
                    salary = DataGetter.getInt();
                    System.out.println("Enter id(in future random): ");
                    id = DataGetter.getInt();
                    JDBCServices.insert("employes", firstName, lastName, salary, id, stmt);
                    JDBCServices.printTable(stmt);
                    break;
                case 2:
                    System.out.println("Enter first name: ");
                    firstName = DataGetter.getString();
                    System.out.println("Enter last name: ");
                    lastName = DataGetter.getString();
                    System.out.println("Enter salary: ");
                    salary = DataGetter.getInt();
                    System.out.println("Enter id: ");
                    id = DataGetter.getInt();
                    JDBCServices.edit("employes", firstName, lastName, salary, id, stmt);
                    JDBCServices.printTable(stmt);
                    break;
                case 3:
                    System.out.println("Enter id: ");
                    id = DataGetter.getInt();
                    JDBCServices.delete("employes", id, stmt);
                    JDBCServices.printTable(stmt);
                    break;
                case 4:
                    varClose = 1;
                    con.close();
                    System.out.println("Connection closed...");

            }


        }
    }
}
