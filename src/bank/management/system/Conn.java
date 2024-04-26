//4/12
//Dont make main method of conn class 
//as will use it as object in signupone or other class.

// we won't run this class will only use it as object
package bank.management.system;

import java.sql.*;

public class Conn {

//Steps of JDBC 
//1. Register the Driver
//2. Create Connection
//3. Create Statement
//4. Executive Query //written in SignupOne as obj is created thr
//5. Close Connection
    
    Connection c; //class connection obj is c globally
    Statement s; //class statement obj is s globally
    
    public Conn() { //Constructor
        //mysql is external entity so use exception handling to avoid run time error
        //it wont give compile time error
        try {
            //by importing lib named below we no need to register the driver it already have a classpath
            //Class.forName(com.mysql.cj.jdbc.Driver); // 1, Class named class, forname is static method, driver name.
            //**to use Driver import lib named below
            //**import lib mysql-connector-java for removing error on COM
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "system"); //2, Class is Driver manager,  function getconnection, url is string giving them a connectivity jdbc: and mysql is db name
            // we put //localhost:3306/ so no need to write lh3306 as its by default instead write ///
            s =c.createStatement(); //3, with use of connection c call the function createstatement
            
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
