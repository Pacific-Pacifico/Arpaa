package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener
{
	Container c;
	JLabel l_title,l_email,l_pass;
	JTextField email;
	JPasswordField pass;
	JButton back,login,cancel;
	
	public Login()
	{
		c=this.getContentPane();
		c.setLayout(null);
		l_title=new JLabel("Login");
		l_email=new JLabel("Enter your Email");
		l_pass=new JLabel("Enter Password");

		email=new JTextField();
		
		pass=new JPasswordField();
		
		back=new JButton("Back");
		login=new JButton("Login");
		cancel=new JButton("Cancel");
		
		windowSetter();
		boundSetter();
		componentsAdder();
		eventSetter();
	}
	
	void boundSetter()
	{
		l_title.setBounds(10, 10,200,50 );
		l_email.setBounds(10, 150,200 ,25 );
		l_pass.setBounds(10, 200,200 ,25 );
		
		email.setBounds(250, 150,200 ,25 );
		pass.setBounds(250, 200,200 ,25 );
	
		back.setBounds(100, 400,100 , 50);
		login.setBounds(225, 400, 100,50 );
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
		c.add(l_email);
		c.add(l_pass);
		
		c.add(email);
		c.add(pass);

		c.add(back);
		c.add(login);
		c.add(cancel);
	}
	
	void eventSetter()
	{
		back.addActionListener(this);
		login.addActionListener(this);
		cancel.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==back)
		{
			new Welcome();
			dispose();
		}
		else if(e.getSource()==login)
		{
			if(!verify())
			{
				int output = JOptionPane.showConfirmDialog(this
			               , "Login failed! try again?"
			               ,"Login Monitor Software"
			               ,JOptionPane.YES_NO_OPTION);
				
				if(output==JOptionPane.YES_OPTION)
				{
					new Login();
					dispose();
				}
				else if(output==JOptionPane.NO_OPTION)
				{
					new Welcome();
					dispose();
				}
			}
			else
			{
	            JOptionPane.showMessageDialog(this, "Login successful!");
				new Install();
				dispose();
			}
		}
		else if(e.getSource()==cancel)
		{
			System.exit(3);
		}
	}
	
	//modify here
	boolean verify()
	{
		return true;
//		return false;
	}
}
