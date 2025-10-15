/**
 * 생성자 함수
 */

const student1 = {
    name: '판다',
    age: 5,
    getInfo : function() {
        return `${this.name}는 ${this.age}세 입니다.`;
    }
}
const student2 = {
    name: '코알라',
    age: 7,
    getInfo : function() {
        return `${this.name}는 ${this.age}세 입니다.`;
    }
}


// 생성자 함수는 일반 함수와 구분하기 위해 첫 글자를 대문자로 작성하는 것이 관례이다.
function Student(name, age) {
    // this는 앞으로 '생성될 객체(인스턴스)'를 가리키는 키워드이다.
    this.name = name;
    this.age = age;
    this.getInfo = function() {
        return `${this.name}는 ${this.age}세 입니다.`;
    }
}

// 'new' 키워드를 사용하여 설계도로부터 실제 객체(인스턴스)를 생성한다.
const student3 = new Student('호랑이', 3);
const student4 = new Student('기린', 6);

console.log(student3);

console.log(student4.getInfo());
