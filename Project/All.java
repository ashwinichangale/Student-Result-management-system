import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
 public class All implements ActionListener
 {
 	Button b1,b2,b3,b4;
 	All()
 	{
 		JFrame f=new JFrame();

 		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we)
			{
				f.dispose();
			}
		});

 		f.setVisible(true);
 		f.setLayout(null);
 		f.setSize(2000,2000);

 		ImageIcon img=new ImageIcon("space.jpg");
		f.setContentPane(new JLabel(img));


 		b1=new Button("Add");
 		b1.addActionListener(this);

 		b2=new Button("View");
 		b2.addActionListener(this);

 		b3=new Button("Calculate Result");
 		b3.addActionListener(this);

 		b4=new Button("Sort");
 		b4.addActionListener(this);

 		b1.setBounds(600,200,200,100);
 		f.add(b1);
 		b2.setBounds(1200,200,200,100);
 		f.add(b2);
 		b3.setBounds(600,600,200,100);
 		f.add(b3);
 		b4.setBounds(1200,600,200,100);
 		f.add(b4);
 	}

 	public void actionPerformed(ActionEvent ae)
 	{
 		if((ae.getSource()) == b1)
 		{
 			new AddC();
 		}
		if(ae.getSource()==b2)
		{
			//new View();
		}
		if((ae.getSource())==b3)
		{
			new CalC();
		}
		if(ae.getSource()==b4)
		{
			new SortD();
		}
 	}

 	public static void main(String args[])
 	{
 		new All();	
 	}
 }