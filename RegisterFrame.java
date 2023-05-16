package four;

import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;

public class RegisterFrame extends JFrame implements ActionListener
{
    String years[]= {"2000","2001","2002","2003","2004","2005","2006","2007","2008"};
    String month[]= {"1","2","3","4","5","6","7","8","9","10","11","12"};
    Integer days[]=new Integer[31];
    JLabel lbl_username;
    JTextField tft_username;
    JLabel lbl_password;
    JPasswordField psf_password;
    JLabel lbl_confirm;
    JPasswordField psf_confirm;
    JComboBox cb_years;
    JComboBox cb_month;
    JComboBox cb_day;
    JRadioButton rab_male;
    JRadioButton rab_female;
    JCheckBox ck1;
    JCheckBox ck2;
    JCheckBox ck3;
    JButton bt_ok;
    JButton bt_reset;
    JButton bt_exit;
    JTextArea ta;

    Mainapp app = new Mainapp();

    public RegisterFrame(Vector<Vector<String>> userinfos)
    {
        this.setTitle("注册");
        this.setSize(350,400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);

        lbl_username=new JLabel("账号");
        lbl_username.setBounds(30, 30, 30, 20);
        this.add(lbl_username);
        tft_username=new JTextField(12);
        tft_username.setBounds(90, 30, 180, 20);
        this.add(tft_username);
        lbl_password=new JLabel("密码");
        lbl_password.setBounds(30, 60, 30, 20);
        this.add(lbl_password);
        psf_password=new JPasswordField(12);
        psf_password.setBounds(90, 60, 180, 20);
        this.add(psf_password);

        lbl_confirm=new JLabel("确认密码");
        lbl_confirm.setBounds(30, 90, 50, 20);
        this.add(lbl_confirm);
        psf_confirm=new JPasswordField(12);
        psf_confirm.setBounds(90, 90, 180, 20);
        this.add(psf_confirm);

        JPanel pl=new JPanel();
        pl.setBounds(30, 120, 400, 50);
        pl.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(pl);
        JLabel lbl_birthday=new JLabel("生日");
        pl.add(lbl_birthday);
        cb_years=new JComboBox(years);
        pl.add(cb_years);
        JLabel lbl_years=new JLabel("年");
        pl.add(lbl_years);
        cb_month=new JComboBox(month);
        pl.add(cb_month);
        JLabel lbl_month=new JLabel("月");
        pl.add(lbl_month);
        for(int i=0;i<31;i++)
        {
            days[i]=i+1;
        }
        cb_day=new JComboBox(days);
        pl.add(cb_day);
        JLabel lbl_day=new JLabel("日");
        pl.add(lbl_day);

        JPanel pl2=new JPanel();
        pl2.setBounds(30, 160, 400, 30);
        pl2.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(pl2);
        JLabel lbl_gender=new JLabel("性别");
        pl2.add(lbl_gender);
        ButtonGroup bg=new ButtonGroup();
        rab_male=new JRadioButton("男",true);
        bg.add(rab_male);
        pl2.add(rab_male);
        rab_female=new JRadioButton("女");
        bg.add(rab_female);
        pl2.add(rab_female);

        JPanel pl3=new JPanel(true);
        pl3.setBounds(30, 190, 400, 30);
        pl3.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(pl3);
        JLabel lbl_hobby=new JLabel("兴趣：");
        pl3.add(lbl_hobby);
        ck1=new JCheckBox("阅读");
        pl3.add(ck1);
        ck2=new JCheckBox("唱歌");
        pl3.add(ck2);
        ck3=new JCheckBox("跳舞");
        pl3.add(ck3);


        JLabel lbl_remarks=new JLabel("备注");
        lbl_remarks.setBounds(30, 230, 50, 20);
        this.add(lbl_remarks);
        ta=new JTextArea("请输入备注信息",5,30);
        ta.setBounds(80,230,200,80);
        ta.addFocusListener(new FocusListener()
        {

            @Override
            public void focusGained(FocusEvent e) {
                if(ta.getText().equals("请输入备注信息"))
                    ta.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(ta.getText().equals(""))
                    ta.setText("请输入备注信息");
            }

        });
        this.add(ta);

        JPanel p3=new JPanel();
        p3.setBounds(30, 320, 300, 50);
        this.add(p3);
        p3.setLayout(new FlowLayout(FlowLayout.CENTER));
        bt_ok=new JButton("注册");
        p3.add(bt_ok);
        bt_ok.addActionListener(this);
        bt_reset=new JButton("重置");
        p3.add(bt_reset);
        bt_reset.addActionListener(this);
        bt_exit=new JButton("退出");
        bt_exit.setActionCommand("exit");
        p3.add(bt_exit);
        bt_exit.addActionListener(this);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bt_ok)
        {	String info;
            String username=tft_username.getText();
            String password=String.valueOf(psf_password.getPassword());
            String confirm_password=String.valueOf(psf_confirm.getPassword());

            String birthday=cb_years.getSelectedItem()+"-"+cb_month.getSelectedItem()+"-"+cb_day.getSelectedItem();
            char gender=rab_male.isSelected()?rab_male.getText().charAt(0):rab_female.getText().charAt(0);
            String hobby="";
            if(ck1.isSelected())
                hobby+=ck1.getText()+" ";
            if(ck2.isSelected())
                hobby+=ck2.getText()+" ";
            if(ck3.isSelected())
                hobby+=ck3.getText();
            String remark=ta.getText();

            info="账号："+username+"\n"
                    +"密码："+password+"\n"
                    +"生日："+birthday+"\n"
                    +"性别："+gender+"\n"
                    +"爱好："+hobby+"\n"
                    +"备注："+remark;
            if(password.equals("")==false && password.equals(confirm_password)==false)
            {
                JOptionPane.showMessageDialog(this, "两次输入密码不一致！");
                psf_password.setText("");
                psf_confirm.setText("");
            }
            else{
                int option = JOptionPane.showConfirmDialog(this, info,"确认注册信息", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION)
                {
                    Vector<String> user = new Vector<String>();
                    user.add(username);
                    user.add(password);
                    user.add(birthday);
                    user.add("" + gender);
                    user.add(hobby);
                    user.add(remark);
                }
            }
        }else if(e.getSource()==bt_reset)
        {
            tft_username.setText("");
            psf_password.setText("");
            psf_confirm.setText("");
            cb_years.setSelectedIndex(0);
            cb_month.setSelectedIndex(0);
            cb_day.setSelectedIndex(0);
            rab_male.setSelected(true);
            ck1.setSelected(false);
            ck2.setSelected(false);
            ck3.setSelected(false);
            ta.setText("");
        }
        else if(e.getActionCommand().equals("exit"))
        {
            int option=JOptionPane.showConfirmDialog(this, "确定退出吗？","确认退出", JOptionPane.YES_NO_OPTION);
            if(option==JOptionPane.YES_OPTION)
                this.dispose();
            new Login(app.getUserinfos());
        }

    }

}