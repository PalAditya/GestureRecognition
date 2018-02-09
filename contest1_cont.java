import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.*;
public class contest1_cont  {
	public static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) throws IOException{
	    contest1_cont obj=new contest1_cont();
	    obj.go();
	   }
	   public void go()throws IOException
	   {
	    BufferedReader br=new BufferedReader(new FileReader("C:/users/lenovo/documents/input00.txt"));
	    BufferedWriter br2=new BufferedWriter(new FileWriter("C:/users/lenovo/documents/output00.txt"));
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i<t; i++){
			helpRamu(br,br2);
		}
		br.close();
		br2.close();
	}

	public int[] takeinput(int n,BufferedReader br) throws IOException{
		int[] rv = null;
		// long n = scn.nextInt();
		rv = new int[n];
		StringTokenizer str=new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			rv[i] = Integer.parseInt(str.nextToken());
		}
		return rv;
	}
	
	public  void helpRamu(BufferedReader br, BufferedWriter br2)throws IOException{ 
	    
		int [] arr = takeinput(4,br);
		StringTokenizer str=new StringTokenizer(br.readLine());
		int n =Integer.parseInt(str.nextToken());
		int m =Integer.parseInt(str.nextToken());
		int[] N = takeinput(n,br);
		int[] M = takeinput(m,br);
		int sum = 0;
		for(int i = 0; i<n;i++){
			if(N[i]*(i+1)>arr[1]){
				sum+=arr[1];
			}else{
			sum+=N[i]*(i+1);
			}
		}
		if(sum>arr[2]){
			sum = arr[2];
		}
		int sum2 = 0;
		for(int i = 0; i<m;i++){
			if(M[i]*(i+1)>arr[1]){
				sum2+=arr[1];
			}else{
			sum2+=M[i]*(i+1);
			}
		}
		if(sum2>arr[2]){
			sum2 = arr[2];
		}
		sum = sum +sum2;
		if(sum>arr[3]){
			br2.write(arr[3]+"");
			br2.newLine();
		}else{
			br2.write(sum+"");
			br2.newLine();
		}
	}
	
}