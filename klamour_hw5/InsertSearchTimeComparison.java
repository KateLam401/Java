package _requirements.part1;
import java.util.*;

public class InsertSearchTimeComparison {

    public static void main(String args[]){

        HashMap<Integer,String> myMap = new HashMap<>();
        ArrayList<Integer> myArrayList = new ArrayList<>();
        LinkedList<Integer> myLinkedList = new LinkedList<>();
        long startTime,endTime,elapsedTime;

        Random r = new Random(1000000);

        int a[] = new int[100000];
        for(int i = 0; i < a.length; i++){
            a[i] = r.nextInt(1000000) + 1;
        }

        System.out.println("Number of Keys : " + a.length);
        startTime = System.currentTimeMillis();
        
        for(int i = 0; i < a.length; i++){
            myMap.put(a[i],"1");
        }
        
        endTime = System.currentTimeMillis();
        elapsedTime = endTime-startTime;
        System.out.println("Hashmap average total insert time : " + elapsedTime);

        startTime = System.currentTimeMillis();
        
        for(int i = 0; i < a.length; i++){
            myArrayList.add(a[i]);
        }
        
        endTime = System.currentTimeMillis();
        elapsedTime = endTime-startTime;
        System.out.println("Arraylist average total insert time : " + elapsedTime);

        startTime = System.currentTimeMillis();
        
        for(int i = 0; i < a.length; i++){
            myLinkedList.add(a[i]);
        }
        
        endTime = System.currentTimeMillis();
        elapsedTime = endTime-startTime;
        System.out.println("LinkedList average total insert time : " + elapsedTime);

        r.setSeed(2000000);

        for(int i = 0 ; i < 100000 ; i++){
            a[i] = r.nextInt(2000000) + 1;
        }

        startTime = System.currentTimeMillis();
        
        for(int i=0 ; i < a.length; i++){
            myMap.containsKey(a[i]);
        }
        
        endTime = System.currentTimeMillis();
        elapsedTime = endTime-startTime;
        System.out.println("Hashmap average total search time : " + elapsedTime);

        startTime = System.currentTimeMillis();
        
        for(int i = 0; i < a.length; i++){
            myArrayList.contains(a[i]);
        }
        
        endTime = System.currentTimeMillis();
        elapsedTime = endTime-startTime;
        System.out.println("Arraylist average total search time : " + elapsedTime);

        startTime = System.currentTimeMillis();
       
        for(int i = 0 ; i< a.length; i++){
            myLinkedList.contains(a[i]);
        }
        
        endTime = System.currentTimeMillis();
        elapsedTime = endTime-startTime;
        System.out.println("LinkedList average total search time : " + elapsedTime);
    }

}