package Vista;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Viewer extends Canvas implements Runnable {
    private BufferedImage backgroundImg;
    private BufferedImage fireImg;
    private BufferStrategy bufferStrategy;
    private DrawingFireDTO fireDTO;


    public Viewer() {
        this.loadBackground();
        this.bufferStrategy = null;
        this.fireImg = null;
    }

    public void setFireDTO(DrawingFireDTO fireDTO) {
        this.fireDTO = fireDTO;
    }

    /** Inicializa el BufferStrategy si aún no existe */
    private void ensureBufferStrategy() {
        if (this.bufferStrategy == null) {
            this.createBufferStrategy(2);
            bufferStrategy = this.getBufferStrategy();
        }
    }

    /** Carga la imagen de fondo */
    public void loadBackground() {
        try {
            this.backgroundImg = ImageIO.read(new File("src/Images/bg.png"));
        } catch (IOException e) {
            System.out.println("No se pudo cargar el fondo");
            backgroundImg = null;
        }
    }

    public BufferedImage paintFire(DrawingFireDTO dto) {
        // Crear la imagen del tamaño del fuego
        BufferedImage img = new BufferedImage(
                dto.getFireWidth(),
                dto.getFireHeight(),
                BufferedImage.TYPE_INT_ARGB
        );

        ColorPalette palette = new ColorPalette();
        int[][] temps = dto.getPixelTemperature();

        // Recorremos cada píxel y pintamos con el color correspondiente
        for (int row = 0; row < dto.getFireHeight(); row++) {
            for (int col = 0; col < dto.getFireWidth(); col++) {
                Color color = palette.getColor(temps[row][col]);
                img.setRGB(col, row, color.getRGB());
            }
        }

        return img;
    }

    private void render() {
        ensureBufferStrategy();
        Graphics g = bufferStrategy.getDrawGraphics();

        // Fondo
        if (backgroundImg != null) {
            g.drawImage(backgroundImg, 0, 0, getWidth(), getHeight(), null);
        } else {
            g.clearRect(0, 0, getWidth(), getHeight());
        }

        // Fuego centrado
        if (fireImg != null) {
            int fireWidth = fireImg.getWidth();
            int fireHeight = fireImg.getHeight();

            // Calcular coordenadas para centrar
            int fireX = (getWidth() - fireWidth) / 2;
            int fireY = (275 - fireHeight) ;

            fireY -= 38;
            fireX -= 50;   // mover 50 píxeles a la izquierda

            g.drawImage(fireImg, fireX, fireY, null);
        }

        g.dispose();
        bufferStrategy.show();
    }

    @Override
    public void run() {
        while (true) {
            render();

            if (fireDTO != null) {
                fireImg = paintFire(fireDTO);
            }
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
