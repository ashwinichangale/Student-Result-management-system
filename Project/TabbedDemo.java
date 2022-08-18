import java.awt.*;
import javax.swing.*;
public class TabbedDemo extends JFrame
{
	TabbedDemo()
	{  
		setVisible(true);
		setLayout(new FlowLayout());
		setSize(500,500);
		
		JTabbedPane jtp=new JTabbedPane();
		jtp.addTab("Add",new Addpane());
		jtp.addTab("View",new Viewpane());
		jtp.addTab("Calculate Result",new Calpane());
		jtp.addTab("Sort",new Sortpane());
		add(jtp);
	}
	public static void main(String args[])
	{
		new TabbedDemo();
	}
}
class Addpane extends JPanel
{
	public Addpane()
	{
		Label l1=new Label("Name:");
	 	Label l2=new Label("Class:");
	 	Label l3=new Label("Roll no:");
	 	Label l4=new Label("Enrollment no:");
	 	TextField t1=new TextField(50);
		TextField t2=new TextField(50);
	 	TextField t3=new TextField(50);
	 	TextField t4=new TextField(50);
	 	Button b1=new Button("Submit");
	 	l1.setBounds(300,300,50,50);
 		add(l1);
 		add(t1);
 		add(l2);
 		add(t2);
 		add(l3);
 		add(t3);
 		add(l4);
 		add(t4);
 		add(b1);
	}
}
class Viewpane extends JPanel
{
	public Viewpane()
	{
		Button b1=new Button("CM1I");
		Button b2=new Button("CM3I");
		Button b3=new Button("CM5I");
		add(b1);
		add(b2);
		add(b3);
	}
}

class Calpane extends JPanel
{
	public Calpane()
	{
		Button b1=new Button("CM1I");
		Button b2=new Button("CM3I");
		Button b3=new Button("CM5I");
		add(b1);
		add(b2);
		add(b3);
	}
}

class Sortpane extends JPanel
{
	public Sortpane()	
	{
		Label l1=new Label("Sorting Deatails....");
		add(l1);
	}
}
