/**
 * 'new' 버튼을 눌렀을 때 내부에서 벌어지는 일 (인스턴스 생성 과정)
 */

function Student(name, age) {
    // 1단계: '빈 객체'가 암묵적으로 만들어지고, this에 할당한다.
    console.log(this);

    // 2단계: this에 할당된 빈 객체에 속성들을 추가하며 초기화합니다.
    this.name = name;
    this.age = age;
    this.getInfo = function() {
        return `${this.name}는 ${this.age}세 입니다.`;
    }
    // 3단계: 완성된 객체(this)가 암묵적으로 반환한다.
    //      마치 return this; 코드가 맨 마지막에 있는 것처럼 동작한다.
}

const student = new Student('판다', 5);
console.log(student);

/**
 * 설계도를 잘못 사용했을 때의 위험성(new 없이 호출)
 */

// new 없이 호출하면 생성자 함수가 아닌 '일반 함수'로 동작한다.
const student2 = Student('코알라', 7);
console.log(student2);
// 이때 함수 안의 this는  '전역 객체(window)'를 가리키게 된다. (전역 오염)
// console.log(window.name);  // '코알라'

/**
 * new.target을 이용한 안전장치 설치
 */

function Dog(name, age) {

    // 이 함수가 new와 함께 '생성자'로 호출되었는지 확인한다.
    // new와 함께 호출되면 new.target은 자기 자신(Dog 함수)을 가르킨다.
    // new 없이 '일반 함수'로 호출되면 new.target은 undefined가 된다.
    if (!new.target) {
        console.log('new 없이 호출했네요~ new를 붙여서 다시 실행합니다.');
        return new Dog(name, age);
    }

    this.name = name;
    this.age = age;
}

const dog = Dog('뽀삐', 5);
console.log(dog);