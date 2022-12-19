package menu;

import exception.queueEmptyException;
import login.logIn;
import service.*;
import util.Clear;

import java.awt.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class Dmenu  {
    private static Scanner r=new Scanner(System.in);
    public static void Menu() throws  IOException, InterruptedException {
        Clear.clean();
            while (true){
        System.out.println("\n\n\n");
        System.out.println("               ————医院病人排队就诊系统主菜单(医护版)————\n");
        System.out.println("               \t\t1.诊断病人\n");
        System.out.println("               \t\t2.查看所有排队病人信息\n");
        System.out.println("               \t\t3.查看医院日志\n");
        System.out.println("               \t\t4.切换用户\n");
        System.out.println("               \t\t0.退出系统\n");
        System.out.println("               ————-----------------------------————");
        System.out.println("               \t\t请输入序号选择相应功能\n");

        while (true){
            System.out.printf("               \t\t");
            int read = r.nextInt();
            if(read==1){
                diagnosisService.diagnosis();
            }
            else if(read==2){
                viewQueueService.viewQueue(2);
            }
            else if(read==3){
//                JournalService.pullJournal();
                JournalServiceTest.pullJournal();
            }
            else if(read==4){
                logIn.login();
            }
            else if(read==0){
                System.out.println("系统将在两秒后自动退出");
                System.out.println("感谢您的使用");
                Thread.sleep(2000);
                System.exit(0);
            }
        }

    }
}
    }

