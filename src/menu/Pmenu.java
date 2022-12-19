package menu;

import exception.queueEmptyException;
import login.logIn;
import service.registerService;
import service.viewQueueService;
import util.Clear;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class Pmenu{
//   private static  BufferedReader SB = new BufferedReader(new InputStreamReader(System.in));
private static Scanner r=new Scanner(System.in);

    private Pmenu() {
    }

    public static void Menu() throws IOException, InterruptedException {
        Clear.clean();
        while (true)
        {
            System.out.println("\n\n\n");
            System.out.println("                   ————医院病人排队就诊系统主菜单————\n");
            System.out.println("                   \t1.病人挂号\n");
            System.out.println("                   \t2.查看所有排队病人信息\n");
            System.out.println("                   \t3.切换用户\n");
            System.out.println("                   \t0.退出系统\n");
            System.out.println("                   \t请输入序号选择相应功能\n");
            System.out.println("                   ————----------------------————");

            while (true){
                System.out.printf("                   \t");
                int read = r.nextInt();
                if(read==1){
                    registerService.register();
                }
                else if(read==2){
                    viewQueueService.viewQueue(1);
                }
                else if(read==3){
                    logIn.login();
                }else if(read==0){
                    System.out.println("系统将在两秒后自动退出");
                    System.out.println("感谢您的使用");
                    Thread.sleep(2000);
                    System.exit(0);
                }
            }

        }
    }
   }
