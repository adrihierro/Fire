import Controller.Controller;
import Model.Model;
import Vista.View;

public class Main {
    public static void main(String[] args) {
        Model model = new Model(260,150); //fire width and fire height
        View view = new View(600,400); // Window width and window height
        Controller controller = new Controller(model,view);
        controller.start();
    }
}
