package login;

import exception.queueEmptyException;
import menu.Dmenu;
import menu.Pmenu;
import sun.security.util.Resources;
import util.Clear;

import java.io.IOException;
import java.io.Serializable;
import java.util.ResourceBundle;
import java.util.Scanner;

public class logIn implements Serializable {
    static int test=3;
    static String name;
    static String pw;
    static {

        ResourceBundle bundle = Resources.getBundle("login/Duser");
        name = bundle.getString("username");
        pw = bundle.getString("userpw");
    }
    public static void login() throws  IOException, InterruptedException {
        Clear.clean();
        System.out.println("\n\n\n\n\n\n\n");
        System.out.println("                      用户身份为  1.病人 or 2.医护人员");
        System.out.println("           -----------------------------------------------------");
        Scanner r = new Scanner(System.in);
        System.out.printf("               ");
        int i = r.nextInt();
        if(i==1){
            Pmenu.Menu();
        }else if(i==2){
            while (true){
                Clear.clean();
                System.out.println("\n\n\n\n\n\n\n");
                System.out.println("                            请您输入账户与密码("+test+"/3)");
                System.out.println("       ------------------------------------------------------------------");
                System.out.printf("                账户名:");
                String userName = r.next();
                System.out.printf("\n                密码:");
                String userPw = r.next();
                if(userName.equals(name)&&userPw.equals(pw))
                    Dmenu.Menu();
                else {
                    if(test==1){
                        System.out.println("您已连续输入错误3次，关闭系统");
                        Thread.sleep(200);
                        System.exit(1);
                    }
                    test--;
                }
            }
        }
    }

    public static void main(String[] args) throws queueEmptyException, IOException, InterruptedException {
        new logIn().login();
    }
}
