import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;


/**
 * 
 */

/**
 * 
 * Create two linked hash sets {"George", "Jim", "John", "Blake", "Kevin", "Michael"} and 
 * {"George", "Katie", "Kevin", "Michelle", "Ryan"} and 
 * find the... 
 * <p>
 * <b>{@link #unionSets  Union of the sets}</b>, 
 * </p>
 * <b>{@link #differenceSets  Difference of the sets}</b>, 
 * <p>
 * and <b>{@link #intersectionSets  Intersection of the sets}</b>. 
 * </p>
 * (You can clone the sets to preserve the original sets from being changed by these set methods.)
 * @author Malachi Gage Sanderson
 * @since 11/5/21 
 *
 */
public class HashedSetQuestion 
{

	private static LinkedHashSet<String> hashedSetA, hashedSetB;



	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		hashedSetA = new LinkedHashSet<String>(Arrays.asList("George", "Jim", "John", "Blake", "Kevin", "Michael"));
		hashedSetB = new LinkedHashSet<String>(Arrays.asList("George", "Katie", "Kevin", "Michelle", "Ryan"));
		
		
		System.out.println("\n\tORIGINAL SETS...");
		printEachSet( new LinkedList<String>(Arrays.asList("Set A", "Set B")), new LinkedList<LinkedHashSet<String>>(Arrays.asList(hashedSetA, hashedSetB)) );
		
		
		System.out.println("\n\n");
		System.out.println("\n\tDO UNION OF SETS...");
		LinkedHashSet<String> unionOfSets = unionSets(hashedSetA, hashedSetB);
		System.out.println("Should return :   [George, Jim, John, Blake, Kevin, Michael, Katie, Michelle, Ryan] ");
		System.out.println("Actually returns: "+ unionOfSets);
		boolean isItCorrect = unionOfSets.equals(new LinkedHashSet<String>(Arrays.asList("George", "Jim", "John", "Blake", "Kevin", "Michael", "Katie", "Michelle", "Ryan")));
		System.out.println("Is it Correct? "+ isItCorrect);
		isItCorrect = false;

		
		
		System.out.println("\n\n");
		System.out.println("\n\tDO DIFFERENCE OF SETS...");
		LinkedHashSet<String> diffOfSets = differenceSets(hashedSetA, hashedSetB);
		System.out.println("Should return :   [Jim, John, Blake, Michael, Katie, Michelle, Ryan]");
		System.out.println("Actually returns: "+ diffOfSets);
		isItCorrect = diffOfSets.equals(new LinkedHashSet<String>(Arrays.asList("Jim", "John", "Blake", "Blake", "Michael", "Katie", "Michelle", "Ryan"))) ;
		System.out.println("Is it Correct? "+ isItCorrect);
		isItCorrect = false;
		
		
		
		System.out.println("\n\n");
		System.out.println("\n\tDO INTERSECTION OF SETS...");
		LinkedHashSet<String> intersectOfSets = intersectionSets(hashedSetA, hashedSetB);
		System.out.println("Should return :   [George, Kevin]");
		System.out.println("Actually returns: "+ intersectOfSets);
		isItCorrect = intersectOfSets.equals(new LinkedHashSet<String>(Arrays.asList("George", "Kevin")));
		System.out.println("Is it Correct? "+ isItCorrect);
		isItCorrect = false;

		
		
	}


	/**
	 * A method for getting the union of two sets and returning it as a hashed set of type E 
	 * where {@link c_hashedSetA hashedSetA} has all elements of {@link c_hashedSetB hashedSetB} 
	 * that it doesn't already have, added to it.
	 * @param <E>
	 * @param c_hashedSetA the base set that will have items added to it from {@link c_hashedSetB hashedSetB} 
	 * @param c_hashedSetB the second set that will add item from itself to {@link c_hashedSetA hashedSetA}
	 * @return a LINKED hashed set of type E 
	 */
	public static <E> LinkedHashSet<E> unionSets(LinkedHashSet<E> c_hashedSetA, LinkedHashSet<E> c_hashedSetB)
	{
		LinkedHashSet<E> temp = (LinkedHashSet<E>) c_hashedSetA.clone();
		temp.addAll(c_hashedSetB);
		//printEachSet( new LinkedList<String>(Arrays.asList("Copy of Set A", "Copy of Set B", "Union of Sets")), new LinkedList<LinkedHashSet<E>>(Arrays.asList(c_hashedSetA, c_hashedSetB, temp)) );
		return temp ;
	}

	/**
	 * A method for getting the difference of two sets and returning it as a hashed set of type E
	 * where we start by adding all elements of {@link c_hashedSetA hashedSetA} to a list that 
	 * will hold all of the non-shared items. We then iterate through {@link c_hashedSetB hashedSetB}
	 * and remove any items from the list that are in {@link c_hashedSetB hashedSetB} AND {@link c_hashedSetA hashedSetA} and add any items that 
	 * are in {@link c_hashedSetB hashedSetB} but not {@link c_hashedSetA hashedSetA}.
	 * @param <E>
	 * @param c_hashedSetA
	 * @param c_hashedSetB
	 * @return a LINKED hashed set of type E 
	 */
	public static <E> LinkedHashSet<E> differenceSets(LinkedHashSet<E> c_hashedSetA, LinkedHashSet<E> c_hashedSetB)
	{
		LinkedHashSet<E> temp = (LinkedHashSet<E>) c_hashedSetA.clone(); //start the list with every element of set A
		for(E elementInB : c_hashedSetB ) //for every element in set B
		{
			
			if(c_hashedSetA.contains(elementInB)) //if set A has the given element of set B
			{
				temp.remove(elementInB);//remove that shared element from the list.
			}
			else
				temp.add(elementInB); //if set A doesn't have the given element of Set B, add it to the list.
		}
		
		
		return temp;
	}

	/**
	 * Basically, just does the inverse of {@link #differenceSets differenceSets()} except that it is a bit simpler in 
	 * that you just add all the elements of one set to a list then just remove any elements in that list 
	 * that aren't in both sets.
	 * @param <E>
	 * @param c_hashedSetA
	 * @param c_hashedSetB
	 * @return a LINKED hashed set of type E 
	 */
	public static <E> LinkedHashSet<E> intersectionSets(LinkedHashSet<E> c_hashedSetA, LinkedHashSet<E> c_hashedSetB)
	{
		LinkedHashSet<E> temp = (LinkedHashSet<E>) c_hashedSetA.clone(); //start the list with every element of set A
		for(E elementInA : c_hashedSetA ) //for every element in set A
		{
			if(!c_hashedSetB.contains(elementInA)) //if set B doesn't have the given element of Set A...
			{
				temp.remove(elementInA); //remove it from the list.
			}
		}
		return temp;
	}


	/**
	 * A way to print all the stuff contained in a bunch of sets/lists at once by batch printing them using linked lists.
	 * @param <E>
	 * @param nameOfEachList  make and provide a linked list containing the names of each list/set you wish to print. 
	 * <p><b>NOTE: PROVIDE THE NAMES IN SAME ORDER AS YOU PROVIDE THEIR CORRESPONDING SETS IN SECOND PARAM</b></p>
	 * @param allSetsToPrint make and provide a linked list containing each list/set you wish to print.
	 */
	public static <E> void printEachSet(LinkedList<String> nameOfEachList, LinkedList<E> allSetsToPrint)
	{
		for(E e : allSetsToPrint)
		{
			System.out.println(nameOfEachList.get(allSetsToPrint.indexOf(e)) +": " + allSetsToPrint.get(allSetsToPrint.indexOf(e)));
		}
	}

	//DOes this work on GitHub??
}
