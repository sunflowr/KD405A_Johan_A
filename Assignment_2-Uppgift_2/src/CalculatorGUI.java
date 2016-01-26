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

public class CalculatorGUI extends JFrame {
	
	private Calculator calculator;

	private JPanel contentPane;
	private JTextField txtDisplay;
	private JButton btnClear;
	private JButton btnProcent;
	private JButton btnInvert;
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
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(5, 4, 2, 2));
		
		btnClear = new JButton("C");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.clear();
				txtDisplay.setText(String.valueOf(calculator.getResult()));
			}
		});
		panel.add(btnClear);
		
		btnInvert = new JButton("+/-");
		btnInvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Sorry! Can't negate! Does not compute!!");
			}
		});
		panel.add(btnInvert);
		
		btnProcent = new JButton("%");
		btnProcent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Sorry! Can't procent! Does not compute!!");
			}
		});
		panel.add(btnProcent);
		
		btnDivide = new JButton("/");
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Sorry! Can't divide! Does not compute!!");
			}
		});
		panel.add(btnDivide);
		
		btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.numberButtonPressed(7);
				txtDisplay.setText(String.valueOf(calculator.getOperand()));
			}
		});
		panel.add(btn7);
		
		btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.numberButtonPressed(8);
				txtDisplay.setText(String.valueOf(calculator.getOperand()));
			}
		});
		panel.add(btn8);
		
		btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.numberButtonPressed(9);
				txtDisplay.setText(String.valueOf(calculator.getOperand()));
			}
		});
		panel.add(btn9);
		
		btnMultiply = new JButton("*");
		btnMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.mult();
				txtDisplay.setText(String.valueOf(calculator.getResult()));
			}
		});
		panel.add(btnMultiply);
		
		btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.numberButtonPressed(4);
				txtDisplay.setText(String.valueOf(calculator.getOperand()));
			}
		});
		panel.add(btn4);
		
		btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.numberButtonPressed(5);
				txtDisplay.setText(String.valueOf(calculator.getOperand()));
			}
		});
		panel.add(btn5);
		
		btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.numberButtonPressed(6);
				txtDisplay.setText(String.valueOf(calculator.getOperand()));
			}
		});
		panel.add(btn6);
		
		btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.minus();
				txtDisplay.setText(String.valueOf(calculator.getResult()));
			}
		});
		panel.add(btnMinus);
		
		btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.numberButtonPressed(1);
				txtDisplay.setText(String.valueOf(calculator.getOperand()));
			}
		});
		panel.add(btn1);
		
		btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.numberButtonPressed(2);
				txtDisplay.setText(String.valueOf(calculator.getOperand()));
			}
		});
		panel.add(btn2);
		
		btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.numberButtonPressed(3);
				txtDisplay.setText(String.valueOf(calculator.getOperand()));
			}
		});
		panel.add(btn3);
		
		btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.plus();
				txtDisplay.setText(String.valueOf(calculator.getResult()));
			}
		});
		panel.add(btnPlus);
		
		btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.numberButtonPressed(0);
				txtDisplay.setText(String.valueOf(calculator.getOperand()));
			}
		});
		panel.add(btn0);
		
		btnDecimal = new JButton(",");
		btnDecimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Sorry! Can't decimal! Does not compute!!");
			}
		});
		panel.add(btnDecimal);
		
		btnSum = new JButton("=");
		btnSum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator.equals();
				txtDisplay.setText(String.valueOf(calculator.getResult()));
			}
		});
		panel.add(btnSum);

		txtDisplay.setText(String.valueOf(calculator.getResult()));
	}
}
