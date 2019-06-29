/**
 * Type: ADT
 * Description: An abstract data type for a stop watch
 * Ref: p. 175
 * 
 * Compilation: javac StopWatch.java
 */

/**
 * StopWatch
 */
public class StopWatch {

  private final long start;

  public StopWatch() {
    start = System.currentTimeMillis();
  }

  public double elapsedTime() {
    long now = System.currentTimeMillis();
    return (now - start) / 1000.0;
  }
}