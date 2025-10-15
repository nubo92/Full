/**
 * 명시적 타입 변환
 * 개발자의 의도에 따라 값의 타입을 변환하는 것이다.
 * 자바스크립트에서 기본 제공하는 표준 빌트인 생성자 함수 (String, Number, Boolean)를
 * new 연산자 없이 호출하는 방법,
 * 빙트인 메서드를 사용하는 방법, 암묵적 타입 변환을 이용하는 방법이 있다.
 */

// 문자열 타입으로 변환

// 1. String 생성자 함수를 new 연산자 없이 호출
// 어떤 값이 들어올지 모를 때 가장 안정하게 쓸 수 있는 방법
console.log(String(10));    // '10'
console.log(String(true));  // 'true'
console.log(String(null));  // 'null'

// 2. toString 메서드 사용
// 변환하려는 값이 null이나 undefined일 경우 에러 발생
console.log((10).toString());    // '10'
// console.log(null.toString());    // TypeError: Cannot read properties of null (reading 'toString')

// 3. 문자열 연결 연산자 이용 - 암묵적 변환 챕터에서 확인함

// 숫자 타입으로 변환

// 1. Number 생성자 함수를 new 연산자 없이 호출(완벽히 숫자일때만)
console.log(Number('10'));    // 10
console.log(Number(false));   // 0
console.log(Number(true));    // 1
console.log(Number('10원'));  // NaN

// 2. parseInt, parseFloat 함수 이용 (문자열 -> 숫자만 가능)
console.log(parseInt('10.01'));      // 10
console.log(parseFloat('10.01'));    // 10.01
console.log(parseInt('10원'));       // 10
console.log(parseFloat('10원'));     // 10

// 3. + 단항 산술 연산자 이용 - 암묵적 변환 챕터에서 확인함

// 불리언 타입으로 변환
/**
 * Falsy (false, undefined, null, 0, NaN, '')는 false로,
 * 나머지는 모두 true로 바꿔주는 방법입니다.
 * Falsy 규칙을 그대로 적용
 */

// 1. Boolean 생성자 함수를 new 연산자 없이 호출하는 방법
console.log(Boolean('JavaScript'));  // true
console.log(Boolean(NaN));           // false

// 2. ! 부정 논리 연산자를 두번 사용하는 방법
console.log(!!'javascript');        // true
console.log(!!undefined);           // false