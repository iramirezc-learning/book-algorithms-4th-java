# Exercises Chapter 1: Fundamentals

[<- index](../index.md)

## 1.2 Data Abstraction

### Exercises

---

**1.2.1 Write a `Point2D` client that takes an integer value `n` from the command line, generates `n` random points in the unit square and computes the distance separating the *closest pair* of points.**

> // TODO

**1.2.2 Write an `Interval1D` client that takes an `int` value `n` as command-line argument, reads `n` intervals (each defined by a pair of `double` values) from standard input and prints all pairs that intersect.**

> // TODO

**1.2.3 Write an `Interval2D` client that takes command-line arguments `n`, `min` and `max` and generates `n` random 2D intervals whose width and heigth are uniformly distributed between `min` and `max` in the unit square. Draw them on `StdDraw` and print the number of pairs of intervals that intersect and the number of intervals that are contained in one another.**

> // TODO

**1.2.4 Waht does the following code fragment print?**

```java
String string1 = "hello";
String string2 = string1;
string1 = "world";
StdOut.println(string1);
StdOut.println(string2);
```

> // TODO
>
> world
>
> world

**1.2.5 What does the following code fragment print?**

```java
String s = "Hello World";
s.toUpperCase();
s.substring(6, 11);
StdOut.println(s);
```

> Hello World
>
> Solution -> [Exercise_1_2_5.java](./Exercise_1_2_5.java)

**1.2.6 A string `s` is a _circular shift_ (or circular rotation) of a string `t` if it matches shwn the characters are circulary shifted by any number of positions; e.g., `ACTGACG` is a circular shift of `TGACCGAC`, and vice versa. Detecting this condition is important in the study of gneomic sequences. Write a program that checks whether two given strings `s` and `t` are circular shifts of one another. _Hint:_ The solutions is a one-liner with `indexOf()`, `length()` and string concatenation.**

**1.2.7 What dows the following recursive function return?**

```java
public static String mystery(String s) {
  int n = s.length();
  if (n <= 1) return s;
  String a = s.substring(0, n/2);
  String b = s.substring(n/2, n);
  return mystery(b) + mystery(a);
}
```

> // TODO
>
> it will return a string reversed

**1.2.8 Suppose that `a[]` and `b[]` are each integer arrays consisting of millions of integers. What does the follow code do? Is it reasonably efficient?**

```java
int[] t = a; a = b; b = t;
```

> // TODO
>
> It switches the contents of a and b. Yes, it is efficient since only changes the corresponding reference in memory.

**1.2.9 Instrument `BinarySeach` (page 47) to use a `Counter` to count the total number of key examined during all searches and then print the total after all searches are complete. _Hint:_ Create a `Counter` in `main()` and pass it as an argument to `indexOf()`.**

> // TODO

**1.2.10 Develop a class `VisualCounter` that allows both increment and decrement operations. Take two arguments `n` and `max` in the constructor, where `n` specifies the maximum number of operations and `max` specifies the maximum absolute value for the counter. As a side effect, create a plot showing the value of the counter each time its tally changes.**

> // TODO

**1.2.11 Develop and implementation `SmartDate` of our `Date` API that raises and exception if the date is not legal.**

> // TODO

**1.2.12 Add a method `dayOfTheWeek()` to `SmartDate` that returns a `String`value `Manday`, `Tuesday`, `Wednesday`, `Thursday`, `Friday`, `Saturday` or `Sunday` giving the appropiate day of the week for the date. You may assume that the date is the `21st` century.**

> // TODO

**1.2.13 Using our implementation of `Date` as a model (page 91), develop an implementation of `Transaction`.**

> // TODO

**1.2.14 Using our implementation of `equals()` in `Date` as a model (page 103), develop an implementation `equals()` for `Transaction`.**

> // TODO

### Creative Problems

---

**1.2.15 _File input._ Develop a static version of the `readAllInts()` method from `In` (which we use for various test clients, such as binary search on page 47) that is based on the `split()` method in `String`.**

> // TODO

**1.2.16 _Rational numbers._ Implement an immutable data type `Rational` for rational numbers that supports addition, substraction, multiplication and division.**

```java
public class Rational {
  Rational (int numerator, int denominator);
  Rational plus(Rational that); // sum of this number and that
  Rational minus(Rational that); // difference of this number and that
  Rational times(Rational that); // product of this number and that
  Rational divideBy(Rational that); // quotient of this number and that
  boolean equals(Object that); // is this number equal to that
  String toString(); // string representation
}
```

**You don't have to worry about testing for overflow (see Exercise1.2.17), but use as instance variables two `long` values that represent the numerator and denominator to limit the possibility of overflow. Use `Euclid's` algorithm (see page 4) to ensure that the numerator and denominator neve have any common factors. Include a test client that exercises all of your methods.**

> // TODO

**1.2.17 _Robust implementation of rational numbers._ Use assertions to develop an implementation of `Rational` (see Exercise 1.2.16) that is immune to overflow.**

> // TODO

**1.2.18 _Variance for accumulator._ Validate that the following code, which adds the methods `var()` and `stddev()` to `Accumulator`, computes both the sample mean, sample variance and sample standard deviation of the numbers presented as arguments to `addDataValue()`:**

```java
public class Accumulator {
  private double mu = 0.0;
  private double sum = 0.0;
  private int n = 0;

  public void addDataValue(double value) {
    n++;
    double delta = value - mu;
    mu += delta / n;
    sum += (double) (n - 1) / n * delta * delta;
  }

  public double mean() {
    return mu;
  }

  public double var() {
    if (n <= 1) return Double.NaN;
    return sum / (n - 1);
  }

  public double stddev() {
    return Math.sqrt(this.var());
  }
}
```

**This implementation is less susceptible to floating-point roundoff error than the straightforward implementation based on saving the sum of the squares of the numbers.**

> // TODO

**1.2.19 _Parsing_. Develop the parse constructors for your `Date` and `Transaction` implementations of Exercise 1.2.13 that take a single `String` argument to specify the initialization values, using the formats given in the table below.**

**_Partial solution:_**

```java
public Date(String date) {
  String[] fields = date.split("/");
  month = Integer.parseInt(fields[0]);
  day = Integer.parseInt(fields[1]);
  year = Integer.parseInt(fields[2]);
}
```

| type | format | example |
|------|--------|---------|
| Date | integers separated by slashes | 5/22/1939 |
| Transaction | customer, date and amount, separated by whitespace | Turing 5/22/1939 11.99 |

> // TODO
