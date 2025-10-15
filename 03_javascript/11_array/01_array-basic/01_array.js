/**
 * array(배열)
 * 배열은 여러 개의 값을 순차적으로 나열한 자료구조이다.
 */

// 배열 리터럴을 통해 배열 생성
const fruits = ['바나나', '복숭아', '키위', '사과'];

// 배열의 요소는 자신의 위치를 나타내는 인덱스를 가지며 배열의 요소에 접근할 때 사용된다.
console.log(fruits[0]);
console.log(fruits[2]);

// 배열은 요소의 개수, 즉 배열의 길이를 나타내는 length 프로퍼티를 갖는다.
console.log(fruits.length);

// 배열은 인덱스와 length 프로퍼티를 갖기 때문에 for문을 통해 순차적으로 요소에 접근할 수 있다.
for (let i = 0; i < fruits.length; i++) {
    console.log(fruits[i]);
}

console.log(typeof fruits);