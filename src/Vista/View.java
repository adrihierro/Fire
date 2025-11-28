package Vista;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private Viewer viewer;

    public View(int width, int height) {
        setTitle("Fire Animation");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        viewer = new Viewer();
        viewer.setPreferredSize(new Dimension(width, height));

        // Añadir el Viewer al frame
        add(viewer);

        setResizable(false);
        pack(); // ajusta el frame al tamaño del viewer
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public Viewer getViewer() {
        return viewer;
    }

    public void setFire(DrawingFireDTO dto){
        viewer.setFireDTO(dto);
    }




}
