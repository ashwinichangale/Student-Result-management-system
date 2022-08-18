import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddC implements ActionListener 
{
	Label l1,l2,l3,l4,l5,l6,l7;
	Label l8=new Label();
	TextField t1,t2,t3,t4,t5,t6,t7;
	Connection con=null;
	Statement state=null;
	Button b1;
	
	AddC()
	{

		JFrame f=new JFrame();

		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we)
			{
				f.dispose();
			}
		});

		
		l1=new Label("Roll no");
		l2=new Label("Name");
		l3=new Label("java");
		l4=new Label("CSS");
		l5=new Label("STE");
		l6=new Label("EST");
		l7=new Label("OS");

		t1=new TextField(100);
		t2=new TextField(100);
		t3=new TextField(100);
		t4=new TextField(100);
		t5=new TextField(100);
		t6=new TextField(100);
		t7=new TextField(100);

		b1=new Button("Insert");
		b1.addActionListener(this);

		f.setSize(2000,2000);
		f.setVisible(true);
		f.setLayout(null);

		l1.setBounds(500,100,180,40);
		f.add(l1);

		t1.setBounds(700,100,350,40);
		f.add(t1);

		l2.setBounds(500,200,180,40);
		f.add(l2);

		t2.setBounds(700,200,350,40);
		f.add(t2);
        
        l3.setBounds(500,300,180,40);
        f.add(l3);

        t3.setBounds(700,300,350,40);
		f.add(t3);
        
        l4.setBounds(500,400,180,40);
        f.add(l4);

        t4.setBounds(700,400,350,40);
		f.add(t4);
        
        l5.setBounds(500,500,180,40);
        f.add(l5);

        t5.setBounds(700,500,350,40);
		f.add(t5);
		
		l6.setBounds(500,600,180,40);
		f.add(l6);

		t6.setBounds(700,600,350,40);
		f.add(t6);

		l7.setBounds(500,700,180,40);
		f.add(l7);

		t7.setBounds(700,700,350,40);
		f.add(t7);

		b1.setBounds(600,800,200,100);
		f.add(b1);
		f.add(l8);

	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			int rn=Integer.parseInt(t1.getText());
			String nm=t2.getText();
			int ja=Integer.parseInt(t3.getText());
			int js=Integer.parseInt(t4.getText());
			int st=Integer.parseInt(t5.getText());
			int es=Integer.parseInt(t6.getText());
			int o=Integer.parseInt(t7.getText());
			
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");  
				con=DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe","system","root");
				System.out.println("Connection created");
				
				state=con.createStatement();
				int c=state.executeUpdate("insert into Student(rollno,name,java,Javascript,STE,EST,OS) values('"+rn+"','"+nm+"','"+ja+"','"+js+"','"+st+"','"+es+"','"+o+"')");

				if(c>0)
				{
					l8.setText("record inserted");
				}
				else
				{
					l8.setText("Record not inserted");
				}
				con.close();
			}
			catch(Exception e)
			{

			}
		}
	}

	public static void main(String args[])throws Exception
	{
			
			new AddC();
	}
}