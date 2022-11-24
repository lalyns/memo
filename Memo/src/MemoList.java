import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MemoList {

    static class MemoDataType
    {
        private int index;
        private String user;
        private String pw;
        private String contents;
        private String date;
        private boolean isDeleted;
        
        // 생성자
        public MemoDataType() {}
    
        public MemoDataType(int index, String user, String pw, String contents, String date) {
            this.index     = index;
            this.user      = user;
            this.pw        = pw;
            this.contents  = contents;
            this.date      = date;
            this.isDeleted = false;
        }

        public int get_index() { return index; }
        public String get_user() { return user; }
        public String get_pw() { return pw; }
        public String get_contents() { return contents; }
        public String get_date() { return date; }
        public boolean isDeleted() { return isDeleted; }
        public boolean isOutOfIndex() { return index == MemoList.OUTOFINDEX; }
    }
    
    static int count = 0;
    public static final int OUTOFINDEX = -1;
    private List<MemoDataType> list;

    public MemoList() {
       list = new ArrayList<>();
    }

    // 목록 조회하기
    public MemoDataType getter(int index) {
        if (index > this.list.size()) 
        { 
            System.out.println("인덱스 값을 초과했습니다."); 
            return new MemoDataType(OUTOFINDEX, null, null, null, null);
        }

        MemoDataType memo = list.get(index);
        if(memo.isDeleted()) return new MemoDataType(OUTOFINDEX, null, null, null, null);

        return memo;
    }

    public int getLength() {
        return this.list.size();
    }

    // 메모 리스트 작성하기
    public void setter(String user, String pw, String contents, LocalDateTime date) {
        count++; 
        String tDateTime = "";
        tDateTime = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        MemoDataType data = new MemoDataType(count, user, pw, contents, tDateTime);
        list.add(data);
    }

    // 메모 리스트 내용 작성하기
    public void modify(int index, String context)
    {
        MemoDataType data = this.getter(index);
        
        if(data.isDeleted())
        {
            return;
        }
        data.contents = context;
    }

    // 메모 리스트 내용 삭제하기
    //  - 글 1건을 삭제하는 메소드가 있다.
    //  - 글 삭제 후 글 번호를 다시 붙여준다.
    //  - 글이 삭제된 후 새 글이 입력될 때 idx가 기존 idx값에 이어서 1씩 증가할 수 있도록 count의 값을 수정한다.
    public void delete(int index) {
        MemoDataType data = this.getter(index);
        data.isDeleted = true;
    }
}
