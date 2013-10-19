package name.eipi.services.appservice.rule;

import com.google.gson.Gson;
import name.eipi.services.logger.Logger;
import name.eipi.services.logger.LoggerFactory;
import org.drools.event.rule.AfterActivationFiredEvent;
import org.drools.event.rule.DefaultAgendaEventListener;

/**
 * Created by dbdon_000
 * Date: 16/08/13
 */
public class Listener extends DefaultAgendaEventListener {

  Logger LOGGER = LoggerFactory.getInstance(DefaultAgendaEventListener.class);

  @Override
  public void afterActivationFired(AfterActivationFiredEvent event) {
    super.afterActivationFired(event);
    System.out.println(new Gson().toJson(event));
  }

}
