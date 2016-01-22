package se.mah.kd405a_johan_a;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.JMenuItem;
import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JSplitPane;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;
import java.util.Vector;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTable tblMembers;
	private JTextField txtNamn;
	private JTextField txtPersonNr;
	private JTextField txtPostNr;
	private JTextField txtOrt;
	private JTextField txtTelefonNr;
	private JTextField txtEpost;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setBackground(new Color(47, 79, 79));
		setTitle("Green Mean Gym Machine 2000");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(47, 79, 79));
		setJMenuBar(menuBar);
		
		JMenu mnArkiv = new JMenu("Arkiv");
		mnArkiv.setBackground(new Color(47, 79, 79));
		menuBar.add(mnArkiv);
		
		JMenuItem mntmSkrivUt = new JMenuItem("Skriv ut");
		mnArkiv.add(mntmSkrivUt);
		
		JSeparator separator = new JSeparator();
		mnArkiv.add(separator);
		
		JMenuItem mntmAvsluta = new JMenuItem("Avsluta");
		mnArkiv.add(mntmAvsluta);
		
		JMenu mnMedlem = new JMenu("Medlem");
		menuBar.add(mnMedlem);
		
		JMenuItem mntmNyMedlem = new JMenuItem("Ny medlem");
		mnMedlem.add(mntmNyMedlem);
		
		JSeparator separator_1 = new JSeparator();
		mnMedlem.add(separator_1);
		
		JMenuItem mntmHittaMedlem = new JMenuItem("Hitta medlem");
		mnMedlem.add(mntmHittaMedlem);
		
		JMenu mnHjlp = new JMenu("Hjälp");
		menuBar.add(mnHjlp);
		
		JMenuItem mntmHjlp = new JMenuItem("Hjälp");
		mnHjlp.add(mntmHjlp);
		
		JSeparator separator_2 = new JSeparator();
		mnHjlp.add(separator_2);
		
		JMenuItem mntmOmProgrammet = new JMenuItem("Om programmet");
		mnHjlp.add(mntmOmProgrammet);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBackground(SystemColor.window);
		splitPane.setResizeWeight(0.5);
		contentPane.add(splitPane);
		
		JScrollPane pnlMembers = new JScrollPane();
		splitPane.setLeftComponent(pnlMembers);
		
		tblMembers = new JTable();
		DefaultTableModel dtm = new DefaultTableModel(0, 0);
		Object columnNames[] = { "Id", "Namn", "E-post"};
		dtm.setColumnIdentifiers(columnNames);
		tblMembers.setModel(dtm);
		tblMembers.setFillsViewportHeight(true);
		tblMembers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblMembers.setShowHorizontalLines(false);
		for(int i = 0; i < 100; i++)
		{
			dtm.addRow(new Object[]{ i, "Namn" + i, "epost"+i+"@hotmail.com" + i });
		}
		pnlMembers.setViewportView(tblMembers);
		
		JPanel pnlMember = new JPanel();
		pnlMember.setBackground(new Color(47, 79, 79));
		splitPane.setRightComponent(pnlMember);
		pnlMember.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("pref:grow"),},
			new RowSpec[] {
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("fill:pref"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:pref:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:pref"),}));
		
		JPanel pnlMemberImage = new JPanel();
		pnlMemberImage.setBackground(new Color(47, 79, 79));
		pnlMember.add(pnlMemberImage, "1, 2, fill, fill");
		pnlMemberImage.setLayout(new BoxLayout(pnlMemberImage, BoxLayout.X_AXIS));
		
		JLabel lblImage = new JLabel("");
		pnlMemberImage.add(lblImage);
		lblImage.setHorizontalAlignment(SwingConstants.TRAILING);
		lblImage.setIcon(new ImageIcon(Main.class.getResource("/res/user.png")));
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(47, 79, 79));
		pnlMemberImage.add(panel);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("pref:grow"),},
			new RowSpec[] {
				RowSpec.decode("fill:183px"),}));
		
		JLabel lblLogo = new JLabel("");
		panel.add(lblLogo, "1, 1, right, top");
		lblLogo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLogo.setVerticalAlignment(SwingConstants.TOP);
		lblLogo.setIcon(new ImageIcon(Main.class.getResource("/res/logo.png")));
		
		JPanel pnlMemberInfoContainer = new JPanel();
		pnlMember.add(pnlMemberInfoContainer, "1, 4, fill, fill");
		pnlMemberInfoContainer.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pnlMemberInfo = new JPanel();
		pnlMemberInfoContainer.add(pnlMemberInfo);
		pnlMemberInfo.setBackground(new Color(47, 79, 79));
		FormLayout fl_pnlMemberInfo = new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("3dlu"),
				ColumnSpec.decode("left:50dlu"),
				ColumnSpec.decode("3dlu"),
				ColumnSpec.decode("pref:grow"),
				ColumnSpec.decode("3dlu"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("top:25px"),
				RowSpec.decode("top:25px"),
				RowSpec.decode("top:35dlu"),
				RowSpec.decode("top:25px"),
				RowSpec.decode("top:25px"),
				RowSpec.decode("top:25px"),
				RowSpec.decode("top:25px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,});
		pnlMemberInfo.setLayout(fl_pnlMemberInfo);
		
		JLabel lblMedlemsId = new JLabel("Medlems Id: 1248");
		pnlMemberInfo.add(lblMedlemsId, "4, 2");
		lblMedlemsId.setVerticalAlignment(SwingConstants.BOTTOM);
		lblMedlemsId.setForeground(new Color(255, 255, 255));
		lblMedlemsId.setBackground(new Color(47, 79, 79));
		
		JLabel lblNamn = new JLabel("Namn");
		lblNamn.setForeground(new Color(255, 255, 255));
		pnlMemberInfo.add(lblNamn, "2, 3, fill, fill");
		lblNamn.setHorizontalAlignment(SwingConstants.TRAILING);
		
		txtNamn = new JTextField();
		txtNamn.setText("Alf Tyngdlyftsson");
		pnlMemberInfo.add(txtNamn, "4, 3, fill, fill");
		txtNamn.setColumns(10);
		
		JLabel lblPersonNr = new JLabel("Person nr.");
		lblPersonNr.setForeground(new Color(255, 255, 255));
		lblPersonNr.setHorizontalAlignment(SwingConstants.TRAILING);
		pnlMemberInfo.add(lblPersonNr, "2, 4, fill, fill");
		
		txtPersonNr = new JTextField();
		txtPersonNr.setText("791001");
		txtPersonNr.setColumns(10);
		pnlMemberInfo.add(txtPersonNr, "4, 4, fill, fill");
		
		JLabel lblAdress = new JLabel("Adress");
		lblAdress.setForeground(new Color(255, 255, 255));
		lblAdress.setVerticalAlignment(SwingConstants.TOP);
		lblAdress.setHorizontalAlignment(SwingConstants.TRAILING);
		pnlMemberInfo.add(lblAdress, "2, 5, fill, fill");
		
		JTextArea txtAdress = new JTextArea();
		txtAdress.setRows(4);
		txtAdress.setText("Gymvägen 3");
		pnlMemberInfo.add(txtAdress, "4, 5, fill, fill");
		
		JLabel lblPostNr = new JLabel("Post nr.");
		lblPostNr.setForeground(new Color(255, 255, 255));
		lblPostNr.setHorizontalAlignment(SwingConstants.TRAILING);
		pnlMemberInfo.add(lblPostNr, "2, 6, fill, fill");
		
		txtPostNr = new JTextField();
		txtPostNr.setText("32145");
		txtPostNr.setColumns(10);
		pnlMemberInfo.add(txtPostNr, "4, 6, fill, fill");
		
		JLabel lblOrt = new JLabel("Ort");
		lblOrt.setForeground(new Color(255, 255, 255));
		lblOrt.setHorizontalAlignment(SwingConstants.TRAILING);
		pnlMemberInfo.add(lblOrt, "2, 7, fill, fill");
		
		txtOrt = new JTextField();
		txtOrt.setText("Tyngdlyftsholmen");
		txtOrt.setColumns(10);
		pnlMemberInfo.add(txtOrt, "4, 7, fill, fill");
		
		JLabel lblTelefonNr = new JLabel("Telefon nr.");
		lblTelefonNr.setForeground(new Color(255, 255, 255));
		lblTelefonNr.setHorizontalAlignment(SwingConstants.TRAILING);
		pnlMemberInfo.add(lblTelefonNr, "2, 8, fill, fill");
		
		txtTelefonNr = new JTextField();
		txtTelefonNr.setText("02012345");
		txtTelefonNr.setColumns(10);
		pnlMemberInfo.add(txtTelefonNr, "4, 8, fill, fill");
		
		JLabel lblEpost = new JLabel("E-post");
		lblEpost.setForeground(Color.WHITE);
		lblEpost.setHorizontalAlignment(SwingConstants.TRAILING);
		pnlMemberInfo.add(lblEpost, "2, 9, fill, fill");
		
		txtEpost = new JTextField();
		txtEpost.setText("alf@tyngdlyftsson.se");
		txtEpost.setColumns(10);
		pnlMemberInfo.add(txtEpost, "4, 9, fill, fill");
		
		JButton btnSpara = new JButton("Spara");
		pnlMemberInfo.add(btnSpara, "2, 11");
		btnSpara.setHorizontalAlignment(SwingConstants.LEFT);
	}

}
