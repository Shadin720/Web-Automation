package experiment;
import java.util.Date;

public class exp {
	
	public static void main(String[] args) {
//		Date date= new Date();
//		String dateText= date.toString();
//		String dateTextWithoutSpaces= dateText.replace(" ", "_");		
//		String dateTextWithoutSpacesAndColon =dateTextWithoutSpaces.replace(":", " ");	
//		System.out.println(dateTextWithoutSpacesAndColon);
		
		
		Date date =new Date();
		System.out.println(date.toString().replace(" ", "_").replace(":", " "));
	}
	
	

}
