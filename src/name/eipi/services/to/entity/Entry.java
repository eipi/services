package name.eipi.services.to.entity;

import name.eipi.services.eao.EAOFactory;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

/**
 * Created by dbdon_000
 * Date: 11/08/13
 */
@Entity(name="Entry")
@Table(name = "entry_t")
@IdClass(value = EntryKey.class)
public class Entry extends EntityTO {

  public Entry() {
  }

  @Column(name = "name", length = 50, nullable = false)
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTypeCode() {
    return typeCode;
  }

  public void setTypeCode(String typeCode) {
    this.typeCode = typeCode;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Date getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(Date lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  @Id
  @Column(name = "typeCd", length = 10, nullable = false)
  private String  typeCode;

  @Column(name = "description", length = 200)
  private String description;

  @Column(name = "status", length = 20, nullable = false)
  private String status;

  @Column(name = "lastUpdated", nullable = false)
  private Date lastUpdated;

  @Override
  public EntityTOKey getPK() {
    EntryKey  entryKey =  new EntryKey();
    entryKey.setTypeCode(this.getTypeCode());
    return entryKey;
  }

}
