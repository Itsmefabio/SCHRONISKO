import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MainRamka extends JFrame {
	
public  MainRamka(String tytul) {
	super("Menad¿er Schroniska dla zwierz¹t");
	PanelBoczny panelBoczny;
	
	

	//set layoutMenager

		
	setLayout(new BorderLayout());

	//add swing components
	JTextArea textArea = new JTextArea();
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
			textArea.append("Program to prosty menager schroniska.\n\n W schronisku mo¿e siê znajdowaæ max 20 zwierz¹t\n Wpisz imiê i i kliknij dodaj,aby dodaæ zwierzê\n Wpisz imiê i kliknij usuñ,aby usun¹æ zwierzê \n");
		}
	});
}

}
