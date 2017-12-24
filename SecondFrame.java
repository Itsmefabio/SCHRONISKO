import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SecondFrame extends JPanel {

	
//declaring new jpanel;
	
	public SecondFrame() {
		
		
	Dimension size=getPreferredSize();
		size.width= 400;
		size.height= 400;
		setPreferredSize(size);
		setBorder(BorderFactory.createTitledBorder("Menad¿er Schroniska dla Zwierz¹t"));
		setBackground(Color.cyan);
	setLayout(new GridBagLayout());
	//declaring buttons, labels and textfields;
	JButton ok=new JButton("Dodaj Rekord");
	JButton koniec= new JButton("Zakoñcz");

	JTextField imier= new JTextField(10);
	JTextField rasa= new JTextField(10);
	JTextField waga= new JTextField(10);
	JTextField wiek= new JTextField(10);
	JTextField plec= new JTextField(10);
	JTextField opiekun= new JTextField(10);
	JLabel im = new JLabel("Podaj imiê: ");
	JLabel ra = new JLabel("Podaj rasê: ");
	JLabel wa = new JLabel("Podaj wagê: ");
	JLabel wi = new JLabel("Podaj wiek: ");
	JLabel pl = new JLabel("Podaj p³eæ: ");
	JLabel op = new JLabel("Podaj dane przypisanego opiekuna: ");
	JTextField info = new JTextField(30);
	info.setSize(150, 150);
	
//placing buttons, labels and texztfields
GridBagConstraints gc2 = new GridBagConstraints();

gc2.anchor=GridBagConstraints.LINE_START;
gc2.weightx=1;
gc2.weighty=1;
gc2.gridx=0;
gc2.gridy=0;
add(im,gc2);
gc2.gridx=0;
gc2.gridy=1;
add(pl,gc2);
gc2.gridx=0;
gc2.gridy=2;
add(wa,gc2);
gc2.gridx=0;
gc2.gridy=3;
add(wi,gc2);
gc2.gridx=0;
gc2.gridy=4;
add(ra,gc2);
gc2.gridx=0;
gc2.gridy=5;
add(op,gc2);
gc2.gridx=0;
gc2.gridy=6;
gc2.gridx=0;
gc2.gridy=7;
add(info,gc2);
gc2.anchor=GridBagConstraints.LINE_END;

gc2.gridx=1;
gc2.gridy=0;
add(imier,gc2);
gc2.gridx=1;
gc2.gridy=1;
add(plec,gc2);
gc2.gridx=1;
gc2.gridy=2;
add(waga,gc2);
gc2.gridx=1;
gc2.gridy=3;
add(wiek,gc2);
gc2.gridx=1;
gc2.gridy=4;
add(rasa,gc2);
gc2.gridx=1;
gc2.gridy=5;
add(opiekun,gc2);
gc2.gridx=1;
gc2.gridy=6;
add(ok,gc2);
gc2.gridx=1;
gc2.gridy=7;
add(koniec,gc2);

//adding actions to buttons
ok.addActionListener(new ActionListener() {
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String namez= imier.getText();
		String plecz= plec.getText();
		int wiekz=Integer.valueOf(wiek.getText());
		int wagaz=Integer.valueOf(waga.getText());
		String rasaz= rasa.getText();
		String opiekunz= opiekun.getText();
	
		
			
			
		String sql = "INSERT zwierzeta("
			    + "imie,"
			    + "plec,"
			    + "waga,"
			    + "wiek,"
			    + "rasa,"
			    + "opiekun) "
			    +  "VALUES(?,?,?,?,?,?)";
 try (final java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/schronisko", "Damian Migus", "kolor1234")) {
	 info.setText("Po³¹czenie udane");

			try {
				PreparedStatement pstmt = connection.prepareStatement(sql); 

				    // Set the values
				    pstmt.setString(1, namez);
				    pstmt.setString(2, plecz);
				    pstmt.setInt(3, wagaz);
				    pstmt.setInt(4, wiekz);
				    pstmt.setString(5, rasaz);
				    pstmt.setString(6, opiekunz);
				    // Insert 
				    pstmt.executeUpdate();
				    pstmt.close();
				    connection.close();
				   ;
				    info.setText("Rekord dodany do bazy, po³¹czenie zakoñczone");
				    imier.setText(null);
				    plec.setText(null);
				    waga.setText(null);
				    wiek.setText(null);
				    rasa.setText(null);
				    opiekun.setText(null);
				    
			} catch (Exception e1) {
				info.setText("nie uda³o siê dodaæ rekordu");
				e1.printStackTrace();
			}

			} catch (SQLException e1) {

				
				info.setText("nie uda³o siê dodaæ rekordu");
	    throw new IllegalStateException("Cannot connect the database!", e1);
	}}
			

	   });
koniec.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
	

	}

	

});
	}}





	
	

	
















