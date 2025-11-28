package Model;

import FirePhysics.FireDTO;
import FirePhysics.PhysicsEngineFire;
import Vista.DrawingFireDTO;
import java.awt.*;
import java.util.Random;

public class Fire implements Runnable {
    private int fireWidth;
    private int fireHeight;
    private int[][] pixelTemperature;
    private final Random random;

    private PhysicsEngineFire physics;
    // DTO con los datos del fuego
    private FireDTO fireDTO;

    public Fire(int fireWidth, int fireHeight){
        this.fireWidth = fireWidth;
        this.fireHeight = fireHeight;
        this.pixelTemperature = new int[fireHeight][fireWidth];
        this.random = new Random();
    }

    public void setPhysics(PhysicsEngineFire physics) {
        this.physics = physics;
    }

    public void setFireDTO(FireDTO fireDTO) {
        this.fireDTO = fireDTO;
    }

    public DrawingFireDTO getDrawingDTO() {
        return new DrawingFireDTO(fireWidth, fireHeight, fireDTO.getPixelTemperature());
    }

    public void update(){
        generateSparks();
        if (physics != null && fireDTO != null) {
            physics.updateFire(fireDTO);
        }
    }

    public void generateSparks() {
        int baseRow = fireHeight - 1;
        int[][] temps = fireDTO.getPixelTemperature();

        for (int col = 0; col < fireWidth; col++) {
            float chance = random.nextFloat();

            if (chance < 0.04f) {

                temps[baseRow][col] = 1023;

            } else if (chance < 0.10f) {

                temps[baseRow][col] = 250 + random.nextInt(150);
            }

            if (chance < 0.02f) {
                // Se enfría suavemente
                temps[baseRow][col] = 0;
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            update();

            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
