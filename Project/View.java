import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;		

public class View extends JFrame
{
	Connection con=null;
	Statement state=null;
	ResultSet res=null;	
	
	Vector data=new Vector();
	Vector col =new Vector();
	Label l;
	
	View()
	{
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we)
			{
				dispose();
			}
		});

		setVisible(true);
		setSize(2000,2000);
		setLayout(new FlowLayout());

				
		l=new Label("STUDENTS DATA");
		add(l);

		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			con=DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe","system","root");
			System.out.println("Connection created");

			state=con.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
			res=state.executeQuery("select * from Student");
			
			

	        while(res.next())
			{
				int rn=0,s1=0,s2=0,s3=0,s4=0,s5=0,tot=0,per=0;
				String nm;

				Vector row= new Vector();
				rn=res.getInt(1);
				nm=res.getString(2);	
				s1=res.getInt(3);
				s2=res.getInt(4);
				s3=res.getInt(5);
				s4=res.getInt(6);
				s5=res.getInt(7);
				tot=res.getInt(8);
				per=res.getInt(9);

				row.add(rn);
				row.add(nm);
				row.add(s1);
				row.add(s2);
				row.add(s3);
				row.add(s4);
				row.add(s5);
				row.add(tot);
				row.add(per);

				data.add(row);

			}

			col.add("Roll no");
			col.add("Name");
			col.add("Java");
			col.add("JavaScript");
			col.add("STE");
			col.add("EST");
			col.add("OS");
			col.add("Total");
			col.add("Percantage");

			JTable jt=new JTable(data,col);
			JScrollPane jsp=new JScrollPane(jt);
			add(jsp);
		}
		catch(Exception e)
		{

		}
	}

	public static void main(String args[])
	{
		new View();
	}
}


