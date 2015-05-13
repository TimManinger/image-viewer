
public class Runner {
	public static void main(String[] args)
	{
		Viewer View = new Viewer();
		for (String s: args) {
			try
			{
				View.OpenViewer(s);				
			}catch(Exception e)
			{
				
			}
        }
	}
}