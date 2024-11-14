public class Pixel{
	private int value;

	public Pixel(int value){
		setValue(value);
	}
	public void setValue(int value){
		this.value = value;
	}
	public String toString(){
		return ""+value;
	}
}