import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        boolean isQuit = false;
        int menuInput = -1;
        Memo memo = new Memo();
        Scanner sc = new Scanner(System.in);

        while (!isQuit){
            console();
    
            // 메뉴 입력받기 
            menuInput = sc.nextInt();
    
            switch(menuInput){
                // 메모 작성
                case 1:
                    memo.MemoWrite();
                    break;
                // 메모 목록 노출
                case 2:
                    memo.GetMemoList();
                    break;
                // 메모 수정

                case 3:
                    memo.MemoModify();
                    break;
                // 메모 삭제
                case 4:
                    memo.MemoDelete();
                    break;
                case 5:
                    // 콘솔창 종료
                    System.out.println("메모장이 종료됩니다.");
                    isQuit = true;
                    break;
                default:
                    System.out.println("잘못된 번호 입니다. 다시입력하세요.");
                    continue;
            }
        }

        sc.close();
    }

    // 콘솔창 구현부
    public static void console()
    {
        System.out.println("-------메모장-------");
        System.out.println("1. 메모 입력");
        System.out.println("2. 메모 목록");
        System.out.println("3. 메모 수정");
        System.out.println("4. 메모 삭제");
        System.out.println("5. 종료");
    }
}
