package modele;

import java.time.LocalDate;
import java.time.Period;

import javafx.util.converter.LocalDateStringConverter;

public class Amende {
	private LocalDate DateRetard;
	private double Montant;
	
	public Amende( LocalDate DateRetard)
	{
		this.DateRetard=DateRetard;
	}

	public void  CoutAmende()
	{
		LocalDate DateDuJour=java.time.LocalDate.now();
		int jourRetard=DateRetard.getDayOfMonth();
		int jourPresent=DateDuJour.getDayOfMonth();
		int intNombreJoursRetard= Period.between(DateRetard, DateDuJour).getDays();
		Montant=intNombreJoursRetard*0.50;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate DateRetard=LocalDate.of(2019, 10, 20);
Amende amende=new Amende(DateRetard);

	}
}
