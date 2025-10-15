/**
 * 함수의 핵심 활용 : 콜백 함수(callback function)
 * 함수가 '일급 객체'이기 때문에 가능한 가장 실용적인 활용법이다.
 * 다은 함수의 '재료'로 전달되어, 그 함수의 실행 시점을 제어하는 함수이다.
 */


// 고차 함수 : 함수를 인자오 받는 함수
function calculator(calculateCallback, a, b) {
    console.log(`계산을 시작합니다.`);
    const result = calculateCallback(a, b);
    return result;
}


//  콜백 함수들
function add(a, b) {
    return a + b;
}

function multiply(a, b) {
    return a * b;
}

// 고차 함수에 콜백 함수를 '재료'처럼 전달
var addResult = calculator(add, 10, 5);
console.log('덧셈 결과 :', addResult);

var multiplyResult = calculator(multiply, 10, 5);
console.log('곱셈 결과 :', multiplyResult);

const numbers = [3, 10, 1, 4, 6, 2, 7];

// .sort() 라는 고차함수에 '정렬 기준'을 담은 콜백 함수를 전달합니다.
numbers.sort(function(a, b){
    // a - b거 음수면 a가 앞으로, 양수면 b가 앞으로 정렬됩니다.
    // return a - b;  // 오름차순 정렬 기준
    return b - a;  // 내림차순 정렬 기준
});

console.log(numbers);
