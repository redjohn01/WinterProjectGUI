package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class ItemMenu extends JFrame {

	private JPanel contentPane;
	private JButton btnBack;
	private JButton btnCreateItem;
	private JButton btnReadItem;
	private JButton btnDeleteItem;
	private JButton btnEditItem;
	private JButton btnPreviousMenu;
	private JButton btnExitProgram;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ItemMenu frame = new ItemMenu();
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
	public ItemMenu() {
		initializeComponents();
		createEvents();
	}

	private void initializeComponents() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnCreateItem = new JButton("Create Item");
		btnCreateItem.setBounds(164, 58, 123, 36);
		contentPane.add(btnCreateItem);
		
		btnReadItem = new JButton("Read Item");
		btnReadItem.setBounds(164, 107, 123, 36);
		contentPane.add(btnReadItem);
		
		btnEditItem = new JButton("Edit Item");
		btnEditItem.setBounds(164, 156, 123, 36);
		contentPane.add(btnEditItem);
		
		btnDeleteItem = new JButton("Delete Item");
		btnDeleteItem.setBounds(164, 205, 123, 36);
		contentPane.add(btnDeleteItem);
		
		btnPreviousMenu = new JButton("Previous Menu");
		btnPreviousMenu.setBounds(164, 254, 123, 36);
		contentPane.add(btnPreviousMenu);
		
		btnExitProgram = new JButton("Exit Program");
		btnExitProgram.setBounds(164, 303, 123, 36);
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
		
		btnCreateItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateItem createItem = new CreateItem();
				dispose();
				createItem.main(null);
			}
		});
		
		btnReadItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReadItem readItem = new ReadItem();
				dispose();
				readItem.main(null);
			}
		});
		btnDeleteItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			DeleteItem deleteItem = new DeleteItem();
			dispose();
			deleteItem.main(null);
			}
		});
		btnEditItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			EditItem editItem = new EditItem();
			dispose();
			editItem.main(null);
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
					//Brexit brexit = new Brexit();
					LoginMenu.brexit.exit();
					System.exit(0);
				}
			}
		});
		
	}

}