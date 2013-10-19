package name.eipi.services.specific;

/**
 * Created by dbdon_000
 * Date: 03/09/13
 */
public class Alarm {

  public Alarm() {

  }

  public Alarm(final Room room) {
    this.room = room;
  }


  private boolean on;

  public boolean isOn() {
    return on;
  }

  public void setOn(boolean on) {
    this.on = on;
  }

  private Room room;

  public Room getRoom() {
    return room;
  }

  public void setRoom(Room room) {
    this.room = room;
  }
}
