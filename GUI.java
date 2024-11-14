import javax.swing.*;
import java.awt.event.*;
public class GUI{
	public static final int WIDTH = 400;
	public static final int HEIGHT = 400;
	public NoiseGenerator ng = new NoiseGenerator();
	public GUI(){
		JFrame frame = new JFrame("Noise Generator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		frame.setLocationRelativeTo(null);
		frame.add(ng);
		frame.addKeyListener(new KeyListener(){
				@Override
				public void keyTyped(KeyEvent e){
					
				}

				@Override
				public void keyPressed(KeyEvent e){
					switch(e.getKeyCode()){
						case 32:
							ng.draw();
							frame.revalidate();
							frame.repaint();
							System.out.println("Space Pressed!");
						break;
					}
				}
				@Override
				public void keyReleased(KeyEvent e){

				}
			}
		);
		frame.setVisible(true);


	}
	public static void main(String[] args){
		GUI gui = new GUI();
		System.out.println("application is open");
	}
}