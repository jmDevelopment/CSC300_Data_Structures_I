package CSC300_HW4;

public class Tile {
	
	private char Letter;
	private int Value;
	
	public static void main(String[] args){
		
		Tile tileOne = new Tile('K', 5);
		Tile tileTwo = new Tile('X', 8);
		
		System.out.println(tileOne.toString());
		System.out.println(tileTwo.toString());
	}	// END MAIN
	
	public Tile(char let, int val){
		Letter = let;
		Value = val;
	}
	
	public char getLetter(){
		return Letter;
	}
	
	public int getValue(){
		return Value;
	}
	
	public String toString(){
		
		String result = getLetter() + "," + getValue();
		return result;
	}

}
