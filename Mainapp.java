package four;

import java.util.*;

public class Mainapp {
    Vector<Vector<String>> userinfos = new Vector<Vector<String>>();  //储存全部注册用户

    public Vector<Vector<String>> getUserinfos(){
        return userinfos;
    }
    public static void main(String[] args) {
        Mainapp app = new Mainapp();

        new Login(app.getUserinfos());
    }

}
