
public class thread_construct extends Thread {
	

    private final classJpanel contentPane; // Référence au contentPane
    private int period;

    public thread_construct(classJpanel contentPane) {
        this.contentPane = contentPane; 
        this.period = 500; 
    }

	public void run() {
        int imageIndex = 0;
        while (!isInterrupted()) {
            ((classJpanel) contentPane).setCurrentImageIndex_construct(imageIndex);
            imageIndex = (imageIndex + 1) % 3;
            contentPane.repaint();
            try {
                Thread.sleep(period); // 500 ms pour l'animation construct
            } catch (InterruptedException e) {
                interrupt(); 
            }
        }
    }
	
	
}
