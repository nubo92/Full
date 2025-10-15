// for (i = 1; i<=9; i++) {
//     for (j = 1; j <= 9; j++) {
//         console.log(`${i} * ${j} = ${i*j}`);
//     }
// }

// //------------------------------------------------------------------------------

// // let userName = '이정희';
// // const MAX_SCORE = 100;
// // console.log(userName);
// // console.log(MAX_SCORE);

// //------------------------------------------------------------------------------

// const price = 19900;
// let productInfo = `제품 가격은 ${price}원 입니다.`;
// const isAvailable = true;
// console.log(price, typeof price)
// console.log(productInfo,typeof productInfo)

// //------------------------------------------------------------------------------

// let defaulName;
// const emptyComment = null;
// console.log(defaulName, typeof defaulName);
// console.log(emptyComment, typeof emptyComment);

// //------------------------------------------------------------------------------

// let productName = '블랙 몬스터 게이밍 마우스';
// const DISCOUNT_RATE = 0.15;
// let adminMemo;
// const isLowStock = true;
// console.log(productName, typeof productName);
// console.log(DISCOUNT_RATE, typeof DISCOUNT_RATE);
// console.log(adminMemo, typeof adminMemo);

// //------------------------------------------------------------------------------

// let result1 = 200 + '점';
// let result2 = true + '';
// console.log(result1, typeof result1);
// console.log(result2, typeof result2);

// //------------------------------------------------------------------------------

// let calResult1 = '100' - 10;
// let calResult2 = '5' * true;
// console.log(calResult1, typeof calResult1);
// console.log(calResult2, typeof calResult2);

// //------------------------------------------------------------------------------

// let rateText = String(98.6);
// let inputYear = Number('2025년');
// console.log(rateText, typeof rateText);
// console.log(inputYear, typeof inputYear);

// //------------------------------------------------------------------------------

// const emptyString = Boolean('');
// const nonExistentValue = Boolean(0);
// console.log(emptyString, typeof emptyString);
// console.log(nonExistentValue, typeof nonExistentValue);

// //------------------------------------------------------------------------------

// let userInput = '150';
// let isLogin = 'false';
// let height = Number(userInput);
// let isVerified = ''-isLogin;
// console.log(height, typeof height);
// console.log(isVerified, typeof isVerified);

// //------------------------------------------------------------------------------

// const numA = 10;
// const strA = '10';
// let resultsEqual = numA == strA;
// let resultStrict = numA === strA;
// console.log(resultsEqual);
// console.log(resultStrict);

//------------------------------------------------------------------------------

// const userName = '';
// const defaultName = '손님';
// let displayName = userName || defaultName;
// console.log(displayName);

//------------------------------------------------------------------------------

// const score = 75;
// const PASS_SCORE = 60;
// let passResult = score >= PASS_SCORE ? '합격' : '불합격';
// console.log(passResult);

//------------------------------------------------------------------------------

// const isVip = true;
// const ordercount = 3;
// let hasCoupon = (isVip || ordercount >= 5) ? true : false;
// console.log(hasCoupon);
// let message = (hasCoupon === true) ? '쿠폰 발금 대상입니다.' : '조건 미달입니다.';
// console.log(message);

// //------------------------------------------------------------------------------

// const currenHour = 14;
// if (currenHour < 12) {
//     console.log('오전입니다.');
// } else {
//     console.log('오후입니다.');
// }

// //------------------------------------------------------------------------------

// const score = 85;
// if (score >=90) {
//     console.log('A 등급');
// } else if (score >= 80) {
//     console.log('B 등급');
// } else {
//     console.log('C 등급');
// }

// //------------------------------------------------------------------------------

// const day = '화요일';
// switch(day) {
//     case '월요일': {
//         console.log('주간 회의 준비');
//         break;
//     }
//     case '화요일': case '수요일': {
//         console.log('개발 작업 진행');
//         break;
//     }
//     default: {
//         console.log('휴식 또는 자유 작업');
//         break;
//     }
// } 


//------------------------------------------------------------------------------

// for ( let i = 0; i <= 4; i++) {
//     console.log(i);
// }

//------------------------------------------------------------------------------

// let count = 0;
// while (count < 10) {
//     console.log(count);
//     count += 2;
// }

//------------------------------------------------------------------------------

// for (let i = 1; i <= 10; i++) {
//     if (i % 2 !== 0){
//         continue;
//     }
//     if (i === 8){
//         break;
//     }
//     console.log(i);
// }

//------------------------------------------------------------------------------

function sayHello() {
    console.log('안녕하세요, 풀스택 튜터입니다!');
}
sayHello();