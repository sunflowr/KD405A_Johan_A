import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;

public class CalculatorGUI extends JFrame {
	
	private Calculator calculator;

	private JPanel contentPane;
	private JTextField txtDisplay;
	private JButton btnClear;
	private JButton btnDivide;
	private JButton btn8;
	private JButton btn7;
	private JButton btn9;
	private JButton btnMultiply;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btnMinus;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btnPlus;
	private JButton btn0;
	private JButton btnDecimal;
	private JButton btnSum;
	private JPanel pnlButtonRow1;
	private JPanel pnlButtonRow2;
	private JPanel pnlButtonRow3;
	private JPanel pnlButtonRow4;
	private JPanel pnlButtonRow5;
	private JPanel pnlRow5Col1;
	private JPanel pnlRow5Col2;
	private JPanel pnlRow1Col2;
	private JPanel pnlRow1Col1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorGUI frame = new CalculatorGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CalculatorGUI() {
		calculator = new Calculator();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 444);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		txtDisplay = new JTextField();
		txtDisplay.setHorizontalAlignment(SwingConstants.TRAILING);
		txtDisplay.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtDisplay.setEditable(false);
		contentPane.add(txtDisplay, BorderLayout.NORTH);
		txtDisplay.setColumns(10);

		// Set initial value of calculator.
		txtDisplay.setText(String.valueOf(calculator.getResult()));
		
		JPanel pnlButtons = new JPanel();
		contentPane.add(pnlButtons, BorderLayout.CENTER);
		pnlButtons.setLayout(new GridLayout(5, 4, 2, 2));
		
		pnlButtonRow1 = new JPanel();
		pnlButtons.add(pnlButtonRow1);
		pnlButtonRow1.setLayout(new GridLayout(0, 2, 2, 0));
		
		pnlRow1Col1 = new JPanel();
		pnlButtonRow1.add(pnlRow1Col1);
		pnlRow1Col1.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnClear = new JButton("C");
		pnlRow1Col1.add(btnClear);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.clear();
				txtDisplay.setText(String.valueOf(calculator.getResult()));
			}
		});
		
		pnlRow1Col2 = new JPanel();
		pnlButtonRow1.add(pnlRow1Col2);
		pnlRow1Col2.setLayout(new GridLayout(0, 1, 2, 2));
		
		btnSum = new JButton("=");
		pnlRow1Col2.add(btnSum);
		btnSum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					calculator.equals();
					txtDisplay.setText(String.valueOf(calculator.getResult()));
				} catch(java.lang.ArithmeticException ex) {
					calculator.clear();
					txtDisplay.setText("Error: " + ex.getMessage());
				}
			}
		});
		
		pnlButtonRow2 = new JPanel();
		pnlButtons.add(pnlButtonRow2);
		pnlButtonRow2.setLayout(new GridLayout(0, 4, 0, 2));
		
		btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.numberButtonPressed(7);
				txtDisplay.setText(String.valueOf(calculator.getOperand()));
			}
		});
		pnlButtonRow2.add(btn7);
		
		btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.numberButtonPressed(8);
				txtDisplay.setText(String.valueOf(calculator.getOperand()));
			}
		});
		pnlButtonRow2.add(btn8);
		
		btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.numberButtonPressed(9);
				txtDisplay.setText(String.valueOf(calculator.getOperand()));
			}
		});
		pnlButtonRow2.add(btn9);
		
		btnMultiply = new JButton("*");
		pnlButtonRow2.add(btnMultiply);
		btnMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.mult();
				txtDisplay.setText(String.valueOf(calculator.getResult()));
			}
		});
		
		pnlButtonRow3 = new JPanel();
		pnlButtons.add(pnlButtonRow3);
		pnlButtonRow3.setLayout(new GridLayout(0, 4, 0, 0));
		
		btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.numberButtonPressed(4);
				txtDisplay.setText(String.valueOf(calculator.getOperand()));
			}
		});
		pnlButtonRow3.add(btn4);
		
		btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.numberButtonPressed(5);
				txtDisplay.setText(String.valueOf(calculator.getOperand()));
			}
		});
		pnlButtonRow3.add(btn5);
		
		btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.numberButtonPressed(6);
				txtDisplay.setText(String.valueOf(calculator.getOperand()));
			}
		});
		pnlButtonRow3.add(btn6);
		
		btnDivide = new JButton("/");
		pnlButtonRow3.add(btnDivide);
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					calculator.div();
					txtDisplay.setText(String.valueOf(calculator.getResult()));
				} catch(java.lang.ArithmeticException ex) {
					calculator.clear();
					txtDisplay.setText("Error: " + ex.getMessage());
				}
			}
		});
		
		pnlButtonRow4 = new JPanel();
		pnlButtons.add(pnlButtonRow4);
		pnlButtonRow4.setLayout(new GridLayout(0, 4, 0, 0));
		
		btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.numberButtonPressed(1);
				txtDisplay.setText(String.valueOf(calculator.getOperand()));
			}
		});
		pnlButtonRow4.add(btn1);
		
		btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.numberButtonPressed(2);
				txtDisplay.setText(String.valueOf(calculator.getOperand()));
			}
		});
		pnlButtonRow4.add(btn2);
		
		btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.numberButtonPressed(3);
				txtDisplay.setText(String.valueOf(calculator.getOperand()));
			}
		});
		pnlButtonRow4.add(btn3);
		
		btnMinus = new JButton("-");
		pnlButtonRow4.add(btnMinus);
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.minus();
				txtDisplay.setText(String.valueOf(calculator.getResult()));
			}
		});
		
		pnlButtonRow5 = new JPanel();
		pnlButtons.add(pnlButtonRow5);
		pnlButtonRow5.setLayout(new GridLayout(0, 2, 0, 0));
		
		pnlRow5Col1 = new JPanel();
		pnlButtonRow5.add(pnlRow5Col1);
		pnlRow5Col1.setLayout(new GridLayout(0, 1, 0, 0));
		
		btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.numberButtonPressed(0);
				txtDisplay.setText(String.valueOf(calculator.getOperand()));
			}
		});
		pnlRow5Col1.add(btn0);
		
		pnlRow5Col2 = new JPanel();
		pnlButtonRow5.add(pnlRow5Col2);
		pnlRow5Col2.setLayout(new GridLayout(1, 2, 2, 2));
		
		btnDecimal = new JButton(",");
		btnDecimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.decimalButtonPressed();
			}
		});
		pnlRow5Col2.add(btnDecimal);
		
		btnPlus = new JButton("+");
		pnlRow5Col2.add(btnPlus);
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.plus();
				txtDisplay.setText(String.valueOf(calculator.getResult()));
			}
		});
	}
}
