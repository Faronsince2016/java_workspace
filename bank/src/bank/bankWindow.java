package bank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JLabel;
import bank.Banker;

public class bankWindow {
	
	static JFrame frame;
	static JTable table;
	static JTextField Max0;
	static JTextField Allocation0;
	static JTextField Need0;
	static JTextField Available;
	static JTextField Max1;
	static JTextField Max2;
	static JTextField Max3;
	static JTextField Max4;
	static JTextField Allocation1;
	static JTextField Allocation2;
	static JTextField Allocation3;
	static JTextField Allocation4;
	static JTextField Need1;
	static JTextField Need2;
	static JTextField Need3;
	static JTextField Need4;
	static JLabel lblMax;
	static JLabel lblAllocationabc;
	static JLabel lblNeedabc;
	static JLabel lblNewLabel;
	static JLabel lblP;
	static JLabel label;
	static JLabel lblP_1;
	static JLabel lblP_2;
	static JLabel lblP_3;
	static JButton btnExit;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bankWindow window = new bankWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public bankWindow() {
		initialize();
	}
	
/*
 * 	public static Integer[] TransForm1(JTextField Name0){
		Integer[] NameX = new Integer[3];
		String[] tempArr = Name0.getText().split(",");
        for(int i=0;i<NameX.length;i++){  
    		 NameX[i] = Integer.parseInt(tempArr[i]);
        }  
		return NameX;
		
		
	}
*/
	
	
public static int[][] TransForm(JTextField Name0,JTextField Name1,JTextField Name2,JTextField Name3,JTextField Name4){
		int k = 0;
	    int[] newArr = new int[16];
	    int[][] NameX = new int [5][3];
		String temp0 = Name0.getText();
		String temp1 = Name1.getText();
		String temp2 = Name2.getText();
		String temp3= Name3.getText();
		String temp4 = Name4.getText();
		String temp = temp0+","+temp1+","+temp2+","+temp3+","+temp4;
		String[] tempArr = temp.split(",");
		//转换成数字
        for(int i=0;i<tempArr.length;i++){  
    		 newArr[i] = Integer.parseInt(tempArr[i]);
        }  
		//传入到各接受数组中
     	for(int i=0;i<5;i++){  
            for(int j=0;j<3;j++){  
                NameX[i][j]=newArr[k++];  
            }  
        } 
		return NameX;
		
	}



	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 599, 426);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(87, 73, 1, 1);
		frame.getContentPane().add(table);
		
		Max0 = new JTextField();
		Max0.setBounds(87, 70, 93, 35);
		frame.getContentPane().add(Max0);
		Max0.setColumns(10);
		
		
		Allocation0 = new JTextField();
		Allocation0.setBounds(206, 70, 93, 35);
		Allocation0.setColumns(10);
		frame.getContentPane().add(Allocation0);
		
		Need0 = new JTextField();
		Need0.setBounds(324, 70, 93, 35);
		Need0.setColumns(10);
		frame.getContentPane().add(Need0);
		
		Available = new JTextField();
		Available.setBounds(441, 70, 93, 35);
		Available.setColumns(10);
		frame.getContentPane().add(Available);
		
		Max1 = new JTextField();
		Max1.setBounds(87, 128, 93, 35);
		Max1.setColumns(10);
		frame.getContentPane().add(Max1);
		
		Max2 = new JTextField();
		Max2.setBounds(87, 177, 93, 35);
		Max2.setColumns(10);
		frame.getContentPane().add(Max2);
		
		Max3 = new JTextField();
		Max3.setBounds(87, 226, 93, 35);
		Max3.setColumns(10);
		frame.getContentPane().add(Max3);
		
		Max4 = new JTextField();
		Max4.setBounds(87, 271, 93, 35);
		Max4.setColumns(10);
		frame.getContentPane().add(Max4);
		
		Allocation1 = new JTextField();
		Allocation1.setBounds(206, 128, 93, 35);
		Allocation1.setColumns(10);
		frame.getContentPane().add(Allocation1);
		
		Allocation2 = new JTextField();
		Allocation2.setBounds(206, 177, 93, 35);
		Allocation2.setColumns(10);
		frame.getContentPane().add(Allocation2);
		
		Allocation3 = new JTextField();
		Allocation3.setBounds(206, 226, 93, 35);
		Allocation3.setColumns(10);
		frame.getContentPane().add(Allocation3);
		
		Allocation4 = new JTextField();
		Allocation4.setBounds(206, 271, 93, 35);
		Allocation4.setColumns(10);
		frame.getContentPane().add(Allocation4);
		
		Need1 = new JTextField();
		Need1.setBounds(324, 128, 93, 35);
		Need1.setColumns(10);
		frame.getContentPane().add(Need1);
		
		Need2 = new JTextField();
		Need2.setBounds(324, 177, 93, 35);
		Need2.setColumns(10);
		frame.getContentPane().add(Need2);
		
		Need3 = new JTextField();
		Need3.setBounds(324, 226, 93, 35);
		Need3.setColumns(10);
		frame.getContentPane().add(Need3);
		
		Need4 = new JTextField();
		Need4.setBounds(324, 271, 93, 35);
		Need4.setColumns(10);
		frame.getContentPane().add(Need4);
		
		lblMax = new JLabel("Max（A,B,C）");
		lblMax.setBounds(98, 31, 72, 15);
		frame.getContentPane().add(lblMax);
		
		lblAllocationabc = new JLabel("ALLOCATION（A,B,C）");
		lblAllocationabc.setBounds(192, 31, 128, 15);
		frame.getContentPane().add(lblAllocationabc);
		
		lblNeedabc = new JLabel("Need（A,B,C）");
		lblNeedabc.setBounds(330, 31, 87, 15);
		frame.getContentPane().add(lblNeedabc);
		
		lblNewLabel = new JLabel("Available(A,B,C)");
		lblNewLabel.setBounds(437, 31, 107, 15);
		frame.getContentPane().add(lblNewLabel);
		
		lblP = new JLabel("P0");
		lblP.setBounds(31, 80, 54, 15);
		frame.getContentPane().add(lblP);
		
		label = new JLabel("P1");
		label.setBounds(31, 138, 54, 15);
		frame.getContentPane().add(label);
		
		lblP_1 = new JLabel("P2");
		lblP_1.setBounds(31, 187, 54, 15);
		frame.getContentPane().add(lblP_1);
		
		lblP_2 = new JLabel("P3");
		lblP_2.setBounds(31, 236, 54, 15);
		frame.getContentPane().add(lblP_2);
		
		lblP_3 = new JLabel("P4");
		lblP_3.setBounds(31, 281, 54, 15);
		frame.getContentPane().add(lblP_3);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bank.Banker.main(null);
			}
		});
		btnStart.setBounds(139, 333, 93, 23);
		frame.getContentPane().add(btnStart);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(307, 333, 93, 23);
		frame.getContentPane().add(btnExit);
	}
}
