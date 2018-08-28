const isInteger = exports.isInteger = function (n) {
  return Number.isInteger(n);
};

exports.validateIsInteger = function (paramName) {
  return function validator(param) {
    if (!isInteger(param)) {
      throw new TypeError(`'${paramName}' should be an integer. Given: ${typeof param}`);
    }
  }
}