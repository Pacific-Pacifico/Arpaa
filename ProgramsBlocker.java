package blocker;

import java.io.IOException;
/**
    Blocks programs.
    @param programs - The array of process names.
    @param timeout - The time between blocks, in milliseconds.
    This parameter should not be set below 100, to avoid slowdown.
 */

public class ProgramsBlocker
{
	public ProgramsBlocker(int timeout, String...programs)
	{
		try
		{
			blockPrograms(timeout,programs);
		}
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	public void blockPrograms(int timeout, String...programs) throws IOException
	{
		if(programs.length==0)
		{
			System.exit(0);
		}
		// Get OS name
		String OS = System.getProperty("os.name").toLowerCase();

		// Identify correct blocking command for OS
		String command = "";
		if ((OS.indexOf("win") >= 0)) 
		{
			command = "taskkill /f /im ";
		} 
		else if ((OS.indexOf("mac") >= 0) || (OS.indexOf("nux") >= 0)) 
		{
			command = "killall ";
		} 
		else 
		{
			// Handle error when platform is not Windows, Mac, or Linux
			System.err.println("Sorry, but your OS doesn't support blocking.");
			System.exit(0);
		}

		// Start blocking!
		while(true) 
		{
			// Cycle through programs list
			for(int i = 0; i < programs.length; i++) 
			{
				// Block program
				Runtime.getRuntime().exec(command + programs[i]);
			}
			// Timeout
			try
			{ 
				Thread.sleep(timeout); 
			} 
			catch(InterruptedException e) 
			{
				System.out.println(e);
				e.printStackTrace();
			}
		}
	}
	
//	public static void main(String args[])throws Exception
//	{
//		ProgramsBlocker pb=new ProgramsBlocker();
//		//block browsers
//		pb.blockPrograms(1000,"iexplore.exe","firefox.exe","chrome.exe","opera.exe","notepad++.exe");
//	}
}