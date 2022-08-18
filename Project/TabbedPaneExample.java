import java.sql.*;
import javax.swing.*;  
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TabbedPaneExample
{  
    JFrame f;  
    
    TabbedPaneExample()
    {  
        f=new JFrame();  
        
        JTabbedPane tp=new JTabbedPane();  
        tp.setBounds(0,0,2000,2000);  
        
        tp.add("Add",new AddC());  
        tp.add("View",new View());  
        tp.add("Calculate",new CalC());    
        tp.add("Sortout",new SortData());
        
        f.add(tp);  
        f.setSize(400,400);  
        f.setLayout(null);  
        f.setVisible(true);  
    }  

    public class SortData extends JPanel implements ActionListener
    {
        Button b1,b2;
        SortData()
        {
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
                //new TopD();
            }
            if((ae.getSource())==b2)
            {
                //new LeastD();
            }
        }
    }

    
    public class AddC extends JPanel implements ItemListener
    {
        
        JComboBox yr=new JComboBox();
        Choice sem=new Choice();

        AddC()
        {

            yr.addItem("1st year");
            yr.addItem("2nd year");
            yr.addItem("3rd year");
            yr.addItemListener(this);

            sem.addItemListener(this);

            
            setSize(2000,2000);
            setVisible(true);
            setLayout(null);
            yr.setBounds(600,400,300,40);
            sem.setBounds(1000,400,200,40);

            add(yr);
            add(sem);
            
        }
        public void itemStateChanged(ItemEvent ie)
        {
            if(yr.getSelectedItem()=="1st year")
            {
                sem.addItem("CM1I");
                sem.addItem("CM2I");
            
            }
            else if(yr.getSelectedItem()=="2nd year")
            {
                sem.addItem("CM3I");
                sem.addItem("CM4I");
            }
            else if(yr.getSelectedItem()=="3rd year")
            {
                sem.addItem("CM5I");
                sem.addItem("CM6I");   
            }  
            else
            {

            }


            if(sem.getSelectedItem()=="CM5I")
            {
                new AddCm5i();
            }
            else
            {
                new AddCm6i();
            }
            
        }


    }



public class View extends JPanel
{
    Connection con=null;
    Statement state=null;
    ResultSet res=null; 
    
    Vector data=new Vector();
    Vector col =new Vector();
    JLabel l;
    
    View()
    {
        setVisible(true);
        setSize(2000,2000);
        setLayout(null);

                
        l=new JLabel("STUDENT DATA");
        l.setFont(new Font("Times New Roman", Font.BOLD,30));
        l.setBounds(820,50,300,90);
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
            jt.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 16 ));

            JScrollPane jsp=new JScrollPane(jt);
            jsp.setBounds(100,150,1700,500);
            add(jsp);
        }
        catch(Exception e)
        {

        }
    }
   } 
    public class CalC extends  JPanel implements ActionListener
    {
        TextField t1=new TextField(50);
        Label l1=new Label();
        Label l2=new Label();
        Label l3=new Label();
        Label l4=new Label("Total:");
        Label l5=new Label("Percentage:");
        Label l6=new Label("Grade:");

        Button b1=new Button("Calculate");
        
        Connection con=null;
        Statement state=null;
        ResultSet res=null; 

        CalC()
        {
            setSize(2000,2000);
            setVisible(true);
            setLayout(new FlowLayout());
            
            b1.addActionListener(this);
            
            
            add(t1);
            add(b1);
            add(l1);
            add(l2);
            add(l3);
            add(l4);
            add(l5);
            add(l6);

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

                    
                    l1.setText(total);
                    l2.setText(percent);
                    l3.setText(grade);

                    con.close();
                }
                catch(Exception e)
                {

                }

            }
    }

   public static void main(String[] args) 
    {  
        new TabbedPaneExample();  
    }
}  
