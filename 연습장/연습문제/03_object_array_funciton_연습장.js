/**
 * 초급 문제 1-1.
 * 두 숫자를 매개변수로 받아 더 큰 숫자를 반환하는 
 * getBiggerNumber(num1, num2) 함수를 함수 선언문으로 정의하세요. 
 * 그리고 숫자 5와 12를 설정한 후, 함수를 호출하여 결과를 콘솔에 출력하는 테스트 코드를 작성하세요.
 */

function max(a, b){
    if(a > b){
        return a;
    }else{
        return b;
    };
}
console.log(max(40, 60));


// -------------------------------------------------------------------------------------------
// function getDifference(a, b) {
//     return a > b ? a - b : b - a;
// }
const getDifference = (a, b) => a > b ? a - b: b - a;
console.log(getDifference(25, 7));



// -------------------------------------------------------------------------------------------
function Student(name, grade) {
    this.name = name,
    this.grade = grade
}

const student = new Student('김철수', 3);

console.log(student);



// -------------------------------------------------------------------------------------------
let scores = [15, 85, 30, 70, 45];

const num = [...scores].sort((a, b) => b - a);

console.log(num);



// -------------------------------------------------------------------------------------------
const fruitList = [
  { name: '사과', price: 1500, color: 'red' },
  { name: '바나나', price: 800, color: 'yellow' },
  { name: '키위', price: 2000, color: 'green' }
];

function fruit(arr) {
    return arr.sort((a, b) => a.price - b.price);
}

const result = fruit(fruitList)
console.log(result);


const sortedAndMappedList = [...fruitList]
.sort((a, b) => a.price - b.price)
.map(fruit => {
    return {
        name: fruit.name,
        price: fruit.price
    };
});
console.log(sortedAndMappedList);



// -------------------------------------------------------------------------------------------
let numbers = [10, 35, 80, 42, 18];

// 여기에 코드를 작성하세요.

const isAnyLarge = numbers.some(num => num > 50);

console.log(`50보다 큰 숫자가 하나라도 존재하는가? ${isAnyLarge}`);

/*
예시 출력:
50보다 큰 숫자가 하나라도 존재하는가? true
*/