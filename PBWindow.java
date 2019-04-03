package gui;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.*;

class PBFrame extends JFrame implements ActionListener,ListSelectionListener,ItemListener
{
	Container c;
	JLabel l_sb,l2,l3;
	JPanel p1,p2;
	JRadioButton run,stop;
	JButton block,unblock,unblockAll,apply,cancel;
	JScrollPane sp;
	JList<String> list;
	DefaultListModel<String> l1;
	
	public PBFrame()
	{
		c=this.getContentPane();
		c.setLayout(null);
		
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBounds(0, 0, 800,50);
		p1.setBackground(Color.blue);
		
		l_sb=new JLabel("Program BLOCKER");
		l_sb.setBounds(270,5, 300, 50);
		l_sb.setFont(new Font("Courier New", Font.BOLD, 25));
		p1.add(l_sb);
		
		p2=new JPanel();
		p2.setLayout(null);
		p2.setBounds(0, 50,800,45);
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
			System.out.println("Clicked run");
			p2.setBackground(Color.red);
			l3.setText("Stoped..");
	
			//dispose();
		}
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
		c.add(p1);
		c.add(p2);
		
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