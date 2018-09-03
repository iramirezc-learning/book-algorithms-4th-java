const { validateIsInteger } = require('../../utils');

function euclidean(p, q) {
  validateIsInteger('p')(p);
  validateIsInteger('q')(q);

  function gcd(p, q) {
    if (q === 0) return p;
    let r = p % q;
    return gcd(q, r);
  }

  return gcd(p, q);
}

module.exports = euclidean;