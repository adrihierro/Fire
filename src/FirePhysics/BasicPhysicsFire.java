package FirePhysics;

public class BasicPhysicsFire implements PhysicsEngineFire {

    @Override
    public void updateFire(FireDTO fireData) {
        int fireWidth = fireData.getFireWidth();
        int fireHeight = fireData.getFireHeight();
        int[][] pixelTemperature = fireData.getPixelTemperature();

        // Recorremos de abajo hacia arriba
        for (int row = fireHeight - 2; row > 4; row--) {
            for (int col = 2; col < fireWidth - 2; col++) {
                // Fórmula propagación
                int newTemp = (int) (
                        (pixelTemperature[row][col - 1] * 1.2D
                                + pixelTemperature[row][col] * 1.5D
                                + pixelTemperature[row][col + 1] * 1.2D
                                + pixelTemperature[row + 1][col - 1] * 0.7D
                                + pixelTemperature[row + 1][col] * 0.7D
                                + pixelTemperature[row + 1][col + 1] * 0.7D)
                                / 5.98569
                                -  9D   //numero mas alto menor tamaño visualmente
                );

                if (newTemp < 0) newTemp = 0;
                else if (newTemp > 1023) newTemp = 1023;

                pixelTemperature[row][col] = newTemp;
            }
        }
    }

}
