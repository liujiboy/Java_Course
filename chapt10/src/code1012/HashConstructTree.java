package code1012;

import java.util.Hashtable;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
public class HashConstructTree extends JFrame{
  public HashConstructTree(){
    String[] s1={"A","B","C"};	
    String[] s2={"a","b","c"};
    Hashtable<String,String[]> hashtable=new Hashtable<String,String[]>();
    hashtable.put("大写字母",s1);
    hashtable.put("小写字母",s2);
    JTree tree=new JTree(hashtable);
    JScrollPane scrollPane=new JScrollPane();
    scrollPane.setViewportView(tree);
  	add(scrollPane);	
  }		
  public static void main(String[] args){
	HashConstructTree frame=new HashConstructTree();
	frame.setTitle("HashConstructTree");
    frame.setSize(300, 300);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
  }
}