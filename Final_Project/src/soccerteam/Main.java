package soccerteam;

public class Main {
    public static void main(String[] args){
        U10TeamModel model = new U10TeamModelImpl();
        U10TeamView view = new U10TeamFrameView("U10 Soccer Team Dashboard");
        U10TeamFeatures controller = new U10TeamFrameController(model, view);
        controller.initializeProgram();
    }
}
