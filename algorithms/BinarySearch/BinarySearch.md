# Binary Search Algorithm

Finds the index of an element in a sorted Array or returns `-1` if not found.

## Implementations

### Java

> [BinarySearch.java](./BinarySearch.java)

```java
public static int indexOf(int[] a, int key) {
  int lo = 0;
  int hi = a.length - 1;

  while (lo <= hi) {
    int mid = lo + (hi - lo) / 2;
    if (key < a[mid])
      hi = mid - 1;
    else if (key > a[mid])
      lo = mid + 1;
    else
      return mid;
  }
  return -1;
}
```

Usage:

```sh
java BinarySearch ./data/whitelist.txt < ./data/targets.txt
java BinarySearch ./data/whitelist.txt < ./data/targets.txt | more
```

### JavaScript

> [BinarySearch.js](./BinarySearch.js)

```js
function binarySearch(a, target) {
  var lo = 0;
  var hi = a.length - 1;

  while (lo <= hi) {
    var mid = Math.floor(lo + (hi - lo) / 2);

    if (target < a[mid]) {
      hi = mid - 1;
    } else if (target > a[mid]) {
      lo = mid + 1;
    } else {
      return mid
    }
  }

  return -1;
}
```

## More Resources

* [Source Code | Algorithms (4th edition)](https://algs4.cs.princeton.edu/11model/BinarySearch.java.html)
* [Binary search (article) | Algorithms | Khan Academy](https://www.khanacademy.org/computing/computer-science/algorithms/binary-search/a/binary-search)