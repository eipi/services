package name.eipi.services.appservice.rule;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.Resource;
import org.drools.io.impl.ClassPathResource;
import org.drools.runtime.StatefulKnowledgeSession;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by dbdon_000
 * Date: 16/08/13
 */
public class Engine {

    private final static String DRL_EXT = ".drl";

    private final static String DRL_DIR = "resources/drl/";

    public StatefulKnowledgeSession getKnowledgeSession(final String resourceName) throws Exception {
        return getKnowledgeSession(resourceName, 0);
    }

    public StatefulKnowledgeSession getKnowledgeSession (final String resourceName,
                                                         final int seqNum) throws Exception {
        return getKnowledgeBase(resourceName, seqNum).newStatefulKnowledgeSession();
    }

    public KnowledgeBase getKnowledgeBase(final String resourceName, final int seqNum) throws Exception {

        KnowledgeBuilder builder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        Iterator<Resource> resources = getDrlResources(resourceName, seqNum).iterator();
        while (resources.hasNext()) {
            builder.add(resources.next(), ResourceType.DRL);
        }

        KnowledgeBase base = KnowledgeBaseFactory.newKnowledgeBase();
        if (!builder.hasErrors()) {
            base.addKnowledgePackages(builder.getKnowledgePackages());
        } else {
            for (Iterator<KnowledgeBuilderError> it = builder.getErrors().iterator(); it.hasNext(); ) {
                KnowledgeBuilderError error = it.next();
                System.err.println(error.getMessage());
                System.err.println(error.getLines());
                System.err.println(error.getResource());
            }

        }
        return base;
    }

    private Collection<Resource> getDrlResources(final String resourceNam, final int seqNum) throws Exception {


        Collection<Resource> resources = new ArrayList();
        if (seqNum == 0) {
            resources.add(new ClassPathResource(DRL_DIR + resourceNam + DRL_EXT));
        } else {
            for (int i = 1; i <= seqNum; i++) {
                resources.add(new ClassPathResource(DRL_DIR + resourceNam + "_" + seqNum + DRL_EXT, getClass()));
            }
        }
        return resources;
    }

}
