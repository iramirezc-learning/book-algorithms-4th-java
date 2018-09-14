/**
 * Finds the Greatest Common Divisor of two positive integers.
 * @param {number} p number 1
 * @param {number} q number 2
 */
function euclidean(p, q) {
  if (q === 0) return p;
  let r = p % q;
  return euclidean(q, r);
}

module.exports = euclidean;