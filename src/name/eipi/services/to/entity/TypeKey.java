package name.eipi.services.to.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by dbdon_000
 * Date: 13/08/13
 */
@Embeddable
public class TypeKey extends EntityTOKey {

  @Column(name = "typeCd",nullable = false, length = 10)
  private String typeCode;

  public String getTypeCode() {
    return typeCode;
  }

  public void setTypeCode(String typeCode) {
    this.typeCode = typeCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || !(o instanceof TypeKey)) {
      return false;
    } else {
      TypeKey other = (TypeKey) o;
      if (this.getTypeCode()!= null && other.getTypeCode()!= null
              && this.getTypeCode().trim().equalsIgnoreCase(other.getTypeCode().trim())) {
        return true;
      } else {
        return false;
      }
    }
  }

  public int hashCode() {
    final int prime = 31;
    int hash = 17;
    hash = (typeCode == null) ? hash * prime : hash * prime + this.typeCode.hashCode();
    return hash;
  }
}
