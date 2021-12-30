package tugasalpro1;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import tugasalpro1.Maze;
import tugasalpro1.Node;
import tugasalpro1.Tree;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author laksmian
 */
public class BFS {
    
    static int lastcounter;
    static int level;
    private static  Queue<Node> queuetogenerate = new LinkedList<>();
    
    public void generateBFSTree(Tree t, Maze maze){
        
        Node rootnode = new Node();
        
        String value = (String.valueOf(Maze.startBaris) +","+ String.valueOf(Maze.startKolom) +","+"2");
        lastcounter = 0;
       
        
        rootnode.setParent(null);
        rootnode.setLevel(0);
        rootnode.setValue(value);
        rootnode.setKeyIndex(lastcounter);
       
        t.root = rootnode;
        
        generateChildren(rootnode);
        
        while (!queuetogenerate.isEmpty()) {
                generateChildren(queuetogenerate.poll());
        }       
        
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
            
            children.add(child);
            
            
            tempKoordinat = childvalue.split(",");
            baris = Integer.valueOf(tempKoordinat[0]);
            kolom = Integer.valueOf(tempKoordinat[1]);
            
            if(Maze.isNotTembok(baris, kolom) && (!Maze.isSolution(baris, kolom))){
                queuetogenerate.add(child);
            }
            
        }
        
        node.setChildren(children);
    }
    
    
    
    
    
}
