package name.eipi.services.to.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by dbdon_000
 * Date: 13/08/13
 */
@Embeddable
public class EntryKey extends EntityTOKey {

  @Column(name = "typeCd", nullable = false, length = 10)
  private String typeCode;

  public EntryKey() {

  }

  public String getTypeCode() {
    return typeCode;
  }

  public void setTypeCode(String typeCode) {
    this.typeCode = typeCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || !(o instanceof EntryKey)) {
      return false;
    } else {
      EntryKey other = (EntryKey) o;
      if (this.typeCode != null && other.typeCode!= null && this.typeCode.trim().equals(other.typeCode.trim())) {
        return true;
      } else {
        return false;
      }
    }
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int hash = 17;
    hash = (typeCode == null) ? hash * prime : hash * prime + this.typeCode.hashCode();
    return hash;
  }

}
