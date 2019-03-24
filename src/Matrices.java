/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lenovo
 */
import java.util.*;
public class Matrices
{
    public static void main(String argv[]) 
    {
        Scanner input = new Scanner(System.in);
        //System.out.println("Enter the dimension of square matrix: ");
        int n = input.nextInt();
        int y=input.nextInt();
        double a[][]= new double[y][n+1];
        double val[][]=new double[y][1];
        //System.out.println("Enter the elements of matrix: ");
        for(int i=0; i<y; i++)
        {
            a[i][0]=1;
            for(int j=1; j<n+1; j++)
            {
                a[i][j] = input.nextDouble();
            }
            val[i][0]=input.nextDouble();
        } 
        int t=input.nextInt();
        double test[][]=new double[t][n+1];
        for(int i=0;i<t;i++)
        {
            test[i][0]=1;
            for(int j=1; j<n+1; j++)
            {
                test[i][j] = input.nextDouble();
            }
        }
        double X_trans[][]=transpose(a,y,n+1);
        double toinvert[][]=multiply(X_trans,a,n+1,y,n+1);
        double d[][] = invert(toinvert);
        /*for (int i=0; i<n+1; ++i) 
        {
            for (int j=0; j<n+1; ++j)
            {
                System.out.print(d[i][j]+"  ");
            }
            System.out.println();
        }*/
        d=multiply(d,X_trans,n+1,n+1,y);
        d=multiply(d,val,n+1,y,1);
        d=multiply(test,d,t,n+1,1);
        for(int i=0;i<t;i++)
        System.out.println(d[i][0]);
        /*System.out.println("The inverse is: ");
        for (int i=0; i<n; ++i) 
        {
            for (int j=0; j<n; ++j)
            {
                System.out.print(d[i][j]+"  ");
            }
            System.out.println();
        }*/
        /*double arr[][]={{1,2},{3,4}};
        d=transpose(arr,2,2);
        for (int i=0; i<n; ++i) 
        {
            for (int j=0; j<n; ++j)
            {
                System.out.print(d[i][j]+"  ");
            }
            System.out.println();
        }*/
        input.close();
    }   
    public static double[][] multiply(double a[][],double b[][],int c,int d,int e)
    {
        double mul[][]=new double[c][e];
        int i,j,k;
        for(i=0;i<c;i++)
        {
            for(j=0;j<e;j++)
            {
                for(k=0;k<d;k++)
                {
                     mul[i][j] = mul[i][j] + a[i][k] * b[k][j];
                }
            }
        }
        /*for (i=0; i<c; ++i) 
        {
            for (j=0; j<e; ++j)
            {
                System.out.print(mul[i][j]+"  ");
            }
            System.out.println();
        }*/
        return mul;
    }
    public static double[][] transpose(double arr[][],int a,int b)
    {
        int i,j;
        double temp[][]=new double[b][a];
        for(i=0;i<b;i++)
        {
            for(j=i;j<a;j++)
            {
                temp[i][j]=arr[j][i];
            }
        }
        return temp;
    }
    public static double[][] invert(double a[][]) 
    {
        int n = a.length;
        double x[][] = new double[n][n];
        double b[][] = new double[n][n];
        int index[] = new int[n];
        for (int i=0; i<n; ++i) 
            b[i][i] = 1;
        gaussian(a, index);
        for (int i=0; i<n-1; ++i)
            for (int j=i+1; j<n; ++j)
                for (int k=0; k<n; ++k)
                    b[index[j]][k]
                            -= a[index[j]][i]*b[index[i]][k];
        for (int i=0; i<n; ++i) 
        {
            x[n-1][i] = b[index[n-1]][i]/a[index[n-1]][n-1];
            for (int j=n-2; j>=0; --j) 
            {
                x[j][i] = b[index[j]][i];
                for (int k=j+1; k<n; ++k) 
                {
                    x[j][i] -= a[index[j]][k]*x[k][i];
                }
                x[j][i] /= a[index[j]][j];
            }
        }
        return x;
    }
    public static void gaussian(double a[][], int index[]) 
    {
        int n = index.length;
        double c[] = new double[n];
        for (int i=0; i<n; ++i) 
            index[i] = i;
        for (int i=0; i<n; ++i) 
        {
            double c1 = 0;
            for (int j=0; j<n; ++j) 
            {
                double c0 = Math.abs(a[i][j]);
                if (c0 > c1) c1 = c0;
            }
            c[i] = c1;
        }
        int k = 0;
        for (int j=0; j<n-1; ++j) 
        {
            double pi1 = 0;
            for (int i=j; i<n; ++i) 
            {
                double pi0 = Math.abs(a[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1) 
                {
                    pi1 = pi0;
                    k = i;
                }
            }
            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i=j+1; i<n; ++i)   
            {
                double pj = a[index[i]][j]/a[index[j]][j];
                a[index[i]][j] = pj;
                for (int l=j+1; l<n; ++l)
                    a[index[i]][l] -= pj*a[index[j]][l];
            }
        }
    }
}