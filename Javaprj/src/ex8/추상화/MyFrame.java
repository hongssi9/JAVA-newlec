package ex8.추상화;

import java.awt.Frame;
import java.awt.Graphics;

public class MyFrame extends Frame{

	@Override
	public void paint(Graphics g) {
		g.drawLine(100, 100, 300, 300);
	}
}
