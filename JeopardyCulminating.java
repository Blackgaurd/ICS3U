/*
 * jeopardy trivia game
 *
 * modified       20210824
 * date           20210824
 * @filename      JeopardyCulminating.java
 * @authors       Iman Faisal, Bryan Deng, Ishaan Gawande, Sai K. Nellutla
 * @version       1.0
 * @see           unit 5.2 content
 */

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class JeopardyCulminating extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JeopardyCulminating frame = new JeopardyCulminating();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JPanel contentPane;

	private JLabel amtEarnedOutput;
	private JLabel feedbackOutput;

	private int totalPoints = 0;

	/**
	 * Create the frame.
	 */
	public JeopardyCulminating() {
		initFrame();
		initMovieQuestions();
		initGeoQuestions();
		initSportQuestions();
		initGenQuestions();
		initOtherComponents();
	}

	// Bryan
	private void initFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 841, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(106, 90, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	// Ishaan
	private void initMovieQuestions(){
		JLabel lblMovie = new JLabel("Movies");
		lblMovie.setFont(new Font("Kohinoor Devanagari", Font.PLAIN, 28));
		lblMovie.setBounds(35, 60, 100, 36);
		contentPane.add(lblMovie);

		QuestionButton movie100 = new QuestionButton(
			100,
			"How many infinity stones are there?",
			new String[] {"6", "5", "9", "3"},
			"A"
		);
		movie100.setBounds(22, 147, 141, 89);
		contentPane.add(movie100);

		QuestionButton movie200 = new QuestionButton(
			200,
			"Other than Thor, Who can lift Thor’s hammer?",
			new String[] {"Captain Marvel", "Captain America", "Iron Man", "Spider Man"},
			"B"
		);
		movie200.setBounds(22, 258, 141, 89);
		contentPane.add(movie200);

		QuestionButton movie300 = new QuestionButton(
			300,
			"Where was the Lord Of The Rings filmed?",
			new String[] {"Egypt", "Canada", "New Zealand", "Mexico"},
			"C"
		);
		movie300.setBounds(22, 369, 141, 89);
		contentPane.add(movie300);

		QuestionButton movie400 = new QuestionButton(
			400,
			"Who directed Pulp Fiction?",
			new String[] {"Steven Spielberg", "Quentin Tarantino", "Chris Evans", "M. Night Shyamalan"},
			"B"
		);
		movie400.setBounds(22, 491, 141, 89);
		contentPane.add(movie400);
	}

	// Ishaan
	private void initGeoQuestions(){
		JLabel lblGeo = new JLabel("Geography");
		lblGeo.setFont(new Font("Kohinoor Devanagari", Font.PLAIN, 28));
		lblGeo.setBounds(213, 60, 155, 36);
		contentPane.add(lblGeo);

		QuestionButton geo100 = new QuestionButton(
			100,
			"What country has the largest population?",
			new String[] {"United States", "Canada", "Russia", "China"},
			"D"
		);
		geo100.setBounds(227, 147, 141, 89);
		contentPane.add(geo100);

		QuestionButton geo200 = new QuestionButton(
			200,
			"What is the largest continent on Earth?",
			new String[] {"Asia", "Europe", "Africa", "Antarctica"},
			"A"
		);
		geo200.setBounds(227, 258, 141, 89);
		contentPane.add(geo200);

		QuestionButton geo300 = new QuestionButton(
			300,
			"London is the capital of what country?",
			new String[] {"New Zealand", "England", "Germany", "Canada"},
			"B"
		);
		geo300.setBounds(227, 369, 141, 89);
		contentPane.add(geo300);

		QuestionButton geo400 = new QuestionButton(
			400,
			"What is the capital of Australia?",
			new String[] {"Beijing", "Canberra", "London", "Berlin"},
			"B"
		);
		geo400.setBounds(227, 491, 141, 89);
		contentPane.add(geo400);
	}

	// Sai
	private void initSportQuestions(){
		JLabel lblSport = new JLabel("Sports");
		lblSport.setFont(new Font("Kohinoor Devanagari", Font.PLAIN, 28));
		lblSport.setBounds(463, 60, 100, 36);
		contentPane.add(lblSport);

		QuestionButton sport100 = new QuestionButton(
			100,
			"How often are the Olympics held?",
			new String[] {"4 years", "2 years", "5 years", "yearly"},
			"A"
		);
		sport100.setBounds(435, 147, 141, 89);
		contentPane.add(sport100);
		
		QuestionButton sport200 = new QuestionButton(
			200,
			"What part of the body can't touch the ball in soccer? ",
			new String[] {"Mouth", "Knees", "Shoulder", "Hands"},
			"D"
			
		);
		sport200.setBounds(435, 258, 141, 89);
		contentPane.add(sport200);

		QuestionButton sport300 = new QuestionButton(
			300,
			"In what game is love a score?",
			new String[] {"Tennis", "Badminton", "Soccer", "VolleyBall"},
			"A"
		);
		sport300.setBounds(435, 369, 141, 89);
		contentPane.add(sport300);

		QuestionButton sport400 = new QuestionButton(
			400,
			"What type of race is the Tour de France?",
			new String[] {"Car Race", "Bike Race", "Canoe Race", "Running"},
			"B"
		);
		sport400.setBounds(435, 491, 141, 89);
		contentPane.add(sport400);
	}

	// Sai
	private void initGenQuestions(){
		JLabel lblGen = new JLabel("General");
		lblGen.setFont(new Font("Kohinoor Devanagari", Font.PLAIN, 28));
		lblGen.setBounds(671, 60, 114, 36);
		contentPane.add(lblGen);

		QuestionButton gen100 = new QuestionButton(
			100,
			"What is the biggest animal in the world?",
			new String[] {"Elephant", "Giraffe", "Blue Whale", "Sperm whale"},
			"C"
		);
		gen100.setBounds(647, 147, 141, 89);
		contentPane.add(gen100);

		QuestionButton gen200 = new QuestionButton(
			200,
			"Who was the first man on the moon?",
			new String[] {"Barack Obama", "Donald Glover", "Martin Luther King", "Neil Armstrong"},
			"D"
		);
		gen200.setBounds(647, 258, 141, 89);
		contentPane.add(gen200);

		QuestionButton gen300 = new QuestionButton(
			300,
			"How many valves does a heart have?",
			new String[] {"8", "3", "4", "2"},
			"C"
		);
		gen300.setBounds(647, 369, 141, 89);
		contentPane.add(gen300);

		QuestionButton gen400 = new QuestionButton(
			400,
			"What planet is closest to the sun?",
			new String[] {"Jupiter", "Mercury", "Earth", "Mars"},
			"B"
		);
		gen400.setBounds(647, 491, 141, 89);
		contentPane.add(gen400);
	}

	// Iman
	private void initOtherComponents(){
		JLabel titleLine = new JLabel("_______________________________________________________________");
		titleLine.setFont(new Font("Kohinoor Devanagari", Font.PLAIN, 28));
		titleLine.setBounds(0, 83, 882, 36);
		contentPane.add(titleLine);

		amtEarnedOutput = new JLabel("Amount Earned: $0");
		amtEarnedOutput.setForeground(new Color(255, 215, 0));
		amtEarnedOutput.setFont(new Font("Kohinoor Devanagari", Font.PLAIN, 28));
		amtEarnedOutput.setBounds(6, 630, 300, 36);
		contentPane.add(amtEarnedOutput);

		feedbackOutput = new JLabel("", SwingConstants.RIGHT);
		feedbackOutput.setFont(new Font("Kohinoor Devanagari", Font.PLAIN, 28));
		feedbackOutput.setBounds(405, 630, 400, 36);
		contentPane.add(feedbackOutput);
	}

	// Iman
	private void addPoints(int points){
		totalPoints += points;
		amtEarnedOutput.setText(String.format("Amount Earned: $%d", totalPoints));
	}

	// Bryan
	private void giveFeedback(String message, Color foreground){
		feedbackOutput.setForeground(foreground);
		feedbackOutput.setText(message);
	}

	// Bryan
	public class QuestionButton extends JButton {
		final Color red = new Color(244, 57, 57);
		final Color green = new Color(138, 255, 74);
		final Color lightGrey = new Color(190, 190, 190);
		final Color darkGrey = new Color(116, 116, 116);

		boolean completed = false;

		QuestionButton(int value, String question, String[] ansChoices, String correctAns) {

			// set text on JButton
			super(String.format("$%d", value));

			this.setFont(new Font("Kohinoor Telugu", Font.PLAIN, 20));
			this.setBackground(lightGrey);

			String popupText = String.format(
				"%s\nA. %s\nB. %s\nC. %s\nD. %s",
				question,
				ansChoices[0],
				ansChoices[1],
				ansChoices[2],
				ansChoices[3]
			);

			this.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (completed){
						return;
					}

					completed = true;
					QuestionButton.this.setBackground(Color.GRAY );
			        QuestionButton.this.setForeground(Color.PINK);


					String input = JOptionPane.showInputDialog(getParent(), popupText, null);
					if (input == null) {
						// input popup cancelled or exited
						giveFeedback("Invalid input, incorrect answer!", red);
						return;
					}

					input = input.trim().toUpperCase();
					if (input.length() == 1 && "ABCD".contains(input)){
						if (input.equals(correctAns)){
							giveFeedback("Correct answer!", green);
							addPoints(value);
						} else {
							giveFeedback("Wrong answer!", red);
						}
					} else {
						giveFeedback("Invalid input, incorrect answer!", red);
					}
				}
			});
		}
	}
}		