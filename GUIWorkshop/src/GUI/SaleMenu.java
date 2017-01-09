package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JButton;

public class SaleMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaleMenu frame = new SaleMenu();
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
	public SaleMenu() {
		initializeComponents();
		createEvents();
	}

	

	private void initializeComponents() {
		setTitle("Sale Menu");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Programming\\eclipse\\Instal eclipse\\eclipse\\workspace\\GUIWorkshop\\src\\components\\system.png"));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCreateSale = new JButton("Create Sale");
		btnCreateSale.setBounds(189, 53, 123, 36);
		contentPane.add(btnCreateSale);
		
		JButton btnReadSale = new JButton("Read Sale");
		btnReadSale.setBounds(189, 102, 123, 36);
		contentPane.add(btnReadSale);
		
		JButton btnEditSale = new JButton("Edit Sale");
		btnEditSale.setBounds(189, 155, 123, 36);
		contentPane.add(btnEditSale);
		
		JButton btnPreviousMenu = new JButton("Previous Menu");
		btnPreviousMenu.setBounds(189, 207, 123, 36);
		contentPane.add(btnPreviousMenu);
		
		JButton btnExitProgram = new JButton("Exit Program");
		btnExitProgram.setBounds(189, 256, 123, 36);
		contentPane.add(btnExitProgram);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(12, 13, 97, 25);
		contentPane.add(btnBack);
	}
	
	private void createEvents() {
		// TODO Auto-generated method stub
		
	}
}
