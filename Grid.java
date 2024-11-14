import java.util.Arrays;
public class Grid{
	private Pixel[][] matrix;
	private int width, height;

	public Grid(int width, int height){
		setWidth(width);
		setHeight(height);
		setMatrix(width, height);
	}
	public void setWidth(int width){
		this.width = width;
	}
	public void setHeight(int height){
		this.height = height;
	}
	public void setMatrix(int width, int height){
		this.matrix = new Pixel[width][height];
	}
	public void setElement(int row, int col, Pixel pixel){
		matrix[row][col] = pixel;
	}
	public String toString(){
		String s = "";
		for(Pixel[] a: matrix){
			s+=Arrays.deepToString(a) + "\n";
		}
		return s;
	}
}