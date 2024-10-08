"use strict";

var _react = _interopRequireDefault(require("react"));
var _reactDom = _interopRequireDefault(require("react-dom"));
function _interopRequireDefault(e) { return e && e.__esModule ? e : { "default": e }; }
var app = function app() {
  return /*#__PURE__*/_react["default"].createElement("div", null, /*#__PURE__*/_react["default"].createElement("h1", null, "Hola Mundo desde React con Babel!"));
};
_reactDom["default"].createRoot(/*#__PURE__*/_react["default"].createElement(App, null), document.getElementById('root'));