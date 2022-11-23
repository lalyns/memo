import java.io.Console;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        console();

        int menuInput = -1;
        Memo memo = new Memo();

        // 메뉴 입력받기 
        Scanner sc = new Scanner(System.in);
        menuInput = sc.nextInt();

        switch(menuInput){
            case 1:
                memo.MemoWrite(null, null, null);
                break;
            case 2:
                memo.GetMemoList();
                break;
            case 3:
                memo.MemoModify();
                break;
            case 4:
                memo.MemoDelete();
                break;
            case 5:
                // 콘솔창 종료
                break;
            default:
                System.out.println("잘못된 번호 입니다. 다시입력하세요.");
                console();
        }

        
        
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
