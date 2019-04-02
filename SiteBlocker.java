package blocker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class SiteBlocker 
{
	public static void main(String[] args) 
	{
		SiteBlocker sb= new SiteBlocker();
		sb.blockSite("www.instagram.com","www.facebook.com");
	}
	
//	public SiteBlocker()
//	{
//		SiteBlocker sb= new SiteBlocker();
//		sb.blockSite("www.instagram.com","www.facebook.com");
//	}
	
	public void blockSite(String... url) 
	{
		// Note that this code only works in Java 7+,
		// refer to the above link about appending files for more info
		
		Process p;
        
		// Get OS name
		String OS = System.getProperty("os.name").toLowerCase();

		// Use OS name to find correct location of hosts file
		String hostsFile = "";
		if ((OS.indexOf("win") >= 0)) 
		{
			// Doesn't work before Windows 2000
			hostsFile = "C:\\Windows\\System32\\drivers\\etc\\hosts";
		}
		else if ((OS.indexOf("mac") >= 0))
		{
			// Doesn't work before OS X 10.2
			hostsFile = "etc/hosts";
		}
		else if ((OS.indexOf("nux") >= 0)) 
		{
			hostsFile = "/etc/hosts";
		}
		else 
		{
			// Handle error when platform is not Windows, Mac, or Linux
			System.err.println("Sorry, but your OS doesn't support blocking.");
			System.exit(0);
		}

		try
		{
			for(int i=0;i<url.length;i++)
			{
				Files.write(Paths.get(hostsFile),
						("127.0.0.1 " + url[i] + "\n").getBytes(),
						StandardOpenOption.APPEND);
				
				p = Runtime.getRuntime().exec("ipconfig /flushdns");
				int result=p.waitFor();
				System.out.println(result);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
	}
}