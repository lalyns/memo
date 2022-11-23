import java.time.LocalDateTime;
import java.util.ArrayList;

class MemoDataType
{
    int _index;
    String _user;
    String _pw;
    String _contents;
    LocalDateTime _date;
    boolean _isDeleted;

    public MemoDataType() {}

    public MemoDataType(int index, String user, String pw, String contents, LocalDateTime date) {
        this._index     = index;
        this._user      = user;
        this._pw        = pw;
        this._contents  = contents;
        this._date      = date;
        this._isDeleted = false;
    }
    public int get_index() { return _index; }
    public String get_user() { return _user; }
    public String get_pw() { return _pw; }
    public String get_contents() { return _contents; }
    public LocalDateTime get_date() { return _date; }
    public boolean isDeleted() { return _isDeleted; }
}

public class MemoList {

    static int count = 0;
    ArrayList<MemoDataType> list;

    public MemoList() {
        list = new ArrayList<>();
    }

    // 목록 조회하기
    public MemoDataType Getter(int index) {
        if (index > this.list.size()) 
        { 
            System.out.println("인덱스 값을 초과했습니다."); 
            return new MemoDataType(-1, null, null, null, null);
        }

        MemoDataType memo = list.get(index);
        if(memo.isDeleted()) return new MemoDataType(-1, null, null, null, null);

        return memo;
    }

    public int GetLength() {
        return this.list.size();
    }

    // 메모 리스트 작성하기
    public void Setter(String user, String pw, String contents, LocalDateTime date) {
        count++; 
        MemoDataType data = new MemoDataType(count, user, pw, contents, date);
        list.add(data);
    }

    // 메모 리스트 내용 작성하기
    public void Modify(int index, String context)
    {
        MemoDataType data = this.Getter(index);
        
        if(data.isDeleted())
        {
            return;
        }

        data._contents = context;
    }

    // 메모 리스트 내용 삭제하기
    //  - 글 1건을 삭제하는 메소드가 있다.
    //  - 글 삭제 후 글 번호를 다시 붙여준다.
    //  - 글이 삭제된 후 새 글이 입력될 때 idx가 기존 idx값에 이어서 1씩 증가할 수 있도록 count의 값을 수정한다.
    public void Delete(int index) {
        MemoDataType data = this.Getter(index);
        data._index = -1;
    }
}
