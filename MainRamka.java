import java.awt.BorderLayout;
import java.awt.Container;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class MainRamka extends JFrame {
	

	private static final long serialVersionUID = -28610974805212468L;

public  MainRamka(String tytul) {
	super("Menad�er Schroniska dla zwierz�t");
	PanelBoczny panelBoczny;
	
	

	//set layoutMenager

		
	setLayout(new BorderLayout());

	//add swing components
	JTextArea textArea = new JTextArea();
	textArea.setSize(500,500);
	textArea.setLineWrap(false);
    textArea.setEditable(false);
    textArea.setVisible(true);



         
	JButton button =new JButton("Tutorial");
	panelBoczny= new PanelBoczny();
	panelBoczny.addDetailListener(new DetailListener() {

		
		public void detailEventOccured(DetailEvent event) {
			String zwierz=event.getText();
			
			textArea.append(zwierz);
		}
		
	});
	//add components to jpane
	Container c= getContentPane();
	c.add(button, BorderLayout.SOUTH);
	c.add(textArea,BorderLayout.CENTER);
	c.add(panelBoczny,BorderLayout.EAST);
	//actions
	textArea.append("");	
	button.addActionListener(new ActionListener() {
	
		@Override
		public void actionPerformed(ActionEvent e) {
			textArea.append("Program to prosty menager schroniska.\n\n W schronisku mo�e si� znajdowa� max 20 zwierz�t\n Wpisz imi� i i kliknij dodaj,aby doda� zwierz�\n Wpisz imi� i kliknij usu�,aby usun�� zwierz� \n Wci�nij Status, aby wy�witli� obecny stan schroniska\n Wci�nij Zapisz do txt, aby zapami�ta� baz�\n");
		}
	});
}

}
