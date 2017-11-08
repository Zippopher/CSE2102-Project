import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.ListModel;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;

import java.awt.CardLayout;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import java.awt.Color;

public class NEW_UI extends JPanel {
	private JTextField Name;
	private String[] type = {"Name", "Price", "Rating"};
	private String[] rest = {"rest1", "rest2", "rest3"};
	/**
	 * Create the panel.
	 */
	public NEW_UI() {
		setLayout(new CardLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		add(panel, "name_432987060586482");
		panel.setLayout(null);


		Name = new JTextField();
		Name.setBounds(0, 10, 165, 26);
		panel.add(Name);
		Name.setText("Restaurant Name");
		Name.setColumns(10);


		JButton btnSearch = new JButton("Enter");
		btnSearch.setBounds(168, 10, 76, 29);
		panel.add(btnSearch);

		//search feature
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("test");
			}
		});

		JLabel lblSearchBy = new JLabel("Search by:");
		lblSearchBy.setBounds(282, 15, 64, 16);
		panel.add(lblSearchBy);

		JComboBox comboBox = new JComboBox(type);
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
		});
		comboBox.setBounds(348, 11, 96, 27);
		panel.add(comboBox);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("rest");
		JMenuItem review = new JMenuItem("Leave a review");
		review.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ReviewWindow review = new ReviewWindow();
				review.setVisible(true);
			}
		});
		JMenuItem look = new JMenuItem("Look a previous reviews");
		review.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ReadWindow read = new ReadWindow();
				read.setVisible(true);
			}
		});
		menuBar.add(menu);
		menu.add(review);
		menu.add(look);
		menuBar.setBounds(10, 48, 132, 22);
		panel.add(menuBar);
		
		JButton btnSignIn = new JButton("Sign in");
		btnSignIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Login login = new Login();
				login.setVisible(true);
			}
		});
		btnSignIn.setBounds(195, 265, 117, 29);
		panel.add(btnSignIn);
		
		JButton button = new JButton("Sign up");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Signup signup = new Signup();
				signup.setVisible(true);
			}
		});
		button.setBounds(324, 265, 117, 29);
		panel.add(button);

	




	}
}
