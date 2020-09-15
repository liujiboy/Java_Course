package code1501;

import java.io.BufferedReader;
import java.io.FileReader;
public class Game {
	// 游戏角色的坐标位置
	private int x;
	private int y;
	// 游戏为8x8的地图
	private String map[][] = new String[8][8];
	// 记录推箱子的目标位置
	private String target[][] = new String[8][8];
	public Game() {
		// 从map文件加载地图信息
		try {
			BufferedReader reader = new BufferedReader(new FileReader("map.txt"));
			// 读取文件的一行
			String line = reader.readLine();
			int j = 0;
			while (line != null) {
				// 以空格为分隔符号，分割一行数据；
				String strs[] = line.split(" ");
				for (int i = 0; i < 8; i++) {
					map[i][j] = strs[i];
					if (strs[i].equals("T")) {
						// 记录目标位置
						target[i][j] = "T";
					} else {
						// 非目标位置记为O
						target[i][j] = "O";
					}
					// 记录角色的初始位置
					if (strs[i].equals("H")) {
						this.x = i;
						this.y = j;
					}
				}
				line = reader.readLine();
				j++;
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//角色向左移动
	public void moveLeft() {
		int a = x;
		int b = y;
		if (!map[a - 1][b].equals("W")) {
			if (map[a - 1][b].equals("B")) {
				if (!map[a - 2][b].equals("B") && !map[a - 2][b].equals("W")) {
					if (target[a][b].equals("T")) {
						map[a - 1][b] = "H";
						map[a][b] = "T";
						map[a - 2][b] = "B";
						x = a - 1;
					} else {
						map[a - 1][b] = "H";
						map[a][b] = "E";
						map[a - 2][b] = "B";
						x = a - 1;
					}
				}
			} else {
				if (target[a][b].equals("T")) {
					map[a - 1][b] = "H";
					map[a][b] = "T";
					x = a - 1;
				} else {
					map[a - 1][b] = "H";
					map[a][b] = "E";
					x = a - 1;
				}
			}
		}
	}
	//角色向右移动
	public void moveRight() {
		int a = x;
		int b = y;
		if (!map[a + 1][b].equals("W")) {
			if (map[a + 1][b].equals("B")) {
				if (!map[a + 2][b].equals("B") && !map[a + 2][b].equals("W")) {
					if (target[a][b].equals("T")) {
						map[a + 1][b] = "H";
						map[a][b] = "T";
						map[a + 2][b] = "B";
						x = a + 1;
					} else {
						map[a + 1][b] = "H";
						map[a][b] = "E";
						map[a + 2][b] = "B";
						x = a + 1;
					}
				}
			} else {
				if (target[a][b].equals("T")) {
					map[a + 1][b] = "H";
					map[a][b] = "T";
					x = a + 1;
				} else {
					map[a + 1][b] = "H";
					map[a][b] = "E";
					x = a + 1;
				}
			}
		}
	}
	//角色向上移动
	public void moveUp() {
		int a = x;
		int b = y;
		if (!map[a][b - 1].equals("W")) {
			if (map[a][b - 1].equals("B")) {
				if (!map[a][b - 2].equals("B") && !map[a][b - 2].equals("W")) {
					if (target[a][b].equals("T")) {
						map[a][b - 1] = "H";
						map[a][b] = "T";
						map[a][b - 2] = "B";
						y = b - 1;
					} else {
						map[a][b - 1] = "H";
						map[a][b] = "E";
						map[a][b - 2] = "B";
						y = b - 1;
					}
				}
			} else {
				if (target[a][b].equals("T")) {
					map[a][b - 1] = "H";
					map[a][b] = "T";
					y = b - 1;
				} else {
					map[a][b - 1] = "H";
					map[a][b] = "E";
					y = b - 1;
				}
			}
		}
	}
	//角色向下移动
	public void moveDown() {
		int a = x;
		int b = y;
		if (!map[a][b + 1].equals("W")) {
			if (map[a][b + 1].equals("B")) {
				if (!map[a][b + 2].equals("B") && !map[a][b + 2].equals("W")) {
					if (target[a][b].equals("T")) {
						map[a][b + 1] = "H";
						map[a][b] = "T";
						map[a][b + 2] = "B";
						y = b - 1;
					} else {
						map[a][b + 1] = "H";
						map[a][b] = "E";
						map[a][b + 2] = "B";
						y = b + 1;
					}
				}
			} else {
				if (target[a][b].equals("T")) {
					map[a][b + 1] = "H";
					map[a][b] = "T";
					y = b + 1;
				} else {
					map[a][b + 1] = "H";
					map[a][b] = "E";
					y = b + 1;
				}
			}
		}
	}
	//判断游戏是否结束
	public boolean isEnd() {
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++) {
				if (map[i][j].equals("T"))
					return false;
			}
		return true;
	}
	public String[][] getMap() {
		return map;
	}
}
