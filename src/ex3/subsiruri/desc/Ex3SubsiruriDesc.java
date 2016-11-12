/***************************************
 * Decomposition in minimal number of descending subarrays(Descompunere in subsiruri descrescatorare) 
 * @author: Ioana-Sofia Pascu
 * Faculty of Mathematics and Computer Science, University of Bucharest
 * Created: 11/11/2016
***************************************/
package ex3.subsiruri.desc;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex3SubsiruriDesc {
    
    static int n;//number of elements
    static int[] arr;//array of elements
    static int nrS;//number of subarrays
    static int[] top;//holds the top of every subarray (the minimal element)
    static int[] s;//s[i] is the index of the subarray x[i] belongs to
    static ArrayList<Integer>[] subarr;//holds the subarrays as we need to print them at the end
    
    static void read(){//reads the data
        try{
            Scanner sc = new Scanner (new File("date.in"));
            n = sc.nextInt();
            arr = new int[n];
            s = new int[n];
            top = new int[n];
            subarr = new ArrayList[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();           
        }
        catch(Exception FileNotFoundException){
            System.out.println("Fisier inexistent!");
        }
    }
    
    //we use binary search and return the index of the subarray where we should put 'what', or -1 if we don't find any
    static int search(int s, int f, int what){
        boolean found = false;
        int mid = -1;
        while(s <= f && found == false){
            mid = (s + f)/2;
            if (top[mid] == what) found = true;
            else
                if (top[mid] < what) s = mid + 1;
                else f = mid - 1;
        }
        if (found == true) return mid; //if we have an element equal to 'what' we will place it in the same subarray as they do not have to be strictly descending
        else
            if(s <= nrS && top[s] > what)
                return s;
        return -1;
                
    }
    
    static void buildSubarrays(){
        int sub;
        
        nrS = 0;
        s[nrS] = 0;
        subarr[0] = new ArrayList<>();
        subarr[0].add(arr[0]);
        top[nrS] = arr[0];
        
        for (int i = 1; i < n; i++){
            sub = search(0, nrS, arr[i]);//sub will be the index of the subset where we will put arr[i]
            if (sub == -1){//if we haven't found a subarray arr[i] will start a new one
                nrS++;
                s[i] = nrS;
                top[nrS] = arr[i];
                subarr[nrS] = new ArrayList<>();
                subarr[nrS].add(arr[i]);
            }
            else {//arr[i] will be added to an existent subarray
                s[i] = sub;
                top[sub] = arr[i];//we update the minimal element in the subarray
                subarr[sub].add(arr[i]);
            }
        }
    } 
    
    static void print(){
        try{
            PrintStream printer = new PrintStream(new File("date.out"));
            for (int i = 0; i <= nrS; i++){
                //System.out.print((i + 1) + ": ");
                for (int j = 0; j < subarr[i].size(); j++)
                    printer.print(subarr[i].get(j) + " ");
                printer.println();
            }
        }
        catch(Exception FileNotFoundException){
            System.out.println("Fisier inexistent!");
        }
    }
    
    public static void main(String[] args) {
        read();
        buildSubarrays();
        print();
    }   
}
