/**
 * 프로토타입 상송의 가장 중요한 규칙 두 가지
 * 1. 읽을 때는 올라가고, 쓸 때는 내 객체에서 쓴다.
 * 2. 메소드를 빌려와도, this는 내 자신을 가리킨다.
 */

const uset = {
    id: 'user',
    login: function() {
        console.log(`${this.id}님 로그인 되었습니다.`);
    }
};

const student = {
    __proto__: uset,   // student.__proto__ = user
};

// 규칙 1: '쓰기'는 프로토타입에 영향을 주지 않고, 자기 자신에세 프로퍼티를 만든다.
student.id = 'student01';

console.log('stydent.id = ', student.id);
console.log('user.id = ', uset.id);

// 규칙 2: user의 login 메소드를 빌려왔지만, this는 무조건 메소드를 호출하는
student.login();