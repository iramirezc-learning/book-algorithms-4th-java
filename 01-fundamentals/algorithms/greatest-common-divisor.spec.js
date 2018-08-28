const assert = require('assert');

const gcd = require('./greatest-common-divisor');
const { INTEGER_TYPE_ERROR } = require('../../utils/errors');

describe('Algorithm - Greatest Common Divisor', function () {
  describe('Error handling', function () {
    it('should throw an error when "p" is not an integer', function () {
      assert.throws(() => gcd('a', 1), INTEGER_TYPE_ERROR, 'argument "p" should throw an error');
    });

    it('should throw an error when "q" is not an integer', function () {
      assert.throws(() => gcd(1, null), INTEGER_TYPE_ERROR, 'argument "q" should throw an error');
    });
  });

  describe('Test cases', function () {
    const testCases = [
      { input: [54, 24], expected: 6 },
      { input: [180, 48], expected: 12 }
    ];

    let result;
    testCases.forEach(({ input, expected }) => {
      it(`should return: ${expected} for gcd(${input.join(', ')})`, function () {
        result = gcd.apply(null, input);
        assert.equal(result, expected);
      });
    });
  });
});