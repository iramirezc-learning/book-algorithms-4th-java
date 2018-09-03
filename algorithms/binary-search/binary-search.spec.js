const assert = require('assert');

const binarySearch = require('./binary-search');
const testCases = require('./data/binary-search.test-cases.json');

describe('Algorithm - Binary Search', function () {
  describe('Test cases', function () {
    let result;
    testCases.forEach(({ input, expected }) => {
      it(`should return: ${expected} for binarySearch(${input.join(', ')})`, function () {
        result = binarySearch.apply(null, input);
        assert.equal(result, expected);
      });
    });
  });
});