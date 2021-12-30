/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasalpro1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author laksmian
 */
public class Tree {
    
    public Node root;
    
    

    public static void BFSTraversal(Tree t){
        
        List<Node> nodes = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
                
        queue.add(t.root);
        
        Node node = new Node();
        String[] tempString = new String[3];
        int baris;
        int kolom;
        int arah;
 
        Node parent;
        Boolean solution;
        
        String print;
        while(!queue.isEmpty()){
            node = queue.poll();
            
            tempString  = node.getValue().split(",");
            baris = Integer.valueOf(tempString[0]);
            kolom = Integer.valueOf(tempString[1]);
            arah = Integer.valueOf(tempString[2]);
            solution = Maze.isSolution(baris, kolom);
            
            parent = node.getParent();
            print = "Level : "+node.getLevel()+"|| Node :"+node.getKeyIndex();
            if(parent!=null)
                print = print+"||Parent : "+ parent.getKeyIndex();
            else 
                print= print+" ROOT ";
                        
            print = print+"|| mouse : [" +baris+"]["+kolom+"], arah : " + Maze.ambilArahNominal(arah);
            
            if(solution){
                print = print+" - SOLUTION!";
            }else if(!Maze.isNotTembok(baris, kolom))
            {
                print = print+" - WALL";
            }else
                print = print+" - PATH";
         
            
            System.out.println(print);
            if (node.getChildren()!=null){
                nodes = node.getChildren();
                Iterator it = nodes.iterator();
                while (it.hasNext()){
                    queue.add((Node)it.next());
                }
            }
        }
        
    }
    
    public static void BranchAndBoundTraversal(Tree t){
        
        List<Node> nodes = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
                
        queue.add(t.root);
        
        Node node = new Node();
        String[] tempString = new String[3];
        int baris;
        int kolom;
        int arah;
 
        Node parent;
        Boolean solution;
        
        String print;
        while(!queue.isEmpty()){
            node = queue.poll();
            
            tempString  = node.getValue().split(",");
            baris = Integer.valueOf(tempString[0]);
            kolom = Integer.valueOf(tempString[1]);
            arah = Integer.valueOf(tempString[2]);
            solution = Maze.isSolution(baris, kolom);
            
            parent = node.getParent();
            print = "Level : "+node.getLevel()+"|| Node :"+node.getKeyIndex() +"|| Cost : "+node.getCost();
            if(parent!=null)
                print = print+"||Parent : "+ parent.getKeyIndex();
            else 
                print= print+" ROOT ";
                        
            print = print+"|| mouse : [" +baris+"]["+kolom+"], arah : " + Maze.ambilArahNominal(arah);
            
            if(solution){
                print = print+" - SOLUTION!";
            }else if(!Maze.isNotTembok(baris, kolom))
            {
                print = print+" - WALL";
            }else
                print = print+" - PATH";
         
            
            System.out.println(print);
            if (node.getChildren()!=null){
                nodes = node.getChildren();
                Iterator it = nodes.iterator();
                while (it.hasNext()){
                    queue.add((Node)it.next());
                }
            }
        }
        
    }
    
    public boolean isRoot(Node node){
        return (node.getParent() == null);
    }
    
    public boolean isLeaf(Node node){
        return(node.getChildren() == null);
    }
    

    
}
