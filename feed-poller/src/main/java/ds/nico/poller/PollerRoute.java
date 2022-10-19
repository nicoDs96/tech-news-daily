package ds.nico.poller;

import io.quarkus.logging.Log;
import org.apache.camel.builder.RouteBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PollerRoute extends RouteBuilder {
    @ConfigProperty(name = "pone.feed")
    private List<String> feedList;
    @ConfigProperty(name = "pone.refresh")
    private Integer refresh;
    @ConfigProperty(name = "pone.refresh.limit")
    private Integer refreshLimit;
    @Transactional
    @Override
    public void configure() throws Exception {
        //https://camel.apache.org/components/3.18.x/rss-component.html
        //String url = "https://codemotion.com/magazine/feed";
        Log.info(feedList);
        feedList.forEach(url ->{
            from("rss:" + url + "?alt=rss&splitEntries=false&delay="+refresh+"&repeatCount="+refreshLimit)
                    .process(new FeedProcessor())
                    .log("${body}")
                    .split(body())
                    .bean(FeedBean.class, "upsert");
        });
    }
}
