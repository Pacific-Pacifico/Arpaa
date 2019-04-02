package testing1;


import javax.swing.*;


import java.awt.*;
import java.awt.event.*;
//import javax.swing.JScrollPane;

class MainFrame extends JFrame implements ActionListener
{
	Container c;
      JLabel l_sb;
      JPanel p1,p2,p3,p4;
	JButton block,unblock,unblockall,apply,cancel;
	
	public MainFrame()
	{
		c=this.getContentPane();
		c.setLayout(null);
		
		l_sb=new JLabel("SITE BLOCKING");
		l_sb.setBounds(270,15, 300, 20);
		l_sb.setFont(new Font("Courier New", Font.BOLD, 25));
		
		
	    DefaultListModel<String> l1 = new DefaultListModel<>();  //list  
        l1.addElement("Item1");  
        l1.addElement("Item2");  
        l1.addElement("Item3");  
        l1.addElement("Item4");  
        JList<String> list = new JList<>(l1);  
        list.setBounds(100,100,250,300); 
        JScrollPane sp=new JScrollPane(list);                       //scrollpane
        c.add(list);
	       
	       
		
		block=new JButton("Block");
		unblock=new JButton("UnBlock");
		unblockall=new JButton("UnBlock All");
		apply=new JButton("Apply");
		cancel=new JButton("Close");
		
		
		
		
		
		
		windowSetter();
		boundSetter();
		componentsAdder();
		eventSetter();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==block)
		{
			String input=JOptionPane.showInputDialog(this,"Enter the Website Address");
			//dispose();
		}
		if(e.getSource()==unblock)
		{
			
			//dispose();
		}
		if(e.getSource()==unblockall)
		{
			
			//dispose();
		}
		if(e.getSource()==apply)
		{
			
			//dispose();
		}
		if(e.getSource()==cancel)
		{
			
			
			dispose();
		}
	}
		
	void boundSetter()
	{
	
		block.setBounds(500,100,200,70);
		unblock.setBounds(500,200,200,70);
		unblockall.setBounds(500,300,200,70);
		apply.setBounds(150,430,200,70);
		cancel.setBounds(450,430,200,70);
	}
	
	
	void windowSetter()
	{
		setTitle("Login Monitor Software");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300,70,800,600);
		setResizable(false);
	}
	
	void componentsAdder()
	{
		c.add(l_sb);
		
		 
		
		c.add(block);
		c.add(unblock);
		c.add(unblockall);
		c.add(apply);
		c.add(cancel);
	
	}
	
	void eventSetter()
	{
		block.addActionListener(this);
		unblock.addActionListener(this);
		unblockall.addActionListener(this);
		apply.addActionListener(this);
		cancel.addActionListener(this);
		
		
	}
	
}

public class SiteBlock 
{
	public static void main(String[] args)
	{
		MainFrame ob=new MainFrame();
	}
}
