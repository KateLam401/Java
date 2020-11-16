import java.util.ArrayList;
import java.util.HashMap;

public class adjacencyGraph {	
	public String vertex;
	public HashMap <String, Integer> distance;
	public HashMap <String, Integer> inputMap;	
	public String finalSet; 
	public String last;	//last vertex
	public ArrayList <String> trace = new ArrayList <>();
	public ArrayList <String> noTrace = new ArrayList <>();
	public ArrayList <String> usedPath = new ArrayList <>();
	public int shortestDistance = 0;
	
	// Constructor
	public adjacencyGraph(){}

	public ArrayList<String> getAdjacentSet(String vertex) {
		ArrayList <String> keys = new ArrayList<>();
		keys.addAll(inputMap.keySet());	
		ArrayList <String> adjacent = new ArrayList<>();		
		for (String key: keys){
			char c[] = key.toCharArray(); // find the ones that are adjacent to the input vertex
			String vertex1 =  Character.toString(c[0]);			
			if (vertex1.equals(vertex)){
				adjacent.add(key);}}
		return adjacent;}
	
	public String printPathNodes (ArrayList <String> sequence){		
		StringBuilder sb = new StringBuilder();
		int finalElement = sequence.size()-1;		
		for (int i = 0; i < sequence.size(); i++){		
			if (i == finalElement) {sb.append(sequence.get(i));}
			else {sb.append(sequence.get(i) + " -> ");}}
		return sb.toString();}	
	
	public int printPathDistance(){
		return shortestDistance;}
	
}
