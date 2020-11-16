import java.util.ArrayList;
import java.util.HashMap;

public class AlgorithmTwo extends adjacencyGraph {
    
	// Constructor
    public AlgorithmTwo(String vertex, HashMap<String, Integer> distance, HashMap<String, Integer> inputMap) {
        this.vertex = vertex; //userInput is the vertex
        this.distance = distance; //distance from distance file
        this.inputMap = inputMap;} //map from graph file
    
    public void getShortestDistance() {getDistance(this.vertex);}    

    public void getDistance(String vertex) {
        String vertexSet = getShortestSetAlgTwo(vertex);

        if (vertex.equals("Z")) {  
            this.last = vertex;
            trace.add(last);
            noTrace.add(last);}

        else if (vertexSet == null && !vertex.equals("Z")) {
            this.trace.remove(last);
            this.last = trace.get(trace.size() - 1);
            this.noTrace.add(last);
            shortestDistance -= inputMap.get(finalSet);}
        
        else {
            finalSet = vertexSet;
            char currentSet[] = vertexSet.toCharArray();
            last = Character.toString(currentSet[1]);

            for (char c : currentSet) {
                if (!this.usedPath.contains(Character.toString(c))) {
                    this.usedPath.add(Character.toString(c));}}

            if (!trace.isEmpty()) {
                trace.add(last);} 
            
            else {trace.add(vertex); trace.add(last);}
            
            if (!noTrace.isEmpty()) {
                noTrace.add(last);} 
            
            else {noTrace.add(vertex); noTrace.add(last);}
            
            shortestDistance += inputMap.get(vertexSet);    
        }

        if (last.equals("Z")) {
        	
        	System.out.println("\nAlgorithm 2:");
            System.out.println("Sequence of all nodes: " + printPathNodes(this.noTrace));
            System.out.println("Shortest path: " + printPathNodes(this.trace));
            System.out.println("Shortest path length: " + printPathDistance());
            System.out.println(" ");
        }

        else {getDistance(last);}
        
    }
    
    private String getShortestSetAlgTwo(String vertex) {
        ArrayList<String> adjacent = getAdjacentSet(vertex);
        
        String shortestSet = null;
        int maxValue = 9999999;
        char c2[] = null;

        for (String s : adjacent) { 
            c2 = s.toCharArray();       
            if ((distance.get(Character.toString(c2[1])) + inputMap.get(s)) < maxValue
                    && !this.usedPath.contains(Character.toString(c2[1]))) {
                maxValue = distance.get(Character.toString(c2[1])) + inputMap.get(s);
                shortestSet = s;}}        
        return shortestSet;
    }
    
}
