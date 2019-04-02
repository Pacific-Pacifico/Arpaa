package blocker;

import java.io.*;
import java.nio.*;
import java.nio.file.*;

public class SiteBlocker 
{
	String OS;
	String hostsFile;
	Process p;

	public SiteBlocker()
	{        
		// Get OS name
		OS = System.getProperty("os.name").toLowerCase();

		// Use OS name to find correct location of hosts file

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
	}

	void blockSite(String... url) 
	{
		// Note that this code only works in Java 7+,
		// refer to the above link about appending files for more info

		try
		{
			Files.write(Paths.get(hostsFile),("\n").getBytes(),StandardOpenOption.APPEND);
			for(int i=0;i<url.length;i++)
			{
				Files.write(Paths.get(hostsFile),("127.0.0.1 " + url[i] + "\n").getBytes(),
						StandardOpenOption.APPEND);
			}
			flushDNS();
		}
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
	}

	void copyFile(String source,String destination)
	{
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try
		{
			/* If file doesnot exist FileInputStream throws 
        FileNotFoundException and read() write() throws 
        IOException if I/O error occurs */

			fis= new FileInputStream(source); 

			/* assuming that the file exists and need not to be 
        checked */
			fos = new FileOutputStream(destination);

			int b; 
			while  ((b=fis.read()) != -1) 
				fos.write(b); 

			/* read() will readonly next int so we used while 
        loop here in order to read upto end of file and 
        keep writing the read int into dest file */

			fis.close();
			fos.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	void flushDNS()
	{
		try
		{
			p = Runtime.getRuntime().exec("ipconfig /flushdns");
			int result=p.waitFor();
			System.out.println(result);
		}
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
	}

	void hostsFileCopy()
	{
		String source=hostsFile;
		String destination=null;

		if((OS.indexOf("win") >= 0))
		{
			destination="C:\\Users\\Public\\Arpaa\\Logs\\hosts";
		}
		copyFile(source, destination);
	}

	void hostsFileOriginal()
	{
		String source=null;
		String destination=hostsFile;

		if((OS.indexOf("win") >= 0))
		{
			source="C:\\Users\\Public\\Arpaa\\Logs\\hosts";
		}
		copyFile(source, destination);
		flushDNS();
	}


	public static void main(String[] args) 
	{
		SiteBlocker sb= new SiteBlocker();
//		sb.hostsFileCopy();
		sb.hostsFileOriginal();
		sb.blockSite("www.instagram.com","www.facebook.com");
	}
	
	public SiteBlocker(String... urls) 
	{
		SiteBlocker sb= new SiteBlocker();
//		sb.hostsFileCopy();
		sb.hostsFileOriginal();
		sb.blockSite(urls);
	}
}