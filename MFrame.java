package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
//import javax.swing.JScrollPane;

class MainFrame extends JFrame implements ActionListener,ItemListener
{
	Container c;
	  JMenu menu,menu1,menu2,menu3;
	  JMenu submenu,submenu1,submenu2,submenu3;
      JMenuItem i1, i2, i3, i4, i5;  
      JLabel l1,l2,l3,l4;
      JPanel p1,p2,p3,p4;
      JRadioButton run,stop;
      JComboBox cb;
	JButton loginfo,prgblock,blank;
	
	public MainFrame()
	{
		c=this.getContentPane();
		c.setLayout(null);
		
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBackground(Color.cyan);
		
		l1=new JLabel("LOGIN MONITORING");
		l1.setBounds(300,15, 200, 20);
		p1.add(l1);
		
		p2=new JPanel();
		p2.setLayout(null);
		p2.setBackground(Color.green);
		
		l2=new JLabel("STATUS :");
		l2.setBounds(70,15, 100, 20);
		p2.add(l2);
		l3=new JLabel("RUNNING..");
		l3.setBounds(130,15, 100, 20);
		p2.add(l3);
		
		run=new JRadioButton("Run");
		run.setBounds(500, 15, 50, 20);
		p2.add(run);
		
		stop=new JRadioButton("Suspend");
		stop.setBounds(600, 15,80, 20);
		p2.add(stop);
		run.setSelected(true);
		run.addItemListener(this);
		stop.addItemListener(this);
		
		
		ButtonGroup grp=new ButtonGroup();
		grp.add(run);
		grp.add(stop);
		
		p3=new JPanel();
		p3.setLayout(null);
		p3.setBackground(Color.cyan);
		
		l4=new JLabel("SortBy:");
		l4.setBounds(70,15, 50, 20);
		p3.add(l4);
		
		String sort[]={"User","Date","From-To"};          
		cb=new JComboBox(sort); 
		cb.setBounds(130,15,100,20);
		p3.add(cb);
		
		p4=new JPanel();
		p4.setLayout(null);
		p4.setBackground(Color.BLUE);
		
		loginfo=new JButton("Login Info");
		loginfo.setBounds(50, 50,200,70);
		
		prgblock=new JButton("Program Blocker");
		prgblock.setBounds(50,150,200,70);
		
		blank=new JButton("Blank");
		blank.setBounds(50,240,200,70);
		p4.add(loginfo);
		p4.add(prgblock);
		p4.add(blank);
		
		
		menu();
		windowSetter();
		boundSetter();
		componentsAdder();
		eventSetter();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==loginfo)
		{
			System.out.println("Clicked");
		//	new tablewin();
			//dispose();
		}
	}
	
	public void itemStateChanged(ItemEvent e)
	{
		if(e.getSource()==run)
		{
			System.out.println("Clicked run");
			p2.setBackground(Color.green);
		//	new tablewin();
			//dispose();
		}
		if(e.getSource()==stop)
		{
			System.out.println("Clicked stop");
			p2.setBackground(Color.red);
		//	new tablewin();
			//dispose();
		}
		
		
	}
	
	void boundSetter()
	{
		p1.setBounds(0, 0,800 ,50);
		p2.setBounds(0,50,800 ,50);
		p3.setBounds(0,100,800 ,50);
		p4.setBounds(0,150,800,500);
		
		
		//l1.setBounds(150,50,200,50);
		//l2.setBounds(20, 30,100,50);
		
	}
	
	
	void windowSetter()
	{
		setTitle("Login Monitor Software");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300,70,800,600);
		//setResizable(false);
	}
	
	void componentsAdder()
	{
		c.add(p1);
		c.add(p2);
		c.add(p3);
		c.add(p4);
		
		
	}
	
	void eventSetter()
	{
		loginfo.addActionListener(this);
		prgblock.addActionListener(this);
		blank.addActionListener(this);
		
	}
	void menu()
	{
		 JMenuBar mb=new JMenuBar();  
         menu=new JMenu("File"); 
        
         menu2=new JMenu("Setting");
         menu3=new JMenu("Help");
         
         
         submenu=new JMenu("Sub Menu"); 
         submenu1=new JMenu("Sub Menu"); 
         submenu2=new JMenu("Sub Menu"); 
         submenu3=new JMenu("Sub Menu"); 
         
         i1=new JMenuItem("Item 1");  
         i2=new JMenuItem("Item 2");  
         i3=new JMenuItem("Item 3");  
         i4=new JMenuItem("Item 4");  
         i5=new JMenuItem("Item 5");  
         menu.add(i1);
         menu.add(i2);
         menu.add(i3);  
         submenu.add(i4);
         submenu.add(i5);
        
         menu1=new JMenu("Search");
         i1=new JMenuItem("Item 11");  
         i2=new JMenuItem("Item 12");  
         i3=new JMenuItem("Item 13");  
         i4=new JMenuItem("Item 41");  
         i5=new JMenuItem("Item 51");  
         menu1.add(i1);
         menu1.add(i2);
         menu1.add(i3);  
         submenu1.add(i4);
         submenu1.add(i5);
         
         menu.add(submenu);
         menu1.add(submenu1);
         
         mb.add(menu);
         mb.add(menu1);
         mb.add(menu2);
         mb.add(menu3);
         
         setJMenuBar(mb);  
		
	}
	
}

public class MFrame 
{
	public static void main(String[] args)
	{
		MainFrame frame=new MainFrame();
	}
}
