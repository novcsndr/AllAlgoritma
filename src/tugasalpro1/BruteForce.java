/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasalpro1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author User
 */
public class BruteForce {
//    private String[][] maze = {{"0", "0", "0", "0", "0", "0", "0", "0", "0"},
//    {"Start", "1", "1", "0", "1", "0", "1", "1", "End"},
//    {"0", "0", "1", "0", "1", "0", "1", "0", "0"},
//    {"0", "1", "1", "0", "1", "1", "1", "1", "0"},
//    {"0", "1", "0", "1", "0", "1", "0", "1", "0"},
//    {"0", "1", "1", "1", "1", "1", "0", "1", "0"},
//    {"0", "0", "0", "0", "0", "0", "0", "0", "0"}};
//    private String[][] jalur = {{"0", "0", "0", "0", "0", "0", "0", "0", "0"},
//    {"0", "0", "0", "0", "0", "0", "0", "0", "0"},
//    {"0", "0", "0", "0", "0", "0", "0", "0", "0"},
//    {"0", "0", "0", "0", "0", "0", "0", "0", "0"},
//    {"0", "0", "0", "0", "0", "0", "0", "0", "0"},
//    {"0", "0", "0", "0", "0", "0", "0", "0", "0"},
//    {"0", "0", "0", "0", "0", "0", "0", "0", "0"}};
    
    public String[][] maze = {{"0", "0", "0", "0"},
    {"Start", "1", "0", "0"},
    {"0", "1", "1", "0"},
    {"0", "0", "1", "0"},
    {"0", "1", "1", "0"},
    {"0", "End", "0", "0"}};
   
//    
//    
//    public int [][] mazes = {{0, 0, 0, 0},
//    {1, 1, 1, 0},
//    {0, 0, 1, 0},
//    {0, 1, 1, 1},
//    {0, 1, 0, 0},
//    {0, 0, 0, 0}};
//    
//    public int [][] jalurs = {{0, 0, 0, 0},
//    {0, 0, 0, 0},
//    {0, 0, 0, 0},
//    {0, 0, 0, 0},
//    {0, 0, 0, 0},
//    {0, 0, 0, 0}};
//    
    public String[][] jalur = {{"0", "0", "0", "0"},
    {"0", "0", "0", "0"},
    {"0", "0", "0", "0"},
    {"0", "0", "0", "0"},
    {"0", "0", "0", "0"},
    {"0", "0", "0", "0"}};
    
    
    
//    private String[][] maze = {{"0", "0", "0", "0", "0", "0", "0", "0", "0"},
//    {"Start", "1", "1", "0", "1", "0", "1", "1", "End"},
//    {"0", "0", "1", "0", "1", "0", "1", "0", "0"},
//    {"0", "1", "1", "0", "1", "1", "1", "1", "0"},
//    {"0", "1", "0", "1", "0", "1", "0", "1", "0"},
//    {"0", "1", "1", "1", "1", "1", "0", "1", "0"},
//    {"0", "0", "0", "0", "0", "0", "0", "0", "0"}};
//    private String[][] jalur = {{"0", "0", "0", "0", "0", "0", "0", "0", "0"},
//    {"0", "0", "0", "0", "0", "0", "0", "0", "0"},
//    {"0", "0", "0", "0", "0", "0", "0", "0", "0"},
//    {"0", "0", "0", "0", "0", "0", "0", "0", "0"},
//    {"0", "0", "0", "0", "0", "0", "0", "0", "0"},
//    {"0", "0", "0", "0", "0", "0", "0", "0", "0"},
//    {"0", "0", "0", "0", "0", "0", "0", "0", "0"}};
    
    private int   xnext, ynext, xprev, yprev, count, stopnumb, xstart, ystart, xend, yend;
    private ArrayList otherPath;
    private int[][] koor;
     List<String> sol = new ArrayList<String>();
    private String Solusi = "Start; ", tempSolusi = "", SolusiOp="";
    private boolean cabang = false, end = false, trace = false, stop = false;
   
