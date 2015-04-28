import java.util.Stack;

/*THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
      CODE WRITTEN BY OTHER STUDENTS. Milap Naik */

public class NQueens {
  
  public static Stack<Integer> stack = new Stack<Integer> ();

  private static boolean check(int spot) { //Check solution to be viable
    for(int Queen = 0; Queen < stack.size(); Queen++)// iterate state to see if this spot can threaten other queens
      {
        if(stack.get(Queen) == spot)
          return false;
        else if(stack.size() - stack.get(Queen) == Queen-spot)
          return false;
        else if(stack.size() + stack.get(Queen)== Queen + spot)
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
    	  if(check(nextQ)){ //Check if solution is viable. If not, iterate.
    		  stack.push(nextQ);
    		  nextQ=0;
    		  break;
    	  }
    	  nextQ++;
      } //closes for
      if(x==n){
         if (stack.isEmpty())
        	 p=true;
         else
        	 nextQ = stack.pop() +1;
      }
      if(stack.size() == n){
         printSolution(stack);
         solution++;
         nextQ = stack.pop() + 1;
      }
    }//closes while
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
  
  int number = 8; //Number of queens...change to be entered as an argument later
  
  
  if (args.length == 1) { //Check perimeters, if number of queens is entered as an argument
    number = Integer.parseInt(args[0].trim());
    if (number < 1) {
      System.out.println("Incorrect parameter");
      System.exit(-1);
    }
  }
  
  int solutions = solve(number);
  System.out.println("There are " + solutions + " solutions to the " + number + "-queens problem.");
 }
  
}