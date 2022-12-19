package service;

import DS.patientQueue;
import dao.Patient;
import exception.noPersonFoundException;
import exception.queueEmptyException;
import menu.Dmenu;
import menu.Pmenu;
import util.Clear;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static menu.Pmenu.Menu;

/**
 * 这个类用来书写队列查看功能
 */

public class viewQueueService {
    private static Scanner r = new Scanner(System.in);
    public static void viewQueue(int TYPE) throws IOException, InterruptedException {
        Clear.clean();
        List<Patient> patients = patientQueue.toErgodicLine();
        System.out.println("显示队列前5位问诊人员如下\n");
        System.out.println("                       病例号   姓名      性别   挂号医生");
        System.out.println("          --------------------------------------------------------         ");
        if(patients.size()!=0){
            if (patients.size()>5){
                for (int i = 0; i < 5; i++) {
                    System.out.printf("                       %-10s",patients.get(i).getpId());
                    System.out.printf("%-7s",patients.get(i).getpName());
                    System.out.printf("%-6s",patients.get(i).getpSex());
                    System.out.printf("root\n");
                }
                System.out.println("          --------------------------------------------------------         ");
            }
            else{
                for (int i = 0; i < patients.size(); i++) {
                    System.out.printf("                       %-10s",patients.get(i).getpId());
                    System.out.printf("%-7s",patients.get(i).getpName());
                    System.out.printf("%-6s",patients.get(i).getpSex());
                    System.out.printf("root\n");
                }
                System.out.println("          --------------------------------------------------------         ");
            }
        }else {
            System.out.println("                                  暂无病人");
            System.out.println("          --------------------------------------------------------         ");
        }
        while (true){
            System.out.println("输入病人病历号查询病人信息 或 按 0 退出查询");
            String next = r.next();
            if(next.equals("0"))
                break;
            Clear.clean();
            try {
                Patient select = patientQueue.select(next);
                System.out.println("查询结果如下");
                System.out.println("                 病例号    姓名     性别   挂号医生   还需等候人数");
                System.out.println("          --------------------------------------------------------         ");
                System.out.printf("                %-9s",select.getpId());
                System.out.printf("%-7s",select.getpName());
                System.out.printf("%-7s",select.getpSex());
                System.out.printf("root       ");
                System.out.println(select.getPosition());


            } catch (noPersonFoundException e) {
                System.out.println("查询结果如下");
                System.out.println("                 病例号    姓名     性别   挂号医生   还需等候人数");
                System.out.println("          --------------------------------------------------------         ");
                System.out.println("                          未发现该用户");
            }
            System.out.println("          --------------------------------------------------------         ");
            System.out.println("按任意键继续查询，按 0 退出查询");
            String flag = r.next();
            if ("0".equals(flag)){
                break;
            }
        }
        if(TYPE==1)
            Pmenu.Menu();
        else
            Dmenu.Menu();


    }

}
