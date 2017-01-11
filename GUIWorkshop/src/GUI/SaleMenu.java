package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlLayer.Brexit;

import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SaleMenu extends JFrame {

	private JPanel contentPane;
	private JButton btnBack;
	private JButton btnCreateSale;
	private JButton btnReadSale;
	private JButton btnEditSale;
	private JButton btnPreviousMenu;
	private JButton btnExitProgram;

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
		
		btnCreateSale = new JButton("Create Sale");
		
		btnCreateSale.setBounds(189, 53, 123, 36);
		contentPane.add(btnCreateSale);
		
		btnReadSale = new JButton("Read Sale");
		
		btnReadSale.setBounds(189, 102, 123, 36);
		contentPane.add(btnReadSale);
		
		btnEditSale = new JButton("Edit Sale");
		
		btnEditSale.setBounds(189, 155, 123, 36);
		contentPane.add(btnEditSale);
		
		btnPreviousMenu = new JButton("Previous Menu");
		
		btnPreviousMenu.setBounds(189, 207, 123, 36);
		contentPane.add(btnPreviousMenu);
		
		btnExitProgram = new JButton("Exit Program");
		
		
		btnExitProgram.setBounds(189, 256, 123, 36);
		contentPane.add(btnExitProgram);
		
		btnBack = new JButton("Back");
		
		btnBack.setBounds(12, 13, 97, 25);
		contentPane.add(btnBack);
	}
	
	private void createEvents() {
		// TODO Auto-generated method stub
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChooseMenu chMenu = new ChooseMenu();
				dispose();
				chMenu.main(null);
			}
		});
		
		btnCreateSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateSale createSale = new CreateSale();
				dispose();
				createSale.main(null);
			}
		});
		
		btnReadSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReadSale readSale = new ReadSale();
				dispose();
				readSale.main(null);
			}
		});
		
		btnEditSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditSale editSale = new EditSale();
				dispose();
				editSale.main(null);
			}
		});
		
		btnPreviousMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChooseMenu chMenu = new ChooseMenu();
				dispose();
				chMenu.main(null);
			}
		});
		
		btnExitProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the program?");
				if(confirm == JOptionPane.YES_OPTION) {
					Brexit brexit = new Brexit();
					brexit.exit();
					System.exit(0);
				}
			}
		});
	}
}
