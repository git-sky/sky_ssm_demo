package cn.com.sky.mybatis.book.domain;

public class User {

    private int uId;
    private String uName;
    private String uPwd;
    private String uEmail;
    private String uBio;

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }


    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuBio() {
        return uBio;
    }

    public void setuBio(String uBio) {
        this.uBio = uBio;
    }


    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uPwd='" + uPwd + '\'' +
                ", uEmail='" + uEmail + '\'' +
                ", uBio='" + uBio + '\'' +
                '}';
    }
}