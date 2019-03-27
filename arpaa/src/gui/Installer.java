package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class WFrame extends JFrame
{
	Container c;
	JLabel l_title,l_wel,l_next,l_note;
	JButton read,next,cancel;
	
	public WFrame()
	{
		l_title=new JLabel("Login Monitor Software Installer");
		c.setLayout(null);
		windowSetter();
		boundSetter();
		componentsAdder();
	}
	
	void boundSetter()
	{
		
	}
	
	
	void windowSetter()
	{
		setTitle("Login Monitor Software");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500,200,500,500);
		setResizable(false);
	}
	
	void componentsAdder()
	{
		c.add(l_title);
		
	}
}

public class Installer 
{
	public static void main(String[] args)
	{
		WFrame frame=new WFrame();
	}
}
