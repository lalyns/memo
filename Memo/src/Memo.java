import java.time.LocalDateTime;
import java.util.Scanner;

public class Memo {
    // 멤버 변수
    int m_Number;
    String m_User;
    int m_PW;
    String m_Contents;
    LocalDateTime m_Date;
    MemoList m_MemoList;

    // Constructor
    public Memo() {
        m_MemoList = new MemoList();
    }

    // 메모 작성 구현
    public void MemoWrite()
    {   
        Scanner sc = new Scanner(System.in);

        // 메모 작성전 입력해야하는 정보(작성자명, 비밀번호) 입력받기
        System.out.println("----메모 작성하기----");
        System.out.println("작성자 명 입력 ---->");
        this.m_User = sc.nextLine();

        /*
         scanner -> string 값이 들어옴
         단, string 길이 값이 4가 아니면 재입력 받게 하기
         범위(0000~9999)
         저장할때 string을 int로 변환해서 저장
        */

        System.out.println("비밀번호 입력(0000~9999)");
        String temp = sc.nextLine();
        boolean isCorrect = false;
        // 입력받은 값이 4자리가 아니거나 0000~9999의 수가아닐경우 재입력
        while (!isCorrect) {
            if (temp.length() != 4) {
                System.out.println("비밀번호가 유효하지 않습니다. 다시입력해주세요.");
                temp = sc.nextLine();
            }
            else {
                // 입력받은 문자열이 숫자가 아닐경우 
                try
                {
                    this.m_PW = Integer.parseInt(temp);
                    isCorrect = true;
                }
                catch (NumberFormatException e)
                {
                    System.out.println("비밀번호가 유효하지 않습니다. 다시입력해주세요.");
                    temp = sc.nextLine();
                }
            }
        }

        // 내용 작성
        System.out.println("내용을 작성해 주세요.");
        this.m_Contents = sc.nextLine();
        System.out.println("유저명: " + this.m_User + "(" + this.m_Contents + ")");
        
        // 날짜 입력
        this.m_Date = LocalDateTime.now();

        // 내용을 리스트에 저장
        m_MemoList.Setter(m_User, m_PW, m_Contents, m_Date);
    }


    // 메모장 목록 보여주기
    public void GetMemoList() {
        System.out.println("글번호\t작성자\t작성시간\t내용");
        System.out.println("-----------------------------------------------------------");
        for (int i=m_MemoList.GetLength(); i>0; i--)
        {
            MemoDataType temp = m_MemoList.Getter(i-1);
            System.out.println(temp.get_index() + "\t" + temp.get_user() + "\t" + temp.get_date() + "\t" + temp.get_contents());
        }
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
