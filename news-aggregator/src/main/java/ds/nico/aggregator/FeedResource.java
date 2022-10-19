package ds.nico.aggregator;

import io.quarkus.logging.Log;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import io.quarkus.runtime.StartupEvent;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.event.Observes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("feeds")
public class FeedResource {
    @ConfigProperty(name = "news.aggregator.page.size")
    Integer pageSize;
    Integer pageSizeDefault = 30;
    @ConfigProperty(name = "quarkus.mongodb.connection-string")
    String mongoString;
    void onStart(@Observes StartupEvent ev) {
        Log.info("The mongo string is: " + mongoString);
        Log.info("Page size is: " + pageSize);
    }

    @GET
    @Path("/{idx}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<FeedBean> getPage(Integer idx) {
        Integer ps = pageSize == null? pageSizeDefault : pageSize;
        return FeedBean.findAll(Sort.by("date", "updateDate").descending()).page(Page.of(idx, ps)).list();
    }

    @GET
    @Path("/pages")
    @Produces(MediaType.APPLICATION_JSON)
    public double getNumberOfPagse() {
        Integer ps = pageSize == null? pageSizeDefault : pageSize;
        return Math.floor(FeedBean.count()/ps);
    }
}
