
package ucsc;

import java.util.Scanner;

public class TKOne {
    
    public static void main(String[] args) {
        
        System.out.println("Input your text to be neatly printed : ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println("Enter the maximum number of characters per line : ");
        int lineMax = scanner.nextInt();
        String text[] = input.split(" ");
        int wordCount = text.length;
        
        double arr[][] = new double[wordCount][wordCount];
        for (int i=0 ; i<wordCount ; i++) {
            for (int j=0 ; j<wordCount ; j++) {
                arr[i][j] = -1;
            }
        }
        
        double result = neatPrint(arr,text,wordCount,lineMax,0,0);
        System.out.println("Cube sum of extra spaces " + result);
//        System.out.println("---------------------------------------");
//        for (int i=0 ; i<wordCount ; i++) {
//            for (int j=0 ; j<wordCount ; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println("");
//        }
//        System.out.println("----------------------------------");
        try {
            printOut(arr,text,0,0);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static double neatPrint(double arr[][], String text[], int wordCount,int lineMax, int left, int right) {
        if (right >= wordCount) {
            return 0;
        }
        if (arr[left][right] != -1) {
            return arr[left][right];
        }
        else {            
            int charSum = 0;
            for (int k=left ; k<right ; k++) {
                charSum += text[k].length();
            }            
            if ((lineMax - right + left - charSum - text[right].length()) >= 0) {
                double extraLeft = neatPrint(arr,text,wordCount,lineMax,left,right+1);
                double extraRight = Math.pow(lineMax - right + left - charSum, 3) + neatPrint(arr,text,wordCount,lineMax,right+1,right+1);
                double result = Math.min(extraLeft, extraRight);
                arr[left][right] = result;                
                return result;
            }
            else {
                double result = Math.pow(lineMax - right + 1 + left - charSum, 3) + neatPrint(arr,text,wordCount,lineMax,right,right);
                return result;
            }
        }
    }
    
    public static void printOut(double arr[][],String text[],int i,int j) { 
        if (arr[i][j] != -1) {
            if (i == (text.length-1) && j == (text.length-1)) {
                System.out.print(text[j]);
                return;
            }
            while (j<text.length-1 && arr[i][j] != -1) {
                System.out.print(text[j] + " ");
                j += 1;
            }
            System.out.println("");
            
            while (i<text.length-1 && arr[i+1][j] == -1) {
                i += 1;
            }
            while (i<text.length-1 && arr[i+1][j] != -1) {
                i += 1;
            }
            printOut(arr, text, i, j);
            return;
        }
        
    }
    
}
