package com.anamikeya.pain.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.anamikeya.pain.level.Level;

public class Mouse implements MouseListener, MouseMotionListener{

	private static int mouseX = -1;   //holds X coordinate of the mouse on the screen 
	private static int mouseY = -1;   //holds y coordinate o the mouse o the screen
	
	private static int mouseB = -1;  
	private Level level;
	public static int getX() {
		return mouseX;
	}
	
	public static int getY() {
		return mouseY;
	}
	
	public static int getButton() {
		return mouseB;
	}
	
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseX = e.getX();
		mouseY = e.getY();
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
				mouseB = e.getButton();
			}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseB = -1;
	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
