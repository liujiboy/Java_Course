package code1013;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
public class TreeNodeConstructTree extends JFrame{
	public TreeNodeConstructTree() {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("字母表");
		DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("大写字母");
		DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("小写字母");
		DefaultMutableTreeNode node3 = new DefaultMutableTreeNode("Readme");
		root.add(node1);
		root.add(node2);
		root.add(node3);
		node1.add(new DefaultMutableTreeNode("A"));
		node1.add(new DefaultMutableTreeNode("B"));
		node1.add(new DefaultMutableTreeNode("C"));
		node2.add(new DefaultMutableTreeNode("a"));
		node2.add(new DefaultMutableTreeNode("b"));
		node2.add(new DefaultMutableTreeNode("c"));
		JTree tree = new JTree(root);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(tree);
		add(scrollPane);
	}
	public static void main(String[] args) {
		TreeNodeConstructTree frame=new TreeNodeConstructTree();
		frame.setTitle("TreeNodeConstructTree");
	    frame.setSize(300, 300);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
}