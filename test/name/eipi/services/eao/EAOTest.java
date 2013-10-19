package name.eipi.services.eao;

import com.google.gson.Gson;
import junit.framework.TestCase;
import name.eipi.services.eao.api.ServicesEAO;
import name.eipi.services.to.entity.Entry;
import name.eipi.services.to.entity.Type;
import name.eipi.services.to.entity.TypeKey;

import javax.persistence.Entity;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/**
 * Created by dbdon_000
 * Date: 11/08/13
 */
public class EAOTest extends TestCase {

  private Type type;

  public void  testTypeReadAll() {
        // Get some data
        ServicesEAO eao =  EAOFactory.getEAO();
        Collection<Type> queryResults = eao.readAll(Type.class);
        System.out.println(new Gson().toJson(queryResults));
    }

    public void  testEntryReadAll() {
        // Get some data
        ServicesEAO eao =  EAOFactory.getEAO();
        Collection<Entry> queryResults = eao.readAll(Entry.class);
        System.out.println(new Gson().toJson(queryResults));
    }

  public void testTypeEAO() throws Exception {

    ServicesEAO eao = EAOFactory.getEAO();
    type = new Type();
    type.setTypeCode("TEST");
    type.setDescription("Test 1a");
    eao.create(type);
    TypeKey typeKey = new TypeKey();
    typeKey.setTypeCode(type.getTypeCode());
    Type foundType = eao.read(Type.class, typeKey);
    assertNotNull(foundType);
    assertTrue(type.getDescription().equals(foundType.getDescription()));
    foundType.setDescription("Test 1b");
    eao.update(foundType);
    type =  foundType;
    typeKey.setTypeCode(type.getTypeCode());
    foundType = eao.read(Type.class, typeKey);
    assertNotNull(foundType);
    assertTrue(type.getDescription().equals(foundType.getDescription()));
    eao.delete(foundType);
    typeKey.setTypeCode(type.getTypeCode());
    foundType = eao.read(Type.class, typeKey);
    assertNull(foundType);
  }

  public void testEntryEAO() throws Exception {

    ServicesEAO eao = EAOFactory.getEAO();
    Type type = null;
    Entry entry = null;

    try {
      type = new Type();
      type.setTypeCode("TEST");
      type.setDescription("Test 1a");
      eao.create(type);
      Type foundType = eao.read(Type.class, type.getPK());
      assertNotNull(foundType);
      assertTrue(type.getDescription().equals(foundType.getDescription()));
      foundType.setDescription("Test 1b");
      eao.update(foundType);
      type  =  foundType;
      foundType = eao.read(Type.class, type.getPK());
      assertNotNull(foundType);
      assertTrue(type.getDescription().equals(foundType.getDescription()));

      try {
        entry = new Entry();
        entry.setTypeCode(type.getTypeCode());
        entry.setLastUpdated(new Date());
        entry.setStatus("NEW");
        entry.setName("TestEntry");
        entry.setDescription("No description available.");
        eao.create(entry);
        Entry foundEntry = eao.read(Entry.class, entry.getPK());
        assertNotNull(foundEntry);
        assertTrue(foundEntry.equals(entry));
      } finally {
        eao.delete(entry);
      }
    } finally {
      eao.delete(type);
    }

    type = eao.read(Type.class, type.getPK());
    assertNull(type);
    entry = eao.read(Entry.class, entry.getPK());
    assertNull(entry);

  }

}
