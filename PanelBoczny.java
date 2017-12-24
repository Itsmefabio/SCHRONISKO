//imports

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.EventListenerList;

public class PanelBoczny extends JPanel {

	private static final long serialVersionUID = -8705547618576488179L;
	   
		public void Saving( ArrayList<String> tomData1)throws IOException{
		      try{
		          BufferedWriter writer = new BufferedWriter(new FileWriter("c:/Users/Fabio/eclipse-workspace/Menager Schroniska/stan.txt"));
		          for (String detail : tomData1) {
		  writer.write(detail.toString()+System.lineSeparator());
		            }
		    writer.close();
		   } 

		      catch (IOException ex) 
		      {
		      } 
		}
		//setting variables
	    ArrayList<String> pojemnoœæ = new ArrayList<String>();{
	    try {
	        BufferedReader input = new BufferedReader(new FileReader("stan.txt"));
	      for(String line = input.readLine(); line != null; line = input.readLine()) {
	            pojemnoœæ.add(line);
	        }
	        input.close();
	    } catch(IOException e) {
	        e.printStackTrace();
	        System.exit(1);
	        }}
	 String Text;
	private EventListenerList listenerList = new EventListenerList();
	//declaration of a panel
	public PanelBoczny() {
	//panel basic attributes
		Dimension size=getPreferredSize();
		size.width= 250;
		setPreferredSize(size);
		setBorder(BorderFactory.createTitledBorder("Menad¿er Schroniska dla Zwierz¹t"));
		setBackground(Color.cyan);
	//creating buttons
	//JButton Dodaj=new JButton(" Dodaj Zwierzê ");
	//JButton Usun=new JButton(" Usuñ Zwierzê ");
	JButton Status=new JButton("       Status       ");
	JButton save=new JButton(" Zapisz do txt ");
	JButton Dodaj2= new JButton(" Dodaj Zwierzê ");
	JButton Usun2= new JButton(" Usuñ Zwierzê");
	//creating textfields
final JTextField imie =  new JTextField(10);
final JTextField imie2 = new JTextField(10);
JDialog w1 =new JDialog();
JDialog w2 =new JDialog();
//Adding events to buttons

////Add Animal to Database Button
//Dodaj.addActionListener(new ActionListener() {
//
//	public void actionPerformed(ActionEvent e) {
//		if(pojemnoœæ.size()==20){
//			String Text = "nie mo¿na dodaæ, schronisko jest pe³ne\n";
//			fireDetailEvent(new DetailEvent(this,Text));
//			imie.setText("");
//		}
//		else {
//		String zwierz= imie.getText();
//		if(zwierz.equals("")) {
//			String Text="b³edna nazwa, podaj prawid³ow¹ Nazwê\n";
//			fireDetailEvent(new DetailEvent(this,Text));
//		}
//		else {
//		pojemnoœæ.add(zwierz);
//		String Text=zwierz + "\n dodany do bazy. Aktualnie w schronisku przebywa: "+String.valueOf(pojemnoœæ.size()+"\n");
//		fireDetailEvent(new DetailEvent(this,Text));
//		imie.setText("");
//		}
//	}}	 
//});
//// remove animal from database button:
//Usun.addActionListener(new ActionListener() {
//public void actionPerformed(ActionEvent e) {
//		String zwierz= imie2.getText();
//		if(pojemnoœæ.size()==0){
//			String Text = "nie mo¿na usun¹æ, schronisko jest puste\n";
//			fireDetailEvent(new DetailEvent(this,Text));
//			imie2.setText("");
//		}
//		 if (pojemnoœæ.contains(zwierz)) {
//		pojemnoœæ.remove(zwierz);
//String Text=zwierz + "\n usuniety z bazy. Aktualnie w schronisku przebywa: "+String.valueOf(pojemnoœæ.size()+"\n");
//		fireDetailEvent(new DetailEvent(this,Text));
//		imie2.setText(""); }
//	else {
//		String Text= "nie mo¿na usun¹æ, brak w bazie\n";
//		fireDetailEvent(new DetailEvent(this,Text));
//		imie2.setText("");
//	}
//		 }
//});

//Status Button
Status.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e){
	String sql = "SELECT * FROM zwierzeta";
	int nextrow=0;
	
		try {
			final java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/schronisko", "Damian Migus", "kolor1234"); 
				
							java.sql.PreparedStatement pstmt = connection.prepareStatement(sql);
							fireDetailEvent(new DetailEvent(this,"Status Schroniska\n"));
							fireDetailEvent(new DetailEvent(this,"id:	 imiê: 	p³eæ: 	waga: 	wiek: 	rasa: 	opiekun:\n"));
							pstmt.executeQuery();
							ResultSet rs= pstmt.getResultSet();
							while(rs.next()) {
								fireDetailEvent(new DetailEvent(this,Integer.toString(rs.getInt("id"))+"  	"));
								fireDetailEvent(new DetailEvent(this,rs.getString("imie")+" 	"));
					            fireDetailEvent(new DetailEvent(this,rs.getString("plec")+ " 	"));
					            fireDetailEvent(new DetailEvent(this,Integer.toString(rs.getInt("waga"))+ "    	"));
					            fireDetailEvent(new DetailEvent(this,Integer.toString(rs.getInt("wiek"))+"     	"));
					            fireDetailEvent(new DetailEvent(this,rs.getString("rasa")+" 	"));
					            fireDetailEvent(new DetailEvent(this,rs.getString("opiekun")+ "\n"));
					            
					            
					            nextrow++;
							}
						    pstmt.close();
						    fireDetailEvent(new DetailEvent(this,"Jest obecnie" +(20-nextrow)+ " wolnych miejsc.\n"));
						    connection.close();
						    fireDetailEvent(new DetailEvent(this,"Po³¹czenie z baz¹ danych zakoñczone"));
		} catch (SQLException e1) {
			fireDetailEvent(new DetailEvent(this,"Problem z baz¹ danych!"));
			e1.printStackTrace();
		}
		}	
		});


