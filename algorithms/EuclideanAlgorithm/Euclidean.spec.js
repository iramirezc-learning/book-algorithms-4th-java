const assert = require('assert');
const euclidean = require('./Euclidean');

const testCases = [
  { "input": [3, 0], "expected": 3 },
  { "input": [0, 5], "expected": 5 },
  { "input": [54, 24], "expected": 6 },
  { "input": [180, 48], "expected": 12 },
  { "input": [15996751, 3870378], "expected": 4057 }
];

describe('Algorithm - Euclidean [Greatest Common Divisor]', function () {
  describe('Test cases', function () {
    let result;
    testCases.forEach(({ input, expected }) => {
      it(`should return: ${expected} for euclidean(${input.join(', ')})`, function () {
        result = euclidean.apply(null, input);
        assert.equal(result, expected);
      });
    });
  });
});