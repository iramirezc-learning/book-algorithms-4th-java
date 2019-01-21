import java.util.Arrays;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Compilation: javac E1135.java
 * Execution: java E1135 <n_simulations>
 *
 * $ java E1135 999999
 * Exact Probability:
 * Dice Sum:   0   Freq:  0        P: 0.000
 * Dice Sum:   1   Freq:  0        P: 0.000
 * Dice Sum:   2   Freq:  1        P: 0.028
 * Dice Sum:   3   Freq:  2        P: 0.056
 * Dice Sum:   4   Freq:  3        P: 0.083
 * Dice Sum:   5   Freq:  4        P: 0.111
 * Dice Sum:   6   Freq:  5        P: 0.139
 * Dice Sum:   7   Freq:  6        P: 0.167
 * Dice Sum:   8   Freq:  5        P: 0.139
 * Dice Sum:   9   Freq:  4        P: 0.111
 * Dice Sum:  10   Freq:  3        P: 0.083
 * Dice Sum:  11   Freq:  2        P: 0.056
 * Dice Sum:  12   Freq:  1        P: 0.028
 * 
 * Min Throws: 35
 */

/**
 * E1135. Dice Simulation
 */
public class E1135 {
  public static int SIDES = 6;

  public static int[] calculateFrequencies() {
    int[] frequencies = new int[2 * SIDES + 1];

    for (int i = 1; i <= SIDES; i++)
      for (int j = 1; j <= SIDES; j++)
        frequencies[i + j]++;

    return frequencies;
  }

  public static double[] calculateProbability(int[] frequencies) {
    double[] probabilities = new double[2 * SIDES + 1];
    double totalCases = 36.0; // 6 sides * 6 sides

    for (int k = 2; k <= 2 * SIDES; k++)
      probabilities[k] = frequencies[k] / totalCases;

    return probabilities;
  }

  public static double roundToThreeDecimals(double n) {
    return Math.round(n * 1000.0) / 1000.0;
  }

  public static boolean isAMatch(double[] simulatedP, double[] exactP) {
    for (int i = 2; i < 2 * SIDES; i++) {
      if (roundToThreeDecimals(simulatedP[i]) < roundToThreeDecimals(exactP[i])) {
        return false;
      }
    }

    return true;
  }

  public static void printFrequencyAndProbability(int[] f, double[] p) {
    for (int i = 0; i < f.length; i++) {
      StdOut.printf("Dice Sum: %3d\tFreq: %2d\tP: %.3f\n", i, f[i], p[i]);
    }
    StdOut.println();
  }

  public static int throwDice() {
    return StdRandom.uniform(1, 6 + 1);
  }

  public static int runSimulation(double[] exactProbability) {
    int[] frequencies = new int[2 * SIDES + 1];
    int nThrows = 0;

    do {
      int dice1 = throwDice();
      int dice2 = throwDice();
      int sum = dice1 + dice2;
      frequencies[sum]++;
      nThrows++;
    } while (!isAMatch(calculateProbability(frequencies), exactProbability));

    // StdOut.println("Simulation:");
    // printFrequencyAndProbability(frequencies, calculateProbability(frequencies));
    // StdOut.println("Total throws: " + nThrows);

    return nThrows;
  }

  public static void main(String[] args) {
    if (args.length != 1) {
      throw new Error("You must provide the number of simulations");
    }
    int simulations = Integer.parseInt(args[0]);
    int minThrows = 1000;
    int[] exactFrequency = calculateFrequencies();
    double[] exactProbability = calculateProbability(exactFrequency);

    StdOut.println("Exact Probability:");
    printFrequencyAndProbability(exactFrequency, exactProbability);

    while (simulations-- > 0) {
      minThrows = Math.min(minThrows, runSimulation(exactProbability));
    }

    StdOut.println("Min Throws: " + minThrows);
  }
}