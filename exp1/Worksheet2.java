import java.util.*;
public class Worksheet2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of rows in first matrix");
        int r1=sc.nextInt();
        System.out.println("Enter no of columns in first matrix");
        int c1=sc.nextInt();
        System.out.println("Enter no of rows in second matrix");
        int r2=sc.nextInt();
        System.out.println("Enter no of columns in second matrix");
        int c2=sc.nextInt();
        int[][] matrix1=new int[r1][c1];
        int[][] matrix2=new int[r2][c2];
        System.out.println("Enter values for first matrix");
        for(int i=0;i<r1;i++){
            for(int j=0;j<c1;j++){
                matrix1[i][j]=sc.nextInt();
            }
        }
        System.out.println("The first matrix is");
        for(int i=0;i<r1;i++){
            for(int j=0;j<c1;j++){
                System.out.print(matrix1[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("Enter values for second matrix");
        for(int i=0;i<r2;i++){
            for(int j=0;j<c2;j++){
                matrix2[i][j]=sc.nextInt();
            }
        }
        System.out.println("The second matrix is");
        for(int i=0;i<r2;i++){
            for(int j=0;j<c2;j++){
                System.out.print(matrix2[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Addition of two matrices is");
        if(r1!=r2 && c1!=c2){
            System.out.println("Addition can't be done");
        }else{
            for(int i=0;i<r2;i++){
                for(int j=0;j<c2;j++){
                    System.out.print((matrix2[i][j]+matrix1[i][j])+" ");
                }
                System.out.println();
            }
        }
        System.out.println("Subtraction of two matrices is");
        if(r1!=r2 && c1!=c2){
            System.out.println("Subtraction can't be done");
        }else{
            for(int i=0;i<r2;i++){
                for(int j=0;j<c2;j++){
                    System.out.print((matrix2[i][j]-matrix1[i][j])+" ");
                }
                System.out.println();
            }
        }
        System.out.println("Multiplication of two matrices is");
        int[][] result = new int[r1][c2];
        if(c1!=r2){
            System.out.println("Multiplication can't be done ");
        }else{
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c2; j++) {
                    for (int k = 0; k < c1; k++) {
                        result[i][j] += matrix1[i][k] * matrix2[k][j];
                    }
                }
            }
            System.out.println("Resultant Matrix after multiplication");
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c2; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
        }

    }

}
