// This code is for establishing connection with MySQL
// database and retrieving data
// from db Java Database connectivity

/*
*1. import --->java.sql
*2. load and register the driver ---> com.jdbc.
*3. create connection
*4. create a statement
*5. execute the query
*6. process the results
*7. close
*/

import java.sql.*;

class JDBC_driver {
	public static void main(String[] args) throws Exception
	{
        Connection connection = null;
        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/idfc",
                "root", "root");
 
            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(
                "select * from idfc.employee where id>2");

           
            // statement.executeUpdate(
            //     "CREATE TABLE idfc.LOCATION"+"(loc_id INTEGER NOT NULL,"+"loc_name varchar(20),"+"id int,"+"primary key(id),"+"foreign key(id) references idfc.employee(id)) ");
            
           // statement.executeUpdate(
             //  "UPDATE employee set salary =50000 where id=1");

              statement.executeUpdate(
              "DROP TABLE LOCATION");



            //      ResultSetMetaData rm = resultSet.getMetaData();
            //      int col = rm.getColumnCount();
            //     while(resultSet.next())
            //   {
            //            for(int i=1;i<=col;i++)
            //            {
            //             System.out.println(resultSet.getString(i));
            //            }
            //     }

           
               // System.out.println(resultSet.getString(1));
            
         
            connection.close();
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
	}
}
