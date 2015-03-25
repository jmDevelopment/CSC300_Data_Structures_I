package CSC300_HW5;

public class LLTest<E>{
	
	public static void main(String[] args) {
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.add(3);
		test.add(2);
		test.add(1);
		
		System.out.println("**APPEND TEST**");
		test.append(4);
		test.append(5);
		try{
			test.append(null);	
		} catch (NullPointerException exp){
			System.out.println("NullPointerException thrown");
		}
		System.out.print("Print using foreach  --  ");
	    for (int n : test)
	      System.out.printf("%s ", n);
	    System.out.println("Linked List size: " + test.size());
	    System.out.println();
		
	    System.out.println("**CONTAINS TEST**");
		System.out.println("Test contains 4: " + test.contains(4));
		System.out.println("Test contains 1: " + test.contains(1));
		try{
			System.out.println(test.contains(null));	
		} catch(NullPointerException exp){
			System.out.println("NullPointerException thrown");
		}
		System.out.print("Print using foreach  --  ");
	    for (int n : test)
	      System.out.printf("%s ", n);
	    System.out.println("Linked List size: " + test.size());
	    System.out.println();
		
		System.out.println("**GET TEST**");
		System.out.println("The item at position 2 is: " + test.get(2));
		System.out.println("The item at position 0 is: " + test.get(0));
		try{
			System.out.println(test.get(98));
		} catch(IndexOutOfBoundsException exp){
			System.out.println("IndexOutOfBoundsException was thrown");
		}
		System.out.print("Print using foreach  --  ");
	    for (int n : test)
	      System.out.printf("%s ", n);
	    System.out.println("Linked List size: " + test.size());
	    System.out.println();
		
		System.out.println("**REMOVE TEST**");
		test.removeAt(3);
		test.removeAt(2);
		try{
			test.removeAt(54);
		} catch(IndexOutOfBoundsException exp){
			System.out.println("IndexOutOfBoundsException was thrown");
		}
		System.out.print("Print using foreach  --  ");
	    for (int n : test)
	      System.out.printf("%s ", n);
	    System.out.println("Linked List size: " + test.size());
	    System.out.println();
	
		test.clear();
		
		System.out.print("Print using foreach  --  ");
	    for (int n : test)
	      System.out.printf("%s ", n);
	    System.out.println();
	    System.out.println("Linked List size: " + test.size());
	}

	

}
