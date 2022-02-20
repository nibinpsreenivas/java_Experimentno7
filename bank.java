import java.util.*;
class customer1 extends Thread
{
 
   banking b;
    customer1(banking b)
    { 
      this.b=b;
    }
    public void run()
    {
       b.withdraw(15000);
    }   
   
  
}
class customer2 extends Thread
{
  
  
   banking b;
   customer2(banking b)
    { 
      this.b=b;
    }
    public void run()
    {
       b.deposit(55000);
    }  
  
}
class banking
 {
    int account=10000;
   synchronized void withdraw(int amount)
   { 
     System.out.println("costumer1 thread is running");
      if(account<amount)
      {
        try{this.wait();}catch(InterruptedException e){System.out.println(e);}
         System.out.println("costumer1 thread is again running");
        account = account-amount;
        System.out.println("balance amount after withdrawing "+amount+" is "+account);
      }
   }
   void deposit(int amount)
   {
      synchronized(this)
      {
          System.out.println("customer1 thread is waiting and customer2 is runnning");
         account = account+amount;
         System.out.println("balance amount after deposit "+amount+" is "+account);
         notify();
      }
    }
    
 }   
 class bank
 {
   public static void main(String args[])
  {
   banking b = new banking();
   customer1 t1 = new customer1(b);
   customer2 t2 = new customer2(b);
   t1.start();
   t2.start();
   }
 }
      
         
