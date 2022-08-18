import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

 
public class HomeN2 extends Frame implements ActionListener 
{
	Label l3=new Label();
	String st1;
	String st2;
	Label l1;
	Label l2;
	TextField t1;
	JPasswordField p2;
	String un=new String("Admin");
	String pas=new String("Admin");
	
	HomeN2()
	{	
		JFrame f=new JFrame();

		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we)
			{
				f.dispose();
			}
		});

		ImageIcon img=new ImageIcon("login.jpg");
		f.setContentPane(new JLabel(img));
		
		f.setVisible(true);
		f.setLayout(null);
		f.setSize(2000,2000);
		
		l1=new Label("Enter user name");		
		l2=new Label("enter password");
		

		t1=new TextField(20);
		p2=new JPasswordField(20);
		//t2.setEchoChar("*");
		Button b=new Button("SUBMIT");
		b.addActionListener(this);
		
		l1.setBounds(550,300,200,40);
		f.add(l1);
		
		t1.setBounds(800,300,350,40);
		f.add(t1);
		
		l2.setBounds(550,400,200,40);
		f.add(l2);
		
		p2.setBounds(800,400,350,40);
		f.add(p2);
		
		b.setBounds(700,500,200,80);
		f.add(b);
		
		//l3.setBounds(750,560,70,40);
		f.add(l3);
	}

	public void actionPerformed(ActionEvent e)
	{
		 st1=t1.getText();
		 st2=p2.getText();
		if(st1.equals(un) && st2.equals(pas))
		{
			l3.setText("Valid user..");
			new TabbedPaneExample();
		
		}
		else
		{
			l3.setText("Invalid user..");

		}
	}
	public static void main(String args[]) 
	{
			new HomeN2();
	}
}