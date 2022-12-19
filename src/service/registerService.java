package service;

import DS.patientQueue;
import dao.Patient;
import dao.disease;
import exception.queueEmptyException;
import menu.Pmenu;
import util.Clear;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

import static menu.Pmenu.Menu;

//该类用来处理病人的挂号服务
public class registerService {

    private static Scanner r=new Scanner(System.in);
    public static void register() throws InterruptedException, IOException {
        Clear.clean();
        Patient patient = new Patient();
        patient.setpRegistrationTime(new Date());
        while (true){
            System.out.printf("病人的姓名:");
            patient.setpName(r.next());
            System.out.println("病人的性别");
            System.out.println("1.男  2.女");
            while (true){
                String sex = r.next();
                if("1".equals(sex)){
                    patient.setpSex("男");
                    break;
                }else if("2".equals(sex)) {
                    patient.setpSex("女");
                    break;
                }else {
                    System.out.println("未知选项、请重新输入");
                }
            }
            System.out.printf("病人年龄:");

            while (true){
                String num;
                if(r.hasNextInt()){
                    num=r.next();
                    patient.setpAge(String.valueOf(Integer.parseInt(num)));
                    break;
                }else {
                    num=r.next();
                    System.out.println("未知数据，请重新输入");
                }

            }
            System.out.println("病人类型");
            System.out.println("1.普通  2.复诊  3.特殊病人");
            while (true){
                int sex = r.nextInt();
                if(sex==1){
                    patient.setpType("普通");
                    break;
                }else if(sex==2) {
                    patient.setpType("复诊");
                    break;
                }else if(sex==3) {
                    patient.setpType("特殊病人");
                    break;
                }else {
                    System.out.println("未知选项、请重新输入");
                }
            }
            System.out.println("是否保存(Y/N)");
            while (true){
                String next = r.next();
                if("Y".equals(next)||"y".equals(next)){
                    System.out.println("信息录入完毕");
                    int no = (int) Math.round(Math.random() * 999);
                    patient.setpId("ptu"+no);
                    System.out.printf("您的挂号为：ptu"+no);
                    Thread.sleep(1000);
                    System.out.println("\n请持遍历号等待传唤");
                    if("特殊病人".equals(patient.getpType()))
                    {
                        System.out.println("作为特殊病人，我们将为您优先处理");
//                --》
                        patient.setpSymptom(disease.ease((int)Math.round(Math.random() * 5)+5));
                        patientQueue.insert(patient,patientQueue.length());

                    }
                    else if("复诊".equals(patient.getpType()))
                    {
                        System.out.println("作为复诊人员，我们将为您进行插入处理");
//                --》
                        patient.setpSymptom(disease.ease((int)Math.round(Math.random() * 10)));
                        patientQueue.insert(patient,patientQueue.length()*2/3);

                    }else {
//                --》
                        patient.setpSymptom(disease.ease((int)Math.round(Math.random() * 5)));
                        patientQueue.add(patient);
                    }
                    break;
                }else if("N".equals(next)||"n".equals(next)){
                    break;
                }else {
                    System.out.println("错误选项，请重新输入");
                }
            }

            System.out.println("按 ‘0’继续挂号 按任意键返回");
            String next = r.next();
            if("0".equals(next)){
                registerService.register();
            }else
            Pmenu.Menu();


        }
    }

}

