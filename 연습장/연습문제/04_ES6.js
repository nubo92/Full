/*
1. 클래스와 메서드 정의
- Animal 클래스를 정의하고 name과 sound를 속성으로 갖습니다.
- Animal 클래스는 sound를 출력하는 speak 메서드를 가집니다.
- Animal 클래스를 상속받은 Dog 클래스를 정의하고,
- Dog 클래스에 새로운 속성을 추가해 보세요.
- Dog 클래스에 Animal 클래스의 speak 메서드를 재정의(오버라이딩) 합니다.
- Dog 클래스를 통해 객체를 생성하고 speak 메서드를 호출하세요.
*/

class Animal {
    constructor(name, sound) {
        this.name = name;
        this.sound = sound;
    }
    speak() {
        console.log(`${this.sound}`);
    }
}

class Dog extends Animal {
    constructor(name, sound, year) {
        super(name, sound);
        this.year = year;
    }
    speak(){
        console.log(`${this.name}`);
    }
}

const dog = new Dog('퍼피', '왈왈', 3);

dog.speak();



/*
2. Getter와 Setter 활용
- Rectangle 클래스를 정의하고 width와 height 속성을 갖습니다.
- 면적을 계산하는 getter인 `area`를 추가하세요.
- width 또는 height를 변경할 수 있도록 setter를 추가하세요.
- Rectangle 클래스를 통해 객체를 생성하고 면적을 출력한 뒤 width를 변경하고 다시 면적을 출력하세요.

예시 출력:
면적: 50
변경 후 면적: 75
*/

class Rectangle {
    constructor(width, height){
        this._width = width;
        this._height = height;
    }
    get area() {
        return this._width * this._height;
    } 
    set width(wid){
        this._width = wid;
    }
    set height(hei){
        this._height = hei;
    }
}

const xy = new Rectangle(10, 5)
console.log(`변경전 : ${xy.area}㎥`);

xy.width = 15;
console.log(`와이드 변경 : ${xy._width}, 변경 후 : ${xy.area}㎥`);


/*
3. Rest 파라미터와 Spread 문법 활용
- 두 개의 함수 sumAll과 mergeArrays를 작성하세요.
    1. sumAll 함수는 가변 인수를 받아 모든 숫자의 합을 반환합니다.
    2. mergeArrays 함수는 두 개의 배열을 인수로 받아 두 배열을 합친 새 배열을 반환합니다.
- 두 함수를 각각 호출하여 결과를 출력하세요.

예시 출력:
합계: 15
병합된 배열: [1, 2, 3, 4, 5, 6]
*/

// 방법 1
function sumAll(num1, ...num2){
    let num = num1
    for(let num3 of num2){
        num += num3
    }
    return num
}

// 방법 2
// const sumAll = (...numbers) => {
//     return numbers.reduce((acc, cur) => acc + cur, 0);
// };

console.log(sumAll(1, 2, 3, 4, 5));


const number1 = [1, 2, 3];
const number2 = [4, 5, 6];

// 배열 합치기가 아니라 문자열로 변환이 됨
// function mergeArrays1([...number1], [...number2]) {
//     return [...number1] + ',' + [...number2]
// }
// console.log(mergeArrays1(number1, number2));

// 방법 1
// function mergeArrays(arr1, arr2){
//     return [...arr1, ...arr2]
// };

// 방법 2
const mergeArrays = (arr1, arr2) =>[...arr1, ...arr2];
console.log(mergeArrays([1, 2, 3],[4, 5, 6]));


/*
4. 구조분해 할당 활용
- User 클래스를 생성하고 name, age, location 속성을 초기화합니다.
- 구조분해 할당을 사용하여 name과 age를 추출하고 이를 이용해 "name은 age살입니다." 형태의 문장을 출력하세요.

임의의 배열을 리터럴로 생성하고,
- 구조분해 할당을 사용하여 배열에서 첫 번째 요소와 나머지 요소를 분리하여 출력하세요.

예시 출력:
홍길동은 30살입니다.
첫 번째 요소: 1
나머지 요소: [2, 3, 4, 5]
*/

const user = {
    name: '홍길동',
    age: 30,
    location: '서울'
}

const {name, age} = user;
console.log(`${name}은 ${age}살 입니다.`);


const numbers = [1, 2, 3, 4, 5]
const [firstNum, ...lastNum] = numbers
console.log(`첫 번째 요소 : ${firstNum}`);
console.log(`나머지 요소 : ${lastNum}`);



/*
5. 클래스와 구조분해 할당을 활용한 학생 관리 시스템
- Student 클래스를 정의하고 name, age, score 속성을 추가하세요.
- 3명의 학생 데이터를 가진 배열 students를 생성하세요.
- 구조분해 할당을 사용하여 학생들의 이름과 점수만 배열로 추출하여 출력하세요.

예시 출력:
학생 이름: [유관순, 홍길동, 장보고]
학생 점수: [90, 80, 70]
*/

class Student{
    constructor(name, age, score){
        this._name = name;
        this._age = age;
        this._score = score;
    }
};

const students = [
    new Student('유관순', 16, 90),
    new Student('홍길동', 20, 80),
    new Student('장보고', 18, 70),
    
]

console.log(students);

//-----------------------------------------------------------------------------------------
// .map()문 활용
const names = students.map(({ _name }) => _name);
const scores = students.map(({ _score }) => _score);

// 구조 분해 할당이 이뤄이는 순간
// students.map(student => {
//     const { _name } = student; // ← 구조분해 할당
//     return _name;
// });

console.log(names);
console.log(scores);



//-----------------------------------------------------------------------------------------
// for ~of 문 활용
let names1 = [];
let scores1 =[];

for (let {_name, _score} of students){
    names1.push(_name);
    scores1.push(_score);
}
console.log(names1);
console.log(scores1);



