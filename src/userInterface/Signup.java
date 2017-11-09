package userInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Function.Main;
import Function.User;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Signup extends JDialog {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup();
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	/**
	 * Create the frame.
	 */
	public Signup(NEW_UI newui) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(46, 49, 88, 16);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(46, 114, 77, 16);
		contentPane.add(lblPassword);
		
		JLabel label = new JLabel("Confirm Password:");
		label.setBounds(9, 177, 125, 16);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(146, 44, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(146, 109, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(146, 172, 130, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton button = new JButton("Enter");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String user = textField.getText();
				String pass1 = textField_1.getText();
				String pass2 = textField_2.getText();
				
				if(pass1.equals(pass2)) {
					Main.addUser(new User(user, pass1));

					newui.invalidate();
					newui.validate();
					newui.repaint();
					
					Signup.this.dispose();
				}
				
			}
		});
		button.setBounds(146, 243, 117, 29);
		contentPane.add(button);



	}
}