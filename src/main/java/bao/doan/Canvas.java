package bao.doan;

public class Canvas {
	char[][] points;
	int width;
	int height;

	public Canvas(int width, int height) {
		if (width <= 0 || height <= 0) {
			throw new IllegalArgumentException("Width and Height are higher zero");
		}
		this.width = width + 2;
		this.height = height + 2;
		points = new char[this.width][this.height];
		this.makeDefaultCanvas();
	}

	private void makeDefaultCanvas() {
		for (int i = 0; i < this.width; i++) {
			for (int j = 0; j < this.height; j++) {
				if (j == 0 || j == this.height - 1) {
					points[i][j] = '-';
				} else if (i == 0 || i == this.width - 1) {
					points[i][j] = '|';
				} else {
					points[i][j] = ' ';
				}
			}
		}
	}

	public void drawLine(int x1, int y1, int x2, int y2) {
		if (x1 < 0 || x2 < 0 || x1 < 0 || y2 < 0) {
			throw new IllegalArgumentException("Points have to be positive.");
		}
		if (x1 > width - 1 || x2 > width - 1 || y1 > height - 1 || y2 > height - 1) {
			throw new IllegalArgumentException("Points are outside the canvas.");
		}
		if (x1 != x2 && y1 != y2) {
			throw new IllegalArgumentException("Horizontal and vertical lines");
		}
		int min, max, temp;
		if (x1 == x2) {
			min = y1;
			max = y2;
		} else {
			min = x1;
			max = x2;
		}
		if (min > max) {
			temp = min;
			min = max;
			max = temp;
		}
		if (x1 == x2) {
			for (int i = min; i <= max; i++) {
				if (points[x1][i] == ' ') {
					points[x1][i] = 'x';
				}
			}
		} else {
			for (int i = min; i <= max; i++) {
				if (points[i][y1] == ' ') {
					points[i][y1] = 'x';
				}
			}
		}
	}

	public void drawRect(int x1, int y1, int x2, int y2) {
		if (x1 > x2 || y1 > y2) {
			throw new IllegalArgumentException("Illegal rectangle.");
		}
		drawLine(x1, y1, x2, y1);
		drawLine(x2, y1, x2, y2);
		drawLine(x2, y2, x1, y2);
		drawLine(x1, y2, x1, y1);

	}

	public void fillArea(int x, int y, char c) {
		if (x < 0 || y < 0) {
			throw new IllegalArgumentException("Points have to be positive.");
		}
		if (x > width - 1 || y > height - 1) {
			throw new IllegalArgumentException("Points are outside the canvas.");
		}
		boolean left = (x - 1 >= 0);
		boolean right = (x + 1 < this.width);
		boolean up = (y - 1) >= 0;
		boolean down = (y + 1) < this.height;
		if (points[x][y] == ' ') {
			points[x][y] = c;
		}
		else {
			return;
		}
		if (left) {
			fillArea(x - 1, y, c);
		}
		if (right) {
			fillArea(x + 1, y, c);
		}
		if (up) {
			fillArea(x, y - 1, c);
		}
		if (down) {
			fillArea(x, y + 1, c);
		}

	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				buffer.append(points[j][i]);
			}
			buffer.append('\n');
		}
		return buffer.toString();
	}
}
