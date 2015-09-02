
public class StanfordCheckerboardDriver {

	public static  final int BOX_SIZE = 15;
	public static final int ROWS = 8;
	public static final int COLUMNS = 8;
	public static final String TITLE = "Stanford Checkboard";

	public StanfordCheckerboardDriver() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String [] args) {
	    StanfordCheckerboard box = new StanfordCheckerboard(ROWS, COLUMNS, BOX_SIZE, TITLE);
	    box.show();
	}
}
