# Euclidean Algorithm

Finds the Greatest Common Divisor of two numbers.

## Implementations

### Java

> [Euclidean.java](./Euclidean.java)

```java
public static int gcd(int p, int q) {
  if (q == 0)
    return p;
  int r = p % q;
  return gcd(q, r);
}
```

### JavaScript

> [Euclidean.js](./Euclidean.js)

```js
function gcd(p, q) {
  if (q === 0) return p;
  let r = p % q;
  return gcd(q, r);
}
```

## More Resources

* [Euclidean Algorithm Explained Visually – Math Hacks – Medium](https://medium.com/i-math/why-does-the-euclidean-algorithm-work-aaf43bd3288e)
* [The Euclidean Algorithm (article) | Khan Academy](https://www.khanacademy.org/computing/computer-science/cryptography/modarithmetic/a/the-euclidean-algorithm)