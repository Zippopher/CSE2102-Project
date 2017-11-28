package userInterface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminWindow extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AdminWindow dialog = new AdminWindow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AdminWindow() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JList list = new JList();
		list.setBounds(28, 33, 106, 172);
		contentPanel.add(list);
		
		JLabel lblUserList = new JLabel("User List:");
		lblUserList.setBounds(28, 16, 61, 16);
		contentPanel.add(lblUserList);
		
		JButton btnAdminUser = new JButton("Admin User");
		btnAdminUser.setBounds(28, 230, 117, 29);
		btnAdminUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		contentPanel.add(btnAdminUser);
		
		JButton btnDeleteUser = new JButton("Delete User");
		btnDeleteUser.setBounds(28, 205, 117, 29);
		btnDeleteUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		contentPanel.add(btnDeleteUser);
		
		JLabel lblAddRestaurant = new JLabel("Add Restaurant:");
		lblAddRestaurant.setBounds(174, 16, 106, 16);
		contentPanel.add(lblAddRestaurant);
		
		textField = new JTextField();
		textField.setBounds(174, 44, 179, 26);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JButton btnAddRestaurant = new JButton("Add Restaurant");
		btnAddRestaurant.setBounds(199, 68, 133, 29);
		contentPanel.add(btnAddRestaurant);
	}
}
