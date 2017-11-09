import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class AdminPage extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JButton btnAdd;
	private JLabel lblDeleteRestaurant;
	private JComboBox comboBox;
	private JButton button;
	private JLabel lblAddAdmin;
	private JTextField textField_1;
	private JButton btnAdd_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AdminPage dialog = new AdminPage();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AdminPage() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.PINK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblAddRestaurant = new JLabel("Add Restaurant:");
			lblAddRestaurant.setBounds(35, 26, 108, 16);
			contentPanel.add(lblAddRestaurant);
		}
		{
			textField = new JTextField();
			textField.setBounds(155, 21, 130, 26);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			btnAdd = new JButton("Add");
			btnAdd.setBounds(297, 21, 117, 29);
			contentPanel.add(btnAdd);
		}
		{
			lblDeleteRestaurant = new JLabel("Delete Restaurant:");
			lblDeleteRestaurant.setBounds(22, 54, 130, 16);
			contentPanel.add(lblDeleteRestaurant);
		}
		{
			comboBox = new JComboBox();
			comboBox.setBounds(155, 50, 130, 27);
			contentPanel.add(comboBox);
		}
		{
			button = new JButton("Delete");
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
				}
			});
			button.setBounds(297, 49, 117, 29);
			contentPanel.add(button);
		}
		{
			lblAddAdmin = new JLabel("Add Admin:");
			lblAddAdmin.setBounds(65, 127, 78, 16);
			contentPanel.add(lblAddAdmin);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(155, 122, 130, 26);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			btnAdd_1 = new JButton("Add");
			btnAdd_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
				}
			});
			btnAdd_1.setBounds(297, 122, 117, 29);
			contentPanel.add(btnAdd_1);
		}
	}
}