    public void getInfo() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == "Start") {
                    xstart = i;
                    ystart = j;
                    jalur[i][j]="1";
                } else if (maze[i][j] == "End") {
                    xend = i;
                    yend = j;
            }
        }
    }
    }

    public BruteForce() throws IOException {
        otherPath = new ArrayList();
        getInfo();
        int x, y;
        selectionStart(xstart, ystart);
        Solusi += tempSolusi;
        int i = 0;
        xprev = xstart;
        yprev = ystart;
        while (i >= 0 && end == false) {
            anotherWay(xnext, ynext, xprev, yprev);
            Solusi += tempSolusi;
            i++;
        }
        count = otherPath.size();
        int j = 0;
        String[] cabang;
        int koorx, koory;
        String sCabang = "";
        while (j < count) {//banyak cabang
            cabang = otherPath.get(j).toString().split(",");
            koorx = Integer.parseInt(cabang[0]);
            koory = Integer.parseInt(cabang[1]);
            sCabang = cabang[2];
            Solusi = sCabang;
            anotherWay(xnext, ynext, xprev, yprev);
            Solusi += tempSolusi;
            j++;
            int k = 0;
            while (stop == false) {
            stopnumb=0;    
            anotherWay(xnext, ynext, xprev, yprev);
            Solusi += tempSolusi;
            if(stopnumb==3){
                stop=true;
            }
           }
        }
        System.out.println("Solusi Optimal: "+ SolusiOp);

    }

    

    //arah atas
    void up(int x, int y) {
        if (maze[x - 1][y] == "0") {
            stopnumb += 1;
            System.out.println(Solusi + "Atas; Block");
            sol.add(Solusi + "Atas; Block");
        } else if (maze[x - 1][y] == "End") {
            System.out.println(Solusi + "Atas; End");
            sol.add(Solusi + "Atas; End");
            end = true;
            jalur[x-1][y] = "1";
            SolusiOp=Solusi + "Atas; End";
        } else if (maze[x - 1][y] == "1") {
            tempSolusi = "Atas; ";
            xnext = x - 1;
            ynext = y;
            jalur[x - 1][y]="1";
//            System.out.println(Solusi + tempSolusi);
        }
    }

    //arah bawah
    void down(int x, int y) {
        if (maze[x + 1][y] == "0") {
            stopnumb += 1;
            System.out.println(Solusi + "Bawah; Block");
            sol.add(Solusi + "Bawah; Block");
        } else if (maze[x + 1][y] == "End") {
            System.out.println(Solusi + "Bawah; End");
            sol.add(Solusi + "Bawah; End");
            end = true;
            jalur[x+1][y] = "1";
            SolusiOp=Solusi + "Bawah; End";
        } else if (maze[x + 1][y] == "1") {
            tempSolusi = "Bawah; ";
            xnext = x + 1;
            ynext = y;
            jalur[x + 1][y] = "1";
//            System.out.println(Solusi + tempSolusi);
        }
    }

    //arah kiri
    void left(int x, int y) {
        if (maze[x][y - 1] == "0") {
            stopnumb += 1;
            System.out.println(Solusi + "Kiri; Block");
        } else if (maze[x][y - 1] == "End") {
            System.out.println(Solusi + "Kiri; End");
            end = true;
            jalur[x][y - 1] = "1";
            SolusiOp=Solusi +  "Kiri; End";
        } else if (maze[x][y - 1] == "1") {
            tempSolusi = "Kiri; ";
            xnext = x;
            ynext = y - 1;
            jalur[x][y - 1] = "1";
//            System.out.println(Solusi + tempSolusi);
        }
    }

    //arah kanan
    void right(int x, int y) {
        if (maze[x][y + 1] == "0") {
            stopnumb += 1;
            System.out.println(Solusi + "Kanan; Block");
        } else if (maze[x][y + 1] == "End") {
            System.out.println(Solusi + "Kanan; End");
            end = true;
            jalur[x][y + 1] = "1";
            SolusiOp=Solusi + "Kanan; End";
        } else if (maze[x][y + 1] == "1") {
            tempSolusi = "Kanan; ";
            xnext = x;
            ynext = y + 1;
            jalur[x][y + 1] = "1";
//            System.out.println(Solusi + tempSolusi);
        }
    }

    // jalur pertama
    void selectionStart(int x, int y) {
        if (x == 0 && y != maze[0].length) {
            right(x, y);
            down(x, y);
            if (y != 0) {
                left(x, y);
            }
        } else if (y == maze[0].length && x != maze.length) {
            left(x, y);
            down(x, y);
            if (x != 0) {
                up(x, y);
            }
        } else if (y == 0) {
            up(x, y);
            right(x, y);
            if (x != 0 && x != maze.length) {
                down(x, y);
            }
        } else if (x == maze.length) {
            up(x, y);
            left(x, y);
            if (y != 0 && y != maze[0].length) {
                right(x, y);
            }
        }
        xprev = x;
        yprev = y;
    }

    //kembali
    void visited(int x, int y, int xvisited, int yvisited) {
        if (x - 1 == xvisited && y == yvisited) {
            System.out.println(Solusi + "Atas; Back");
        }
        if (x + 1 == xvisited && y == yvisited) {
            System.out.println(Solusi + "Bawah; Back");
        }
        if (x == xvisited && y - 1 == yvisited) {
            System.out.println(Solusi + "Kiri; Back");
        }
        if (x == xvisited && y + 1 == yvisited) {
            System.out.println(Solusi + "Kanan; Back");
        }
    }

    //mencari jalan berdasarkan arah sekitar
    void unvisited(int x, int y, int xvisited, int yvisited) {
        if (x - 1 != xvisited || y != yvisited ) {
            up(x, y);
        }
        if (x + 1 != xvisited || y != yvisited ) {
            down(x, y);
        }
        if (x != xvisited || y - 1 != yvisited ) {
            left(x, y);
        }
        if (x != xvisited || y + 1 != yvisited ) {
            right(x, y);
        }

    }

    //sek end goal
    void endGoal(int x, int y, int xvisited, int yvisited) {
        if ((x - 1 != xvisited || y != yvisited) && maze[x - 1][y] == "End") {
            end = true;
        }
        if ((x + 1 != xvisited || y != yvisited) && maze[x + 1][y] == "End") {
            end = true;
        }
        if ((x != xvisited || y - 1 != yvisited) && maze[x][y - 1] == "End") {
            end = true;
        }
        if ((x != xvisited || y + 1 != yvisited) && maze[x][y + 1] == "End") {
            end = true;
        }
    }

    //cek Banyak cabang
    void anotherWay(int x, int y, int xvisited, int yvisited) {
        int hitung = 0;
        endGoal(x, y, xvisited, yvisited);
        if ((x - 1 != xvisited || y != yvisited) && maze[x - 1][y] == "1") {
            hitung++;
            if (hitung == 1) {
//                up(x, y);
//                trace = true;
                if (end == true) {
                    otherPath.add((x - 1) + "," + y + "," + Solusi + "Atas; ");
                }
            } else if (hitung > 1 || end == true) {
                otherPath.add((x - 1) + "," + y + "," + Solusi + "Atas; ");
            }
        }
        if ((x + 1 != xvisited || y != yvisited) && maze[x + 1][y] == "1") {
            hitung++;
            if (hitung == 1) {
//                down(x, y);
//                trace = true;
                if (end == true) {
                    otherPath.add((x + 1) + "," + y + "," + Solusi + "Bawah; ");
                }
            } else if (hitung > 1 || end == true) {
                otherPath.add((x + 1) + "," + y + "," + Solusi + "Bawah; ");
            }
        }
        if ((x != xvisited || y - 1 != yvisited) && maze[x][y - 1] == "1") {
            hitung++;
            if (hitung == 1) {
//                left(x, y);
//                trace = true;
                if (end == true) {
                    otherPath.add(x + "," + (y - 1) + "," + Solusi + "Kiri; ");
                }
            } else if (hitung > 1 || end == true) {
                otherPath.add(x + "," + (y - 1) + "," + Solusi + "Kiri; ");
            }
        }
        if ((x != xvisited || y + 1 != yvisited) && maze[x][y + 1] == "1") {
            hitung++;
            if (hitung == 1) {
//                right(x, y);
//                trace = true;
                if (end == true) {
                    otherPath.add(x + "," + (y + 1) + "," + Solusi + "Kanan; ");
                }
            } else if (hitung > 1) {
                otherPath.add(x + "," + (y + 1) + "," + Solusi + "Kanan; ");
            }
        }
        count += (hitung - 1);
        if (hitung == 1) {
            unvisited(x, y, xvisited, yvisited);
            visited(x, y, xvisited, yvisited);
        }
        xprev = x;
        yprev = y;
    }

    
}
