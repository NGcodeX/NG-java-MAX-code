package pilotezebs;


public class BrinADN{
	
	String brinAdn;
	
	public BrinADN(String x) throws SequenceException{
		int i=0;
		boolean verif=true;
		while(i<x.length()) {
			if(x.charAt(i)=='a'||x.charAt(i)=='t'||x.charAt(i)=='c'||x.charAt(i)=='g') {
				verif=true;
				i++;
			}else{
				verif=false;
				i=x.length()+1;
			}
		}
		if(verif==true) {
			System.out.println("Votre brin entrer est valide");
			this.brinAdn=x;
		}else {
			System.out.println("votre brin entrer est invalide");
			System.out.println("VOICI LA PILE D ERREUR");
			throw new SequenceException();
		}
	}
	
	public boolean sequenceValide(String s) {
		int sequenceCompteur=0;
		boolean verifSequence=true;
		while(sequenceCompteur<s.length()) {
			if(s.charAt(sequenceCompteur)=='a'||s.charAt(sequenceCompteur)=='t'||s.charAt(sequenceCompteur)=='c'||s.charAt(sequenceCompteur)=='g') {
				verifSequence=true;
				sequenceCompteur++;
			}else{
				verifSequence=false;
				sequenceCompteur=s.length()+1;
			}
		}
		if(verifSequence==true) {
			return true;
		}else {
			return false;	
		}
	}
	
	public void sousSequence(String s) {
		int len=s.length()-1;
		int i;
		boolean verif=false;
		for(i=0;i<this.brinAdn.length();i++) {	
			if(s.substring(0).equals(this.brinAdn.substring(i, (len+i)))) {
				i=this.brinAdn.length()+1;
				verif=true;
			}
		}
		if(verif) {
			System.out.println("OUI "+s+" est une sous sequence l'ADN "+this.brinAdn);
		}else {
			System.out.println("Non "+s+" n est pas une sous sequence d ADN de "+this.brinAdn);
		}
	}
	
	public void doubleBrinADN(String s) {
		int doubleCompteur=0;
		boolean verifSequence=true;
		while(doubleCompteur<s.length()) {
			if(s.charAt(doubleCompteur)=='a'||s.charAt(doubleCompteur)=='t'||s.charAt(doubleCompteur)=='c'||s.charAt(doubleCompteur)=='g') {
				verifSequence=true;
				doubleCompteur++;
			}else{
				verifSequence=false;
				doubleCompteur=s.length()+1;
			}
		}
		if(verifSequence==true) {
			System.out.println("voici le resultat du double brin: ");
			int i;
			boolean verif=false;
			int p=1;
			for(i=0;i<this.brinAdn.length();i++) {	
				if(s.charAt(i)=='a'&& this.brinAdn.charAt(i)=='t') {
					verif=true;
				}else {
					p=0;
				}
				if(s.charAt(i)=='c'&& this.brinAdn.charAt(i)=='g') {
					verif=true;
				}else {
					p=0;
				}
			}
			if(p==0) {
				System.out.println("OUI c est sequnce peux former un double brin d ADN avec "+this.brinAdn);
				System.out.println(s+" lier avec "+this.brinAdn);
			}else {
				System.out.println("cette sequence n est pas un double de "+this.brinAdn);
			}
		}else {
			System.out.println("brin ERROR non valide");
		}
	}
}
