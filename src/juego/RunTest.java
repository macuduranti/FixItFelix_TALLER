package juego;

public class RunTest
{
   public static void main(String[] args)
     {
	   int exitos=0;
         for(int i=1; i<=10000; i++)
             if (Test.main(args))
            	 exitos++;
       System.err.println(exitos);
     }
}
