import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ManipulationDate {

	public static void main(String[] args) {

		LocalDate aujourdhui= LocalDate.now();
		System.out.println(aujourdhui.getDayOfMonth()+ "/"+ aujourdhui.getMonthValue()+"/" + aujourdhui.getYear());
		System.out.println(aujourdhui.getDayOfMonth()+ " "+ aujourdhui.getMonth()+" " + aujourdhui.getYear());
	
		LocalDate dateRetour= aujourdhui.plusDays(2);
		System.out.println(dateRetour);
		System.out.println(LocalDate.parse("2019-12-30"));
		LocalDate uneAutreDate = LocalDate.parse("2020-01-02");

		// exemple de formattage
		LocalDate date = LocalDate.of(2019, 10, 17);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM uuuu");
		String text = date.format(formatter);
		System.out.println("date avec format: " + text);

		LocalDate parsedDate = LocalDate.parse("17 oct. 2019", formatter);
		
		System.out.println("date avec format  (parseDate): " + parsedDate);
		
		LocalDate maDate = LocalDate.of(2019,12,27);
		System.out.println("maDate: " + maDate);

		// différence en jours entre deux dates 
		long diff =maDate.until(uneAutreDate,ChronoUnit.DAYS);
		System.out.println("nb jours:" + diff);
	}
}