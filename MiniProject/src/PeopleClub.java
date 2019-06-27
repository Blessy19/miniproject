import java.sql.*;
import java.util.Scanner;
	public class PeopleClub
	{
		 Connection con;
		 Statement st;
		 ResultSet res;
		 PreparedStatement ps;
	
		PeopleClub()
		{
			con =null;
		}
		public Connection getConnection()
		{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			}
			catch(Exception e)
			{
				System.out.println("Error in connection" +e);
			}
			return con;
		}
		
		public void insertPeople(String first_name, String last_name, Integer dob, String city) 
		{
					try {
						con=getConnection();
						ps=con.prepareStatement("insert into People_club values" + "(member_seq.NEXTVAL,?,?,?,?)");
						ps.setString(1,first_name);
						ps.setString(2, last_name);
						ps.setInt(3, dob);
						ps.setString(4, city);
						
						int i=ps.executeUpdate();
						if(i!=0)
						{
							System.out.println("inserted");
						}
						else
						{
							System.out.println("not inserted");
						}
						con.close();
					}
					catch (Exception e)
					{
						e.printStackTrace();
						
					}
		}
		
		public void getPeople() 
		{
		  try 
		  {
			  con=getConnection();
			  st= con.createStatement();
			  res=st.executeQuery("select * from people_club order by id");
					  System.out.println("pid\t first_name \t last_name \t dob \t\t City");
					  System.out.println("***********************************");
					  while(res.next())
					  {
						  System.out.print(res.getInt(1)+"\t");
						  System.out.print(res.getString(2)+"\t\t");
						  System.out.print(res.getString(3)+"\t\t");
						  System.out.println(res.getInt(4));
						  System.out.println(res.getString(5));
					  }
					  System.out.println("*************************************");
					  res.close();
					  con.close();
					  }
		  catch(Exception e)
		  {
			  System.out.println("error in fetching " + e);
		  
		  }
		}
		
		 public void display() 
			{
			  try 
			  {
				  con=getConnection();
				  st= con.createStatement();
				  res=st.executeQuery("select city,count(id) from people_club group by city ");
				  System.out.println("city\t pid");
				  while(res.next())
				  {
					  System.out.print(res.getString(1)+"\t");
					 System.out.print(res.getInt(2)+"\t");
				  }
						  res.close();
						  con.close();
						  }
			  catch(Exception e)
			  {
				  System.out.println("error in fetching " + e);
			  
			  }
			}

		public void updatePeople(int pid,String city) 
		{
			try {
				 con = getConnection();
			    ps = con.prepareStatement("update people_club" + " set city=? where id=?");
			    ps.setString(1, city);
			    ps.setInt(2,pid);
			    int i = ps.executeUpdate();
			    if (i != 0) {
			        System.out.println("City updated");
			    } else {
			        System.out.println("not updated");
			    }
			    con.close();
			} catch (Exception e){
			    e.printStackTrace();
			}
		}
		
		public void deletePeople(int pid) 
		{
			try {
				con = getConnection();
			    ps = con.prepareStatement("delete from people_club where id=?");
			    ps.setInt(1, pid);
			    int i = ps.executeUpdate();
			    if (i != 0) {
			        System.out.println("People deleted");
			    } else {
			        System.out.println("People Doesn't Exist");
			    }
			    con.close();
			}
			catch (Exception e) {
			    e.printStackTrace();
			}
		}
		
		public static void main(String[] args) {
			PeopleClub p=new PeopleClub();
			String city;
			int pid;
			
			System.out.println("-------PEOPLE CLUB-------");
			while(true)
			{
			System.out.println("Press 1 for Inserting People \t Press 2 to Display People");
			System.out.println("Press 3 for Update People \t Press 4 to Delete People");
			System.out.println("Press 5 to Display count of People \t Press 6 for Exit"); 
				
			Scanner s=new Scanner(System.in);
			int option=s.nextInt();
			
			switch(option)
			{
			case 1: System.out.println("Enter People first_name, last_name, dob & city");
							String first_name=s.next();
							String last_name=s.next();
							Integer dob=s.nextInt();
							city=s.next();
							p.insertPeople(first_name, last_name, dob, city);
							break;
			case 2: p.getPeople();
							break;
			case 3: System.out.println("Enter id & city to be Updated:");
    					  pid=s.nextInt();
    					  city=s.next();
    					  p.updatePeople(pid,city);
    					  break;
			case 4: System.out.println("Enter pid to be Deleted:");
						pid=s.nextInt();
						p.deletePeople(pid);
						break;
			case 5: p.display();
						   break;
		case 6: System.out.println("Application Terminated");
		 			  System.exit(0);
			default: System.out.println("Invalid Selection");
	          				break;
	}
			}}}
