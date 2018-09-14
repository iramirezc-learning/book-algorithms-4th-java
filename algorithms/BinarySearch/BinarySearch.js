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
