package CSC300_HW4;

import java.util.Iterator;
import java.util.Random;

/**
 * <i>RandomBag</i>. This class stores a collection of items in an array and,
 * in addition to the standard methods such as add() and size(), it allows the
 * client to pick an  item randomly (and the item is removed from the bag).
 */
@SuppressWarnings("unchecked")
public class RandomBag<E> implements Iterable<E> {

  private int N;    // number of elements in bag
  private E data[]; // data storage of this bag

  private Random rand; // random number generator

  /**
   * Create an empty bag (i.e., N is 0, but data is given an array of size 1.
   */
  public RandomBag() {
    N = 0;                      // no element
    data = (E[]) new Object[1]; // but physical storage of length 1
    rand = new Random(System.currentTimeMillis()); // random number generator
  }

  /**
   * Is the BAG empty?
   */
  public boolean isEmpty() {
    return N == 0;
  }

  /**
   * Return the number of items in the bag.
   */
  public int size() {
    return N;
  }

  /**
   * Add the item to the bag.
   */
  public void add(E item) {
    if (N == data.length) {
      resizing(N * 2);
    }
    data[N++] = item;
  }

  // private support method to resize the data array.. but only to be used to EXTEND the array.
  private void resizing(int max) {
    E temp[] = (E[]) new Object[max];

    for (int i = 0; i < N; i++)
      temp[i] = data[i];

    data = temp;
  }

  /**
   * Return an iterator that iterates over the items in the bag.
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder("Len=" + data.length + ", N=" + N + ": [ ");
    for (E e : this) {
      builder.append(e); builder.append(" ");
    }
    builder.append("]");
    return builder.toString();
  }

  //
  //
  // WRITE YOUR CODE HERE
  //
  //
  
  /**
   * Shuffles the items (in 'data').  Shuffling should be done by selecting two items randomly at a time and swap them (in the array), 
   * 	and repeat the procedure for 'N' number of times (where N is the number of items stored in the array).
   */
  
  public void shuffle(){
	  
	  E temp = null;
	  
	  for(int i = 0; i < N; i++){
		  int index1 = rand.nextInt(N);
		  int index2 = rand.nextInt(N);
		  
		  temp = data[index1];	// Temporarily hold the value for data[index1]
		  data[index1] = data[index2]; // Replace the value of data[index1] with data[index2]
		  data[index2] = temp;	// Replace data[index2] with the temporary value.  
	  }
  }
  
  /**
   * Picks an element randomly and returns it.  Random selection should be done in the same way as shuffle().  
   * Before returning the item, the slot in the array for the selected item has to be 'covered' by 
   * 	shifting the remaining elements one slot to the left.
   */
  
  public E randomRemoveOne(){
	  
	  int index = rand.nextInt(N);

	  E temp = data[index];
	  
	  for(int i = index; i < data.length - 1; i++){
		  data[i] = data[i + 1];
	  }
	  N--;
	  
	  return temp;
  }

  /**
   * Trims the trailing unused space by re-allocating the array (i.e., obtaining a new array) that holds 
   * exactly N elements and transfer over the existing items to the new array (and set 'data' to the new array
   */
  
  public void trimToSize(){
	  E[] array = (E[]) new Object[N];
	  
	  for(int i = 0; i < N; i++){
		  array[i] = data[i];
	  }
	  
	  data = array;
  }
  
  //
  //
  // WRITE YOUR CODE HERE
  //
  //

  /**
   * Return an iterator that iterates over the items in the bag.
   */
  @Override
  public Iterator<E> iterator() {
    return new RandomBagIterator();
  }

  /**
   * <i>RandomBagIterator</i>.  A simple iterator which traverses the data array
   *   from the 0th to the last element (where the bag contains N elements).
   */
  private class RandomBagIterator implements Iterator<E> {

   // instance variable
    int index = 0;

    // full defition of the methods in the Iterator interface
    @Override
    public boolean hasNext() {
      return index < N;
    }

    @Override
    public E next() {
      E answer = data[index];
      index++;
      return answer;
    }

    @Override
    public void remove() { /* omitted for now */ }

  } // end RandomBagIterator

  /**
   * main()
   */
  public static void main(String[] args)
  {
    String names[ ] = {"aa", "bb", "cc", "dd", "ee", "ff", "gg"};
    RandomBag<String> rbag = new RandomBag<String>();

    for (String s : names)
      rbag.add(s); // add in the Bag

    // (1) Use an Iterator to iterate/traverse the bag
    System.out.print("Bag contains --  ");
    Iterator<String> it = rbag.iterator();
    while (it.hasNext())
    {
      String n = it.next();
      System.out.printf("%s ", n);
    }
    System.out.printf("%n");

    // (2) Shuffle the bag
    rbag.shuffle();

    // (3) Another way by the for-each syntax
    System.out.print("After shuffle -- ");
    for (String n : rbag)
      System.out.printf("%s ", n);
    System.out.printf("%n%n");

    // (4)
    for (int i = 0; i < 3; ++i) {
      String element = rbag.randomRemoveOne();
      System.out.println("Removed: " + element);
      System.out.println(rbag);
      System.out.println();
    }

    // (5) Call trimToSize(), and print the bag using toString()
    rbag.trimToSize();
    System.out.println("---------------------\nAfter trimToSize()");
    System.out.println(rbag);
    System.out.println();

  } // end main()
} // end class

/* Sample output

Bag contains --  aa bb cc dd ee ff gg
After shuffle -- ee gg cc aa ff bb dd

Removed: cc
Len=8, N=6: [ ee gg aa ff bb dd ]

Removed: gg
Len=8, N=5: [ ee aa ff bb dd ]

Removed: ff
Len=8, N=4: [ ee aa bb dd ]

---------------------
After trimToSize()
Len=4, N=4: [ ee aa bb dd ]

*/