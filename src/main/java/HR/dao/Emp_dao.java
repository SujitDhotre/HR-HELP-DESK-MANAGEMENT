package HR.dao;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

	import org.w3c.dom.ls.LSOutput;

	

	import HR.bo.Emp_bo;
	import HR.bo.Enquiry_bo;
	import HR.bo.Interviwe_bo;
	import HR.*;


	public class Emp_dao {
		public static Connection getConnection() {
			Connection con =null;
			try {
				String url="jdbc:mysql://localhost:3306/emp_pro";
				String username="root";
				String password="Sujit@5";
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection(url,username,password);
				
			}catch(Exception e)
			{
				
			}
			return con;
			
		}

		public static int signup(Emp_bo em)
		{
			int status=0;
			try
			{
				Connection con=Emp_dao.getConnection();
				String sql="insert into signup(name,email,phone,pass,doj) values(?,?,?,?,?)";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1,em.getName());
				ps.setString(2, em.getEmail());
				ps.setString(3,em.getPhone());
				ps.setString(4,em.getPassword());
				ps.setString(5,em.getDoj());
				status=ps.executeUpdate();
			}
			catch(Exception e) {
				System.out.println(e);
			}
			return status;
		}
		public static int inter(Interviwe_bo im) {
			int status =0;
			try {
				Connection con=Emp_dao.getConnection();
				String sql="insert into inter(name,edu,email,mode,dt) values (?,?,?,?,?)";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, im.getName());
				ps.setString(2, im.getEdu());
				ps.setString(3, im.getEmail());		
				ps.setString(4, im.getMode());
				ps.setString(5, im.getDate());
				
				status=ps.executeUpdate();
				
			}catch(Exception e)
			{
				System.out.println(e);
			}
			return status;
			
		}
		public static int enq(Enquiry_bo eb)
		
		{
			int status =0;
			try {
				Connection con=Emp_dao.getConnection();
				String sql="insert into enq(name,email,dis,DI) values (?,?,?,?)";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, eb.getName());
				ps.setString(2, eb.getEmail());
				ps.setString(3, eb.getDesc());
				ps.setString(4, eb.getDate());
				
				status=ps.executeUpdate();
			}catch(Exception e)
			{
				System.out.println(e);

			}
			return status;
			
			
		}
		
		public static boolean Login(String email ,String pass) throws SQLException
		{
			boolean status=false;
			try {
				
				Connection con=Emp_dao.getConnection();
				String sql="select * from login where email=? and pass =?";
				PreparedStatement ps=con.prepareStatement(sql);
				Emp_bo em;
				ps.setString(1, email);
				ps.setString(2, pass);
				
				ResultSet rs=ps.executeQuery();
				status =rs.next();
				
			}catch (Exception e)
			{
				System.out.println(e);
				
				
			}
			
			
			return status;
		}
		
		
		
		public static List getAllEmployee() {
			List <Emp_bo> list=new ArrayList<Emp_bo>();
			try {
				Connection con=Emp_dao.getConnection();
				PreparedStatement ps=con.prepareStatement("select * from signup");
				ResultSet rs=ps.executeQuery();
				
				while(rs.next())
				{
					Emp_bo eb= new Emp_bo();
					eb.setId(rs.getInt(1));
					eb.setName(rs.getNString(2));
					eb.setEmail(rs.getString(3));
					eb.setPhone(rs.getString(4));
					eb.setPassword(rs.getString(5));
					eb.setDoj(rs.getString(6));
					
					
					list.add(eb);
				}	
			}catch(Exception e)
			{
			System.out.println(e);
			}
			return list;
			
			
		}
		
		public static List getAllInter() {
			List<Interviwe_bo> list=new ArrayList<Interviwe_bo>();
			try {
				Connection con=Emp_dao.getConnection();
				PreparedStatement ps=con.prepareStatement("select * from inter");
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					Interviwe_bo im =new Interviwe_bo();
					im.setId(rs.getInt(1));
					im.setName(rs.getString(2));
					im.setEmail(rs.getString(3));
					im.setEdu(rs.getString(4));
					im.setMode(rs.getString(5));
					im.setDate_time(rs.getString(6));
					list.add(im);
				}
				
			}catch(Exception e)
			{
				
			}
			return list;
		}
		public static List getAllEnq() {
			List<Enquiry_bo> list=new ArrayList<Enquiry_bo>();
			try {
				Connection con=Emp_dao.getConnection();
				PreparedStatement ps=con.prepareStatement("select * from enq");
				ResultSet rs=ps.executeQuery();
				
				while(rs.next())
				{
					Enquiry_bo eb =new Enquiry_bo();
					eb.setId(rs.getInt(1));
					eb.setName(rs.getString(2));
					eb.setEmail(rs.getString(3));
					eb.setDesc(rs.getString(4));
					eb.setDate(rs.getString(5));
					list.add(eb);
					
					
				}
			}catch(Exception e)
			{
				
			}
			return list;
			
		}
		
		//Editing the Employee
		public static Emp_bo getElementByid( int eid) {
			Emp_bo eb=new Emp_bo();
			try {
				Connection con=Emp_dao.getConnection();
				String sql="select * from signup where id=?";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1, eid);
				
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					eb.setId(rs.getInt(1));
					eb.setName(rs.getString(2));
					eb.setEmail(rs.getString(3));
					eb.setPhone(rs.getString(4));
					eb.setPassword(rs.getString(5));
					eb.setDoj(rs.getString(6));
				}
				
				
			}catch(Exception e)
			{
				
			}
			return eb;
			
		}
		public static int Update(Emp_bo eb)
		{
			int status =0;
			try {
				
				Connection con=Emp_dao.getConnection();
				String sql="update signup set name=?,email=?,phone=?,pass=?,doj=? where id=?";
				PreparedStatement ps=con.prepareStatement(sql);
				
				ps.setString(1, eb.getName());
				ps.setString(2, eb.getEmail());
				ps.setString(3, eb.getPhone());
				ps.setString(4, eb.getPassword());
				ps.setString(5, eb.getDoj());
				ps.setInt(6, eb.getId());
				
				status=ps.executeUpdate();
				
				
				
			}catch(Exception e)
			{
				System.out.print(e);
			}
			return status;
			
		}
		
	}


