/**
 * 매개변수(parameter)와 인수(argument)
 */

// 함수 선언문
function hello(name) {   // 매개변수

    // 매개변수는 함수 몸체 내부에서만 참조할 수 있다.
    console.log(name);

    // 모든 인수는 암묵적으로 arguments 객체의 프로퍼티로 보관된다.
    console.log(arguments);  // 가변인자 함수 구현 시 유용하게 사용 된다.

    return `${name}님 안녕하세요!`;
}

// 매개변수는 함수 내부에서만 사용 가능해서 밖에서는 참조할 수 없다.
// console.log(name);    // ReferenceError: name is not defined

var result = hello('판다');   // 전당하는 값을 '인수(argument)'라고 한다.
console.log(result);


// 인수가 부족해서 할당되지 않은 매개변수의 값은 undefined이다.
result =  hello();
console.log(result);

// 매개변수보다 인수가 더 많은 경우 초과된 인수는 무시된다.
result = hello('코알라', '판다');
console.log(result);


function hi(name='호랑이'){
    // 인수를 전달하지 않았을 경우, ES6에서 도입된 매개변수 기본값을 사용할 수 있다.
    return `${name} 안녕~`;
}

result = hi();
console.log(result);