//// save to txt button
//			save.addActionListener(new ActionListener() {
//					public void actionPerformed(ActionEvent e){
//						try {
//						Saving(pojemnoœæ);
//					} catch (IOException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//						Text="\nZapis ukoñczony\n";
//						fireDetailEvent(new DetailEvent(this,Text));
//					}
//					});
	//Adding to database button		
			Dodaj2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
				SecondFrame daneZwierze= new SecondFrame();
					
					w1.add(daneZwierze);
					w1.setVisible(true);
					w1.setSize(500, 400);
					w1.setTitle("Dodaj kilka podstawowych informacji o zwierzêciu");
					w1.setLocationRelativeTo(null);
					
				}});
			
			Usun2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
				ThirdFrame usunZwierze= new ThirdFrame();
					
					w2.add(usunZwierze);
					w2.setVisible(true);
					w2.setSize(500, 400);
					w2.setTitle("Podaj numer id zwierzêcia");
					w2.setLocationRelativeTo(null);
					
				}});
				
		
				setLayout(new GridBagLayout());
	GridBagConstraints gc = new GridBagConstraints();
	gc.anchor=GridBagConstraints.LINE_START;
	gc.weightx=1;
	gc.weighty=1;
	gc.gridx=0;
	gc.gridy=0;
	add(Dodaj2,gc);
	gc.gridx=0;
	gc.gridy=1;
add(Usun2,gc);
gc.gridx=0;
gc.gridy=2;
add(Status,gc);
gc.gridx=0;
gc.gridy=3;
//add(save,gc);
//gc.gridx=1;
//gc.gridy=0;
gc.anchor=GridBagConstraints.LINE_END;


	}
	public void fireDetailEvent(DetailEvent event)
	{Object[] listeners = listenerList.getListenerList();
	for(int i=0;i<listeners.length; i+=2)
	{
	if(listeners[i]==DetailListener.class) {
		((DetailListener)listeners[i+1]).detailEventOccured(event);
		}
	}
	}
public void  addDetailListener(DetailListener listener) {
	listenerList.add(DetailListener.class, listener);
}
public void  removeDetailListener(DetailListener listener) {
	listenerList.remove(DetailListener.class, listener);
}
	}

