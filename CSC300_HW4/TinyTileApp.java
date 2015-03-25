package CSC300_HW4;

public class TinyTileApp {
	
	public static void main(String[] args) {
		
		RandomBag<Tile> rbag = new RandomBag<Tile>();
		
		// Add 2, 'E' tiles
		Tile t1 = new Tile('E', 1);
		rbag.add(t1);
		rbag.add(t1);
		
		// Add 2, 'A' tiles
		Tile t2 = new Tile('A', 1);
		rbag.add(t2);
		rbag.add(t2);
		
		// Add 1 'I' tiles
		Tile t3 = new Tile('I', 1);
		rbag.add(t3);
		
		// Add 1, 'R' tiles
		Tile t4 = new Tile('R', 1);
		rbag.add(t4);
		
		// Add 1, 'C' tiles
		Tile t5 = new Tile('C', 3);
		rbag.add(t5);
		
		// Add 1, 'P' tiles
		Tile t6 = new Tile('P', 4);
		rbag.add(t6);
		
		// Add 1, 'K' tiles
		Tile t7 = new Tile('K', 5);
		rbag.add(t7);
		
		// Add 1, 'J' tiles
		Tile t8 = new Tile('J', 5);
		rbag.add(t8);
		
		Tile[] holder = new Tile[3];	// Array to hold 3 tiles.
		String chosen = "";	// String to hold letters of selected tiles.
		int total = 0;	// Total to hold running total.
		
		// Shuffle and choose one random element 3 times.
		for(int i = 0; i < 3; i++){
			rbag.shuffle();
			holder[i] = rbag.randomRemoveOne();	
		}
		
		// For each tile in the tile holder:
		//		Add letter to string holder
		//		Add value to running total
		for(Tile t : holder){
			chosen += t.getLetter();
			total += t.getValue();
		}
		
		// Print results
		System.out.println(chosen + " -- " + total);			
	}

}
