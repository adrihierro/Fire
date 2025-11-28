package Model;

import FirePhysics.BasicPhysicsFire;
import FirePhysics.FireDTO;
import FirePhysics.PhysicsEngineFire;
import Vista.DrawingFireDTO;

public class Model {
    private Fire fire;
    private PhysicsEngineFire physics;
    private FireDTO fireDTO;

    public Model(int width, int height){
        // Inicializa el motor de física
        this.physics = new BasicPhysicsFire();

        // Inicializa el DTO con los datos del fuego
        this.fireDTO = new FireDTO(width, height);

        // Crea el fuego y le pasa el motor y el DTO
        this.fire = new Fire(width, height);
        fire.setPhysics(physics);
        fire.setFireDTO(fireDTO);
    }


    public DrawingFireDTO getDrawingDTO() {
        return fire.getDrawingDTO();
    }

    public Fire getFire() {
        return fire;
    }
}
