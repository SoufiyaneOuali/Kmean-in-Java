
public class K_MEANS {
	public static int n=3;
	/*variable globale indiquer le nombre des classes et les centres de gravité */ 
	
    public static int X[]= {100,1,9,10,13,56,75,33,11,10};
    /* ce tableau contients les éléments qui nous allons les classifier*/
    
    public static int C[][]=new int[n][X.length];
    /* 'C' c'est une matrice ,les lignes de la matric correspondant à les classes de la méthode K-MEANS */ 
	public static void main(String arg[]) {
		
		double U[]=new double[n]; 
		/*la table 'U' représent les centre de gravité */
		double M[]=new double[n];
		int q=0;
		/*on va utilisé la table 'M' pour tester si les centres de gravité changer au cour de la classification 
		-> si oui ,l'algorithme va refaire la procédure avec des  nouveau centres (q=0)
		-> si non ,l'algorithme va s'arrété (q=1) */
		
		/* initialisation les centres de gravité */
		for(int i=0;i<n;i++)
		{
			U[i]=i;
		} 
		int L[]=new int [n];
		double s=0; 
		/* on déclare la variable 's' pour calculer la somme des éléments 
		de chaque classe afin de trouver les nouveau centres de gravité*/
		
		int indic=0;
		
		do {
			/* initialisation les éléments de chaque classe à '-1' */
			for(int k=0;k<n;k++)
			{
			  for(int j=0;j<X.length;j++)
			  {
				  C[k][j]=-1;
			  }
			}
		
			for(int i=0;i<n;i++)
			{
				M[i]=U[i];
			}
			
			
		
		
		for(int k=0;k<X.length;k++)
		{
			for(int j=0;j<n;j++)
			{
				indic=min(dist(X[k],U));
			/* la méthode dist() elle fournit une tableau contient  les distances entre 
			 * chauqe élément de la table X avec chauqe centre de gravité,  */
			/* la méthode min() calcule la distance  minimale de la résultat de la méthode dist() 
			 * et fournit l'indice de la plus proche classe à l'élément X[k]*/
			}
			
			C[indic][k]=X[k];
			/* affecter à la classe 'indic' l'élément X[k] */	
		}
		/*réinitialisé la variable indice à zero afin de refaire la meme procedure sur les autre éléments de la table X */
		indic=0;
		
		L=lenght(C);
		/* la méthode Lenght() fournit une table contient le nombre d'élément exist dans chaque classes */
		
		for(int k=0;k<n;k++)
		{
			System.out.println(" lenght of classe"+k+"is "+L[k]);
		}
			
		for(int k=0;k<n;k++)
		{
			for(int j=0;j<X.length;j++)
			{
				if(C[k][j]!=-1)
				System.out.print(" ->"+C[k][j]);	
			}
			System.out.println(" ");
		}
		System.out.println(" ");
		
		
		for(int k=0;k<n;k++)
		{
			for(int j=0;j<X.length;j++)
			{
				if(C[k][j]!=-1)
				s+=C[k][j];
			}
			if(L[k]!=0)
			U[k]=s/L[k];
			/* la calcule du nouveux centres de gravité */
			
			System.out.println("the new centre of gravity "+k+" ="+U[k]);
			s=0;
			
		}
		for(int j=0;j<n;j++)
		   {
           if(M[j]==U[j]) 
	            q=1;
		    	else
				q=0;
		      }
		}while(q!=1);
	}
	
///////////////-------------------------FUCTIONS---------------------//////////////////////////////////////////////
	private static int[] lenght(int[][] c) {
		int count=0;
		int L[]=new int [n];
		for(int k=0;k<n;k++)
		{
			for(int j=0;j<X.length;j++)
			{
			if(c[k][j]!=-1)
				count++;
			}
			L[k]=count;
			count=0;
		}
		return L;
	}
/////////////--------------------------------------MIN----------------/////////////////////////////////////////////

	private static int min(double [] dist) {
		double a=dist[0];
		int b=0;
		for(int i=1;i<dist.length;i++)
		{
			if(dist[i]<=a)
			{
				a=dist[i];
				b=i;
			}
		}
		
		return b;
	}

/////////////--------------------------------------DIST----------------/////////////////////////////////////////////
	private static double[] dist(int i, double[] u) {
		int j;
		double d[]=new double[u.length];
		for(j=0;j<u.length;j++)
		{
			if((i-u[j])<0)
			d[j]=-(i-u[j]);
			else
			d[j]=(i-u[j]);
		}
		
		return d;
	}
}
