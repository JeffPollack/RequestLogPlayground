package keyLog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class MainWindow extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	JTextField [] input = new JTextField[16];	
	String [] textLabel = {"Date Recieved", "UMID", "Last Name", "First Name", "Department", "Dept Phone", "Status", "Authoized Signer",
			"Key Descrip", "Room/Area", "Building", "Entered By", "Date Picked Up", "Picked Up By", "Issued By", "Note"};
	JLabel [] inputLabel = new JLabel[textLabel.length];
	JButton [] button = new JButton[2];
	String [] buttonLabel = {"Save Record", "New Record"};
	
	public MainWindow() {
		super();
		//this.setSize(1600,1600);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		UIManager.put("TitledBorder.border", new LineBorder(new Color(00,00,00), 2));
		TitledBorder border;
		JPanel form = new JPanel();
		GridLayout gl = new GridLayout(16,2);
		form.setLayout(gl);
		Dimension d = new Dimension(300, 450);
		
		for (int i = 0; i < textLabel.length; i++){
			inputLabel[i] = new JLabel(textLabel[i]);
			JTextField jtf = new JTextField(textLabel.length);
			input[i] = jtf;
			form.add(inputLabel[i]);
			form.add(jtf);
		}
		border = BorderFactory.createTitledBorder("Enter Key Info");
		form.setPreferredSize(d);
		form.setBorder(border);
		add(form, BorderLayout.CENTER);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
