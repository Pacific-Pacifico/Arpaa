package login;

import java.io.*;

public class LTime
{
   public static void main(String[] args)throws IOException
    {
        Process p;
        File f=null;
        FileWriter fw=null;
        StringBuilder sb=null;
        PrintWriter pw=null;
        BufferedReader reader=null;
        try
        {
            sb=new StringBuilder();
            f=new File("C:\\Users\\Public\\Arpaa\\Logs\\login_info.txt");
            fw=new FileWriter(f,true);
            pw=new PrintWriter(fw);
            p = Runtime.getRuntime().exec("quser");
            p.waitFor();
            reader= new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            System.out.println(sb);

            String[] vals = sb.toString().split(" ");
    
            //System.out.println("length=" +vals.length);

            String uname=System.getProperty("user.name");
            String loginTime = vals[vals.length - 3] + " " + vals[vals.length - 2] + " " + vals[vals.length - 1];
            System.out.println(uname);
            System.out.println(loginTime);
            //fw.write("username:" + uname);
            pw.println("username:" + uname);
            pw.println("Login time:" + loginTime);
            
            new CheckConnection(uname, loginTime);
//            new db.Update(uname,loginTime);
//            new mail.SendMail(uname,loginTime);

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        finally
        {
            if(fw!=null)
                fw.close();
        }
    }
}
