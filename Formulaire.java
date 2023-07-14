package Formulaire;

import java.io.*;
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Formulaire extends JFrame {

	 private JPanel contentPane;
	 
	 private JPanel pan=new JPanel();
	 private JLabel titre=new JLabel("Saisie Note Etudiant");
	 private  JLabel t1=new JLabel("Nom");
   	private  JLabel t2=new JLabel("Prenom");
	 private  JLabel t3=new JLabel("UE");
	 private  JLabel t4=new JLabel("EC");
	 private  JLabel t5=new JLabel("NOTE DEVOIR");
	 private  JLabel t6=new JLabel("NOT EXAMEN");
	 private JLabel t7=new JLabel("Email");
	 private JLabel t8=new JLabel("Age");
	private JLabel t9=new JLabel("sexe");
     private JTextField nom=new JTextField();
     private JTextField prenom=new JTextField();
     private JTextField ue=new JTextField();
     private JTextField ec=new JTextField();
     private JTextField noteD=new JTextField();
     private JTextField noteE=new JTextField();
	 private JTextField age=new JTextField();
	 private JTextField mail=new JTextField();
	 private JTextField sexe=new JTextField();
	 private JButton CalculMoy =new JButton("calculer Moyenne");
	 private JButton Annuler =new JButton("Annuler");
     private double noteDevoir;
     private double noteExamen; 
     private double moy;

	private Object set;

	 
	    
	public Formulaire(){
		
		
	}
	public Formulaire(int height, int width,int x,int y){
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Gestion System LMD");
		this.setSize(width, height);
		this.setLocation(x, y);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      this.setSize(600,400);
		this.setLocationRelativeTo(null);
		
		
		CalculMoy.addActionListener(new CalculMoyListenner());
		Annuler.addActionListener(new AnnulerListenner());
		
		JPanel P_nord=new JPanel();
		JPanel P_sud=new JPanel();
		JPanel P_center=new JPanel();
		
		pan.setLayout(new BorderLayout());
		
		pan.add(P_nord,BorderLayout.NORTH);
		pan.add(P_center,BorderLayout.CENTER);
		pan.add(P_sud,BorderLayout.SOUTH);

		P_nord.add(titre);
		
		// creation des police 
		titre.setForeground(new Color(166,11,110));
		Font police=new Font("Arial", Font.BOLD,24);
		titre.setFont(police);
		P_center.setLayout(new GridLayout(6, 2));
		//taille et dimension de chaque label
		nom.setPreferredSize(new Dimension(50,50));
		prenom.setPreferredSize(new Dimension(50,50));
		ue.setPreferredSize(new Dimension(50,50));
		ec.setPreferredSize(new Dimension(50,50));
		noteD.setPreferredSize(new Dimension(50,50));
		noteE.setPreferredSize(new Dimension(50,50));
        mail.setPreferredSize(new Dimension(50,50));
		 age.setPreferredSize(new Dimension(50,50));
		sexe.setPreferredSize(new Dimension(50,50));

       //insertion des panel au centre
		
		P_center.add(t1);
		P_center.add(nom);
		P_center.add(t2);
		P_center.add(prenom);
		P_center.add(t3);
		P_center.add(ue);
		P_center.add(t4);
		P_center.add(ec);
		P_center.add(t5);
		P_center.add(t8);
		P_center.add(age);
		p_center.add(t9);
		p_center.add(sexe);
		P_center.add(t7);
		P_center.add(mail);
		P_center.add(noteD);
		P_center.add(t6);
		P_center.add(noteE);
		
		
		
		//insertion au sud
		
		P_sud.add(CalculMoy);
		P_sud.add(Annuler);
		
		
		this.setContentPane(pan);
		//contentPane.add(CalculMoy);
	
		
		
		
	}

	// fonction de calcul de la moyenne
	
	public void calcul() {
		try{
         noteDevoir=Double.parseDouble(noteD.getText());
         noteExamen=Double.parseDouble(noteE.getText());
         
         if(noteDevoir<=20 && noteDevoir>=0 && noteExamen<=20 && noteExamen>=0){
        
        	     moy=(noteDevoir*0.4)+(noteExamen*0.6);
         }
         else{
        	 // message erreur
        	 JOptionPane message;
        	 message =new JOptionPane();
        	 message.showMessageDialog(null, "Erreur Format", "Message",JOptionPane.INFORMATION_MESSAGE);
        	 System.exit(DISPOSE_ON_CLOSE);
        	 
           }
        	
		
         }
		catch (Exception ex){
			
		}
        
		
		}
	
	class CalculMoyListenner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			calcul();
			JOptionPane op;
			op=new JOptionPane();
			JOptionPane.showMessageDialog(null, "L'etudiant(e) "+nom.getText()+ "  "+prenom.getText()+" âgé(e) de "+age.getText()+" de sexe "+sexe.getText()+ "dont l'email est "+mail.getText()+" a une moyenne de : "+moy+"  ","Resultat", JOptionPane.INFORMATION_MESSAGE);
			
					
		}
		
	}
	
	class AnnulerListenner implements ActionListener{
		
		
		

		@Override
		public void actionPerformed(ActionEvent ev) {
			
			System.exit(0);
			
			
		}
		
		
	}
	/*public static void main(String[] args) {
		Toolkit screenSize=Toolkit.getDefaultToolkit();
		int w=screenSize.width;
		int h=screenSize.height;
		
	}
	*/
	public static void main(String[] args){
       
		 Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();
          int w=screenSize.width;
		  int h=screenSize.height;
         
	  // int h = 110;
		//int w = 110;
		Formulaire f=new Formulaire(h/2,w/2,h/2,w/4);
		f.setVisible(true);
		 
		 
		
	}
	
	
	private static void getDefaultToolkit() {
		// TODO Auto-generated method stub
		
	}
	private void setLocation(Object x, Object y) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
