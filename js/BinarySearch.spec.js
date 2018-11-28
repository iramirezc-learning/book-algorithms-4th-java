/* globals describe it */

const assert = require('assert')
const binarySearch = require('./BinarySearch')

const testCases = [
  {
    'input': [[1, 2, 3, 4, 5], 4], 'expected': 3
  },
  {
    'input': [[1, 2, 3, 4, 5], 6], 'expected': -1
  },
  {
    'input': [[1, 5, 10, 15, 20], 1], 'expected': 0
  },
  {
    'input': [[1, 5, 10, 15, 20], 20], 'expected': 4
  }
]

describe('Algorithm - Binary Search', function () {
  describe('Test cases', function () {
    let result
    testCases.forEach(({ input, expected }) => {
      it(`should return: ${expected} for binarySearch(${input.join(', ')})`, function () {
        result = binarySearch.apply(null, input)
        assert.strictEqual(result, expected)
      })
    })
  })
})
