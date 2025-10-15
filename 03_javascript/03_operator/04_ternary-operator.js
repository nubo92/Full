/**
 * 삼항 연산자는 조건식에 따라 두 값 중 하나를 선택하는 연산자이다.
 * 조건 ? 값1 : 값2
 * 조건이 ture일 경우 값1, false일 경우 값2 선택
 */

var age = 18;

// 1. 삼항 연산자 사용
var result = (age >= 20) ? '성인' : '미성년자';
console.log(result);    // '성인'

// 2. 중첩된 삼항 연산자
var score = 95;
var grade = (score >= 90) ? 'A' : (score >= 80) ? 'B' : (score >= 70) ? 'C' : 'D';
console.log(grade);