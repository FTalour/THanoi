package tp4;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Line2D;

/**
 * @author Nicolas Roussel (roussel@lri.fr)
 * 
 */
class LineItem extends CanvasItem {

	public LineItem(PersistentCanvas c, Color o, Color f, Point p) {
		super(c, o, f);
		shape = new Line2D.Double(p.x, p.y, p.x, p.y);
	}

	public LineItem(LineItem other) {
		super(other.canvas, other.outline, other.fill);
		Line2D.Double l = (Line2D.Double) other.shape;
		shape = new Line2D.Double(l.x1, l.y1, l.x2, l.y2);
		isSelected = false;
	}

	public Boolean contains(Point p) {
		Line2D.Double l = (Line2D.Double) shape;
		return (l.ptSegDist(p) < 4);
	}

	public CanvasItem duplicate() {
		return canvas.addItem(new LineItem(this));
	}

	public void update(Point p) {
		Line2D.Double l = (Line2D.Double) shape;
		l.setLine(l.getP1(), p);
		canvas.repaint();
	}

	public void move(int dx, int dy) {
		Line2D.Double l = (Line2D.Double) shape;
		l.x1 += dx;
		l.x2 += dx;
		l.y1 += dy;
		l.y2 += dy;
		canvas.repaint();
	}

}