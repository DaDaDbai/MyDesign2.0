package dao;

import java.io.Serializable;
import java.util.Date;

public class Patient implements Serializable {
    private static final long serialVersionUID = 4390482518182625971L;
    private String pName;
//    病人姓名
private String pSex;
//    病人的性别
    private String pAge;
//    病人的年龄
    private String pId;
//    病人病历号
    private String pType;
//    病人类型
    private String pDoctorInCharge="尚未就诊";
//    主治医生
    private String pSymptom;
//    病人症状
    private Date pRegistrationTime;
//    病人的挂号时间
    private Date pRehabilitationTime;
//    病人的康复时间
    private int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "pName='" + pName + '\'' +
                ", pSex='" + pSex + '\'' +
                ", pAge='" + pAge + '\'' +
                ", pId='" + pId + '\'' +
                ", pType='" + pType + '\'' +
                ", pDoctorInCharge='" + pDoctorInCharge + '\'' +
                ", pSymptom='" + pSymptom + '\'' +
                ", pRegistrationTime=" + pRegistrationTime +
                ", pRehabilitationTime=" + pRehabilitationTime +
                '}';
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpSex() {
        return pSex;
    }

    public void setpSex(String pSex) {
        this.pSex = pSex;
    }

    public String getpAge() {
        return pAge;
    }

    public void setpAge(String pAge) {
        this.pAge = pAge;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getpType() {
        return pType;
    }

    public void setpType(String pType) {
        this.pType = pType;
    }

    public String getpDoctorInCharge() {
        return pDoctorInCharge;
    }

    public void setpDoctorInCharge(String pDoctorInCharge) {
        this.pDoctorInCharge = pDoctorInCharge;
    }

    public String getpSymptom() {
        return pSymptom;
    }

    public void setpSymptom(String pSymptom) {
        this.pSymptom = pSymptom;
    }

    public Date getpRegistrationTime() {
        return pRegistrationTime;
    }

    public void setpRegistrationTime(Date pRegistrationTime) {
        this.pRegistrationTime = pRegistrationTime;
    }

    public Date getpRehabilitationTime() {
        return pRehabilitationTime;
    }

    public void setpRehabilitationTime(Date pRehabilitationTime) {
        this.pRehabilitationTime = pRehabilitationTime;
    }

    public Patient() {
    }

    public Patient(String pName, String pSex, String pAge, String pId, String pType, String pDoctorInCharge, String pSymptom, Date pRegistrationTime, Date pRehabilitationTime) {
        this.pName = pName;
        this.pSex = pSex;
        this.pAge = pAge;
        this.pId = pId;
        this.pType = pType;
        this.pDoctorInCharge = pDoctorInCharge;
        this.pSymptom = pSymptom;
        this.pRegistrationTime = pRegistrationTime;
        this.pRehabilitationTime = pRehabilitationTime;
    }
}
