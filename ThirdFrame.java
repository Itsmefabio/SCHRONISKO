import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
public class ThirdFrame extends JPanel {
	public ThirdFrame() {
		final String url = "jdbc:mysql://localhost:3306/schronisko";
		final String username = "Damian Migus";
		final String password = "kolor1234";

		
		Dimension size=getPreferredSize();
		size.width= 400;
		size.height= 400;
		setPreferredSize(size);
		setBorder(BorderFactory.createTitledBorder("Menad¿er Schroniska dla Zwierz¹t"));
		setBackground(Color.cyan);
	setLayout(new GridBagLayout());
	//declaring buttons, labels and textfields;
	JButton recdel=new JButton("Usuñ Rekord");
	JTextField delrec= new JTextField(10);
	JLabel id = new JLabel("Podaj id zwierzêcia ");
	JTextField info = new JTextField(30);
	info.setSize(150, 150);

	//placing buttons, labels and texztfields
	GridBagConstraints gc3 = new GridBagConstraints();

	gc3.anchor=GridBagConstraints.LINE_START;
	gc3.weightx=1;
	gc3.weighty=1;
	gc3.gridx=0;
	gc3.gridy=0;
	add(id,gc3);
	gc3.gridx=0;
	gc3.gridy=1;
	add(info,gc3);
	
	gc3.anchor=GridBagConstraints.LINE_END;

	gc3.gridx=1;
	gc3.gridy=0;
	add(delrec,gc3);
	gc3.gridx=1;
	gc3.gridy=1;
	add(recdel,gc3);
	
	
	//adding actions to buttons	
recdel.addActionListener(new ActionListener() {
		
		
		
		
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			int idz=Integer.valueOf(delrec.getText());
			
		
			
				
				
			String sql = "DELETE FROM zwierzeta WHERE ID= ?";
				    
	try {
		final java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/schronisko", "Damian Migus", "kolor1234"); 
			
						java.sql.PreparedStatement pstmt = connection.prepareStatement(sql);
						pstmt.setInt(1, idz);
						pstmt.executeUpdate();
					    pstmt.close();
					    connection.close();
					    info.setText("Rekord usuniêty z bazy, po³¹czenie zakoñczone");
					    delrec.setText(null);
	} catch (SQLException e1) {
	
		info.setText("Rekordu nie uda³o siê dodaæ, po³¹czenie zakoñczone");
		e1.printStackTrace();
	} 
		}});
}}
