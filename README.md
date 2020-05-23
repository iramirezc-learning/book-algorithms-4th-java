# algorithms-red-book

Code exercises and personal notes from the book [Algorithms (4th edition)](https://www.amazon.com/Algorithms-4th-Robert-Sedgewick/dp/032157351X) by Robert Sedgewick and Kevin Wayne.

> :warning: reading in progress...

## Book Resources

* [Video Lectures](http://www.informit.com/store/algorithms-video-lectures-24-part-lecture-series-9780134384436)
* [Booksite](https://algs4.cs.princeton.edu)
* [Standard Libraries](https://introcs.cs.princeton.edu/java/stdlib/)
* [Code & Solutions](https://algs4.cs.princeton.edu/code/)

## My Solutions

[Exercise List](chapters/exercises.list.md)

## Installation of `algs4.jar`

Follow these instructions ["Installing the textbook libraries"](https://algs4.cs.princeton.edu/code/) to install `algs4.jar`.

### For Mac OS X and `.zshrc`

Download  `algs4.jar` file to your classes folder like: `~/algs4` (or any other folder of your preference).

Edit `~/.zprofile` file:

```sh
sudo vim ~/.zprofile
```

Add the following line and save:

```txt
export MY_CLASSPATH=~/algs4
export CLASSPATH=$CLASSPATH:$MY_CLASSPATH/algs4.jar:$MY_CLASSPATH
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
