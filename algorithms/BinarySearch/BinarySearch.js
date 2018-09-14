/**
 * Returns the index of the `target` in the array `a`
 * @param {array} a the sorted array
 * @param {*} target the value to search in the array
 */
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

module.exports = binarySearch;
