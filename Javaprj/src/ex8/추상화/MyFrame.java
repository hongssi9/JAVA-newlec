package ex8.μΆμν;

import java.awt.Frame;
import java.awt.Graphics;

public class MyFrame extends Frame{

	@Override
	public void paint(Graphics g) {
		g.drawLine(100, 100, 300, 300);
	}
}
