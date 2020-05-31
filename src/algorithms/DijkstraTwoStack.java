import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * DijkstraTwoStack
 * Type: Algorithm
 * Description: Dijkstra's Two-Stack Algorithm for Expression Evaluation
 * Section: 1.3
 * Ref: p. 129
 * Compilation: javac DijkstraTwoStack.java
 * Execution: java DijkstraTwoStack < <standard_input>
 * Example(s):
 *
 * $ java DijkstraTwoStack
 * Reading from Standard Input...
 * > ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )
 * > <ctrl + d>
 * Expression value: 101.000
 *
 * $ java DijkstraTwoStack
 * Reading from Standard Input...
 * > ( ( 1 + sqrt ( 5.0 ) ) / 2.0 )
 * > <ctrl + d>
 * Expression value: 1.618
 */
public class DijkstraTwoStack {
  public static void main(String[] args) {
    Stack<String> operators = new Stack<String>();
    Stack<Double> values = new Stack<Double>();

    StdOut.println("Reading from Standard Input...");

    while (!StdIn.isEmpty()) {
      String s = StdIn.readString();

      if (s.equals("(")) {
        /* do nothing */
      } else if (s.equals("+")) {
        operators.push(s);
      } else if (s.equals("-")) {
        operators.push(s);
      } else if (s.equals("/")) {
        operators.push(s);
      } else if (s.equals("*")) {
        operators.push(s);
      } else if (s.equals("sqrt")) {
        operators.push(s);
      } else if (s.equals(")")) {
        // pop, evaluate and push result if token is ")"
        String op = operators.pop();
        double v = values.pop();

        if (op.equals("+")) {
          v = values.pop() + v;
        } else if (op.equals("-")) {
          v = values.pop() - v;
        } else if (op.equals("/")) {
          v = values.pop() / v;
        } else if (op.equals("*")) {
          v = values.pop() * v;
        } else if (op.equals("sqrt")) {
          v = Math.sqrt(v);
        }

        values.push(v);
      } else {
        values.push(Double.parseDouble(s));
      }
    }

    StdOut.printf("Expression value: %.3f\n", values.pop());
  }
}
