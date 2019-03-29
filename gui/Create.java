package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Create extends JFrame implements ActionListener
{
	Container c;
	JLabel l_title,l_name,l_email,l_pass,l_cpass;
	JTextField name,email;
	JPasswordField pass,cpass;
	JButton back,next,cancel;
	
	public Create()
	{
		c=this.getContentPane();
		c.setLayout(null);
		l_title=new JLabel("Create your account");
		l_name=new JLabel("Name");
		l_email=new JLabel("Email");
		l_pass=new JLabel("Create Password");
		l_cpass=new JLabel("Confirm Password");
		
		name=new JTextField();
		email=new JTextField();
		
		pass=new JPasswordField();
		cpass=new JPasswordField();
		
		back=new JButton("Back");
		next=new JButton("Next");
		cancel=new JButton("Cancel");
		
		windowSetter();
		boundSetter();
		componentsAdder();
		eventSetter();
	}
	
	void boundSetter()
	{
		l_title.setBounds(10, 10,200,50 );
		l_name.setBounds(10, 100,200,25 );
		l_email.setBounds(10, 150,200 ,25 );
		l_pass.setBounds(10, 200,200 ,25 );
		l_cpass.setBounds(10, 250,200 ,25 );
		
		name.setBounds(250, 100,200,25 );
		email.setBounds(250, 150,200 ,25 );
		pass.setBounds(250, 200,200 ,25 );
		cpass.setBounds(250, 250,200 ,25 );
	
		back.setBounds(100, 400,100 , 50);
		next.setBounds(225, 400, 100,50 );
		cancel.setBounds(350, 400,100 , 50);
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
		c.add(l_name);
		c.add(l_email);
		c.add(l_pass);
		c.add(l_cpass);
		
		c.add(name);
		c.add(email);
		c.add(pass);
		c.add(cpass);
		
		c.add(back);
		c.add(next);
		c.add(cancel);
	}
	
	void eventSetter()
	{
		back.addActionListener(this);
		next.addActionListener(this);
		cancel.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==back)
		{
			new Welcome();
			dispose();
		}
		else if(e.getSource()==next)
		{
			int i;
			i=verify();
			if(i==1)
			{
				JOptionPane.showMessageDialog(this, "Invalid: Empty password field or only whitespces not allowed");
			}
			else if(i==2)
			{
				JOptionPane.showMessageDialog(this, "Invalid: Passwords didn't match");
			}
			else
			{
				  JOptionPane.showMessageDialog(this, "Account creation successful!");
				  new Install();
				  dispose();
			}
		}
		else if(e.getSource()==cancel)
		{
			System.exit(2);
		}
	}
	
	//modify here
	int verify()
	{

		if(pass.getText().isBlank())
		{
			return 1;
		}
		else if(!pass.getText().equals(cpass.getText()))
		{
			return 2;
		}
		return 0;
	}
}
