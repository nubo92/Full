// const applePrice = 1500;
// let appleCount = 3;
// const bananaPrice = 2000;
// let bananaCount = 2;
// const orangePrice = 1000;
// let orangeCount = 5;

// let totalAmount = applePrice * (appleCount +=2) + bananaPrice * bananaCount + orangePrice * orangeCount;
// console.log(`총 금액은 ${totalAmount}원 입니다.`);


// let userAge = 14;
// let hasParent = true;
// if (userAge >= 15) {
//     console.log('👍 15세 이상 관람가 영화를 볼 수 있습닠다.');
// } else if (userAge >= 13 && hasParent === true) {
//     console.log('👍 보호자 동반으로 12세 관람가 영화를 볼 수 있습니다.');
// } else if (userAge >= 13 && hasParent === false) {
//     console.log('🚫 12세 관람가 영화는 보호자 동반이 필요합니다.');
// } else {
//     console.log('👶 모든 영화 관람이 불가능합니다.');
// }

// const purchaseAmounts = ['15000', '35000', '8000', '100000', '12000']; // 구매 금액 (문자열 배열)
// let totalPoints = 0; // 누적 포인트를 저장할 변수

// // 1. for 반복문을 사용하여 배열의 모든 요소를 순회
// for (let i = 0; i < purchaseAmounts.length; i++) {
    
//     // 2. 명시적 타입 변환 (String -> Number)
//     let amount = Number(purchaseAmounts[i]); 
//     let earnedPoints = 0; // 현재 구매 건의 적립 포인트
    
//     // 3. switch(true)를 이용한 범위 조건 확인
//     switch (true) {
        
//         case (amount >= 100000): // 10만원 이상이면 (5% 적립)
//             earnedPoints = amount * 0.05;
//             break;
            
//         case (amount >= 50000): // 5만원 이상이면 (3% 적립)
//             earnedPoints = amount * 0.03;
//             break;
            
//         case (amount >= 10000): // 1만원 이상이면 (1% 적립)
//             earnedPoints = amount * 0.01;
//             break;
            
//         default: // 그 외 (1만원 미만)
//             earnedPoints = 0;
//             break;
//     }
    
//     // 4. 할당 연산자로 총 포인트에 누적
//     totalPoints += earnedPoints; 
// }

// // 5. 최종 결과 출력
// console.log(`총 적립된 포인트: ${totalPoints}점 입니다.`); 
// // 예상 출력: 총 적립된 포인트: 5620점 입니다.


// const studentScores = ['95', '78', '42', '85', '60'];
// let passCount = 0;
// let failCount = 0;

// for(let  i = 0; i < studentScores.length; i++) {
//     let score = Number(studentScores[i]);
//     switch(true) {
//         case (score >= 90):
//             console.log('A 등급(합격)');
//             passCount++;
//             break;
//         case (score >= 80):
//             console.log('B 등급(합격)');
//             passCount++;
//             break;
//         case (score >= 70):
//             console.log('C 등급(합격)');
//             passCount++;
//             break;
//         case (score >= 60):
//             console.log('D 등급(합격)');
//             passCount++;
//             break;
//         default:
//             console.log('F 등급(불합격');
//             failCount++;
//             break;
//     }
// }
// console.log(`총 합격자 : ${passCount}명, 총 불합격자 : ${failCount}명`);

// const totalMission = 10;
// let bonusCoount = 0;

// for (let i = totalMission; i > 0; i--) {
//     if (i % 2 !== 0){
//         console.log(`🎆${i}번 미션 완료! 보너스 획득!`);
//         bonusCoount++;

//     } else {
//         console.log(`${i}번 미션 완료!`);

//     }
// }
// console.log(`최종 획득 보너스 : ${bonusCoount}개`);

// let studentScores = ['93', '28', '59', '82', '78', '60', '54', '98','85']
// let scoreMean = 0;
// let A = 0;
// let B = 0;
// let C = 0;
// let D = 0;
// let F = 0;

// for (let i = 0; i < studentScores.length; i++) {
//     let score = Number(studentScores[i]);
//     scoreMean += score;
//     if (score >= 90) {
//         A++;
//     } else if (score >= 80) {
//         B++;
//     } else if (score >= 70) {
//         C++;
//     } else if (score >= 60) {
//         D++;
//     } else {
//         F++;
//     }
// }
// scoreMean = scoreMean / studentScores.length;
// console.log(`A : ${A}`);
// console.log(`B : ${B}`);
// console.log(`C : ${C}`);
// console.log(`D : ${D}`);
// console.log(`F : ${F}`);
// console.log(`평균 점수 : ${scoreMean}`);
// console.log(`최고점 : ${Math.max(...studentScores)}`);
// console.log(`최저점 : ${Math.min(...studentScores)}`);


