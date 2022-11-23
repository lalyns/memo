    public class MemoList {
        private String m_User, m_Contents, m_Date;
        private int m_PW;
        private Memo allUsers;      // 객체간 상호관계
        private int count = 0;              // 순번
        MemoList arr[];

    public MemoList() {
        arr = new MemoList[10];     // 배열 초기화
    }
    public MemoList(String m_User, String m_Contents, String m_Date, int m_PW) {
        this.m_User = m_User;
        this.m_Contents = m_Contents;
        this.m_Date = m_Date;
        this.m_PW = m_PW;
    }

        // 목록 조회하기
    public void setUser() {
        this.m_User = m_User;
    }
    public void setContents() {
        this.m_Contents = m_Contents;
    }
    public void setDate() {
        this.m_Date = m_Date;
    }
    public void setPassword() {
        this.m_PW = m_PW;
    }


        // 메모 리스트 작성하기
    public void getUser() {
        return m_User;
    }
    public void getContents() {
        return m_Contents;
    }
    public void getDate() {
        return m_Date;
    }
    public void getPassword() {
        return m_PW;
    }

        // List 출력문
    public void printuserList() {
        System.out.println(count+" ID: "+m_User+" PW:"+m_PW+" Memo: "+m_Contents+" Time: "+m_Date);
    }
        // count를 기준으로 검색
    public void searchMemoList() {
        // ?
    }



    public Memo getallUsers() {
        return allUsers;
    }
    public void setAllUsers() {
        return allUsers;
    }
}
