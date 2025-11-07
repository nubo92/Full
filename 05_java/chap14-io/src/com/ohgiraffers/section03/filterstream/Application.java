package com.ohgiraffers.section03.filterstream;

import java.io.*;

public class Application {
    public static void main(String[] args) {

        /* BuffersdWriter / BuffersdReader : 버퍼(임시 공간)를 이용하여 성능을 향상시키는 보조스트림
        * 데이터를 일단 버퍼에 모아뒀다가, 버퍼가 꽉 차면 한번에 쓴다. -> 성능 향상*/

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/com/ohgiraffers/section03/filterstream/testBuffered.txt"))) {

            bw.write("안녕하세요.");
            bw.write("반갑습니다.");

            // bw.flush() // 버퍼가 다 차기 전에 강제로 내보내고 싶을 때 사용
            // 지금은 try-with-resources 구문을 사용하기 때문에 flush가 자동 실행 된다.
            // clise()를 호출하면 내부적으로 flush()를 하고 나서 자원을 반납하기 때무.

        } catch (IOException e) {
            e.printStackTrace();
        }

        try( BufferedReader br = new BufferedReader(new FileReader("src/com/ohgiraffers/section03/filterStream/testBuffered.txt"))) {

            /* readLine() : 버퍼의 한 줄을 읽어와서 문자열로 반환, 더 이상 읽을 줄이 없으면 null을 반환 */
            String temp;
            while((temp = br.readLine()) != null) {
                System.out.println(temp);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
