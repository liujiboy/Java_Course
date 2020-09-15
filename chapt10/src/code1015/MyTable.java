package code1015;

import javax.swing.table.AbstractTableModel;

public class MyTable extends AbstractTableModel{
	String[] columnNames = {"First Name", "Last Name",  "Sport",  "# of Years",  "Vegetarian"};  //表头名称
	Object[][] data = {  //表数据
		{"Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false)},  
		{"John", "Doe",  "Rowing", new Integer(3), new Boolean(true)},  
		{"Sue", "Black", "Knitting", new Integer(2), new Boolean(false)},  
		{"Jane", "White", "Speed reading", new Integer(20), new Boolean(true)},  
		{"Joe", "Brown", "Pool", new Integer(10), new Boolean(false)}  
	};
	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
	@Override
	public int getRowCount() {
		return data.length;
	}
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
	}
	
}