package soccerteam;

/**
 * The Driver of the U10 Soccer Team Dashboard App.
 */
public class Main {
  /**
   * The main Class.
   * @param args not using.
   */
  public static void main(String[] args) {
    U10TeamModel model = new U10TeamModelImpl();
    U10TeamView view = new U10TeamFrameView("U10 Soccer Team Dashboard");
    U10TeamFeatures controller = new U10TeamFrameController(model, view);
    controller.initializeProgram();
  }
}
