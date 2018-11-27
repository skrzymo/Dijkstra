/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorytmy_0205;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author skrzy
 */
public class Algorytmy_0205 {

    static void Dijkstra(int s, int n, int[][] A, int[] dist, int[] pred) throws FileNotFoundException{
        PrintWriter zapis = new PrintWriter("Out0304.txt");
        int[] fin = new int[n+1];
        int inf=Integer.MAX_VALUE;
        for(int v=1; v<=n; v++){
            dist[v]=inf; 
            fin[v]=0; 
            pred[v]=-1;
        }
        dist[s]=0; 
        fin[s]=1; 
        int last=s;
        for(int i=1; i<n; i++){
            for(int v=1; v<=n; v++){
                if((A[last][v]<inf)&&(fin[v]==0)){
                    if(dist[last]+A[last][v]<dist[v]){
                    dist[v]=dist[last]+A[last][v]; 
                    pred[v]=last;
                    }
                }
            }
            int y=0, temp=inf;
            for(int u=1; u<=n; u++){
                if((fin[u]==0)&&(dist[u]<temp)){
                    y=u;
                    temp=dist[u];
                }
            }
            if(temp<inf){
                fin[y]=1; 
                last=y;
            }
        }
        int i;
        zapis.print("dist[");
        for(i=1;i<n;i++){
                zapis.print(dist[i]+" ");
        }
        zapis.println(dist[i]+"]");
        zapis.print("pred[");
        for(i=1;i<n;i++){
                zapis.print(pred[i]+" ");
        }
        zapis.print(pred[i]+"]");
        zapis.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("In0304.txt"));
        int wierzcholki = sc.nextInt();
        int zrodlo = sc.nextInt();
        int macierz_wag[][] = new int[wierzcholki+1][wierzcholki+1];
        int najkrotsze_drogi[] = new int[wierzcholki+1];
        int poprzedniki[] = new int[wierzcholki+1];
        for(int i=1;i<=wierzcholki;i++){
            for(int j=1;j<=wierzcholki;j++)
                macierz_wag[i][j] = sc.nextInt();
        }
        for(int i=1;i<=wierzcholki;i++){
            for(int j=1;j<=wierzcholki;j++)
                System.out.print(macierz_wag[i][j]+" ");
            System.out.println("\n");
        }
        Dijkstra(zrodlo,wierzcholki,macierz_wag,najkrotsze_drogi,poprzedniki);       
        
    }
    
}
