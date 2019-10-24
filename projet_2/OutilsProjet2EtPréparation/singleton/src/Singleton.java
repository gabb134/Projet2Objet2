

public final class Singleton {
  private static Singleton instance;
 
  private Singleton() {
	  System.out.println( " objet Sigleton Créé");
  }
	
  // instanciation de Singleton si null
  public static Singleton getInstance() {
	  if (instance == null) 
		  instance = new Singleton();
	  return instance; 
  }
  
  
  
	public static void main(String[] args) {
		
	

	 Singleton premierSingleton;
	 Singleton deuxiemeSingleton;
	  
	 // créer les objets Singleton
	 
	 premierSingleton = Singleton.getInstance();
	 deuxiemeSingleton= Singleton.getInstance();      
	
	// les deux Singletons se refèrent en fait au même Singleton
	if (premierSingleton== deuxiemeSingleton)System.out.println(" premierSingleton et deuxiemeSingleton font reférence au même objet Singleton");
}
}