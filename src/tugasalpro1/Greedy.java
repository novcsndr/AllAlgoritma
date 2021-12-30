/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasalpro1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 *
 * @author laksmian
 */
public class Greedy {
    
    static Stack<String> stackHimpunanC;
    
    static List<String> himpunansolusi;

    public Greedy(){
        stackHimpunanC = new Stack<>();
        himpunansolusi =  new ArrayList<>();
    }
    
    
     public static String fungsiSeleksi(){
    
        Stack<String> tempStack = (Stack<String>)stackHimpunanC.clone();
    
        
        int min = Maze.endKolom+Maze.endKolom; // ambil nilai maksimal
        
        String solution = "";
        while (!tempStack.isEmpty()){
            String tempString = tempStack.pop();
            
            String[] tempKoordinat = new String[3];
            tempKoordinat = tempString.split(",");
            
            int baris = Integer.parseInt(tempKoordinat[0]);
            int kolom = Integer.parseInt(tempKoordinat[1]);
            int nextStep = Math.abs(Maze.endBaris-baris) + Math.abs(Maze.endKolom-kolom);
            
            if (nextStep < min){
                min = nextStep;
                solution = tempString;      
            }    
        }
           
        return solution;
    }
    
    
    
    public static boolean fungsiLayak(String nextPosisition, Maze mazeobj){
        String[] temp = new String[3]; 
        temp =  nextPosisition.split(",");
        int barisNext = Integer.parseInt(temp[0]);
        int kolomNext = Integer.parseInt(temp[1]);
        
        
        
        if(barisNext < 0 || kolomNext<0 || barisNext > mazeobj.getMaxBaris() || kolomNext > mazeobj.getMaxKolom()){
            return false;
        }else{
            return(mazeobj.isNotTembok(barisNext, kolomNext));
        }
    }    
    

    


    public static void cariSolusi(int baris, int kolom, int arah, Maze maze){

        int koordinatbaris = baris;
        int koordinatkolom = kolom;
        int arahsebelum = 1;
        
        boolean solution = Maze.isSolution(koordinatbaris, koordinatkolom);
        Maze.ambilArrah(stackHimpunanC, koordinatbaris, koordinatkolom, arahsebelum);
        
        while (!stackHimpunanC.isEmpty() && !solution){
            String temp = fungsiSeleksi();
            stackHimpunanC.remove(temp);
            if (fungsiLayak(temp, maze)){
                himpunansolusi.add(temp);
                
                
                String[] tempKoordinat = new String[3];
                tempKoordinat = temp.split(",");
                int nextbaris = Integer.parseInt(tempKoordinat[0]);
                int nextkolom = Integer.parseInt(tempKoordinat[1]);
                int arahAsal = Integer.parseInt(tempKoordinat[2]);
               
               
                
                koordinatbaris = nextbaris;
                koordinatkolom = nextkolom;
                
                solution = Maze.isSolution(koordinatbaris, koordinatkolom);
                if(!solution){
                    Maze.ambilArrah(stackHimpunanC, koordinatbaris, koordinatkolom, Maze.cekArahSebelum(arahAsal));
                }
               
                
            }
            
        }
               
    }
    
    

     
}
