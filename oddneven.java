import java.util.*;
 class thread1 extends Thread
  { 
     
      public void run()
       {
         for(int i=1;i<100;i++)
           if(i%2!=0)
            System.out.println(i);
       } 
  }
  class thread2 extends Thread
  { 
     
      public void run()
       {
         for(int i=1;i<100;i++)
           if(i%2==0)
            System.out.println(i);
       } 
  }
class oddneven
{
  public static void main(String args[])
   {
     thread1 t1 = new thread1();  
     thread2 t2 = new thread2();  
      System.out.println("the odd numbers are:");
     t1.start();
    try{
         t1.join();
       }catch(InterruptedException e)
         {
           System.out.println(e);
         }
             
    System.out.println("the even numbers are:");
     t2.start();
    }
}
