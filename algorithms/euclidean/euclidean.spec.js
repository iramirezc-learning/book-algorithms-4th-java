const assert = require('assert');

const euclidean = require('./euclidean');
const testCases = require('./data/euclidean.test-cases.json');

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