import java.time.LocalDateTime;
import java.util.Scanner;

public class Memo {
    // 멤버 변수
    int m_Number;
    String m_User;
    int m_PW;
    String m_Contents;
    LocalDateTime m_Date;

    // 구현 내용
    public Memo() {

    }

    // 메모 작성 구현
    public void MemoWrite() {
        // this.m_User = user;
        // this.m_Contents = contents;

        /*
         scanner -> string 값이 들어옴
         int 로 바꾸고, 단, string 값이 4가 아니면 재입력 받게 하기
         범위(0000~9999)
         저장할때 string을 int로 변환해서 배열에 넣기
         -> string : string 비교할때 연산을 엄청 먹어서 int로 변환하는게 유리한걸로 알거든요
        */

        // 입력내용 
        // this.m_PW = new int[4] {0, 0, 0, 0};

        // this.m_Date = LocalDateTime.now();

        // 내용을 리스트에 저장
    }

    // 메모장 목록 보여주기
    public void GetMemoList() {

    }

    // 메모장 내용 수정하기
//    - 수정할 글 번호를 입력 받는다.
//    - 수정할 글이 존재하면 글을 수정하고 존재하지 않으면 존재하지 않는다고 메시지를 출력한다.
//    - 수정할 글의 비밀번호를 입력 받는다.
//    - 글을 수정하기 위해 입력한 비밀번호와 수정할 글의 비밀번호가 일치하면 글을 수정하고 일치하지 않으면 비밀번호가 일치하지 않는다는 메시지를 출력한다.
//    - 비밀번호가 일치할 시 : 수정 내용 업데이트
//    - 비밀번호 불일치 시 : 비밀번호가 일치하지 않는다는 메시지 출력
    public void MemoModify() {
        int m_Number2;
        int m_PW2;

        System.out.println("수정할 글 번호를 입력하세요.");
        Scanner sc_Num = new Scanner(System.in);
        m_Number2 = sc_Num.nextInt();

        if (m_Number2 == m_Number) {
            System.out.println("비밀번호를 입력하세요.");
            Scanner sc_PW = new Scanner(System.in);
            m_PW2 = sc_PW.nextInt();
            if (m_PW == m_PW2) {
//                this.GetMemoList()
                System.out.println();
            } else {
                System.out.println("비밀번호가 일치하지 않습니다.");
            }
        } else {
            System.out.println("수정할 글이 존재하지 않습니다.");
            this.GetMemoList();
        }
    }



    // 메모장 내용 삭제하기
    public void MemoDelete() {

    }
}
