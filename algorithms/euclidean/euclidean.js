function euclidean(p, q) {
  if (q === 0) return p;
  let r = p % q;
  return euclidean(q, r);
}

module.exports = euclidean;