package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Welcome extends JFrame implements ActionListener
{	
	Container c;
	JButton create,login;
	
	public Welcome()
	{
		c=this.getContentPane();
		c.setLayout(null);
		
		create=new JButton("Create Account");
		login=new JButton("Login");
		
		windowSetter();
		boundSetter();
		componentsAdder();
		eventSetter();
	}
	
	void boundSetter()
	{
		create.setBounds(25,200 ,200 ,100 );
		login.setBounds(250,200 , 200,100 );
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
		c.add(create);
		c.add(login);
	}
	
	void eventSetter()
	{
		create.addActionListener(this);
		login.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==create)
		{
			new Create();
			dispose();
		}
		else if(e.getSource()==login)
		{
			new Login();
			dispose();
		}
	}
	

}
