package Controller;

import Model.Model;
import Vista.View;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    public void start() {

        Thread fireThread = new Thread(model.getFire());
        fireThread.start();

        Thread viewerThread = new Thread(view.getViewer());
        viewerThread.start();

        updateView();
    }

    public void updateView() {
        view.setFire(model.getDrawingDTO());
    }
}