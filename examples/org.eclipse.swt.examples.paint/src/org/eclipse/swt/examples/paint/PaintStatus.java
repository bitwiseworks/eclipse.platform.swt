package org.eclipse.swt.examples.paint;/* * (c) Copyright IBM Corp. 2000, 2001. * All Rights Reserved */import org.eclipse.swt.graphics.Point;import org.eclipse.swt.widgets.Text;

public class PaintStatus {
	private Text statusText;
	private String actionInfo, messageInfo, coordInfo;	private Point pointA = new Point(-1, -1), pointB = new Point(-1, -1);	private int coordFlag = 0;
	
	/**
	 * Constructs a PaintStatus.
	 * 
	 * @param statusText the handle of status bar text widget to use
	 */
	public PaintStatus(Text statusText) {
		this.statusText = statusText;
		clear();
	}

	/**
	 * Clears the status bar.
	 */
	public void clear() {
		clearAction();
		clearMessage();
		clearCoord();
	}

	/**
	 * Sets the status bar action text.
	 *
	 * @param action the action in progress
	 */
	public void setAction(String action) {
		actionInfo = action;
		update();
	}
	
	/**
	 * Clears the status bar action text.
	 */
	public void clearAction() {
		actionInfo = "";
		update();
	}

	/**
	 * Sets the status bar message text.
	 * 
	 * @param message the message to display
	 */
	public void setMessage(String message) {
		messageInfo = message;
		update();
	}
	
	/**
	 * Clears the status bar message text.
	 */
	public void clearMessage() {
		messageInfo = "";
		update();
	}

	/**
	 * Sets the coordinates in the status bar.
	 * 
	 * @param coord the coordinates to display
	 */
	public void setCoord(Point coord) {		if (coordFlag == 1 && pointA.equals(coord)) return; // big speedup		pointA.x = coord.x; pointA.y = coord.y;		coordFlag = 1;		
		coordInfo = PaintPlugin.getResourceString("status.Coord.format", new Object[]			{ new Integer(coord.x), new Integer(coord.y)});		update();
	}

	/**
	 * Sets the coordinate range in the status bar.
	 * 
	 * @param a the "from" coordinate
	 * @param b the "to" coordinate
	 */
	public void setCoordRange(Point a, Point b) {
		if (coordFlag == 2 && pointA.equals(a) && pointB.equals(b)) return; // big speedup		pointA.x = a.x; pointA.y = a.y; pointB.x = b.x; pointB.y = b.y;		coordFlag = 2;		coordInfo = PaintPlugin.getResourceString("status.CoordRange.format", new Object[]			{ new Integer(a.x), new Integer(a.y), new Integer(b.x), new Integer(b.y)});		update();
	}

	/**
	 * Clears the coordinates in the status bar.
	 */
	public void clearCoord() {
		coordInfo = "";		coordFlag = 0;
		update();
	}

	/**
	 * Updates the display.
	 */
	private void update() {
		statusText.setText(			PaintPlugin.getResourceString("status.Bar.format", new Object[]			{ actionInfo, messageInfo, coordInfo }));	}
}
