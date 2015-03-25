package CSC300_HW5;

import java.util.Iterator;

public class LinkedList<E extends Comparable<E>> implements Iterable<E>
{
  // instance data members of list
  private Node head; // reference to the first node
  private int N;     // number of elements stored in the list

  /*******************
   * nested class Node
   *******************/
  private class Node
  {
    // instance data members of Node
    public E item;
    public Node next;

    // constructors for Node
    public Node()
    {
      item = null;  next = null;
    }

    public Node(E e, Node ptr)
    {
      item = e;  next = ptr;
    }
  }// end class Node

  /***************************
   * nested class ListIterator
   ***************************/
  private class ListIterator implements Iterator<E>
  {
    // instance data member of ListIterator
    private Node current;

    // constructors for ListIterator
    public ListIterator()
    {
      current = head; // head in the enclosing list
    }

    public boolean hasNext()
    {
      return current != null;
    }

    public E next()
    {
      E ret = current.item;
      current = current.next;
      return ret;
    }

    public void remove() { /* omitted because optional */ }

  }// end class ListIterator

  /***** back to class LinkedList *******/
  public LinkedList()
  {
    head = null; N = 0;
  }

  public Iterator<E> iterator( )
  {
    return new ListIterator();
  }

  public void add(E e)
  {
    // This code will be edited during the class.
    // For now, it pushes a new node in the front.
    // But first check the parameter is null.. if so, throw an exception.
    if (e == null)
      throw new NullPointerException();

    // For now, the element is pushed in the front, and N is incremented.
    head = new Node(e, head);
    ++N;
  }

  public void remove(E e)
  {
    // This code will be edited during the class.
    // Removes the node with the parameter item if it exists, and decrements N.
    // Does nothing if the item doesn't exist, or the list is empty.
    // Throws a NullPointerException if the parameter item is null.
    if (e == null)
      throw new NullPointerException();

    // special cases first
    if (head == null) // or N == 0 (empty list)
      return;
    else if (head.item.equals(e)) // fist node has e
    {
      head = head.next; // head jump over the first node (regardless of the length)
      N--;
    }
    else
    {
      // general case (list with one or more nodes)
      // using two references (forward-going ptr and trailing prev)
      Node ptr, prev;
      for (ptr = head, prev = null; ptr != null; prev = ptr, ptr = ptr.next) // traverse within the list
      {
        if (ptr.item.equals(e)) // if node pointed by ptr has e
        {
          // prev must point to a non-null node
          prev.next = ptr.next; // make it jump over the next node
          N--;   // decrement N
          break; // break out of the loop
        }
      }
    }
  }

  public boolean isEmpty() { return N == 0; }
  public int size() { return N; }

  //********************************************
  //  WRITE YOUE CODE BELOW
  //********************************************

  
  /**
   * Appends the specified/parameter element to the end of this list.
   * If the parameter is null, the method throws a NullPointerException (and returns).
   * After the successful insertion, the method also increments N (the number of elements in the list).
   */
  
  public void append(E item)
  {
    Node temp = new Node();
    temp.item = item;
    
    Node ptr = head;
    
    if(item == null){
    	throw new NullPointerException();
    }
    else if(head == null){
    	head = temp;
    }
    else{
    	while(ptr.next != null){
    		ptr = ptr.next;
    	} ptr.next = temp;
    }
    
    N++;
  }

  /**
   * Returns true if this list contains the specified element, or false otherwise.
   * If the parameter is null, the method throws a NullPointerException (and returns).
   * The comparison was done using equals().
   */
  
  public boolean contains(E item)
  {
	  Boolean tf = false;
	  Node ptr = head;
	  
	  if(item == null){
		  throw new NullPointerException();
	  }
	  else{
		  for(ptr = head; ptr != null; ptr = ptr.next){
			  if(ptr.item.equals(item)){
				  tf = true;
			  }
		  }
	  }	  
	  return tf;  
  }
  
  /**
   * Removes the element at the specified position in this list (and decrements N).
   * The position (k) is a 0-based index.
   * The method also throws an IndexOutOfBoundsException if the index is out of range (k < 0 || k >= size()).
   */

  public E get(int k)
  {
	Node ptr = head;
	E item;
	
	if(k < 0 || k > size()){
		throw new IndexOutOfBoundsException();
	}
	else{
		
		for(int i = 0; i < k; i++){
			ptr = ptr.next;
		}
		
		item = ptr.item;
	}
	
	return item;
  }
  
  /**
   * Removes the element at the specified position in this list (and decrements N).  
   * The position (k) is a 0-based index.
   * The method also throws an IndexOutOfBoundsException if the index is out of range (k < 0 || k >= size()).
   */

  public void removeAt(int k)
  {
    Node ptr = head;
    Node prev = null;
    
    if(k < 0 || k > size()){
    	throw new IndexOutOfBoundsException();
    }
    else{
    	for(int i = 0; i < k; i++){
    		prev = ptr;
    		ptr = ptr.next;
    	}	
    	
    	prev.next = ptr.next;	// "Skip" over the index's value.
    	N--;
    }
  }

  /**
   * Sets head to null and N to 0.
   */
  
  public void clear()
  {
    head = null;
    N = 0;
  }
   
  /**
   * main()
   */
  public static void main(String[] args)
  {
    String names[ ] = {"Uno", "Dos", "Tres", "Cuatro", "Cinco"};
    LinkedList<String> lst = new LinkedList<String>();

    for (String s : names)
      lst.add(s); // add in the Bag

    // (1) Use an Iterator to iterate/traverse the bag
    System.out.print("Print using iterator --  ");
    Iterator<String> it = lst.iterator();
    while (it.hasNext())
    {
      String n = it.next();
      System.out.printf("%s ", n);
    }
    System.out.printf("%n%n");

    // (2) Another way by the for-each syntax
    System.out.print("Print using foreach  --  ");
    for (String n : lst)
      System.out.printf("%s ", n);
    System.out.printf("%n%n");

    try {
      lst.add(null);
    } catch (NullPointerException exp)
    {
      System.out.println("NullPointerException thrown");
    }

  } // end main
} // end class

/* Output

Print using iterator --  Cinco Cuatro Tres Dos Uno

Print using foreach  --  Cinco Cuatro Tres Dos Uno
NullPointerException thrown

*/

