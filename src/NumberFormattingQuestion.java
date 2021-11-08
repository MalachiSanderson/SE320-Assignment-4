import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * Answer the following questions:
 * <p>
 *
 * <pre>
 * 1.) Write the code to format number 12345.678 in the United Kingdom locale. 
 * Keep two digits after the decimal point.
 * 
 * 2.)Write the code to format number 12345.678 in U.S. currency.
 * 
 * 3.) Write the code to parse '12,345.678' into a number.
 * </pre>
 * 
 * </p>
 * @author Malachi Gage Sanderson
 * @since 11/5/21 
 *
 */
public class NumberFormattingQuestion 
{


	private static  NumberFormat UK_Local = NumberFormat.getInstance(Locale.UK);
	private static final NumberFormat US_Currency = NumberFormat.getCurrencyInstance(Locale.US);
	
	private static final Number partA = 12345.678;
	private static final Number partB = 12345.678;
	private static final String partC = "12,345.678";
	
	
	
	public static void main(String[] args) 
	{
		UK_Local.setMaximumFractionDigits(2);
		
		
		String partA_Answer = UK_Local.format(partA);
		String partB_Answer = US_Currency.format(partB);
		
		
		
		System.out.println(partA_Answer);
		System.out.println(partB_Answer);
		
		NumberFormat format = NumberFormat.getNumberInstance();
		try 
		{
			Number partC_Answer = format.parse(partC);
			System.out.println(partC_Answer);
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}

	}



}