// let studentScores = ['92', '45', '81', '67', '100', '73', '56', '88', '99'];
// let totalStudent = 0;
// let totalScore = 0;
// let passCount = 0;
// let failCount = 0;

// for (let i = 0; i < studentScores.length; i++) {
//     let score = Number(studentScores[i]);
//     totalStudent++;
//     if (score >= 90) {
//         console.log(`${score}점 → 장학금 대상!`);
//         totalScore++;
//     } else if (score < 90 && score >= 60) {
//         console.log(`${score}점 → 합격`);
//         passCount++;
//     } else {
//         console.log(`${score}점 → 불합격`);
//         failCount++;
//     }
// }

// console.log(`총 학생 : ${totalStudent}명`);
// console.log(`총 장학금 대상자 수 : ${totalScore}명`);
// console.log(`총 합격자 : ${passCount}명`);
// console.log(`총 불합격자 : ${failCount}명`);


const password = "pAwOrd 13";
const MAX_LENGTH = 10;
let isValid = true;

// for (let i = password; i < MAX_LENGTH; i++) {
//     if (password.length > MAX_LENGTH){
//         isValid = false;
//         console.log(`암호 길이가 최대 길이${MAX_LENGTH}를 초과하였습니다.`);
//         break;
//     } 
//     if (password[i] === ' ') {
//         console.log(`[${i}번째] 공백 문자는 건너뜁니다.`);
//         continue ;
//     } 
//     if (password[i] =='!' || password[i] == '#') {
//         isValid = false;
//         console.log(`[${i}번째] 보안에 취약한 문자 ${password[i]}가 포함되어 있습니다.`);
//         break;
//     }
// }
// console.log(`\n최종 유효성 결과: ${isValid}`);

if (password.length > MAX_LENGTH){
    isValid = false;
    console.log(`암호 길이가 최대 길이${MAX_LENGTH}를 초과하였습니다.`);
} else{
    for (let i = 0; i < password.length; i++) {
        if (password[i] === ' ') {
            console.log(`[${i}번째] 공백 문자는 건너뜁니다.`);
            continue ;
        } 
        if (password[i] =='!' || password[i] == '#') {
            isValid = false;
            console.log(`[${i}번째] 보안에 취약한 문자 ${password[i]}가 포함되어 있습니다.`);
            break;
        }
    }
}
console.log(`\n최종 유효성 결과: ${isValid}`);

// // 1. 변수 선언
// const password = "pA$$wOrd 123";
// const MAX_LENGTH = 10;
// let isValid = true; // 최종 유효성 검사 결과

// // 2. for 반복문 (비밀번호 문자열을 순회)
// for (let i = 0; i < password.length; i++) {
    
//     // 현재 검사 중인 문자 (Character)
//     const char = password[i]; 
    
//     // [조건 1 - break]: 길이 초과 검사 (i가 10이 되면)
//     // 인덱스 i는 0부터 시작하므로, i가 MAX_LENGTH와 같아지면 (11번째 문자) 길이 초과입니다.
//     if (i >= MAX_LENGTH) {
//         isValid = false;
//         console.log(`[${i}번째] 길이 제한 ${MAX_LENGTH}를 초과했습니다. 검사 중단.`);
//         break; // break: 반복문을 즉시 완전히 종료합니다.
//     }

//     // [조건 2 - continue]: 공백 문자 건너뛰기
//     if (char === ' ') {
//         console.log(`[${i}번째] 공백 문자는 건너뜁니다.`);
//         continue; // continue: 아래 코드를 무시하고 다음 반복(i++)으로 넘어갑니다.
//     }
    
//     // [조건 3 - if & 논리 OR]: 보안 취약 문자 검사
//     // '!' 이거나 ' #' 이면 (논리 OR 연산자 || 사용)
//     if (char === '!' || char === '#') { 
//         isValid = false;
//         console.log(`[${i}번째] 보안에 취약한 문자 '${char}' 발견. 검사 중단.`);
//         break; // break: 취약점 발견 시 즉시 반복문 종료
//     }

//     // (보안에 문제가 없는 경우)
//     // console.log(`[${i}번째] 문자 '${char}' 검사 통과.`);
// }

// // 3. 최종 결과 출력
// console.log(`\n최종 유효성 결과: ${isValid}`); 
// // 출력: 최종 유효성 결과: false (길이 초과로 인해)