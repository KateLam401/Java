package _requirements.part1;
import java.io.*;
import java.util.*;

public class ProcessScheduling {
	
	protected static class Process {
		private int id; // process id
		private int pr; // priority of the process
		private int duration = 0; // execution of the process takes this amount of time
		private int arrivalTime = 0; // the time when the process arrives at the system
	
		public Process(){
			id = 0;
			pr = 0;
			duration = 0;
			arrivalTime = 0;
		};
		public Process(int id, int pr, int duration, int arrivalTime){  // (K,V)
			this.id = id;
			this.pr = pr;
			this.duration = duration;
			this.arrivalTime = arrivalTime;
		};
		
		public int getPr() {return pr;}
		public int getId() {return id;}
		public int getDuration() {return duration;}
		public int getArrivalTime() {return arrivalTime;}
		
		public void setPr(int pr) {this.pr = pr;}
		public void setId(int id) {this.id = id;}
		public void setDuration(int duration) {this.duration = duration;}
		public void setArrivalTime(int arrivalTime) {this.arrivalTime = arrivalTime;}
		
		public String toString(){
			String s = new String();
			s += "id = " + id + "; ";
			s += "pr = " + pr + "; "; 
			s += "duration = " + duration + "; ";
			s += "arrivalTime = " + arrivalTime + "; ";
			return s;
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		HeapPriorityQueue<Integer, Process> Q = new HeapPriorityQueue<>();
		ArrayList<Process> D = new ArrayList<>();
		
		String[] line = new String[] {};
		Scanner textScanner = new Scanner (new File(
				"src/_requirements/part1/process_scheduling_in.txt"));		
		while (textScanner.hasNext()){
			line = textScanner.nextLine().split("\\s+");
			D.add(new Process(
					Integer.parseInt(line[0]), 
					Integer.parseInt(line[1]), 
					Integer.parseInt(line[2]), 
					Integer.parseInt(line[3])));}
		
//		System.out.println("All file input in Array:");
//        for (var d: D) {
//        	System.out.println(d.toString());}   
      
        int currentTime = 0;
        int waitTime = 0;
        int totalWaitTime = 0;
        boolean running = false;
        Entry<Integer, Process> runningProcess = null;
        int processTimeStamp = 0;
        
        while (D.isEmpty() == false) {
	        for (int index = 0; index < D.size(); index++) {
	        	Process p = D.get(index);
	        	if (p.getArrivalTime() <= currentTime) {
	        		Q.insert(p.getPr(), p);	        		
	        		D.remove(index);}
		        if (Q.isEmpty() == false && running == false) {
		        	runningProcess = Q.removeMin();
		        	running = true;
		        	processTimeStamp = currentTime;
		        	waitTime = currentTime + runningProcess.getValue().getDuration() - runningProcess.getValue().getArrivalTime();
		        	totalWaitTime = totalWaitTime + waitTime;
		        	if (waitTime < 0) {
		        		waitTime = 0;
		        	}
		        	if (totalWaitTime < 0) {
		        		totalWaitTime = 0; 
		        	}
		        	System.out.println("Process removed from queue is: id = " + runningProcess.getValue().getId()
		        			+ ", at time " + currentTime
		        			+ ", at wait time = " + waitTime 
		        			+ ", Total wait time = " + totalWaitTime);
		        	System.out.println("Process id = " + runningProcess.getValue().getId());
		        	System.out.println("Priority = " + runningProcess.getValue().getPr());
				    System.out.println("Arrival = " + runningProcess.getValue().getArrivalTime());
				    System.out.println("Duration = " + runningProcess.getValue().getDuration());}
				    currentTime++;
				
			   if (runningProcess != null && (processTimeStamp + runningProcess.getValue().getDuration()) == currentTime) {
				   running = false;
				   System.out.println("Process " + runningProcess.getValue().getId() + " finished at time " + currentTime + "\n");}
		   }
       }
        
       System.out.println("\nD becomes empty at time " + currentTime + "\n");
       
	   while (Q.isEmpty() == false) {
		   if (running == false) {
	        	runningProcess = Q.removeMin();
	        	running = true;
	        	processTimeStamp = currentTime;
	        	waitTime = currentTime + runningProcess.getValue().getDuration() - runningProcess.getValue().getArrivalTime();
	        	totalWaitTime = totalWaitTime + waitTime;
	        	if (waitTime < 0) {
	        		waitTime = 0;
	        	}
	        	if (totalWaitTime < 0) {
	        		totalWaitTime = 0; 
	        	}
	        	System.out.println("Process removed from queue is: id = " + runningProcess.getValue().getId()
	        			+ ", at time " + currentTime
	        			+ ", at wait time = " + waitTime 
	        			+ ", Total wait time = " + totalWaitTime);
	        	System.out.println("Process id = " + runningProcess.getValue().getId());
	        	System.out.println("Priority = " + runningProcess.getValue().getPr());
			    System.out.println("Arrival = " + runningProcess.getValue().getArrivalTime());
			    System.out.println("Duration = " + runningProcess.getValue().getDuration());}
			    currentTime++;
		   
		   if ((processTimeStamp + runningProcess.getValue().getDuration()) == currentTime) {
			   running = false;
			   System.out.println("Process " + runningProcess.getValue().getId() + " finished at time " + currentTime + "\n");}
	   }
	   
	   System.out.println("Process " + runningProcess.getValue().getId() + " finished at time " + currentTime + "\n");
	   System.out.println("Total wait time = " + totalWaitTime);
	   System.out.println("Average wait time = " + (totalWaitTime / 10));
 }
}