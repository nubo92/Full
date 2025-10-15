/**
 * const는 let의 장점을 모두 가지면서, '재할당 금지'라는 강력한 규칙이 추가된 키워드이다.
 */

// 1. 선언과 동시에 반드시 초기화해야 한다.
// const GREETING;
const GREETING = '안녕하세요!';

// 2. 재할당이 금지됩니다.
// GREETING = '안녕히 가세요~!';   // TypeError: Assignment to constant variable.
console.log(GREETING);

// const와 객체
const student = {
    name: '판다',
    age: 5,
};

// student 변수를 다른 객체로 '바꿔치기'하는 것은 불가능하다.
// student = { name: '홍길동', age : 30 };     // TypeError: Assignment to constant variable.

// 객체 내부의 '내용물(프로퍼티)'을 변경하는 것은 가능하다.
student.name = '코알라';
student.age = 7;
console.log(student);