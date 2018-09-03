# Euclidean Algorithm

Finds the Greatest Common Divisor of two numbers.

## Implementations

### JavaScript

```js
function gcd(p, q) {
  if (q === 0) return p;
  let r = p % q;
  return gcd(q, r);
}
```

> [euclidean.js](./euclidean.js)

## More Resources

* [Euclidean Algorithm Explained Visually – Math Hacks – Medium](https://medium.com/i-math/why-does-the-euclidean-algorithm-work-aaf43bd3288e)
* [The Euclidean Algorithm (article) | Khan Academy](https://www.khanacademy.org/computing/computer-science/cryptography/modarithmetic/a/the-euclidean-algorithm)