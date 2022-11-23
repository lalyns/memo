import java.time.LocalDateTime;
import java.util.ArrayList;

class MemoDataType
{
    int _index;
    String _user;
    int _pw;
    String _contents;
    LocalDateTime _date;

    public MemoDataType() {}

    public MemoDataType(int index, String user, int pw, String contents, LocalDateTime date) {
        this._index     = index;
        this._user      = user;
        this._pw        = pw;
        this._contents  = contents;
        this._date      = date;
    }
    public int get_index() { return _index; }
    public String get_user() { return _user; }
    public int get_pw() { return _pw; }
    public String get_contents() { return _contents; }
    public LocalDateTime get_date() { return _date; }
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
            return new MemoDataType();
        }
        return list.get(index);
    }

    public int GetLength() {
        return this.list.size();
    }

    // 메모 리스트 작성하기
    public void Setter(String user, int pw, String contents, LocalDateTime date) {
        count++; 
        MemoDataType data = new MemoDataType(count, user, pw, contents, date);
        list.add(data);
    }

    // 메모 리스트 내용 작성하기
    public void Modify(int index, String context)
    {
        MemoDataType data = this.Getter(index);
        data._contents = context;
    }
}
