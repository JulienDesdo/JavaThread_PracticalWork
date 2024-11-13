public class thread_loop extends Thread {
	
	private final classJpanel contentPane; // Référence au contentPane
    private int period;
    
    public thread_loop(classJpanel contentPane) {
        this.contentPane = contentPane; 
        this.period = 300; 
    }
	
	
	
    public void run() {
        int imageIndex = 0;
        while (!isInterrupted()) {
            ((classJpanel) contentPane).setCurrentImageIndex_loop(imageIndex);
            imageIndex = (imageIndex + 1) % 11;
            contentPane.repaint();
            try {
                Thread.sleep(period); // 300 ms pour l'animation loop
            } catch (InterruptedException e) {
                interrupt();
            }
        }
    }
}

/*
// Classes de threads pour chaque animation avec contrôle d'interruption
public class thread_construct extends Thread {
    public void run() {
        int imageIndex = 0;
        while (!isInterrupted()) {
            ((classJpanel) contentPane).setCurrentImageIndex_construct(imageIndex);
            imageIndex = (imageIndex + 1) % 3;
            contentPane.repaint();
            try {
                Thread.sleep(500); // 500 ms pour l'animation construct
            } catch (InterruptedException e) {
                interrupt(); // Ré-interrompre pour sortir de la boucle
            }
        }
    }
}

public class thread_loop extends Thread {
    public void run() {
        int imageIndex = 0;
        while (!isInterrupted()) {
            ((classJpanel) contentPane).setCurrentImageIndex_loop(imageIndex);
            imageIndex = (imageIndex + 1) % 11;
            contentPane.repaint();
            try {
                Thread.sleep(300); // 300 ms pour l'animation loop
            } catch (InterruptedException e) {
                interrupt();
            }
        }
    }
}

public class thread_earth extends Thread {
    public void run() {
        int imageIndex = 0;
        while (!isInterrupted()) {
            ((classJpanel) contentPane).setCurrentImageIndex_earth(imageIndex);
            imageIndex = (imageIndex + 1) % 18;
            contentPane.repaint();
            try {
                Thread.sleep(700); // 700 ms pour l'animation earth
            } catch (InterruptedException e) {
                interrupt();
            }
        }
    }
}

*/