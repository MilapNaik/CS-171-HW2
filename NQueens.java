import java.util.Stack;

/*THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
      CODE WRITTEN BY OTHER STUDENTS. Milap Naik */

public class NQueens {
  
  public static Stack<Integer> s = new Stack<Integer> ();

  private static boolean check(int t) {
    for(int i = 0; i < s.size(); i++)
      {
        if(s.get(i) == t)
          return false;
        else if(s.size() - s.get(i) == i-t)
          return false;
        else if(s.size() + s.get(i)== i + t)
          return false;
      }
    return true;
  }
  
  public static int solve(int n) {
    int solution = 0;
    int nextQ = 0;
    //boolean checkit = false;
    boolean p = false;
    int x = 0;

    while(!p){
      for (x = nextQ; x<n; x++){
       if(check(nextQ)){
         s.push(nextQ);
         nextQ=0;
         break;
       }
       nextQ++;
      }
       if(x==n){
         if (s.isEmpty())
          p=true;
         else
           nextQ = s.pop() +1;
       }
       if(s.size() == n){
         printSolution(s);
         solution++;
         nextQ = s.pop() + 1;
       }
    }
    return solution;
  }
  
 //Don't change below this
  private static void printSolution(Stack<Integer> s) {
    for (int i = 0; i < s.size(); i ++) {
      for (int j = 0; j < s.size(); j ++) {
        if (j == s.get(i))
          System.out.print("Q ");
        else
          System.out.print("* ");
      }
      System.out.println();
    }
    System.out.println();  
  }
  
  public static void main(String[] args) {
  
  int n = 8;
  
  
  if (args.length == 1) {
    n = Integer.parseInt(args[0].trim());
    if (n < 1) {
      System.out.println("Incorrect parameter");
      System.exit(-1);
    }
  }
  
  int number = solve(n);
  System.out.println("There are " + number + " solutions to the " + n + "-queens problem.");
 }
  
}