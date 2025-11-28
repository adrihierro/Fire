package FirePhysics;

/**
 * Interfaz que define el contrato mínimo para un motor de física de fuego.
 * Solo requiere la actualización de la simulación.
 */
public interface PhysicsEngineFire {

    void updateFire(FireDTO fireData);

}
