import java.time.LocalDateTime;
import java.util.Scanner;

public class Memo {
    // 멤버 변수
    private MemoList        memoList;
    private Scanner         sc;
    
    // Constructor
    public Memo() {
        memoList = new MemoList();
        sc = new Scanner(System.in);
    }

    // 메모 작성 구현
    public void memoWrite()
    {   
        String          user;
        String          pw; 
        String          contents;
        LocalDateTime   date;

        // 메모 작성전 입력해야하는 정보(작성자명, 비밀번호) 입력받기
        System.out.println("----메모 작성하기----");
        System.out.println("작성자 명 입력 ---->");
        user = sc.nextLine();

        pw = Passward.createPassward();

        // 내용 작성
        System.out.println("내용을 작성해 주세요.");
        contents = sc.nextLine();
        System.out.println("유저명: " + user + "(" + contents + ")");
        
        // 날짜 입력
        date = LocalDateTime.now();

        // 내용을 리스트에 저장
        memoList.setter(user, pw, contents, date);
    }


    // 메모장 목록 보여주기
    public void getMemoList() {
        System.out.println("글번호\t작성시간\t\t작성자\t\t내용");
        System.out.println("-----------------------------------------------------------------------");
        for (int i=memoList.getLength(); i>0; i--)
        {
            var data = memoList.getter(i-1);

            if (data.isOutOfIndex()) continue;

            System.out.println(data.get_index() + "\t" + data.get_date() + "\t" + data.get_user() + "\t" + data.get_contents());
        }
    }

    // 메모장 내용 수정하기
    //  - 수정할 글 번호를 입력 받는다.
    //  - 수정할 글이 존재하면 글을 수정하고 존재하지 않으면 존재하지 않는다고 메시지를 출력한다.
    //  - 수정할 글의 비밀번호를 입력 받는다.
    //  - 글을 수정하기 위해 입력한 비밀번호와 수정할 글의 비밀번호가 일치하면 글을 수정하고 일치하지 않으면 비밀번호가 일치하지 않는다는 메시지를 출력한다.
    //  - 비밀번호가 일치할 시 : 수정 내용 업데이트
    //  - 비밀번호 불일치 시 : 비밀번호가 일치하지 않는다는 메시지 출력
    public void memoModify() {

        int index = -1;

        System.out.println("수정할 글 번호를 입력하세요.");
        index = Integer.valueOf(sc.nextLine());

        // m_MemoList << 여기서 비교할 리스트를 가져온다.

        var data = memoList.getter(index -1);

        if (data.isOutOfIndex() || data.isDeleted()) {
            System.out.println("수정할 메모가 존재하지 않습니다.");    
        }
        
        if (!Passward.isCorrectedPassward(data)) {
            System.out.println("비밀번호가 일치하지 않습니다. 메뉴로 돌아갑니다.");
            return;
        }
        
        System.out.println("수정할 글의 내용을 입력하세요.");
        String newMemo = sc.nextLine();
        memoList.modify(index-1, newMemo);

    }

    // 메모장 내용 삭제하기
    public void memoDelete() {
        int index = -1;

        System.out.println("삭제할 글 번호를 입력하세요.");
        index = Integer.valueOf(sc.nextLine());

        // m_MemoList << 여기서 비교할 리스트를 가져온다.
        var data = memoList.getter(index -1);

        if (data.isOutOfIndex()) {
            System.out.println("삭제할 메모가 존재하지 않습니다.");    
        }
        
        if (!Passward.isCorrectedPassward(data)) {
            System.out.println("비밀번호가 일치하지 않습니다. 메뉴로 돌아갑니다.");
            return;
        }

        System.out.println("해당 메모를 삭제합니다.");
        this.memoList.delete(index-1);
    }
}
