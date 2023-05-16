package four;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

class mainFrame extends JFrame implements ActionListener{
    JButton jb1 ;
     Vector<Vector<String>> userinfos;

    public mainFrame(Vector<Vector<String>> userinfos){
        this.userinfos = userinfos;
        this.setTitle("用户信息");
        this.setSize(400,450);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        jb1  = new JButton("查看用户信息");
        jb1.addActionListener(this);
        this.add(jb1);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb1){
            new ListInfoFrame(userinfos);
        }

    }



}
