/**
 * 
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.TreeSet;
/**
 * Write a program that reads words from a text file and displays all the non-duplicate 
 * words in ascending order. (Use a TreeSet to hold the words)
 * <p>
 * NOTE: Some of the assumptions made include...
 * <pre>
 * 1.) The words in the file are comma delimited
 * </pre>
 * 
 * </p>
 * @author Malachi Gage Sanderson
 * @since 11/5/21 
 *
 */
public class TreeSetIOQuestion 
{
	private static File textFile;
	private static TreeSet<String> words;
	
	
	public static void main(String[] args) 
	{
		textFile = new File("RandomWordsFile.txt");
		readOutEveryLineInFile(textFile);
		System.out.println("\n\nProcessed File...\n");
		parseFile();

	}
	
	
	/**
	 * Splits comma-separated-words in the file into a bunch of individual 
	 * elements which are placed into a tree set. 
	 */
	public static void parseFile()
	{
		BufferedReader br = null;
		try
		{
			FileReader fr = new FileReader(textFile);
			br = new BufferedReader(fr);
			String line; //used to get each individual line of a file.
			int numberOfDuplicateWords = 0;
			
			// while line is equal to the next line of the buffered reader is not equal to null
			// this means read the next line in the file until there are not any more line to read
			while (  (line = br.readLine()) != null ) 
			{
				int totalStartNumberOfWordsInTree = 0;
				
				if(words == null)
				{
					words = new TreeSet<String>(makeListOfWords(line));
				}
				else
				{
					totalStartNumberOfWordsInTree = words.size();
					words.addAll(makeListOfWords(line));
				}
				
				//System.out.println(words);
				
				//System.out.println("Number of words In This Line: " + makeListOfWords(line).size());
				numberOfDuplicateWords += makeListOfWords(line).size() - (words.size()-totalStartNumberOfWordsInTree);
				

			}
			System.out.println("SAVED WORDS IN TREESET...\n"+words);
			System.out.println("Total Number of Words: " + words.size());
			System.out.println("Total Number of Duplicate Words (they were removed): " + numberOfDuplicateWords);
		}
		catch (Exception e) 
		{

			e.printStackTrace();
		}
		finally
		{
			try 
			{
				br.close();
			}
			catch(Exception e)
			{
				System.out.println("[ERROR NO BUFFERED READER TO CLOSE]");
			}
			
		}
	}
	
	
	/**
	 * given a string with commas separating words split the string into 
	 * a list of words.
	 * @param s a string of words
	 * @return a linked list of strings.
	 */
	public static LinkedList<String> makeListOfWords(String s)
	{
		
		return new LinkedList<String>(Arrays.asList(s.split(",")));
		
	}
	
	/**
	 * Just prints every line in a provided file.
	 * @param file
	 */
	public static void readOutEveryLineInFile(File file)
	{
		BufferedReader br = null;
		try
		{
			FileReader fr = new FileReader(file);
			System.out.println("\n\tFile Being Read: "+file.getName() + "\n\n");
			br = new BufferedReader(fr);
			String line; //used to get each individual line of the file.
			
			// while line is equal to the next line of the buffered reader is not equal to null
			// this means read the next line in the file until there are not any more line to read
			while (  (line = br.readLine()) != null ) 
			{
				System.out.println(line); // print out next line 
			}	
		}
		catch (Exception e) 
		{

			e.printStackTrace();
		}
		finally
		{
			try 
			{
				br.close();
			}
			catch(Exception e)
			{
				System.out.println("[ERROR NO BUFFERED READER TO CLOSE]");
			}
			
		}
	}
	

}
