/**
 * null 병합 연산자
 * 좌항의 피연산자가 null 또는 undefined인 경우 우항의 피연산자를 반환하고,
 * 그렇지 않으면 좌항의 피연산자를 반환한다.
 * 변수에 기본 값을 설정할 때 유용하다.
 */

var test = null ?? '기본 값';
console.log(test);

// 의도적으로 입력창을 비워둬서 빈 문자열도 유룟게 처리하고 싶거나,
// 삼품의 쟈고가 0개여야 하는 상황에 의도치 않은 기본 값이 설정 될 수 있다.
var value = '' || '기본 값';    // '기본 값'
console.log(value);

// null 병합 연산자는 nulll, undefined 가 아닐 경우 그대로 반환한다.
value = '' ?? '기본 값';
console.log(value);
