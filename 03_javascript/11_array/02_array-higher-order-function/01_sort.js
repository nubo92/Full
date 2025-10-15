/** 배열 고차 함수  */
// sort: 배열의 요소를 정렬하는 메서드. 원본 배열을 직접 변경한다.

const numbers = [3, 1, 7, 10, 15, 4, 9];

// 그냥 호출하면 각 요소를 문자열로 취급하여 정렬한다. (의도와 다를 수 있음)
numbers.sort();
console.log(numbers);

// 숫자 오름차순으로 정렬하기 위해 '비교 규칙(콜백 함수)'을 알려준다.
// => 다른 장렬 기준을 사용하려면 매개변수로 compare 함수 전달

numbers.sort((a, b) => a - b);
// function compare(a, b) {
//     return a - b;
// }
console.log(numbers);

/**
 * a - b의 의미?
 * a - b가 음수면 a를 앞으로
 * a - b가 양수면 b를 앞으로
 * 결과적으로 오름차순 정렬이 된다.
 */

// 객체 배열도 정렬 가능
const users = [
    {name: '판다', age: 5},
    {name: '코알라', age: 3}
];

users.sort((a, b) => a.age - b.age);     // 나이 기준 정렬
console.log(users);