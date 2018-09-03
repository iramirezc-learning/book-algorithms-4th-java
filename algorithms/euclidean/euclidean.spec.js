const assert = require('assert');

const euclidean = require('./euclidean');
const testCases = require('./data/euclidean.test-cases.json');
const { INTEGER_TYPE_ERROR } = require('../../utils/errors');

describe('Algorithm - Euclidean [Greatest Common Divisor]', function () {
  describe('Error handling', function () {
    it('should throw an error when "p" is not an integer', function () {
      assert.throws(() => euclidean('a', 1), INTEGER_TYPE_ERROR, 'argument "p" should throw an error');
    });

    it('should throw an error when "q" is not an integer', function () {
      assert.throws(() => euclidean(1, null), INTEGER_TYPE_ERROR, 'argument "q" should throw an error');
    });
  });

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