/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasalpro1;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import javax.swing.tree.TreeNode;
import static tugasalpro1.BFS.lastcounter;

/**
 *
 * @author laksmian
 */
public class BranchAndBound {
    
    static int lastcounter;
    static int level;
    private static  Queue<Node> queuetogenerate = new LinkedList<>();
    
    public void generateBranchAndBoundTree(Tree t, Maze maze){
        
        Node rootnode = new Node();
        boolean solution = false;
        
        
        String value = (String.valueOf(Maze.startBaris) +","+ String.valueOf(Maze.startKolom) +","+"2");
        lastcounter = 0;
       
        
        rootnode.setParent(null);
        rootnode.setLevel(0);
        rootnode.setValue(value);
        rootnode.setKeyIndex(lastcounter);
        rootnode.setCost(0);
        
        t.root = rootnode;
        
        queuetogenerate.add(rootnode);
       
        
        while (!queuetogenerate.isEmpty() && !solution){
            solution = generateChildernWithMinCost();
        }    
    }
    
    
    public boolean generateChildernWithMinCost(){
        //copy all pointers
        boolean solution = false;
        
        Queue<Node> pointerMin = new LinkedList<>(queuetogenerate);
        
        int min = 999; // ambil nilai maksimal
        int tempMin;
        Node tempNode;
        Node nodeToGenerate = null;
        
        while (!pointerMin.isEmpty()){
            
           
            tempNode = pointerMin.poll();
            tempMin = tempNode.getCost();
            
            if (tempMin < min){
                min = tempMin;
                nodeToGenerate = tempNode;
            }    
        }
        
        String[] tempKoordinat = new String[3];
        tempKoordinat = nodeToGenerate.getValue().split(",");
        
        int baris = Integer.valueOf(tempKoordinat[0]);
        int kolom = Integer.valueOf(tempKoordinat[1]);
        
        solution = Maze.isSolution(baris, kolom);
        
        if(!solution){
            generateChildren(nodeToGenerate);
            queuetogenerate.remove(nodeToGenerate);

        }
        
        
        return solution;
    }
    
    
    private void generateChildren(Node node){
        
        List<Node> children = new ArrayList<>();
        
        //untuk  ambil arah
        List<String> nextarah = new ArrayList<>();
        
        String[] tempKoordinat = new String[3];
        tempKoordinat = node.getValue().split(",");
        
        int baris = Integer.valueOf(tempKoordinat[0]);
        int kolom = Integer.valueOf(tempKoordinat[1]);
        int arah = Integer.valueOf(tempKoordinat[2]);
        
        nextarah = Maze.ambilArahList(baris, kolom, Maze.cekArahSebelum(arah));
    
        //
        
        
        
        int levelParent = node.getLevel();
        int keyParent = node.getKeyIndex();
        int childLevel = levelParent+1;
        String childvalue;
        
        Iterator it = nextarah.iterator();
        while (it.hasNext()){
            childvalue = it.next().toString();
            
            Node child = new Node();
            child.setParent(node);
            child.setLevel(childLevel);
            child.setValue(childvalue);
            lastcounter++;
            child.setKeyIndex(lastcounter);
            child.setChildren(null);
            child.setCost(fungsiHitungBobot(childvalue, childLevel));
            
            children.add(child);
           
            
            queuetogenerate.add(child);
            
            
        }
        
        node.setChildren(children);
    }
    
  
    
    
    public int fungsiHitungBobot(String value, int level){
        
        
        String[] tempKoordinat = new String[3];
        tempKoordinat = value.split(",");
        int baris = Integer.parseInt(tempKoordinat[0]);
        int kolom = Integer.parseInt(tempKoordinat[1]);
        
        if(!Maze.isNotTembok(baris, kolom)){ //tembok
            return 1000;
        }else //dia adalah jalan
            return (Math.abs(Maze.endBaris-baris) + Math.abs(Maze.endKolom-kolom) + level);
    }
    
   
    
}
