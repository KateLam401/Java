import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class project {

    private static Scanner input = new Scanner(System.in);
    private static ArrayList<String> nodes = new ArrayList<>();
    
    private static HashMap<String, Integer> distance = new HashMap<>();
    private static HashMap<String, Integer> inputMap = new HashMap<>();
    private static String[][] matrix = null;
    
    public static void main(String[] args) {
        
    	readFiles();     
        // get starting node
        // and run algorithms
        getStartNode();
         
    }
    

    public static void getStartNode() {
    	
    	// prompt the user to enter the start node
    	System.out.println("Enter the start node: ");
        String inputNode = input.nextLine();
        
        // check the validity of the user-entered start node
        if (nodes.contains(inputNode.toUpperCase())) {
        	runAlgorithms(inputNode.toUpperCase());}
        
        else {
        	// if the input is invalid, prompt the user for input again
        	System.out.println("Invalid node. Please try again.\n");
        	getStartNode();}
        
    }


    public static void runAlgorithms(String input) {
        
        //initialize Algorithm1
        AlgorithmOne alg1 = new AlgorithmOne(input, distance, inputMap);
        alg1.getShortestDistance();
        
        //initialize Algorithm2
        AlgorithmTwo alg2 = new AlgorithmTwo(input, distance, inputMap);
        alg2.getShortestDistance();
        
    }
    
    
    public static void readFiles() {
        String file1 = "direct_distance.txt"; String file2 = "graph_input.txt"; //store file names
        FileReader fr1 = null; FileReader fr2 = null; //initiate file readers
        try { fr1 = new FileReader(file1); fr2 = new FileReader(file2); }
        catch (FileNotFoundException e) {e.printStackTrace();}
        BufferedReader br1 = new BufferedReader(fr1); BufferedReader br2 = new BufferedReader(fr2); //initiate buffered reader
        
        try { String line;
        
        int row = 0; int column = -1; int x = 0; int y = 1;
        
	        //read graph file
	        while ((line = br2.readLine()) != null) {
	            String[] values = line.split("\\s+");
	            if (matrix == null) {
	            	matrix = new String[column = values.length][row = values.length];}
	            for (int i = 0; i < values.length; i++) {
	            	matrix[i][x] = values[i];} //insert graph into matrix
	            x++;}
        
        	//read distance file
            while ((line = br1.readLine()) != null) {
                StringBuilder num = new StringBuilder(); StringBuilder str = new StringBuilder(); //initiate string builders
                for (char c : line.toCharArray()) {
                    if (Character.isLetter(c)) {str.append(c);}
                    else if (Character.isDigit(c)) {num.append(c);}                    }
                distance.put(str.toString(), Integer.parseInt(num.toString()));} //combine stings and nums into distance hash map
            
            while (y < row) {
                nodes.add(matrix[0][y]); //add the matrix to the notes array
                for (int i = 1; i < column; i++) {
                    StringBuilder str = new StringBuilder();
                    str.append(matrix[0][y]);
                    str.append(matrix[i][0]);
                    int inputValue = Integer.parseInt(matrix[i][y]);
                    if (inputValue > 0) {inputMap.put(str.toString(), inputValue);} //add notes and matrix to the input map
                } y++;}   
        
        } catch (IOException e) {}}

}