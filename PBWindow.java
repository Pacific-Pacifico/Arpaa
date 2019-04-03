package gui;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.*;

class PBFrame extends JFrame implements ActionListener,ListSelectionListener
{
	Container c;
	JLabel l_sb;
	JButton block,unblock,unblockAll,apply,cancel;
	JScrollPane sp;
	JList<String> list;
	DefaultListModel<String> l1;
	
	public PBFrame()
	{
		c=this.getContentPane();
		c.setLayout(null);

		l_sb=new JLabel("Program BLOCKER");
		l_sb.setBounds(270,15, 300, 50);
		l_sb.setFont(new Font("Courier New", Font.BOLD, 25));

		l1 = new DefaultListModel<>();  //list  
		l1.addElement("chrome.exe");  
		l1.addElement("firefox.exe");  
		l1.addElement("Item3");  
		l1.addElement("Item4");  
		list = new JList<>(l1);  
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

		unblock.setEnabled(false);
		apply.setEnabled(false);
		cancel.setEnabled(false);
		
		windowSetter();
		boundSetter();
		componentsAdder();
		eventSetter();
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==block)
		{
			String input=JOptionPane.showInputDialog(this,"Enter the program name:");
			if(input!=null && !input.isEmpty())
			{
				l1.addElement(input);
				apply.setEnabled(true);
				cancel.setEnabled(true);
				block.setEnabled(true);
			}
			//dispose();
		}
		if(e.getSource()==unblock)
		{
			l1.removeElementAt(list.getSelectedIndex());
			apply.setEnabled(true);
			cancel.setEnabled(true);
			block.setEnabled(true);
			//dispose();
		}
		if(e.getSource()==unblockAll)
		{
			l1.clear();
			apply.setEnabled(true);
			cancel.setEnabled(true);
			block.setEnabled(true);
			//dispose();
		}
		if(e.getSource()==apply)
		{
			String[] programs=new String[l1.getSize()];
			for(int i=0;i<l1.getSize();i++)
			{
				programs[i]=l1.getElementAt(i);
			}
			JOptionPane.showMessageDialog(this, "done!");
			dispose();
			new blocker.ProgramsBlocker(1000,programs);
		
			//dispose();
		}
		if(e.getSource()==cancel)
		{
			dispose();
		}
	}
	
	public void valueChanged(ListSelectionEvent e)
	{
		if(e.getSource()==list)
		{
			unblock.setEnabled(true);
			block.setEnabled(false);
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
		
		list.addListSelectionListener(this);
	}
}

public class PBWindow
{
	public static void main(String[] args)
	{
		PBFrame ob=new PBFrame();
	}
}
