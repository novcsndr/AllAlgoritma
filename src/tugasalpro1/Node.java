/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasalpro1;

import java.util.List;

/**
 *
 * @author laksmian
 */
public class Node {
    private int keyIndex;
    private String value;
    
    private List<Node> children;
    private Node parent;
    
    private int level;
    
    private int cost;
    
    public void setKeyIndex(int key){
        this.keyIndex = key;
    }
    
    public int getKeyIndex(){
        return this.keyIndex;
    }
    
    public void setValue(String val){
        this.value = val;
    }
    
    public String getValue(){
        return this.value;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getParent() {
        return parent;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }   

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    
    
}
