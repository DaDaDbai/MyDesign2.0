package service;

import dao.Patient;
import exception.queueEmptyException;
import menu.Dmenu;
import util.Clear;
import util.MyObjectOutputStream;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JournalServiceTest {
    static SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm");
    static Map<String,Patient> map=new HashMap<>();
    static File file = new File(System.getProperty("user.dir").replace("\\", "/")+"/Journal.txt");

    static Scanner r=new Scanner(System.in);
    public static void pushJournal(Patient patient){
        MyObjectOutputStream out=null;
        try {

            out =MyObjectOutputStream.getInstance(new FileOutputStream(file,true),file);
            out.writeObject(patient);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(out!=null) {
                try {
                    out.close();
                } catch (IOException e) {
                    System.out.println("文件未正常关闭");
                }
            }
        }
    }


    public static void pullJournal() throws InterruptedException, IOException {
        Clear.clean();
        ObjectInputStream in = null;
            in=new ObjectInputStream(new FileInputStream(file));
        try {
            System.out.println();
            System.out.println("      病例号   姓名      年龄   性别   症状  主治医生   入院时间   出院时间");
            System.out.println("--------------------------------------------------------------------------------");
            while (true){
                try {
                    Patient patient = (Patient) in.readObject();
                    map.put(patient.getpId(),patient);
                    System.out.printf("      %-9s",patient.getpId());
                    System.out.printf("%-7s",patient.getpName());
                    System.out.printf("%-7s",patient.getpAge());
                    System.out.printf("%-6s",patient.getpSex());
                    System.out.printf("%-7s",patient.getpSymptom());
                    System.out.printf("%-10s",patient.getpDoctorInCharge());
                    System.out.printf("%-10s",dateformat.format(patient.getpRegistrationTime()));
                    System.out.printf("%s\n",dateformat.format(patient.getpRehabilitationTime()));

                } catch (IOException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println();
            while (true){
                System.out.println("按 0 返回菜单，或输入病历号查看病人信息\n");
                System.out.printf("操作：");
                String next = r.next();
                if("0".equals(next))
                    Dmenu.Menu();
                else {
                    Clear.clean();
                    Patient patient = map.get(next);
                    System.out.println("查询到病人信息如下");
                    System.out.println();
                    System.out.println("      病例号   姓名      年龄   性别   症状  主治医生   入院时间   出院时间");
                    System.out.println("--------------------------------------------------------------------------------");
                    if(patient!=null){
                        System.out.printf("      %-9s",patient.getpId());
                        System.out.printf("%-7s",patient.getpName());
                        System.out.printf("%-7s",patient.getpAge());
                        System.out.printf("%-6s",patient.getpSex());
                        System.out.printf("%-7s",patient.getpSymptom());
                        System.out.printf("%-10s",patient.getpDoctorInCharge());
                        System.out.printf("%-10s",dateformat.format(patient.getpRegistrationTime()));
                        System.out.printf("%s\n",dateformat.format(patient.getpRehabilitationTime()));
                    }else {
                    System.out.println("                          未找到病人日志信息");
                    }
                    System.out.println("--------------------------------------------------------------------------------");
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("日志为空");
        } finally {
            if(in!=null) {
                try {
                    in.close();
                } catch (IOException e) {
                    System.out.println("文件未正常关闭");
                }
            }

        }
    }
}
