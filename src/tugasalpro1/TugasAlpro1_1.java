/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasalpro1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author laksmian
 */
public class TugasAlpro1_1{
    
    
//0	0	0	0	0	0	0	0	0
//1	1	1	0	1	0	1	1	1
//0	0	1	0	1	0	1	0	0
//0	1	1	0	1	1	1	1	0
//0	1	0	1	0	1	0	1	0
//0	1	1	1	1	1	0	1	0
//0	0	0	0	0	0	0	0	0

//
//    
//1.	Inisiasi S dengan kosong. jumlah langkah diisi 0;  
//2.	Lakukan penelusuran semua tetangga (kanan, kiri, atas, atau bawah) dalam kasus ini nilai  semua koordinat tetangga. Masukan kedalam himpunan kandidat : C
//3.	Pilih sebuah kandidat dengan fungsi (SELEKSI) dari C
//4.	Periksa apakah fungsi tersebut dapat membentuk solusi (dilakukan oleh fungsi LAYAK). Jika ya, masukan kandidat tersebut ke dalam himpunan solusi, jika tidak, buang kandidat tersebut dan tidak perlu dipertimbangkan lagi. 
//5.	Simpan semua sisa kandidat yang belum dieliminasi oleh fungsi LAYAK kedalam queue cabang
//6.	Masukan pilihan tersebut (next step) kedalam fungsi SOLUSI . Lakukan langkah tersebut jumlah langkah ditambah 1 
//7.	Ulangi langkah 2 sampai isian fungsi SOLISI adalah koordinat END

/*
    
jalan terus, kalau nemu cabang baru masuk himpunan C    
    
    */    
      

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        
        
        // TODO code application logic here
        Maze maze = new Maze(); //inisialisasi maze
        System.out.println("-------------------------------------- BRUTE FORCE --------------------------------------");
        long brute1 = System.nanoTime();
        BruteForce b = new BruteForce();
        long brute2 = System.nanoTime();
        long bruteTimeTaken = brute2 - brute1;  
        System.out.println("Time taken Brute Force " + bruteTimeTaken + " ns");
        
       
        System.out.println("-------------------------------------- GREEDY --------------------------------------");
        long greedytime1 = System.nanoTime();
        Greedy greedy = new Greedy();
        
        greedy.cariSolusi(Maze.startBaris, Maze.startKolom,1, maze);

        Iterator it = greedy.himpunansolusi.iterator();
        while(it.hasNext()){
            String[] tempString = new String[3];
            String value = it.next().toString();
            
            tempString = value.split(",");
            System.out.println("["+tempString[0]+"]["+tempString[1]+"], arah : " + Maze.ambilArahNominal(Integer.parseInt(tempString[2])));
        }
        long greedytime2 = System.nanoTime();
        long greedyTimeTaken = greedytime2 - greedytime1;  
        System.out.println("Time taken Greedy " + greedyTimeTaken + " ns");
        
  
        System.out.println("-------------------------------------- BFS --------------------------------------");
        long BFStime1 = System.nanoTime();
        BFS bfstree = new BFS();
        Tree t = new Tree();
        
        
        bfstree.generateBFSTree(t, maze);
        t.BFSTraversal(t);
        long BFStime2 = System.nanoTime();
        long BFSTimeTaken = BFStime2 - BFStime1;  
        System.out.println("Time taken BFS " + BFSTimeTaken + " ns");
        System.out.println("-------------------------------------- DFS --------------------------------------");
        long DFS1 = System.nanoTime();
        DFS rat = new DFS();
        long DFS2 = System.nanoTime();
        long DFSTimeTaken = DFS2 - DFS1;
        System.out.println("Time taken DFS " + DFSTimeTaken + " ns");
        
        System.out.println("-------------------------------------- Backtracking --------------------------------------");
        long backtrack1 = System.nanoTime();
        Backtrack backtrack = new Backtrack();
        long backtrack2 = System.nanoTime();
        long backtrackTimeTaken = backtrack2 - backtrack1;
        System.out.println("Time taken Backtrack " + backtrackTimeTaken + " ns");
        
        System.out.println("-------------------------------------- Branch and Bound --------------------------------------");
        long BBtime1 = System.nanoTime();
        BranchAndBound branchAndBound = new BranchAndBound();
        Tree treeBranchandBound = new Tree();
        
        
        branchAndBound.generateBranchAndBoundTree(treeBranchandBound, maze);
        treeBranchandBound.BranchAndBoundTraversal(treeBranchandBound);
        long BBtime2 = System.nanoTime();
        long BBTimeTaken = BBtime2 - BBtime1;  
        System.out.println("Time taken Branch and Bound " + BBTimeTaken + " ns");
    }
    
   
    
    
}
