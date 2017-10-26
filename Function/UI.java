import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import javax.swing.*;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

public class UI {

	public static JLabel label = new JLabel("Search Here:");
	public static JLabel label2 = new JLabel("Restaurants:");
	public static JTextArea inputSearch = new JTextArea();
	private static String nameENTER = "nEnter";
	private static String priceENTER = "pEnter";
	private static String rateENTER = "rEnter";
	static JButton nameButton = new JButton("Name");
	static JButton ratingButton = new JButton("Rating");
	static JButton priceButton = new JButton("Price");
	public static JTextArea output;
	public static JTextField input;
	static JFrame frame;
	static JPanel panel;

	public static void main(String... args){
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
		createFrame();
	}

	public static void createFrame(){
		frame = new JFrame("Restaurant Reviewer");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.setOpaque(true);
		ButtonListener buttonListener = new ButtonListener();
		output = new JTextArea(35, 70);
		output.setWrapStyleWord(true);
		output.setEditable(false);
		JScrollPane scroller = new JScrollPane(output);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JPanel inputpanel = new JPanel();
		inputpanel.setLayout(new FlowLayout());
		input = new JTextField(20);
		inputpanel.add(label);
		
		nameButton.setActionCommand(nameENTER);
		nameButton.addActionListener(buttonListener);
		
		priceButton.setActionCommand(priceENTER);
		priceButton.addActionListener(buttonListener);
		
		ratingButton.setActionCommand(rateENTER);
		ratingButton.addActionListener(buttonListener);
		
		DefaultCaret caret = (DefaultCaret) output.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		panel.add(scroller);
		inputpanel.add(input);
		inputpanel.add(nameButton);
		inputpanel.add(priceButton);
		inputpanel.add(ratingButton);
		panel.add(inputpanel);
		frame.getContentPane().add(BorderLayout.NORTH, panel);
		frame.pack();
		frame.setLocationByPlatform(true);
		
		// Center of screen
		// frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
		input.requestFocus();
	
	}

	public static class ButtonListener implements ActionListener{

		public void actionPerformed(final ActionEvent ev){
			if (!input.getText().trim().equals("")){
				String cmd = ev.getActionCommand();
				if (nameENTER.equals(cmd)){
					output.append("Search by name: ");
					if (input.getText().trim().equals(input)) output.append("test");
					else output.append("invalid search");
					output.append("\n");
				}			if (priceENTER.equals(cmd)){
					output.append("Search by price: ");
					if (input.getText().trim().equals(input)) output.append("test");
					else output.append("invalid search");
					output.append("\n");
				}			if (rateENTER.equals(cmd)){
					output.append("Search by rate: ");
					if (input.getText().trim().equals(input)) output.append("test");
					else output.append("invalid search");
					output.append("\n");
				}
			}
			input.setText("");
			input.requestFocus();
		}
	}


}
