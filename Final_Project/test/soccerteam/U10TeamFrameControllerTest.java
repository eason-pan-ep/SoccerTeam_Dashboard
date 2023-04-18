package soccerteam;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for Controller.
 * Basically just test the constructor,
 * since all other features are connected to GUIs.
 */
public class U10TeamFrameControllerTest {

  private U10TeamModel testModel;
  private U10TeamView testView;

  /**
   * Set up a view and a model.
   */
  @Before
  public void setUp() {
    this.testModel = new U10TeamModelImpl();
    this.testView = new U10TeamFrameView("Test");
  }

  /**
   * Test constructing a new Controller with null View.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructWithNullView() {
    U10TeamView fakeView = null;
    U10TeamFeatures test1 = new U10TeamFrameController(this.testModel, fakeView);
  }

  /**
   * Test constructing a new Controller with null Model.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructWithNullModel() {
    U10TeamModel fakeModel = null;
    U10TeamFeatures test2 = new U10TeamFrameController(fakeModel, this.testView);
  }


}