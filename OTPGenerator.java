package cli;

import java.util.Random;

public class OTPGenerator
{
	Random r;
	public int generateOTP()
	{
		r=new Random();
		long fraction = (long)(1000 * r.nextDouble());
	    int otp= (int)(fraction + 1000);
	    //System.out.println(otp);
	    return otp;
	}
}