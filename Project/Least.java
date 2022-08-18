import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class LeastD extends Frame
{
	LeastD()
	{
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we)
			{
				dispose();
			}
		});
		setSize(2000,2000);
		setVisible(true);
		setLayout(new FlowLayout());
		Label l1=new Label("Least most Student Deatils..");
		add(l1);
	}
	public static void main(String args[])
	{
		new LeastD();
	}
}