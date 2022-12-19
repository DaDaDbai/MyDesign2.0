package service;

import DS.patientQueue;
import dao.Patient;
import exception.queueEmptyException;
import menu.Dmenu;
import util.Clear;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class diagnosisService {
    private static Scanner r=new Scanner(System.in);
    static SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm");
    public static void diagnosis() throws IOException, InterruptedException {
        Clear.clean();
        try {
            Patient patient = patientQueue.pop();
            System.out.println("病人信息如下");
            System.out.println("病例号   姓名      年龄   性别    症状   入院时间");
            System.out.printf("%-9s",patient.getpId());
            System.out.printf("%-7s",patient.getpName());
            System.out.printf("%-7s",patient.getpAge());
            System.out.printf("%-7s",patient.getpSex());
            System.out.printf("%-7s",patient.getpSymptom());
            System.out.printf("%-10s\n",dateformat.format(patient.getpRegistrationTime()));


            System.out.println("开始诊断");
            Thread.sleep(1000);
            patient.setpDoctorInCharge("root");
            patient.setpRehabilitationTime(new Date());
            System.out.println("诊断完毕，安排病人");
//            JournalService.pushJournal(patient);
            new JournalServiceTest().pushJournal(patient);
            System.out.println();
            System.out.println("是否继续诊断?");
            System.out.println("按 1 继续诊断 任意键退出");
            String next = r.next();
            if("1".equals(next)){
                diagnosis();
            }else{
                Dmenu.Menu();
            }
        } catch (queueEmptyException e) {
            System.out.println("暂无病人可以诊断");
            System.out.println("按任意键返回");
            Scanner r = new Scanner(System.in);
            String next = r.next();
            Dmenu.Menu();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
