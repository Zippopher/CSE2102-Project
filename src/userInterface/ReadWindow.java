package userInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Function.Restaurant;
import Function.Review;
import Function.User;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import java.awt.Color;

public class ReadWindow extends JDialog {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReadWindow frame = new ReadWindow();
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
	public ReadWindow(NEW_UI newui, Restaurant rest, User user) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOverallRating = new JLabel("Overall Rating: " + rest.getAvgRate());
		lblOverallRating.setBounds(25, 16, 102, 16);
		contentPane.add(lblOverallRating);
		
		JLabel label = new JLabel("Price Rating: " + rest.getAvgPrice());
		label.setBounds(224, 16, 102, 16);
		contentPane.add(label);
		
		String revs = "";
		for(Review r : rest.getReviews())
		{
			revs = revs + r.getAuthor().getUsername() + ":\n" + r.getReview() + "\n\n";
		}
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(31, 66, 386, 192);
		textPane.setText(revs);
		contentPane.add(textPane);
		
		JLabel lblReviews = new JLabel("Reviews:" );
		lblReviews.setBounds(35, 44, 61, 16);
		contentPane.add(lblReviews);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(418, 66, 15, 192);
		contentPane.add(scrollBar);
	}
}
