//imports

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.EventListenerList;

public class PanelBoczny extends JPanel {
	 
	
private static final long serialVersionUID = -8705547618576488179L;

	private static void add(List<String> pojemnoœæ, String E){
	
		pojemnoœæ.add(E);
	}
	private static void remove(List<String> pojemnoœæ, String E){
	
		pojemnoœæ.remove(E);
	}
	//setting variables
	ArrayList<String> pojemnoœæ = new ArrayList<String>(20);
	String Text;
	private EventListenerList listenerList = new EventListenerList();
	//declaration of a panel
	public PanelBoczny() {
	//panel basic attributes
		Dimension size=getPreferredSize();
		size.width= 250;
		setPreferredSize(size);
		setBorder(BorderFactory.createTitledBorder("Menad¿er Schroniska dla Zwierz¹t"));
	//creating buttons
	JButton Dodaj=new JButton(" Dodaj Zwierzê ");
	JButton Usun=new JButton(" Usuñ Zwierzê ");
	JButton Status=new JButton("       Status       ");
	JButton save=new JButton(" Zapisz do txt ");
	JButton load=new JButton(" Wczytaj z txt ");
	//creating textfields
final JTextField imie =  new JTextField(10);
final JTextField imie2 = new JTextField(10);
//Adding events to buttons
Dodaj.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent e) {
		if(pojemnoœæ.size()==20){
			String Text = "nie mo¿na dodaæ, schronisko jest pe³ne\n";
			fireDetailEvent(new DetailEvent(this,Text));
			imie.setText("");
		}
		else {
		String zwierz= imie.getText();
		if(zwierz.equals("")) {
			String Text="b³edna nazwa, podaj prawid³ow¹ Nazwê\n";
			fireDetailEvent(new DetailEvent(this,Text));
		}
		else {
		pojemnoœæ.add(zwierz);
		String Text=zwierz + "\n dodany do bazy. Aktualnie w schronisku przebywa: "+String.valueOf(pojemnoœæ.size()+"\n");
		fireDetailEvent(new DetailEvent(this,Text));
		imie.setText("");
		}
	}}	 
});
Usun.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent e) {
		
		String zwierz= imie2.getText();
		if(pojemnoœæ.size()==0){
			String Text = "nie mo¿na usun¹æ, schronisko jest puste\n";
			fireDetailEvent(new DetailEvent(this,Text));
			imie2.setText("");
		}
		 if (pojemnoœæ.contains(zwierz)) {
		pojemnoœæ.remove(zwierz);
String Text=zwierz + "\n usuniety z bazy. Aktualnie w schronisku przebywa: "+String.valueOf(pojemnoœæ.size()+"\n");
		fireDetailEvent(new DetailEvent(this,Text));
		imie2.setText(""); }
	else {
		String Text= "nie mo¿na usun¹æ, brak w bazie\n";
		fireDetailEvent(new DetailEvent(this,Text));
		imie2.setText("");
	}
		 }
});
Status.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent e){
		String tekscik= "Aktualna Lista Zwierz¹t:\n";
		fireDetailEvent(new DetailEvent(this,tekscik));
		for(int L=0;L<pojemnoœæ.size();L++) {
		
			Text= L+"."+ (String)pojemnoœæ.get(L)+"\n";
			fireDetailEvent(new DetailEvent(this,Text)); }
			if(pojemnoœæ.size()==20) {
			String stan="Schronisko jest pe³ne";
			fireDetailEvent(new DetailEvent(this,stan));
			}
			else
			{
				String stan="S¹ jeszcze Wolne miejsca. Aktualnie jest ich: " +(20- (pojemnoœæ.size()));
				fireDetailEvent(new DetailEvent(this,stan));	
			}
		}	
		
		
		
	
	
		});


	setLayout(new GridBagLayout());
	GridBagConstraints gc = new GridBagConstraints();
	gc.anchor=GridBagConstraints.LINE_START;
	gc.weightx=1;
	gc.weighty=1;
	gc.gridx=0;
	gc.gridy=0;
	add(Dodaj,gc);
	gc.gridx=0;
	gc.gridy=1;
add(Usun,gc);
gc.gridx=0;
gc.gridy=2;
add(Status,gc);
gc.gridx=0;
gc.gridy=9;
add(save,gc);
gc.gridx=0;
gc.gridy=10;
add(load,gc);
gc.gridx=1;
gc.gridy=0;
gc.anchor=GridBagConstraints.LINE_END;
add(imie,gc);
gc.gridx=1;
gc.gridy=1;
add(imie2,gc);
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

