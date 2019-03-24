import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.*;
public class oraclejdbc {

	public static void main(String[] argv) throws SQLException, FileNotFoundException, IOException {

		System.out.println("-------- Oracle JDBC Connection Testing ------");

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return;

		}

		System.out.println("Oracle JDBC Driver Registered!");

		Connection connection = null;

		try {

			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", "hr",
					"orcl");

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;

		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
                Statement stmt=connection.createStatement();
                q1(stmt,connection);
                q2(stmt,connection);
                q3(stmt,connection);
                q4(stmt,connection);
                q5(stmt,connection);
                q6(stmt,connection);
                stmt.close();
                connection.close();
	}
        
        static void q1(Statement stmt,Connection conn)throws SQLException
        {
            Scanner sc=new Scanner(System.in);
		 System.out.println("Enter Employee id");
            int x=sc.nextInt();
            PreparedStatement getMinSalary = conn.prepareStatement("SELECT Salary FROM Employees WHERE Employee_id=?");
            getMinSalary.setInt(1,x);
            getMinSalary.execute();
            ResultSet rs=getMinSalary.getResultSet();
            int val=0;
            while(rs.next())
            {
                val=rs.getInt("Salary");
            }
            System.out.println("The salary is: "+val);
            String str="SELECT * FROM Jobs WHERE Min_salary<?";
            PreparedStatement ps=conn.prepareStatement(str);
            ps.setInt(1, val);
            ps.execute();
            rs=ps.getResultSet();
            while(rs.next())
            {
                System.out.println("Job id: "+rs.getString("Job_id")+",Job name: "+rs.getString("Job_title")+",Min Salary:"+rs.getString("Min_salary"));
            }
        }
        static void q2(Statement stmt,Connection conn)throws SQLException
        {
            Scanner sc=new Scanner(System.in);
		 System.out.println("Enter Employee id");
            int id=sc.nextInt();
            CallableStatement cStmt = conn.prepareCall("{call Q2JDBC(?,?,?)}");
            cStmt.setInt(1, id);
            cStmt.registerOutParameter(2, Types.INTEGER);
            cStmt.registerOutParameter(3, Types.NVARCHAR);
            if(cStmt.execute())
            {
                ResultSet rs=cStmt.getResultSet();
                                while(rs.next())
                {
                    System.out.println("Manager id: "+cStmt.getInt(2)+"Department name: "+cStmt.getString(3));
                }
            }
            
        }
        static void q3(Statement stmt,Connection conn)throws SQLException
        {
            Scanner sc=new Scanner(System.in);
            int dept=sc.nextInt();
            System.out.println("Enter department id");
            String str="SELECT Employee_id FROM Employees WHERE Department_id=?";
            PreparedStatement ps=conn.prepareStatement(str);
            ps.setInt(1, dept);
            ps.execute();
            ResultSet rs=ps.getResultSet();
            HashSet<Integer> hs=new HashSet<>();
            while(rs.next())
            {
                //System.out.println("A:"+rs.getInt("Employee_id"));
                hs.add(rs.getInt("Employee_id"));
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println("Enter year,month,day");
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, year);
            cal.set(Calendar.MONTH, month - 1); // <-- months start at 0.
            cal.set(Calendar.DAY_OF_MONTH, day);
            java.sql.Date date = new java.sql.Date(cal.getTimeInMillis());
            str="SELECT * FROM Employees WHERE Hire_date<?";
            ps=conn.prepareStatement(str);
            ps.setDate(1, (java.sql.Date) date);
            ps.execute();
            rs=ps.getResultSet();
            while(rs.next())
            {
                int id=rs.getInt("Manager_id");
                //System.out.println("B:"+rs.getInt("Manager_id"));
                if(hs.contains(id))
                {
                    str="SELECT Job_title FROM Jobs WHERE Job_id=?";
                    ps=conn.prepareStatement(str);
                    ps.setString(1,rs.getString("Job_id"));
                    ps.execute();
                    ResultSet r=ps.getResultSet();
                    while(r.next())
                    {
                        System.out.println("Employee name is: "+rs.getString("First_name")+" "+rs.getString("Last_name")+" , Job title is: "+r.getString("Job_title"));
                    }
                }
            }
        }
        static void q4(Statement stmt,Connection conn)throws SQLException
        {
            System.out.println("Enter employee id");
            String str="UPDATE Employees SET Salary=Salary*1.05 WHERE Employee_id=?";
            String str2="UPDATE Employees SET Job_id=? WHERE Employee_id=?";   
            Scanner sc=new Scanner(System.in);
            int eid=sc.nextInt();
            System.out.println("Enter new job id");
            String jid=sc.next();
            PreparedStatement ps=conn.prepareStatement(str);
            ps.setInt(1, eid);
            ps.execute();
            ps=conn.prepareStatement(str2);
            ps.setString(1,jid);
            ps.setInt(2,eid);
            ps.execute();
        }
        static void q5(Statement stmt,Connection conn)throws SQLException, FileNotFoundException, IOException
        {
            FileWriter fw=new FileWriter("C://Users/Lenovo/Desktop/Report.txt");  
            String str="SELECT Department_id, Department_name FROM Departments";
            ResultSet rs=stmt.executeQuery(str);
            while(rs.next())
            {
                int tot=0;
                str="SELECT SUM(Salary) FROM Employees WHERE Department_id=?";
                PreparedStatement ps=conn.prepareStatement(str);
                ps.setInt(1, rs.getInt("department_id"));
                ps.execute();
                ResultSet r=ps.getResultSet();
                while(r.next())
                {
                    tot=r.getInt(1);
                }
                 
                if(tot>100000)
                {
                    fw.write("Department id: "+rs.getInt(1)+" , Department name: "+rs.getString(2)+" , Total Cost: "+tot);
                    fw.write(System.lineSeparator());
                }
            }
            fw.close();
        }
        static void q6(Statement stmt,Connection conn)throws SQLException, FileNotFoundException, IOException
        {
            FileWriter fw=new FileWriter("C://Users/Lenovo/Desktop/Report.txt");  
            fw.write("Department name            Manager name       Employee name             Salary");
            fw.write(System.lineSeparator());
            String str="SELECT * FROM Departments";
            ResultSet rs=stmt.executeQuery(str);
            while(rs.next())
            {
                int tot=0;
                PreparedStatement ps=null;
                if(rs.getString(3)!=null)
                {
                    str="SELECT First_name, Last_name FROM Employees WHERE Employee_id=?";
                    ps=conn.prepareStatement(str);
                    ps.setInt(1,rs.getInt(3));
                    ps.execute();
                    ResultSet rr=ps.getResultSet();
                    String name="";
                    while(rr.next())
                    {
                        name=rr.getString(1)+" "+rr.getString(2);
                    }
                    fw.write(rs.getString(2)+"                "+name+"        ");
                }
                else
                     fw.write(rs.getString(2)+"                "+"No manager        ");
                str="SELECT * FROM Employees WHERE Department_id=?";
                ps=conn.prepareStatement(str);
                ps.setInt(1, rs.getInt("department_id"));
                ps.execute();
                ResultSet r=ps.getResultSet();
                while(r.next())
                {
                   if(tot==0)
                        fw.write(r.getString(2)+" "+r.getString(3)+"        "+r.getInt("Salary"));
                   else
                       fw.write("                              "+r.getString(2)+" "+r.getString(3)+"        "+r.getInt("Salary"));
                   fw.write(System.lineSeparator());
                   tot+=r.getInt("Salary");
                }
                fw.write("Total Salary: "+tot);
                fw.write(System.lineSeparator());
            }
            fw.close();
        }
}
