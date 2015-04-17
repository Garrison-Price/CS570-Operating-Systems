

public class PageTable {
	public int levelCount;		//Number of levels in page table
	public int[] bitmasks;		//Bitmask for each level of page table
	public int[] shifts;		//Shift for each level of page table
	public int[] entryCounts;	//Number of entries for each level
	
	private Level rootNode;		//Root level node
	
	public PageTable(int numLevels, int[] bitsPerLevel) {
		levelCount = numLevels;
		shifts = new int[levelCount];
		entryCounts = new int[levelCount];
		bitmasks = new int[levelCount];
		
		shifts[levelCount-1] = bitsPerLevel[levelCount-1];
		entryCounts[levelCount-1] = (int)Math.pow(2, bitsPerLevel[levelCount-1]);
		bitmasks[levelCount-1] = entryCounts[levelCount-1]<<shifts[levelCount-1];
		
		for(int i = levelCount - 2; i >= 0; i--) {
			shifts[i] = bitsPerLevel[i] + shifts[i+1];
			entryCounts[i] = (int)Math.pow(2, bitsPerLevel[i]);
			bitmasks[i] = entryCounts[i]<<shifts[i];
		}
	}
}
