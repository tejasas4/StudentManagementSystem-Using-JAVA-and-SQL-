package com.sms.student;

import java.security.spec.DSAGenParameterSpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentMainPro {
	public static void main(String[] args) throws ClassNotFoundException, SQLException  {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Scanner s1=new Scanner(System.in);
		while(true) {
			
		intro();
	System.out.println("*****************************");
	System.out.println("Choose the Operation");
	int o=s1.nextInt();
	switch (o) {
    case 1:
    	System.out.println("***************************");
    	System.out.println("***   <Insert Record>   ***");
     	System.out.println("***************************");
    		insert();
    	
    	break;
	
    case 2:
        	System.out.println("***************************");
        	System.out.println("***   <Update Record>   ***");
         	System.out.println("***************************");
         	update();
    	break;
    	
    	
    case 3: System.out.println("***************************");
	        System.out.println("***   <View Record>   ***");
	        System.out.println("***************************");
	        view();
	        break;
    case 4:
    	System.out.println("***************************");
    	System.out.println("***   <Delete Record>   ***");
    	System.out.println("***************************");
    	delete();
    	
    	break;
    	
    	
    case 5:
    	System.exit(0);
    	
    	break;
    	default: 
    		System.out.println("Invalid Number:");
    		break;
}


	}
	
	//view the record

	}

	public static void delete() throws SQLException {
		String url="jdbc:mysql://localhost:3306/sms_db";
		Connection con=DriverManager.getConnection(url,"root","Localhost");
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the ID to Delete: ");
		int i=in.nextInt();
		String query="DELETE FROM student_info WHERE id=?";
		PreparedStatement ps=con.prepareStatement(query);
		
		ps.setInt(1,i);
		
		
		ps.executeUpdate();
		System.out.println("Data delete sucessfully....");
	}
	
	public static void update() throws SQLException{
		view();
		String url="jdbc:mysql://localhost:3306/sms_db";
		Connection con=DriverManager.getConnection(url,"root","Localhost");
		String query ="UPDATE student_info SET Name = ?, std = ?, fname = ?, mobile = ? WHERE (id = ?);";
		PreparedStatement ps=con.prepareStatement(query);
		Scanner s=new Scanner(System.in);
		System.out.println("Enter your ID");
		int i=s.nextInt();
		System.out.println("Enter your Name"); 
		s.nextLine();
		String n=s.nextLine();
		System.out.println("Enter youur Class");
		String c=s.nextLine();
		System.out.println("Enter your Father Name");
		String f=s.nextLine();
		System.out.println("Enter your Mobile no.");
		String m=s.nextLine();

				
		ps.setInt(5, i);
		ps.setString(1, n);
		ps.setString(2, c);
		ps.setString(3, f);
		ps.setString(4, m);
		ps.executeUpdate();
		System.out.println("updated Succesfully.. ");
		
	}
	public static void view() throws SQLException {
		String url="jdbc:mysql://localhost:3306/sms_db";
		Connection con=DriverManager.getConnection(url,"root","Localhost");
		Statement st=con.createStatement();
		//Step 4: Execute Query
		ResultSet rs=st.executeQuery("Select * from student_info");
		System.out.println("ID | NAME | CLASS | FATHER | MOBILE");
		System.out.println("****************************");
		while(rs.next()) {
			System.out.println(rs.getString (1)+" ||"+rs.getString(2)+"|| "+rs.getString(3)+" ||"+rs.getString(4)+" ||"+rs.getString(5));
			
		}
	}
	public static void insert() throws SQLException {
		String url="jdbc:mysql://localhost:3306/sms_db";
		Connection con=DriverManager.getConnection(url,"root","Localhost");
		Scanner s=new Scanner(System.in);
		System.out.println("Enter your Name"); 
		String n=s.nextLine();
		System.out.println("Enter youur Class");
		String c=s.nextLine();
		System.out.println("Enter your Father Name");
		String f=s.nextLine();
		System.out.println("Enter your Mobile no.");
		String m=s.nextLine();
		
		String query="insert into student_info (Name,std,fname,mobile) value"
				+ "(?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, n);
		ps.setString(2, c);
		ps.setString(3, f);
		ps.setString(4, m);
		
		ps.executeUpdate();
		System.out.println("Data Inserted Succesfully.....");
	}
	public static void intro() {
			 System.out.println("*******************************");
			 System.out.println("*      STUDENT MODULE        **");
			 System.out.println("*******************************");
			 System.out.println("\n 1.Insert ");
			 System.out.println("\n 2.View ");
			 System.out.println("\n 3.Delete ");
			 System.out.println("Enter your choice to be made :");
			 Scanner in= new Scanner(System.in);
			 int i=in.nextInt();
			 Object choice = 0;
			

}

	private static void Switch(Object choice) {
		// TODO Auto-generated method stub
		
	}
}