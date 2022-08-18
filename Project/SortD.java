import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SortD extends Frame implements ActionListener
{
	Button b1,b2;
	SortD()
	{
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we)
			{
				dispose();
			}
		});
		b1=new Button("TOP-5");
		b2=new Button("LEAST-5");
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(b1);
		add(b2);
		setVisible(true);
		setSize(2000,2000);
		setLayout(new FlowLayout());
	}

	public void actionPerformed(ActionEvent ae)
	{
		if((ae.getSource())==b1)
		{
			new TopD();
		}
		if((ae.getSource())==b2)
		{
			new LeastD();
		}
	}

	public static void main(String args[])
	{
		new SortD();
	}
}