/** 1. 함수 선언문 */

// 함수 선언문에서는 함수의 이름을 생략할 수 없다.
function hello(name) {
    return `${name}님 안녕하세요!`;
}

// 함수 호출
console.log(hello('홍길동'));

/** 2. 함수 표현식 */
// 함수 표현식에서는 함수명을 생략할 수 있다.
var hi = function(name) {
    return `${name} 안녕~`;
}

console.log(hi('홍길동'));

// 함수 표현식에서 함수명을 생략하지 않아도 문제는 없다.
var calc = function add(a, b) {
    return a + b;
}

// 단, 함수 호출은 식별자로 이루어 진다.
console.log(calc(10, 20));

// ReferenceError: add is not defined
// console.log(add(10, 20)); 