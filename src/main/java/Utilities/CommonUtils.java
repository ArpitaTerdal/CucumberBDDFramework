package Utilities;

import java.util.Date;

public class CommonUtils {
	
	public static final int IMPLICIT_WAIT_TIME=10;
	
	public static final int PAGE_LOAD_TIME=15;
	
	public static final int EXPLICIT_BASIC_WAIT_TIME=15;

	public static String emailWithTimeStamp()
	{
		Date date=new Date();
		return "arpita"+date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
		
	}
}
