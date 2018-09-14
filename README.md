# Algorithms

Code exercises and personal notes from the book [Algorithms (4th edition)](https://www.amazon.com/Algorithms-4th-Robert-Sedgewick/dp/032157351X) by Robert Sedgewick and Kevin Wayne.

> :warning: still in progress...

## Resources from the book

* [Video Lectures](http://www.informit.com/store/algorithms-video-lectures-24-part-lecture-series-9780134384436)
* [Booksite](https://algs4.cs.princeton.edu)
* [Standard Libraries](https://introcs.cs.princeton.edu/java/stdlib/)
* [Code & Solutions](https://algs4.cs.princeton.edu/code/)

## Algorithms & Data Structures

### 1. Fundamentals

* [Euclidean Algorithm](./algorithms/EuclideanAlgorithm/Euclidean.md)
* [Binary Search](./algorithms/BinarySearch/BinarySearch.md)

#### 1.1 Basic Programming Model - [exercises](./exercises/section-1.1/answers-1.1.md)

#### 1.2 Data Abstraction - [exercises](./exercises/section-1.2/answers-1.2.md)

### 2. Sorting

### 3. Searching

### 4. Graphs

### 5. Strings

### 6. Context

## Installation of `algs4.jar`

Follow these instructions ["Installing the textbook libraries"](https://algs4.cs.princeton.edu/code/) to install `algs4.jar`.

### For Mac OS X and `.zshrc`

Download  `algs4.jar` file to folder `~/algs4`

Edit `~/.zprofile` file:

```sh
sudo vim ~/.zprofile
```

Add the following line and save:

```txt
export CLASSPATH=$CLASSPATH:~/algs4/algs4.jar
```

Do NOT forget to include the imports you need in your code:

```java
# in your code
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
```

Compile your java class:

```sh
javac BinarySearch.java
```

## Tests (Node.js)

Install `mocha` globally:

```sh
npm install -g mocha
```

Run test:

```sh
npm run test
```