public class thread_earth extends Thread {
	
	private final classJpanel contentPane; // Référence au contentPane
    private int period;
    
    public thread_earth(classJpanel contentPane) {
        this.contentPane = contentPane; 
        this.period = 700; 
    }
	
	
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