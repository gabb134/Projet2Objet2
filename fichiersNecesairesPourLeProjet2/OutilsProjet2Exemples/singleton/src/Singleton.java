

public final class Singleton {
  private static Singleton instance;
 
  private Singleton() {
	  System.out.println( " objet Sigleton Cr��");
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
	  
	 // cr�er les objets Singleton
	 
	 premierSingleton = Singleton.getInstance();
	 deuxiemeSingleton= Singleton.getInstance();      
	
	// les deux Singletons se ref�rent en fait au m�me Singleton
	if (premierSingleton== deuxiemeSingleton)System.out.println(" premierSingleton et deuxiemeSingleton font ref�rence au m�me objet Singleton");
}
}