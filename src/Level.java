
public class Level {
	public Level[] levels;
	public Map[] maps;
	private PageTable pageTable;
	private int levelDepth;

	public Level(PageTable pt, int depth) {
		pageTable = pt;
		levelDepth = depth;
		
		if(pageTable.levelCount-1 > levelDepth) 
			levels = new Level[pageTable.entryCounts[levelDepth]];
		else
			maps = new Map[pageTable.entryCounts[levelDepth]];
	}
}
