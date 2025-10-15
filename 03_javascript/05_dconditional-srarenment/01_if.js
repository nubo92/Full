/**
 * 조건문 : if-else
 * if (조건식){
 *     // 조건식이 ture일 경우 실행구문
 * } else {
 *     // 조건식이 false일 경우 실행구문
 * }
 */

var temperature = 9;

if (temperature < 10) {
    console.log('오늘은 추룬 날씨입니다. 옷을 따듯하게 입으세요~!')  //조건이 참일 때 실향
} else {
    console.log('오늘은 날씨가 괜찮습니다.')   // 조건이 거짓일 때 실행
}

/**
 * 조건문 : if else if-else
 * if (조건식1) {
 *     // 조건식1이 ture일 경우 실행구문
 * } else if (조건식2) {
 *     // 조건식2이 ture일 경우 실행구문
 * } else {
 *     // 위의 조건식이 다 false일 경우 실행구문
 * }
 */

var score = 95;

if (score >= 90) {
    console.log("성적이 매우 우수합니다.")
} else if (score >= 70) {
    console.log('성적이 양호합니다')
} else if ( score >= 50) {
    console.log('성적이 보통입니다.')
} else {
    console.log('공부가 많이 필요합니다.')
}