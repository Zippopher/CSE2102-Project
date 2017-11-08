import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollBar;
import java.awt.Color;

public class ReviewWindow extends JFrame {

	private JPanel contentPane;
	private String[] rating = {"1", "2", "3", "4", "5"};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReviewWindow frame = new ReviewWindow();
					frame.setVisible(false);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReviewWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOverallRating = new JLabel("Overall Rating");
		lblOverallRating.setBounds(22, 17, 88, 16);
		contentPane.add(lblOverallRating);
		
		JComboBox comboBox = new JComboBox(rating);
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
		});
		comboBox.setBounds(123, 13, 64, 27);
		contentPane.add(comboBox);
		
		JLabel label = new JLabel("Price Rating");
		label.setBounds(247, 17, 88, 16);
		contentPane.add(label);
		
		JComboBox comboBox_1 = new JComboBox(rating);
		comboBox_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
		});
		comboBox_1.setBounds(333, 13, 64, 27);
		contentPane.add(comboBox_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(22, 64, 410, 176);
		contentPane.add(textArea);
		
		JLabel lblLeaveAReview = new JLabel("Leave a Review:");
		lblLeaveAReview.setBounds(32, 45, 109, 16);
		contentPane.add(lblLeaveAReview);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
		});
		btnSubmit.setBounds(55, 243, 117, 29);
		contentPane.add(btnSubmit);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(429, 64, 15, 176);
		contentPane.add(scrollBar);
	}
}
