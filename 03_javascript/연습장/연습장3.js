// const AppConfig = (function() {
//     const ADMIN_NAME = 'Admin';
//     return {
//         getVersion() {
//             return 'v1.0';
//         },
//         checkUser(userName) {
//             return userName === ADMIN_NAME ? true : false;
//         }
// }})();

// // 결과 확인
// console.log(AppConfig.getVersion());        // 출력: v1.0
// console.log(AppConfig.checkUser('Admin'));  // 출력: true
// console.log(AppConfig.checkUser('Guest'));  // 출력: false
// // console.log(AppConfig.ADMIN_NAME);       // ReferenceError 또는 undefined여야 함 (외부 접근 불가)

const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on('line', function (line) {
    input = [line];
}).on('close',function(){
    let str = input[0];
    let abc = str.split('');
    console.log(abc);
    for(let i = 0; i <=abc; i ++){
        if (i == i.toUpperCase()) {
            console.log(i);
            return i.toLowerCase();
        } else {
            console.log(i);
            return i.toUpperCase();
        }
    }
});