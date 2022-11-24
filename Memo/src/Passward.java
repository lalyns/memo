import java.util.Scanner;

// 1. 클래스가 어떠한 동작(매소드)를 가질지 생각해본다.
// 2. 이 클래스 내부에서 사용할 멤버변수 생각하기.
// 비밀번호 처리를 위한 클래스
public class Passward {

    private static Scanner sc = new Scanner(System.in);

    // 생성자
    public Passward() {};

    // 매소드

    /*
    scanner -> string 값이 들어옴
    단, string 길이 값이 4가 아니면 재입력 받게 하기 범위(0000~9999)
    */
    public static String createPassward() { 
        String pw = "";

        System.out.println("비밀번호 입력(0000~9999)");
        pw = sc.nextLine();

        boolean isCorrect = false;

        // 입력받은 값이 4자리가 아니거나 0000~9999의 수가아닐경우 재입력
        while (!isCorrect)
        {
            if(pw.length() != 4)
            {
                System.out.println("비밀번호가 유효하지 않습니다. 다시입력해주세요.");
                sc.nextLine();
                continue;
            }

            try {
                Integer.parseInt(pw);

            } catch (NumberFormatException e) {
                System.out.println("비밀번호가 유효하지 않습니다. 다시입력해주세요.");
                pw = sc.nextLine();
                continue;
            }
            isCorrect = true;
        }


        return pw; 
    };
    public boolean isCorrectedPassward(String pw) { 
        
        return true; 
    };


}
