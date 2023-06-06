package com.changework;

public class RecursionExample
{
    public static void main(String[] args)
    {
        //方法一
//      int sum = 0;
//      for(int i=0; i<10; i++)
//      {
//          sum = sum + i + 1;
//          System.out.print(sum + "  ");
//      }
//      System.out.println();

        //方法二
//      int Size = 10;
//      int[] a = new int[Size];
//      a[0] = 1;
//      for(int i=1; i<a.length; i++)
//          a[i] = a[i-1] + i + 1;
//      for(int i=0; i<a.length; i++)
//          System.out.print(a[i] + "  ");
//      System.out.println();

        //方法三：使用递归，输出所有结果，可把下面Compute()方法中的输出注释掉
//      int N = 10;
//      for(int i=0; i<N; i++)
//          System.out.print(Compute(i+1) + "  ");
//      System.out.println();

        //方便调试、跟踪，也便于理解
        int result = Compute(5);
        System.out.println("The result is " + result);
    }

    public static int Compute(int n)
    {
        System.out.println("Entering : n=" + n);
        if(n == 1)
        {
            System.out.println("Returning 1");
            return 1;
        }
        else
        {
            int temp = n + Compute(n-1);
            System.out.println("Returning " + temp);
            return temp;
        }
    }
}