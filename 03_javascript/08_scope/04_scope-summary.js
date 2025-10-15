let globalVar = '전역 변수';    // 가장 넒은 스코프

if (true) {
    let bloxkVar = '블록 스코프 변수';      // if문 안에서만 유효

    function sayHi() {
        let functionVar = '함수 스코프 변수';    // sayHi 함수 안에서만 유효

        console.log(globalVar);
        console.log(bloxkVar);
        console.log(functionVar);
    }
    sayHi();

    console.log('if문');
    // console.log(functionVar);   // ReferenceError: functionVar is not defined   함수 밖에서는 접근 불가
}

// console.log(bloxkVar);  // ReferenceError: bloxkVar is not defined  블록 밖에서는 접금 불가


/**
 * 원치 1: 기본적으로 모든 변수는 const로 선언한다. (가장 안전)
 * 원칙 2: 값이 반드시 바뀌어야만 하는 변수에만 let을 사용한다.
 * 원칙 3: var는 이제 사용하지 않는다.
 */