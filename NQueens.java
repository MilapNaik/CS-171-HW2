import java.util.Stack;

/*THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
      CODE WRITTEN BY OTHER STUDENTS. Milap Naik */

public class NQueens {
  
  public static Stack<Integer> stack = new Stack<Integer> ();

  private static boolean check(int NewSpot) { //Check solution to be viable
    for(int Queen = 0; Queen < stack.size(); Queen++)// iterate state to see if this spot can threaten other queens
      {
        if(stack.get(Queen) == NewSpot)//Check vertical on chess board
          return false;
        else if(stack.size() - stack.get(Queen) == Queen - NewSpot)//Check descending diagonal
          return false;
        else if(stack.size() + stack.get(Queen) == Queen + NewSpot)//Check ascending diagonal
          return false;
      }
    return true; //NewSpot is a viable solution
  }
  
  public static int solve(int number) { //Main solving algorithm. number = number of Queens
    int solution = 0;
    int nextQ = 0;
    
    boolean Solved = false; //True if all solutions are found
    int x = 0;

    while(!Solved){
      for (x = nextQ; x<number; x++){
    	  if(check(nextQ)){ //Check if solution is viable. If not, iterate.
    		  stack.push(nextQ); //Queens are numbered 0-N in stack according to position in row
    		  nextQ=0;
    		  break;
    	  }
    	  nextQ++;
      } //Closes for loop
      if(x==number){
         if (stack.isEmpty()) //This means all solutions have been found
        	 Solved=true;
         else //Pop last found queen and search for more solutions
        	 nextQ = stack.pop() +1;
      }
      if(stack.size() == number){ //A solution has been found, needs to be printed
         printSolution(stack);
         solution++;
         nextQ = stack.pop() + 1;
      }
    }//closes while
    return solution;
  }
  
 //Don't change below this
  private static void printSolution(Stack<Integer> stack) { //Print all chess board solutions
    for (int i = 0; i < stack.size(); i ++) {
      for (int j = 0; j < stack.size(); j ++) {
        if (j == stack.get(i))
          System.out.print("Q ");
        else
          System.out.print("* ");
      }
      System.out.println();
    }
    System.out.println();  
  }
  
  public static void main(String[] args) {
  
  int number = 8; //Number of queens. Will be overwritten if given a parameter
  
  
  if (args.length == 1) { //Check perameter to see if # of queens was entered as an argument
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