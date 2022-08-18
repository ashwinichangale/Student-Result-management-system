import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class TopD extends Frame
{
	TopD()
	{
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we)
			{
				dispose();
			}
		});
		setSize(1000,1000);
		setVisible(true);
		setLayout(new FlowLayout());
		Label l1=new Label("Top most Student Deatils..");
		add(l1);
	}
	public static void main(String args[])
	{
		new TopD();
	}
}