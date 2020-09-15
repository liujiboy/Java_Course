package code1015;


import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AbstractTableModelDemo extends JFrame{
public AbstractTableModelDemo() {
	MyTable myTable=new MyTable();
    JTable t=new JTable(myTable);
    JScrollPane s = new JScrollPane(t);
    add(s);
}
public static void main(String args[]) {
    AbstractTableModelDemo frame=new AbstractTableModelDemo();
    frame.setTitle("JTable");
    frame.setSize(300, 300);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
