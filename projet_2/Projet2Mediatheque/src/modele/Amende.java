package modele;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import javafx.util.converter.LocalDateStringConverter;

public class Amende implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LocalDate MiseAJour=LocalDate.now().minusDays(1);
	private LocalDate DateduRetour;
	public LocalDate getDateduRetour() {
		return DateduRetour;
	}

	public void setDateduRetour(LocalDate dateduRetour) {
		DateduRetour = dateduRetour;
	}

	public LocalDate getMiseAJour() {
		return MiseAJour;
	}

	public void setMiseAJour(LocalDate miseAJour) {
		MiseAJour = miseAJour;
	}

	private double Montant=0;
	
	//public Amende( LocalDate DateRetard)
	//{
	//	this.DateRetard=DateRetard;
	//}

	public void  CoutAmende(LocalDate DateRetard)
	{
		LocalDate DateDuJour=java.time.LocalDate.now();
		//int jourRetard=DateRetard.getDayOfMonth();
		//int jourPresent=DateDuJour.getDayOfMonth();
		int intNombreJoursRetard= (int) ChronoUnit.DAYS.between(DateDuJour,DateRetard );
		System.out.println(intNombreJoursRetard);
		Montant+=intNombreJoursRetard*0.50;
		MiseAJour=LocalDate.now();
		
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
Amende amende=new Amende();

	}
}
