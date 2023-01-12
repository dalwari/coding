package Thread;

import java.util.*;

class MatMul implements Runnable {
    private int[][] rm;
    private int[][] m1;
    private int[][] m2;

    public MatMul(int[][] m1, int[][] m2) {
        this.m1 = m1;
        this.m2 = m2;
        rm=new int[m1.length][m2[0].length];
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        for (int i = 0; i < rm.length; ++i) {

            for (int j = 0; j < rm[i].length; ++j) {

                for (int k = 0; k < m2.length; ++k) {

                    rm[i][j] += m1[i][k] * m2[k][j];
                }

            }
            MainA.printMatrixInput(rm);
        }
    }

}
class RowWorker implements Runnable{
   
    int[][] m1;
    int[][] m2;
    int row;
    
    public RowWorker(int[][] m1, int[][] m2, int row) {
        
        this.m1 = m1;
        this.m2 = m2;
        this.row = row;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        int i=row;
        for (int j = 0; j < m2[i].length; ++j) {

            for (int k = 0; k < m2.length; ++k) {

                MainA.rm[i][j] += m1[i][k] * m2[k][j];
            }

        }
    }
    
}
public class MainA {
    public static Scanner ip = new Scanner(System.in);
    static int[][] rm;
    public static void multiply(int[][]m1,int[][]m2){
        rm=new int[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; ++i) {
            RowWorker task=new RowWorker(m1, m2, i);
            Thread th=new Thread(task);
            th.start();
            List<Thread> threads=new ArrayList<>();
            threads.add(th);
            if(threads.size()%10==0){
                waitForThreads(threads);       
            }
         
        }
    }
    public static void waitForThreads(List<Thread> threads){
        for(Thread th:threads){
            try{
                th.join();
            }catch(Exception e){
                e.printStackTrace();
            }
            threads.clear();
        }
    }
    public static int[][] getMatrixInput() {
        int r = ip.nextInt();
        int c = ip.nextInt();
        int[][] M = new int[r][c];
        for (int i = 0; i < M.length; ++i) {
            for (int j = 0; j < M[0].length; ++j) {
                M[i][j] = ip.nextInt();
            }
        }
        // printMatrixInput(M);
        return M;
    }

    public static void printMatrixInput(int[][] M) {
        for (int i = 0; i < M.length; ++i) {
            System.out.println(Arrays.toString(M[i]));
        }
    }

    public static void main(String[] args) {

        int[][] A = getMatrixInput();
        int[][] B = getMatrixInput();

        // MatMul r1=new MatMul(A, B);
        // Thread th=new Thread(r1);
        // th.start();
         multiply(A, B);
         printMatrixInput(rm);

    }
}
