package name.eipi.services.specific;

/**
 * Created by dbdon_000
 * Date: 03/09/13
 */
public class Room {

  private String name;

  public Room(final String roomName) {
    this.name=  roomName;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean equals(final Object object) {
    if (object instanceof Room) {
      Room otherRoom = (Room)object;
      if (otherRoom.name!=null && this.name!=null
              && otherRoom.name.trim().equalsIgnoreCase(this.name)) {
        return true;
      }
    }
    return false;
  }

  public int hashCode() {
    if (this.name == null) {
      return 13;
    } else return 13*this.name.hashCode();

  }

  public String toString() {
    return this.name;
  }


}
