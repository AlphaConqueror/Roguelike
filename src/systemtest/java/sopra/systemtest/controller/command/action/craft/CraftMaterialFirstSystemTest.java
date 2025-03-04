package sopra.systemtest.controller.command.action.craft;

import static sopra.systemtest.api.Utils.loadResource;

import sopra.comm.Direction;
import sopra.comm.TimeoutException;
import sopra.systemtest.DefaultSystemTest;

public class CraftMaterialFirstSystemTest extends DefaultSystemTest {

  public CraftMaterialFirstSystemTest() {
    super(CraftMaterialFirstSystemTest.class, false);
  }

  @Override
  protected String createWorld() {
    return loadResource(this.getClass(), "maps/CraftMenuSimpleRecipe.json");
  }

  @Override
  protected void execute() throws TimeoutException {
    sendPickUp(Direction.WEST);
    assertUpdateWorld("{\"position\":{\"x\":4,\"y\":-19,\"z\":15},\"representation\":.}");
    assertNextCycle(1);
    assertActNow();

    sendPickUp(Direction.EAST);
    assertUpdateWorld("{\"position\":{\"x\":6,\"y\":-21,\"z\":15},\"representation\":.}");
    assertNextCycle(2);
    assertActNow();

    sendCraft(2, Direction.NORTH_WEST);
    assertNextCycle(3);
    assertActNow();
  }
}
