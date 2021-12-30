/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasalpro1;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Mazes {
    
//    private String[][] maze = {{"0", "0", "0", "0", "0", "0", "0", "0", "0"},
//    {"Start", "1", "1", "0", "1", "0", "1", "1", "End"},
//    {"0", "0", "1", "0", "1", "0", "1", "0", "0"},
//    {"0", "1", "1", "0", "1", "1", "1", "1", "0"},
//    {"0", "1", "0", "1", "0", "1", "0", "1", "0"},
//    {"0", "1", "1", "1", "1", "1", "0", "1", "0"},
//    {"0", "0", "0", "0", "0", "0", "0", "0", "0"}};
    
//    public int [][] maze = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
//    {1, 1, 1, 0, 1, 0, 1, 1, 1},
//    {0, 0, 1, 0, 1, 0, 1, 0, 0},
//    {0, 1, 1, 0, 1, 1, 1, 1, 0},
//    {0, 1, 0, 1, 0, 1, 0, 1, 0},
//    {0, 1, 1, 1, 1, 1, 0, 1, 0},
//    {0, 0, 0, 0, 0, 0, 0, 0, 0}};
    
        public int [][] mazes = {{0, 0, 0, 0},
    {1, 1, 1, 0},
    {0, 0, 1, 0},
    {0, 1, 1, 1},
    {0, 1, 0, 0},
    {0, 0, 0, 0}};
    
//           public int [][] mazes = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
//    {1, 1, 1, 0, 1, 0, 0, 0, 0},
//    {0, 0, 1, 0, 1, 0, 0, 0, 0},
//    {0, 1, 1, 0, 1, 1, 1, 1, 0},
//    {0, 1, 0, 1, 0, 1, 0, 1, 0},
//    {0, 1, 1, 1, 1, 1, 0, 1, 0},
//    {0, 0, 0, 0, 0, 0, 0, 1, 0}};
    
    public int [][] jalurs = new int [mazes.length][mazes[0].length];    
//        
//    public String[][] maze = {{"0", "0", "0", "0"},
//    {"Start", "1", "1", "0"},
//    {"0", "0", "1", "0"},
//    {"0", "1", "1", "End"},
//    {"0", "1", "0", "0"},
//    {"0", "0", "0", "0"}};
//    
//    

//    
//    public int [][] jalurs = {{0, 0, 0, 0},
//    {0, 0, 0, 0},
//    {0, 0, 0, 0},
//    {0, 0, 0, 0},
//    {0, 0, 0, 0},
//    {0, 0, 0, 0}};
//    
//    public String[][] jalur = {{"0", "0", "0", "0"},
//    {"0", "0", "0", "0"},
//    {"0", "0", "0", "0"},
//    {"0", "0", "0", "0"},
//    {"0", "0", "0", "0"},
//    {"0", "0", "0", "0"}};
    public int xstart=1, ystart=0,xend=1,yend=8;
    public ArrayList koors;
    
    public void getInfo() {
        koors = new ArrayList();
//        xstart = 1;
//        ystart = 0;
//        xend = 3;
//        yend = 3;
        for (int i = 0; i < mazes.length; i++) {
            for (int j = 0; j < mazes[0].length; j++) {
                jalurs[i][j] = 0;
                }

            }
        }
    }

