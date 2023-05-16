package four;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.*;

class ListInfoFrame extends JFrame
{

    public ListInfoFrame(Vector<Vector<String>> userinfo)
    {
        this.setTitle("用户信息");
        this.setSize(550, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Vector<String> columnNames = new Vector() ; // 定义表格列名数组
        // 定义表格数据数组
        columnNames.add("账号");
        columnNames.add("生日");
        columnNames.add("性别");
        columnNames.add("爱好");
        columnNames.add("备注");
        Vector<Vector> users=new Vector<Vector>();
        Vector user=new Vector();
        user.add("zhagnsan");
        user.add("123456");
        user.add("2005-6-8");
        user.add("男");
        user.add("唱歌 跳舞");
        user.add("软件工程专业");
        users.add(user);

        // 创建指定列名和数据的表格
        DefaultTableModel tablemodel=new DefaultTableModel(userinfo,columnNames);
        JTable table = new JTable(tablemodel)
        {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTableHeader tableheader=table.getTableHeader();
        DefaultTableCellRenderer hr=(DefaultTableCellRenderer)tableheader.getDefaultRenderer();
        hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        tableheader.setBackground(Color.gray);
        Font font1=new Font("黑体",Font.BOLD,18);
        tableheader.setFont(font1);
        tableheader.setForeground(Color.white);

        DefaultTableCellRenderer cr=(DefaultTableCellRenderer)table.getDefaultRenderer(columnNames.getClass());
        cr.setBackground(Color.LIGHT_GRAY);
        Font font2=new Font("楷体",Font.PLAIN,20);
        table.setFont(font2);
        cr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        table.setForeground(Color.blue);
        table.setRowHeight(25);
        table.setSelectionBackground(Color.cyan);
        table.setSelectionForeground(Color.red);

        table.setRowSorter(new TableRowSorter<>(tablemodel));
        // 创建显示表格的滚动面板
        JScrollPane scrollPane = new JScrollPane(table);
        // 将滚动面板添加到边界布局的中间
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}