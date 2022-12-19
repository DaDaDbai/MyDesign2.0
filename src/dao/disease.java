package dao;

public class disease {
    public static String ease(int ease) {
        switch (ease){
            case 1:return "感冒";
            case 2:return "咳嗽";
            case 3:return "头痛";
            case 4:return "腹泻";
            case 5:return "胃疼";
            case 6:return "伤残";
            case 7:return "哮喘";
            case 8:return "中毒";
            case 9:return "烧伤";
           case 10:return "癌症";


        }
        return null;
    }
}
