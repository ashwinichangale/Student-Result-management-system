import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
 public class Cm1i extends Frame 
 {
 	Connection con=DriverManager.getConnection();
 	JTable table;
 	Cm1i()
 	{
 		setVisible(true);
 		setLayout(new FlowLayout());
 		setSize(700,700);
 		
 		String[] columnNames = {"Roll No", "Name", "Java", "CSS",""};

 		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);

		//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames()); 
		//table = new JTable(model);
		
		table = new JTable();
		table.setModel(model); 
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		
		String roll= "";
		String name= "";
		String cl = "";
		String sec = "";

		try
		{ 
			Class.forName(driverName); 
			Connection con = DriverManager.getConnection(url, userName, password);
			String sql = "select * from student where rollno = "+textvalue;
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int i =0;
			
			if(rs.next())
			{
				roll = rs.getString("rollno");
				name = rs.getString("name");
				cl = rs.getString("class");
				sec = rs.getString("section"); 
				model.addRow(new Object[]{roll, name, cl, sec});
				i++; 
				}
 		}
 	public static void main(String args[])
 	{
 		new Frame3();	
 	}
 }