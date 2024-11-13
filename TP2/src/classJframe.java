import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class classJframe extends JFrame {

	private classJpanel contentPane;
    private thread_construct constructThread;
    private thread_loop loopThread;
    private thread_earth earthThread;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					classJframe frame = new classJframe();
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
    public classJframe() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 610, 382);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu mnNewMenu = new JMenu("Lancez le programme");
        menuBar.add(mnNewMenu);
        
        JMenuItem mntmNewMenuItem = new JMenuItem("Affichage Image");
        mntmNewMenuItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		// Affichage des images 
        		
        		((classJpanel) contentPane).define_image(); 
        		//((classJpanel) contentPane).paintComponent(Graphics g); 
        		contentPane.repaint();
        		

        		        		
        	}
        });
        mnNewMenu.add(mntmNewMenuItem);
        
        JMenu mnNewMenu_1 = new JMenu("D\u00E9marrer l'animation");
        mnNewMenu.add(mnNewMenu_1);
        
        JMenuItem mntmNewMenuItem_5 = new JMenuItem("Builder Sign");
        mntmNewMenuItem_5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (!contentPane.imagesLoaded()) {
                    JOptionPane.showMessageDialog(
                        classJframe.this,
                        "L'image Builder Sign n'est pas chargée. Veuillez charger l'image avant de démarrer l'animation.",
                        "Erreur",
                        JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }
        		
        		if (constructThread == null) {
                    constructThread = new thread_construct(contentPane);
                }
        		if (!constructThread.isAlive()) {
                	constructThread.start();
                	contentPane.setConstructAnimationActive(true); // Activer l'animation, désactiver les clics
                }
        		contentPane.repaint();
        		
        	}
        });
        mnNewMenu_1.add(mntmNewMenuItem_5);
        
        JMenuItem mntmNewMenuItem_6 = new JMenuItem("Loop Pannel");
        mntmNewMenuItem_6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (!contentPane.imagesLoaded()) {
                    JOptionPane.showMessageDialog(
                        classJframe.this,
                        "L'image Loop n'est pas chargée. Veuillez charger l'image avant de démarrer l'animation.",
                        "Erreur",
                        JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }
        		
        		if (loopThread == null) {
                    loopThread = new thread_loop(contentPane);
                }
        		if (!loopThread.isAlive()) {
                	loopThread.start();
                }
        		contentPane.repaint();
        		
        	}
        });
        mnNewMenu_1.add(mntmNewMenuItem_6);
        
        JMenuItem mntmNewMenuItem_7 = new JMenuItem("Earth Picture");
        mntmNewMenuItem_7.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (!contentPane.imagesLoaded()) {
                    JOptionPane.showMessageDialog(
                        classJframe.this,
                        "L'image Earth n'est pas chargée. Veuillez charger l'image avant de démarrer l'animation.",
                        "Erreur",
                        JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }
        		
        		if (earthThread == null) {
                    earthThread = new thread_earth(contentPane);
                }
        		if (!earthThread.isAlive()) {
                	earthThread.start();
                }
        		contentPane.repaint();
        		
        	}
        });
        mnNewMenu_1.add(mntmNewMenuItem_7);
        
        JMenu mnNewMenu_2 = new JMenu("Arr\u00EAter l'animation");
        mnNewMenu.add(mnNewMenu_2);
        
        JMenuItem mntmNewMenuItem_8 = new JMenuItem("Builder Sign");
        mntmNewMenuItem_8.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (!contentPane.imagesLoaded()) {
                    JOptionPane.showMessageDialog(
                        classJframe.this,
                        "L'image Builder Sign n'est pas chargée. Il n'y a pas d'animation à arrêter.",
                        "Erreur",
                        JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }
        		
        		if (constructThread != null && constructThread.isAlive()) {
                    constructThread.interrupt();
                    constructThread = null;
                    contentPane.setConstructAnimationActive(false); // Désactiver l'animation, activer les clics
                }
        		((classJpanel) contentPane).setCurrentImageIndex_construct(0);
        		contentPane.repaint();
        	}
        });
        mnNewMenu_2.add(mntmNewMenuItem_8);
        
        JMenuItem mntmNewMenuItem_9 = new JMenuItem("Loop Pannel");
        mntmNewMenuItem_9.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (!contentPane.imagesLoaded()) {
                    JOptionPane.showMessageDialog(
                        classJframe.this,
                        "L'image Loop n'est pas chargée. Il n'y a pas d'animation à arrêter.",
                        "Erreur",
                        JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }
        		
        		
        		if (loopThread != null && loopThread.isAlive()) {
                    loopThread.interrupt();
                    loopThread = null;
                }
        		((classJpanel) contentPane).setCurrentImageIndex_loop(0);
        		contentPane.repaint();
        	}
        	
        });
        mnNewMenu_2.add(mntmNewMenuItem_9);
        
        JMenuItem mntmNewMenuItem_10 = new JMenuItem("Earth Picture");
        mntmNewMenuItem_10.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (!contentPane.imagesLoaded()) {
                    JOptionPane.showMessageDialog(
                        classJframe.this,
                        "L'image Earth n'est pas chargée. Il n'y a pas d'animation à arrêter.",
                        "Erreur",
                        JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }
        		
        		
        		if (earthThread != null && earthThread.isAlive()) {
                    earthThread.interrupt();
                    earthThread = null;
                }
        		((classJpanel) contentPane).setCurrentImageIndex_earth(0);   
        		contentPane.repaint();
        		
        	}
        });
        mnNewMenu_2.add(mntmNewMenuItem_10);
        
        JMenuItem mntmNewMenuItem_1 = new JMenuItem("Aide");
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Ceci est un panneau d'aide sympathique.\n" +
                        "Vous pouvez ajouter plus de détails ici.",
                        "Aide",
                        JOptionPane.INFORMATION_MESSAGE
                    );
        	}
        });
        menuBar.add(mntmNewMenuItem_1);
        
        JMenuItem mntmNewMenuItem_2 = new JMenuItem("Quitter");
        mntmNewMenuItem_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}
        });
        menuBar.add(mntmNewMenuItem_2);

        // Remplacer JPanel par une instance de votre classJpanel
        contentPane = new classJpanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);  // Définir le contentPane à partir de votre classJpanel
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 586, Short.MAX_VALUE)
        );
        gl_contentPane.setVerticalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 335, Short.MAX_VALUE)
        );
        contentPane.setLayout(gl_contentPane);
        
        
        
    }

}
