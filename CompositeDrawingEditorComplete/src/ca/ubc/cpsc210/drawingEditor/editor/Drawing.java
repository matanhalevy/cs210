package ca.ubc.cpsc210.drawingEditor.editor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

import ca.ubc.cpsc210.drawingEditor.figures.CompositeFigure;
import ca.ubc.cpsc210.drawingEditor.figures.Figure;

/**
 * Represents a drawing
 */
public class Drawing extends JPanel {

	private DrawingEditor editor;

	private static int WIDTH = 500;
	private static int HEIGHT = 500;

	private List <Figure> figures;

	/**
	 * Constructor sets up drawing window
	 * 
	 * @param ed
	 *            the drawing editor that edits this drawing
	 */
	public Drawing(DrawingEditor ed) {
		super();
		setMinimumSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.white);
		figures = new LinkedList <Figure>();
		editor = ed;
		DrawingMouseListener dml = new DrawingMouseListener();
		addMouseListener(dml);
		addMouseMotionListener(dml);
		setVisible(true);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Figure f : figures) {
			f.draw(g);
		}
	}

	/**
	 * Adds a figure to this drawing
	 * 
	 * @param f
	 *            the figure to add to this drawing
	 */
	public void addFigure(Figure f) {
		figures.add(f);
		repaint();
	}

	/**
	 * Removes a figure from this drawing
	 * 
	 * @param f
	 *            the figure to remove from this drawing
	 */
	public void removeFigure(Figure f) {
		figures.remove(f);
		repaint();
	}

	/**
	 * Gets the figure at a given point.
	 * 
	 * @param point
	 *            the point at which figure is to be located
	 * @return figure at given point or null if no such figure exists
	 */
	public Figure getFigureAtPoint(Point point) {
		for (Figure f : figures) {
			if (f.contains(point)) {
				return f;
			}
		}
		return null;
	}

	/**
	 * Groups selected figures
	 */
	public void groupSelectedFigures() {
		List <Figure> selectedFigures = new ArrayList<Figure>();
		for (Figure f : figures)
			if (f.isSelected()) {
				selectedFigures.add(f);
				f.unselect();
			}
		
		if (selectedFigures.size() != 0) {
			CompositeFigure compFigure = new CompositeFigure(selectedFigures);
			for (Figure f : selectedFigures)
				figures.remove(f);
			figures.add(compFigure);
		}
		
		repaint();
	}
	
	/**
	 * Ungroup selected figures
	 */
	public void ungroupSelectedFigures() {
		// TODO
	}

	/**
	 * Represents a mouse listener for this drawing Note to CPSC 210 students:
	 * this is an example of an inner class - it is defined within the scope of
	 * another class (in this case Drawing) which is referred to as the outer
	 * class. Notice how the methods in this inner class have access to the
	 * private fields of the outer class (in this case 'editor').
	 */
	private class DrawingMouseListener extends MouseAdapter {
		/**
		 * Forward mouse pressed event to the active tool
		 */
		public void mousePressed(MouseEvent e) {
			editor.sendMousePressedToActiveTool(e);
		}

		/**
		 * Forward mouse released event to the active tool
		 */
		public void mouseReleased(MouseEvent e) {
			editor.sendMouseReleasedToActiveTool(e);
		}

		/**
		 * Forward mouse clicked event to the active tool
		 */
		public void mouseClicked(MouseEvent e) {
			editor.sendMouseClickedToActiveTool(e);
		}

		/**
		 * Forward mouse dragged event to the active tool
		 */
		public void mouseDragged(MouseEvent e) {
			editor.sendMouseDraggedToActiveTool(e);
		}
	}
}
