/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasalpro1;

import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author laksmian
 */
public class Maze {

    static public int maze[][];
    static final int startBaris = 1;
    static final int startKolom = 0;

    static final int endBaris = 1;
    static final int endKolom = 8;

    public Maze(){
        maze = new int[7][9];
        for (int baris = 0; baris < maze.length; baris++) {
            for (int kolom = 0; kolom < maze[0].length; kolom++) {
                maze[baris][kolom] = 0;
            }
        }

        maze[1][0] = 1;     //1
        maze[1][1] = 1;     //2
        maze[1][2] = 1;     //3
        maze[2][2] = 1;     //4
        maze[3][2] = 1;     //5
        maze[3][1] = 1;     //6
        maze[4][1] = 1;     //7
        maze[5][1] = 1;     //8
        maze[5][2] = 1;     //9
        maze[5][3] = 1;     //10
        maze[5][4] = 1;     //11
        maze[5][5] = 1;     //12
        maze[4][5] = 1;     //13
        maze[3][5] = 1;     //14
        maze[3][4] = 1;     //15
        maze[2][4] = 1;     //16
        maze[1][4] = 1;     //17
        maze[3][6] = 1;     //18
        maze[3][7] = 1;     //19
        maze[4][7] = 1;     //20
        maze[5][7] = 1;     //21
        maze[2][6] = 1;     //22
        maze[1][6] = 1;     //23
        maze[1][7] = 1;     //24
        maze[1][8] = 1;     //25
//
//        maze[1][0] = 1;     //1
//        maze[1][1] = 1;     //2
//        maze[1][2] = 1;     //3
//        maze[1][3] = 1;     //4
//        maze[1][4] = 1;     //5
//        maze[1][5] = 1;     //6
//        maze[1][6] = 1;     //7
//        maze[1][7] = 1;     //8
//        maze[1][8] = 1;     //9



//        maze[1][0] = 1;     //1
//        maze[1][1] = 1;     //2
//        maze[1][2] = 1;     //3
//        maze[2][2] = 1;     //4
//        maze[3][2] = 1;     //5
//        maze[3][3] = 1;     //6
//        maze[3][4] = 1;     //7
//        maze[3][5] = 1;     //8
//        maze[3][6] = 1;     //9
//        maze[2][6] = 1;     //8
//        maze[1][6] = 1;     //9
//        maze[1][7] = 1;     //9
//        maze[1][8] = 1;     //9

    }


    public static void ambilArrah(Stack<String> himpunan, int koordinatBaris, int koordinatKolom, int posisiSebelum) {
        List<String> arahNext = new ArrayList<>();

        //  kiri = 1
        //  kanan = 2
        //  atas = 3
        // bawah = 4
        switch (posisiSebelum) {
            case 1: { //dari kiri - ambil kanan, ambil atas, ambil bawah 
                himpunan.push(ambilKanan(koordinatBaris, koordinatKolom));

                himpunan.push(ambilAtas(koordinatBaris, koordinatKolom));
                himpunan.push(ambilBawah(koordinatBaris, koordinatKolom));
            }
            break;

            case 2: {
                //dari kanan - ambil kiri, ambil atas, ambil bawah 
                himpunan.push(ambilKiri(koordinatBaris, koordinatKolom));
                himpunan.push(ambilAtas(koordinatBaris, koordinatKolom));
                himpunan.push(ambilBawah(koordinatBaris, koordinatKolom));
            }
            break;

            case 3: {
                //dari atas - ambil kiri, ambil kanan, ambil bawah 
                himpunan.push(ambilKanan(koordinatBaris, koordinatKolom));
                himpunan.push(ambilKiri(koordinatBaris, koordinatKolom));
                himpunan.push(ambilBawah(koordinatBaris, koordinatKolom));
            }
            break;

            case 4: {
                //dari bawah - ambil kiri, ambil kanan, ambil atas 
                himpunan.push(ambilKanan(koordinatBaris, koordinatKolom));
                himpunan.push(ambilKiri(koordinatBaris, koordinatKolom));
                himpunan.push(ambilAtas(koordinatBaris, koordinatKolom));
            }
            break;

            default: //pointer di set last chaincode // masih pusing
            {
                arahNext = null;
            }
            break;
        }

    }
    
