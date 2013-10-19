package name.eipi.services.to.entity;

import javax.persistence.*;

/**
 * Created by dbdon_000
 * Date: 11/08/13
 */
@Entity(name="Type")
@Table(name="type_t")
@IdClass(value = TypeKey.class)
public class Type extends EntityTO {

  @Id
  @Column(name = "typeCd",nullable = false, length = 10)
  private String typeCode;

  public String getTypeCode() {
    return typeCode;
  }

  public void setTypeCode(String typeCode) {
    this.typeCode = typeCode;
  }

  public Type() {
  }


  @Column(name = "typeDesc", nullable = false, length = 50)
  private String description;

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public EntityTOKey getPK() {
    TypeKey typeKey = new TypeKey();
    typeKey.setTypeCode(this.getTypeCode());
    return typeKey;
  }
}
