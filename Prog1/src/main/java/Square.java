import java.util.Scanner;
/*
Samuel Sausville
sps222@lehigh.edu
Program 1
*/
public class Square{
    public static void main (String[] args){
        //Scanners, Assumes that it is valid input and that it is guaranteed to be 5
         int [] [] arr = new int[5][5];
         //First scanner
        Scanner scan = new Scanner (System.in);
        for(int i = 0; i < arr.length; i++){
            //Reads in line by line as the instructions ask
            String line = scan.nextLine();
            Scanner sc = new Scanner(line);
            //Fill loop
            for(int j = 0; j < arr.length; j++){
                int get = sc.nextInt();
                arr[i][j] = get;
            }
        }
        //Just test arr to get sum working faster
        //int [] [] nums = {{1,1,1,1,1},{2,2,2,2,2},{1,2,3,4,5},{4,4,4,4,4},{6,6,6,6,6}};
        System.out.println("Sums of rows and columns");
        sumrowsandcols(arr);
    }
    private static void sumrowsandcols(int [][] nums){
        //Sum rows
        int rowSum = 0;
        for(int j = 0; j < nums.length; j++){
            for(int i = 0; i < nums[j].length; i++){
            rowSum += nums[j][i];
            }
            System.out.print(rowSum + " ");
            rowSum = 0;
        }
        System.out.println();
        //Sum columns
        int colSum = 0;
        for(int j = 0; j < nums.length; j++){
            for(int i = 0; i <nums[j].length; i++){
                colSum += nums[i][j];
            }
            System.out.print(colSum + " ");
            colSum = 0;
        }
        
    }
}