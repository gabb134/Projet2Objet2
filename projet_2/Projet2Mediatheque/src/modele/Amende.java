package modele;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

import javafx.util.converter.LocalDateStringConverter;

public class Amende implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	public double getMontant() {
		return Montant;
	}

	public void setMontant(double montant) {
		Montant = montant;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate DateRetard=LocalDate.of(2019, 10, 20);
Amende amende=new Amende(DateRetard);

	}
}