    public static List<String> ambilArahList(int koordinatBaris, int koordinatKolom, int posisiSebelum) {
        List<String> listArah = new ArrayList<>();

        //  kiri = 1
        //  kanan = 2
        //  atas = 3
        // bawah = 4
        switch (posisiSebelum) {
            case 1: { //dari kiri - ambil kanan, ambil atas, ambil bawah 
                listArah.add(ambilKanan(koordinatBaris, koordinatKolom));
                listArah.add(ambilAtas(koordinatBaris, koordinatKolom));
                listArah.add(ambilBawah(koordinatBaris, koordinatKolom));
            }
            break;

            case 2: {
                //dari kanan - ambil kiri, ambil atas, ambil bawah 
                listArah.add(ambilKiri(koordinatBaris, koordinatKolom));
                listArah.add(ambilAtas(koordinatBaris, koordinatKolom));
                listArah.add(ambilBawah(koordinatBaris, koordinatKolom));
            }
            break;

            case 3: {
                //dari atas - ambil kiri, ambil kanan, ambil bawah 
                listArah.add(ambilKanan(koordinatBaris, koordinatKolom));
                listArah.add(ambilKiri(koordinatBaris, koordinatKolom));
                listArah.add(ambilBawah(koordinatBaris, koordinatKolom));
            }
            break;

            case 4: {
                //dari bawah - ambil kiri, ambil kanan, ambil atas 
                listArah.add(ambilKanan(koordinatBaris, koordinatKolom));
                listArah.add(ambilKiri(koordinatBaris, koordinatKolom));
                listArah.add(ambilAtas(koordinatBaris, koordinatKolom));
            }
            break;

            default: //pointer di set last chaincode // masih pusing
            {
                listArah = null;
            }
            break;
        }
        return listArah;
    }
    

    //  kiri = 1
    //  kanan = 2
    //  atas = 3
    // bawah = 4
    private static String ambilKanan(int baris, int kolom) {
        String tempBaris;
        String tempKolom;

        tempBaris = String.valueOf(baris);
        tempKolom = String.valueOf(kolom + 1);

        return tempBaris + "," + tempKolom + ",2";
    }

    private static String ambilKiri(int baris, int kolom) {
        String tempBaris;
        String tempKolom;

        tempBaris = String.valueOf(baris);
        tempKolom = String.valueOf(kolom - 1);

        return tempBaris + "," + tempKolom + ",1";
    }

    private static String ambilBawah(int baris, int kolom) {
        String tempBaris;
        String tempKolom;

        tempBaris = String.valueOf(baris + 1);
        tempKolom = String.valueOf(kolom);

        return tempBaris + "," + tempKolom + ",4";
    }

    private static String ambilAtas(int baris, int kolom) {
        String tempBaris;
        String tempKolom;

        tempBaris = String.valueOf(baris - 1);
        tempKolom = String.valueOf(kolom);

        return tempBaris + "," + tempKolom + ",3";
    }

    public static int getMaxBaris() {
        return maze.length;
    }

    public static int getMaxKolom() {
        return maze[0].length;
    }

    public static boolean isNotTembok(int baris, int kolom) {
        return maze[baris][kolom] == 1;
    }
    
    public static boolean isSolution(int baris, int kolom){
        return (baris == Maze.endBaris && kolom == Maze.endKolom);
    }
    
    public static int cekArahSebelum(int arahAsal){
        
        //  kiri = 1
        //  kanan = 2
        //  atas = 3
        // bawah = 4
        int arahSebelum;
        switch (arahAsal) {
                case 1:{ //kiri 
                    //return kanan;
                    arahSebelum =  2;
                }    break;

                case 2:
                {
                    arahSebelum =  1;
                } break;

                case 3:
                {
                    arahSebelum =  4;
                } break;

                case 4:
                {
                    arahSebelum =  3;
                } break;
                 default: //pointer di set last chaincode // masih pusing
                {
                  arahSebelum = 0;
                } break;
               
            }
        return arahSebelum;
    }
    
    public static String ambilArahNominal(int arahAsal){
        
        //  kiri = 1
        //  kanan = 2
        //  atas = 3
        // bawah = 4
        String arahSebelum = "";
        switch (arahAsal) {
                case 1:{ //kiri 
                    //return kanan;
                    arahSebelum =  "kiri";
                }    break;

                case 2:
                {
                    arahSebelum =  "kanan";
                } break;

                case 3:
                {
                    arahSebelum =  "atas";
                } break;

                case 4:
                {
                    arahSebelum =  "bawah";
                } break;
                 default: //pointer di set last chaincode // masih pusing
                {
                  arahSebelum = "kanan";
                } break;
               
            }
        return arahSebelum;
    }


}
