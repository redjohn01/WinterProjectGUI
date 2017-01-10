package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChooseMenu extends JFrame {

	private JPanel contentPane;
	private JMenuItem mntmLogout;
	private JButton btCustomer;
	private JButton btEmployee;
	private JButton btItem;
	private JButton btContractor;
	private JButton btSale;
	private JButton btLeasing;
	private JButton btExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseMenu frame = new ChooseMenu();
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
	public ChooseMenu() {
		initializeComponents();
		createEvents();
	}

	private void initializeComponents() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Programming\\eclipse\\Instal eclipse\\eclipse\\workspace\\GUIWorkshop\\src\\components\\system.png"));
		setTitle("Main Menu");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 447);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmLogout = new JMenuItem("Logout");
		mntmLogout.setIcon(new ImageIcon("D:\\Programming\\eclipse\\Instal eclipse\\eclipse\\workspace\\BlueJExport\\src\\components\\exit_16.png"));
		mnFile.add(mntmLogout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btCustomer = new JButton("Customer Menu");
		
		btCustomer.setBounds(212, 13, 158, 36);
		contentPane.add(btCustomer);
		
		btEmployee = new JButton("Employee Menu");
		btEmployee.setBounds(212, 62, 158, 36);
		contentPane.add(btEmployee);
		
		btItem = new JButton("Item Menu");
		
		btItem.setBounds(212, 113, 158, 36);
		contentPane.add(btItem);
		
		btContractor = new JButton("Contractor Menu");
		btContractor.setBounds(212, 162, 158, 36);
		contentPane.add(btContractor);
		
		btSale = new JButton("Sale Menu");
		
		btSale.setBounds(212, 210, 158, 36);
		contentPane.add(btSale);
		
		btLeasing = new JButton("Leasing Menu");
		
		btLeasing.setBounds(212, 259, 158, 36);
		contentPane.add(btLeasing);
		
		btExit = new JButton("Exit Program");
		
		btExit.setBounds(212, 308, 158, 36);
		contentPane.add(btExit);
	}
	
	private void createEvents() {
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout ?");
				if(confirm == JOptionPane.YES_OPTION) {
					dispose();
					LoginMenu loginMenu = new LoginMenu();
					loginMenu.main(null);
				}
			}
		});
		
		btCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CustomerMenu customerMenu = new CustomerMenu();
				dispose();
				customerMenu.main(null);
			}
		});
		
		btSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaleMenu saleMenu = new SaleMenu();
				dispose();
				saleMenu.main(null);
			}
		});
		
		btLeasing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LeasingMenu lMenu = new LeasingMenu();
				dispose();
				lMenu.main(null);
			}
		});
		
		btItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ItemMenu itemMenu = new ItemMenu();
				dispose();
				itemMenu.main(null);
			}
		});
	}
}
