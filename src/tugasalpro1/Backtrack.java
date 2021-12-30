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
public class Backtrack {

    Node n = new Node();
    Mazes m = new Mazes();
    String Solusi = "";
    ArrayList visited = new ArrayList();
    boolean end = false, visit = false, backtrack = false;
    String statusNode = "";
    boolean death = false;
    int xubah, yubah;

    /* A utility function to print solution matrix
     sol[N][N] */
    public Backtrack() {
        m.getInfo();
        solveMaze(m.mazes);
        System.out.println(Solusi);
    }

    void printSolution(int sol[][]) {
        for (int i = 0; i < m.mazes.length; i++) {
            for (int j = 0; j < m.mazes[0].length; j++) {
                System.out.print(" " + m.jalurs[i][j]
                        + " ");
            }
            System.out.println();
        }
    }

    /* A utility function to check if x,y is valid
     index for N*N maze */
    boolean isSafe(int maze[][], int x, int y) {
        checkVisited(x, y);
        int a = 0;
        int b = 0;
        if (visit == true) {
            a = 1;
        }
        if (end == true) {
            b = 1;
        }
        visit = false;
        // if (x,y outside maze) return false
        return (x >= 0 && x < m.mazes.length && y >= 0
                && y < m.mazes[0].length && maze[x][y] == 1 && a == 0 && b == 0);
    }

    /* This function solves the Maze problem using
     Backtracking. It mainly uses solveMazeUtil()
     to solve the problem. It returns false if no
     path is possible, otherwise return true and
     prints the path in the form of 1s. Please note
     that there may be more than one solutions, this
     function prints one of the feasible solutions.*/
    boolean solveMaze(int maze[][]) {
        if (mazeBacktrack(maze, m.xstart, m.ystart, m.jalurs) == false) {
            System.out.print("Solution doesn't exist");
            return false;
        }

        printSolution(m.jalurs);
        return true;
    }

    /* A recursive utility function to solve Maze
     problem */
    boolean mazeBacktrack(int maze[][], int x, int y,
            int sol[][]) {
        // if (x,y is goal) return true
        if (x == m.xend && y == m.yend) {
            sol[x][y] = 1;
            end = true;
            return true;
        }

        // Check if maze[x][y] is valid
        if (isSafe(maze, x, y) == true) {
            sol[x][y] = 1;
            printsolusi();
            addVisited(x, y);

            if (end == false) {

                if (isSafe(maze, x, y + 1) == true) {
                    System.out.println("Kanan" + "(" + x + "," + (y + 1) + ")");
                    Solusi += "Kanan; ";
                    mazeBacktrack(maze, x, y + 1, sol);
                    return true;
                }

            }

        }
        if (isSafe(maze, x, y) == false) {
            if (end == false) {
                backtrack(x, y);
                if (visit == true || backtrack == true) {
                    x = xubah;
                    y = yubah;
                    xubah = 0;
                    yubah = 0;
                }
                visit = false;
                backtrack = false;
                if (isSafe(maze, x, y - 1) == true) {
                    sol[x][y - 1] = 1;
                    System.out.println("Kiri" + "(" + x + "," + (y - 1) + ")");
                    Solusi += "Kiri; ";

                    mazeBacktrack(maze, x, y - 1, sol);

                    return true;
                } else if (isSafe(maze, x - 1, y) == true) {
                    sol[x - 1][y] = 1;
                    System.out.println("Atas" + "(" + (x - 1) + "," + y + ")");
                    Solusi += "Atas; ";
                    mazeBacktrack(maze, x - 1, y, sol);
                    return true;
                } else if (isSafe(maze, x + 1, y) == true) {
                    sol[x + 1][y] = 1;
                    System.out.println("Bawah" + "(" + (x + 1) + "," + y + ")");
                    Solusi += "Bawah; ";
                    mazeBacktrack(maze, x + 1, y, sol);

                    return true;
                }
            }
        }

        Solusi += "End";

        return false;
    }

    void checkVisited(int x, int y) {
        int koorx, koory;
        String[] koor = new String[2];
        if (visited.size() == 0) {
            visit = false;
        } else {
            for (int i = 0; i < visited.size(); i++) {//cek apa sudah pernah di visit
                koor = visited.get(i).toString().split(",");
                koorx = Integer.parseInt(koor[0]);
                koory = Integer.parseInt(koor[1]);
                if (koorx == x && koory == y) {
                    koor = visited.get(visited.size() - 1).toString().split(",");
                    xubah = Integer.parseInt(koor[0]);
                    yubah = Integer.parseInt(koor[1]);
                    visit = true;
                }
            }
        }
    }

    void addVisited(int x, int y) {
        int koorx, koory;
        String[] koor = new String[2];
        if (visited.size() == 0) {
            visited.add(x + "," + y);
        } else {
            for (int i = 0; i < visited.size(); i++) {//cek apa sudah pernah di visit
                koor = visited.get(i).toString().split(",");
                koorx = Integer.parseInt(koor[0]);
                koory = Integer.parseInt(koor[1]);
                if (koorx != x || koory != y) {
                    visited.add(x + "," + y);
                    break;
                }
            }
        }
    }

    void backtrack(int x, int y) {
        int koorx, koory;
        String[] koor = new String[2];
        backtrack = true;
        koor = visited.get(visited.size() - 1).toString().split(",");
        xubah = Integer.parseInt(koor[0]);
        yubah = Integer.parseInt(koor[1]);
        System.out.println("backtrack/death :" + xubah + "," + yubah);
//                visit=true;
    }

    void printsolusi() {
        for (int i = 0; i < m.jalurs.length; i++) {
            for (int j = 0; j < m.jalurs[0].length; j++) {
                System.out.print(" " + m.jalurs[i][j] + " ");
            }
            System.out.println("");
        }
    }


}
