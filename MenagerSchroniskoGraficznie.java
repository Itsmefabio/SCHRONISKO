import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MenagerSchroniskoGraficznie {

	public static void main(String[] args) throws IOException {
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
		JFrame MainRamka = new MainRamka("Menad¿er Schroniska Dla Zwierz¹t");
		MainRamka.setVisible(true);
		MainRamka.setSize(1000,500);
		MainRamka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainRamka.setLocationRelativeTo(null);
		
			}});
	}

}
