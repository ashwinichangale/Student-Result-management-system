import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class CalC implements ActionListener
{	
	Label l=new Label("Enter student roll number:");
	TextField t1=new TextField(50);
	Label l1=new Label();
	Label l2=new Label();
	Label l3=new Label();
	Label l4=new Label();
	Label l5=new Label();
	Label l6=new Label();
	Label l7=new Label();
	Label l8=new Label();
	Label l9=new Label();
	Label l20=new Label();

	Label l10=new Label("Roll no :");
	Label l11=new Label("Name :");
	Label l12=new Label("Java :");
	Label l13=new Label("JavaScript :");
	Label l14=new Label("STE :");
	Label l15=new Label("EST :");
	Label l16=new Label("OS :");
	Label l17=new Label("Total :");
	Label l18=new Label("Percentage :");
	Label l19=new Label("Grade");

	Button b1=new Button("Calculate");
	
	Connection con=null;
	Statement state=null;
	ResultSet res=null;	

	CalC()
	{
		JFrame f=new JFrame();
		
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we)
			{
				f.dispose();
			}
		});
 
		ImageIcon img=new ImageIcon("space.jpg");
		f.setContentPane(new JLabel(img));
		
		f.setSize(2000,2000);
		f.setVisible(true);
		f.setLayout(new FlowLayout());
		
		b1.addActionListener(this);
		
		/*t1.setBounds(600,100,200,40);
		b1.setBounds(600,250,200,100);
		l1.setBounds(1200,100,200,40);
		l2.setBounds(1200,250,200,40);
		l3.setBounds(1200,400,200,40);
		l4.setBounds(1000,100,100,40);
		l5.setBounds(1000,250,100,40);
		l6.setBounds(1000,400,100,40);*/
		f.add(l);
		f.add(t1);
		f.add(b1);
		f.add(l10);
		f.add(l1);
		f.add(l11);
		f.add(l2);
		f.add(l12);
		f.add(l3);
		f.add(l13);
		f.add(l4);
		f.add(l14);
		f.add(l5);
		f.add(l15);
		f.add(l6);
		f.add(l16);
		f.add(l7);
		f.add(l17);
		f.add(l8);
		f.add(l18);
		f.add(l9);
		f.add(l19);
		f.add(l20);

	}
	public void actionPerformed(ActionEvent ae)
	{
		int s1=0,s2=0,s3=0,s4=0,s5=0,rn=0,blank1=0,blank2=0;
		String nm="";
		int r=Integer.parseInt(t1.getText());

		try
			{

				Class.forName("oracle.jdbc.driver.OracleDriver");  
				con=DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe","system","root");
				System.out.println("Connection created");
				//System.out.println(r);
				
				state=con.createStatement();
				res=state.executeQuery("select * from Student where rollno='"+r+"'");

					
					while(res.next())
					{
						rn=res.getInt(1);
						nm=res.getString(2);	
						s1=res.getInt(3);
						s2=res.getInt(4);
						s3=res.getInt(5);
						s4=res.getInt(6);
						s5=res.getInt(7);
						blank1=res.getInt(8);
						blank2=res.getInt(9);
					}

				//System.out.println("hello");	

				int tot=(s1+s2+s3+s4+s5);
				String total=Integer.toString(tot);
				float per=(float)tot/5;
				String percent=String.valueOf(per);
				String grade=null;
				
				if(per >= 35)
				{
					grade="pass";
				}
				else
				{
					grade="fail";
				}

				
				l1.setText(Integer.toString(rn));
				l2.setText(nm);
				l3.setText(Integer.toString(s1));
				l4.setText(Integer.toString(s2));
				l5.setText(Integer.toString(s3));
				l6.setText(Integer.toString(s4));
				l7.setText(Integer.toString(s5));
				l8.setText(total);
				l9.setText(percent);
				l20.setText(grade);

				con.close();
			}
			catch(Exception e)
			{

			}

	}
	public static void main(String args[])
	{
		new CalC();
	}
}