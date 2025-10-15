// map: 배열우ㅏ ㅁㅎ둔 요소에 대해 콜백 함수를 호출하고, 그 결과를 모아 '새로운 배열'을 만든다.
const numbers = [1, 2, 3, 4, 5];

// 각 숫자를 제곱한 새로운 배열 만들기
const squaredNumbers = numbers.map(num => num * num);
console.log(squaredNumbers);
console.log(numbers);   // 원본 배열에는 영향을 주지 않는다.

// 객체 배열에서 이름만 뽑아 새로운 배열 만들기
const students = [
    {name: '홍길동', age: 90},
    {name: '유관순', age: 95},
];

const studentNames = students.map(students => students.name);
console.log(studentNames);