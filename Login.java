package four;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Iterator;
import java.util.Vector;

public class Login extends JFrame implements ActionListener
{
    Vector<Vector<String>> userinfos;
    JLabel lb_name,lb_password;
    JTextField tf_name;
    JPasswordField tf_password;
    JButton bt_submit,bt_cancel;
    JButton bt_reg;

    public Login(Vector<Vector<String>> userinfos)
    {
        this.userinfos = userinfos;
        this.setTitle("登录界面");
        this.setSize(300,250);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        JPanel panel=new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER,10,25));
        lb_name=new JLabel("账号：");
        panel.add(lb_name);
        tf_name=new JTextField(18);
        panel.add(tf_name);
        lb_password=new JLabel("密码：");
        panel.add(lb_password);
        tf_password=new JPasswordField(18);
        panel.add(tf_password);
        bt_submit=new JButton("确定");
        bt_submit.addActionListener(this);
        panel.add(bt_submit);
        bt_cancel=new JButton("重置");
        bt_cancel.addActionListener(this);
        panel.add(bt_cancel);
        bt_reg=new JButton("注册");
        bt_reg.addActionListener(this);
        panel.add(bt_reg);

        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==bt_reg){
            new RegisterFrame(userinfos);
        }
        else if (e.getSource()==bt_cancel){
            tf_name.setText("");
            tf_password.setText("");
        }
        else if (e.getSource()==bt_submit){
            Iterator it = userinfos.iterator();//创建构造器方便调用数组
            boolean exist = false;   //用来进行判断
            String username = tf_name.getText();//方便循环时的调用，不用重复运行
            String password = String.valueOf(tf_password.getPassword());

            while (it.hasNext()){
                Vector<String> user = new Vector<String>();  //存放用户信息
                user = (Vector)it.next();
                if (user.get(0).equals(username) && user.get(1).equals(password)){
                    exist = true;
                    break;
                }
            }
            if (exist == true){
                this.dispose();
                new mainFrame(userinfos);
            }
            else {
                JOptionPane.showMessageDialog(this,"账号或密码输入错误！请重新输入");
                tf_name.setText("");
                tf_password.setText("");
                
            }
        }
    }
}

