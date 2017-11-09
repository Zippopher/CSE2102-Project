package userInterface;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import Function.Main;
import Function.Restaurant;

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
	private String[] type = {"Name", "Rating", "Price"};
	private String[] rest = {"rest1", "rest2", "rest3"};
	Restaurant[] restList;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run(){
	            JFrame frame = new JFrame();
	            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	            frame.getContentPane().add(new NEW_UI());
	            frame.pack();
	            frame.setVisible(true);
	        }
		});
	}
	
	/**
	 * Create the panel.
	 */
	public NEW_UI() {
		setLayout(new CardLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		add(panel, "name_432987060586482");
		panel.setLayout(null);

		restList = Main.getRestaurants();

		Name = new JTextField();
		Name.setBounds(10, 10, 165, 26);
		panel.add(Name);
		Name.setText("Restaurant Name");
		Name.setColumns(10);


		JButton btnSearch = new JButton("Enter");
		btnSearch.setBounds(185, 10, 76, 29);
		panel.add(btnSearch);

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
		
		//search feature
				btnSearch.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						setList(Main.search(Name.getText(), comboBox.getSelectedIndex()));
						
						NEW_UI.this.validate();
						NEW_UI.this.repaint();
					}
				});
		
		JList<Restaurant> list = new JList<Restaurant>(restList);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(250, 80));
		list.setBounds(10, 48, 307, 205);
		panel.add(list);
		
		
		JButton makeRev = new JButton("New Review");
		makeRev.setBounds(327, 48, 117, 29);
		panel.add(makeRev);
		makeRev.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(list.getSelectedValue() != null){
					ReviewWindow review = new ReviewWindow(NEW_UI.this, list.getSelectedValue(), Main.getCurrentUser());
					review.setVisible(true);
				}
			}
		});
		
		JButton seeRev = new JButton("See Reviews");
		seeRev.setBounds(327, 87, 117, 29);
		panel.add(seeRev);
		seeRev.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(list.getSelectedValue() != null){
					ReadWindow read = new ReadWindow(NEW_UI.this, list.getSelectedValue(), Main.getCurrentUser());
					read.setVisible(true);
				}
			}
		});
		
		JButton btnSignIn = new JButton("Sign in");
		btnSignIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Login login = new Login(NEW_UI.this);
				login.setVisible(true);
			}
		});
		btnSignIn.setBounds(195, 265, 117, 29);
		panel.add(btnSignIn);
		
		JButton button = new JButton("Sign up");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Signup signup = new Signup(NEW_UI.this);
				signup.setVisible(true);
			}
		});
		button.setBounds(324, 265, 117, 29);
		panel.add(button);

	




	}
	
	private void setList(Restaurant[] rests)
	{
		restList = rests;
	}
}
