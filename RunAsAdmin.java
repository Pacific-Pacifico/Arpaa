package gui;

import java.io.*;

public class RunAsAdmin 
{
	private String command;
	Process p;
	public void getRights()
	{
		// Get OS name
		String OS = System.getProperty("os.name").toLowerCase();

		if ((OS.indexOf("win") >= 0)) 
		{
			command="powershell.exe Start-Process \"java \'-classpath .\\bin gui.SBWindow\'\" -verb RunAs";
			
			//working directory check
			//command="cmd.exe /c start";
		}
		else if ((OS.indexOf("mac") >= 0))
		{
			
		}
		else if ((OS.indexOf("nux") >= 0)) 
		{
		}
		else 
		{
			// Handle error when platform is not Windows, Mac, or Linux
			System.err.println("Sorry, but your OS doesn't support blocking.");
			System.exit(0);
		}
		
		try
		{
			p=Runtime.getRuntime().exec(command);
		}
		catch(Exception e)
		{
			System.out.println("error");
		}
	}
	
	public static void main(String args[])
	{
		RunAsAdmin r=new RunAsAdmin();
		r.getRights();
	}
}

