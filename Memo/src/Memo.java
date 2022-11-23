import java.time.LocalDateTime;

public class Memo {
    // 멤버 변수
    int m_Number;
    String m_User;
    int[] m_PW;
    String m_Contents;
    LocalDateTime m_Date;

    // 구현 내용
    public Memo() {
        
    }

    // 메모 작성 구현
    public void MemoWrite(String user, String pw, String contents)
    {
        this.m_User = user;
        this.m_Contents = contents;

        /*
         scanner -> string 값이 들어옴
         int 로 바꾸고, 단, string 값이 4가 아니면 재입력 받게 하기
         범위(0000~9999)
         저장할때 string을 int로 변환해서 배열에 넣기
         -> string : string 비교할때 연산을 엄청 먹어서 int로 변환하는게 유리한걸로 알거든요
        */

        // 입력내용 
        // this.m_PW = new int[4] {0,0,0,0};

        this.m_Date = LocalDateTime.now();

        // 내용을 리스트에 저장
    }

    // 메모장 목록 보여주기
    public void GetMemoList() {

    }

    // 메모장 내용 수정하기
    public void MemoModify() {

    }

    // 메모장 내용 삭제하기
    public void MemoDelete() {

    }
}
