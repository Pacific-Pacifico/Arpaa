package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SBFrame extends JFrame implements ActionListener
{
	Container c;
	JLabel l_sb;
	JButton block,unblock,unblockAll,apply,cancel;
	JScrollPane sp;
	DefaultListModel<String> l1;
	
	public SBFrame()
	{
		c=this.getContentPane();
		c.setLayout(null);

		l_sb=new JLabel("SITE BLOCKER");
		l_sb.setBounds(270,15, 300, 20);
		l_sb.setFont(new Font("Courier New", Font.BOLD, 25));

		l1 = new DefaultListModel<>();  //list  
		l1.addElement("Item1");  
		l1.addElement("Item2");  
		l1.addElement("Item3");  
		l1.addElement("Item4");  
		JList<String> list = new JList<>(l1);  
		list.setBounds(100,100,250,300);
		sp=new JScrollPane(list);  //scrollpane
		sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setBounds(100,100,250,300);
		c.add(sp);

		block=new JButton("Block");
		unblock=new JButton("UnBlock");
		unblockAll=new JButton("UnBlock All");
		apply=new JButton("Apply");
		cancel=new JButton("Cancel");

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
			if(input!=null)
			{
				l1.addElement(input);
			}
			//dispose();
		}
		if(e.getSource()==unblock)
		{
//			l1.removeElement()
			//dispose();
		}
		if(e.getSource()==unblockAll)
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
		unblockAll.setBounds(500,300,200,70);
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
		c.add(unblockAll);
		c.add(apply);
		c.add(cancel);
	}

	void eventSetter()
	{
		block.addActionListener(this);
		unblock.addActionListener(this);
		unblockAll.addActionListener(this);
		apply.addActionListener(this);
		cancel.addActionListener(this);
	}
}

public class SBWindow
{
	public static void main(String[] args)
	{
		SBFrame ob=new SBFrame();
	}
}
