import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class classJpanel extends JPanel {

    private Image[] im_construct;
    private int currentImageIndex_construct;

    private Image[] im_loop;
    private int currentImageIndex_loop;

    private Image[] im_earth;
    private int currentImageIndex_earth;

    // Positions spécifiques pour chaque série d'images
    int posx_construct, posy_construct;
    int posx_loop, posy_loop;
    int posx_earth, posy_earth;
    
    private boolean isConstructAnimationActive = false;

    public classJpanel() {
        setBackground(Color.black);

        currentImageIndex_earth = 0;
        currentImageIndex_loop = 0;
        currentImageIndex_construct = 0;

        // Initialisation des positions pour chaque groupe d'images
        posx_construct = 50;    // Par exemple, à 50 pixels du bord gauche
        posy_construct = 50;    // 50 pixels du bord supérieur

        posx_loop = 200;        // Décalé vers la droite pour éviter la superposition
        posy_loop = 100;        // Position modifiée pour chaque groupe

        posx_earth = 350;       // Encore plus vers la droite
        posy_earth = 150;
        
        
        
        
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!isConstructAnimationActive && im_construct != null) {
                    currentImageIndex_construct = (currentImageIndex_construct + 1) % im_construct.length;
                    repaint();
                    playSound("audio/catyell.wav");
                }
                
            }
        });
    }
    
    private void playSound(String soundFilePath) {
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File(soundFilePath));
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    
    public void setConstructAnimationActive(boolean active) {
        this.isConstructAnimationActive = active;
    }
    
    public boolean imagesLoaded() {
        return im_construct != null && im_loop != null && im_earth != null;
    }

    public void define_image() { 
        im_construct = new Image[3];
        im_construct[0] = Toolkit.getDefaultToolkit().getImage("images/construct1.gif");
        im_construct[1] = Toolkit.getDefaultToolkit().getImage("images/construct2.gif");
        im_construct[2] = Toolkit.getDefaultToolkit().getImage("images/construct3.gif");

        im_loop = new Image[11];
        for (int i = 0; i <= 10; i++) {
            im_loop[i] = Toolkit.getDefaultToolkit().getImage("images/im" + i + ".gif");
        }

        im_earth = new Image[18];
        for (int i = 1; i <= 18; i++) {
            im_earth[i - 1] = Toolkit.getDefaultToolkit().getImage("images/img00" + (i < 10 ? "0" + i : i) + ".gif");
        }

        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dessiner l'image actuelle de im_construct
        if (im_construct != null && im_construct[currentImageIndex_construct] != null) {
            int imgWidth = im_construct[currentImageIndex_construct].getWidth(this);
            int imgHeight = im_construct[currentImageIndex_construct].getHeight(this);

            if (imgWidth > 0 && imgHeight > 0) {
                g.drawImage(im_construct[currentImageIndex_construct], posx_construct, posy_construct, this);
            }
        }

        // Dessiner l'image actuelle de im_loop
        if (im_loop != null && im_loop[currentImageIndex_loop] != null) {
            int imgWidth = im_loop[currentImageIndex_loop].getWidth(this);
            int imgHeight = im_loop[currentImageIndex_loop].getHeight(this);

            if (imgWidth > 0 && imgHeight > 0) {
                g.drawImage(im_loop[currentImageIndex_loop], posx_loop, posy_loop, this);
            }
        }

        // Dessiner l'image actuelle de im_earth
        if (im_earth != null && im_earth[currentImageIndex_earth] != null) {
            int imgWidth = im_earth[currentImageIndex_earth].getWidth(this);
            int imgHeight = im_earth[currentImageIndex_earth].getHeight(this);

            if (imgWidth > 0 && imgHeight > 0) {
                g.drawImage(im_earth[currentImageIndex_earth], posx_earth, posy_earth, this);
            }
        }
    }

    public void setCurrentImageIndex_construct(int index) {
        if (index >= 0 && index < im_construct.length) {
            currentImageIndex_construct = index;
            repaint();
        }
    }

    public void setCurrentImageIndex_loop(int index) {
        if (index >= 0 && index < im_loop.length) {
            currentImageIndex_loop = index;
            repaint();
        }
    }

    public void setCurrentImageIndex_earth(int index) {
        if (index >= 0 && index < im_earth.length) {
            currentImageIndex_earth = index;
            repaint();
        }
    }
}
