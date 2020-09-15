package code1014;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SimpleTable extends JFrame {
	public SimpleTable() {
		String[] columnNames = { "First Name", "Last Name", "Sport",
				"# of Years", "Vegetarian" }; // 表头名称
		Object[][] data = {
				{ "Kathy", "Smith", "Snowboarding", new Integer(5),
						new Boolean(false) },
				{ "John", "Doe", "Rowing", new Integer(3), new Boolean(true) },
				{ "Sue", "Black", "Knitting", new Integer(2),
						new Boolean(false) },
				{ "Jane", "White", "Speed reading", new Integer(20),
						new Boolean(true) },
				{ "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) } }; // 表数据
		JTable table = new JTable(data, columnNames);
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
	}

	public static void main(String[] args) {
		SimpleTable frame = new SimpleTable();
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setTitle("Simple Table");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
