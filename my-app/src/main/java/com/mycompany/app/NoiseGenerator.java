import java.util.Random;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
//import java.util.Scanner;
public class NoiseGenerator extends JPanel{
	private static int range=255;
	private static Random rand = new Random();

	private BufferedImage img;
	private Graphics2D gr;

	public int row;
	public int col;

	public NoiseGenerator(){
		img = new BufferedImage(GUI.WIDTH, GUI.HEIGHT, BufferedImage.TYPE_INT_RGB);
		img.getData();
		gr = (Graphics2D)img.getGraphics();
		draw();
	}
	public void draw(){
		gr.setColor(Color.WHITE);
		gr.fillRect(0,0,500, 500);
		
		int[][] sh = simpleNoise(25, 25);
		
		int scale = 20;
		for(int i=0; i<sh.length; i++){
			for(int j=0; j<sh.length; j++){
				//if-statement for creating scuffed grass terrain.
				/*if (sh[i][j] > 150){
					gr.setColor(new Color(0,153, 100));
					gr.fillRect(i*scale, j*scale,1*scale,1*scale);
				}else if(sh[i][j] > 100){
					gr.setColor(new Color(90,70, 50));
					gr.fillRect(i*scale, j*scale,1*scale,1*scale);
				}else{
					gr.setColor(new Color(sh[i][j],sh[i][j], sh[i][j]));
					gr.fillRect(i*scale, j*scale,1*scale,1*scale);
				}*/
				gr.setColor(new Color(sh[i][j],sh[i][j], sh[i][j]));
				gr.fillRect(i*scale, j*scale,1*scale,1*scale);
			}
		}
	}
	public void paintComponent(Graphics g){
		g.drawImage(img, 0,0,null);
	}
	public int[][] simpleNoise(int row, int col){
		int[][] noise = new int[row][col];

		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				noise[i][j] = rand.nextInt(range);
			}
		}
		return noise;
	}
	public static Grid noise(int row, int col){
		Grid g = new Grid(row, col);

		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				Pixel p = new Pixel(rand.nextInt(range));
				g.setElement(i,j,p);
			}
		}
		return g;
	}
	public static void main(String[] args){
		/*
		Scanner sc = new Scanner(System.in);

		System.out.print("width: ");
		int row = sc.nextInt();
		System.out.print("height: ");
		int col = sc.nextInt();
		*/

		int row = Integer.parseInt(args[0]);
		int col = Integer.parseInt(args[1]);

		//debugImage
		System.out.print(noise(row, col).toString());
	}
}