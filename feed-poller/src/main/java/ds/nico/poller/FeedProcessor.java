package ds.nico.poller;

import com.rometools.rome.feed.synd.SyndCategory;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.feed.synd.SyndPerson;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

import java.util.List;

public class FeedProcessor implements Processor {

    public FeedBean syndEntryToFeedBean(SyndEntry entry, String src){
        FeedBean fb = new FeedBean();
        String authors = entry.getAuthors()
                .stream()
                .map(SyndPerson::getName)
                .reduce((a1,a2) -> a1.concat(";").concat(a2))
                .orElse("");

        fb.authors = authors.isEmpty()? entry.getAuthor(): authors;
        fb.title = entry.getTitle();
        fb.categories = entry.getCategories()
                .stream()
                .map(SyndCategory::getName)
                .reduce((a1,a2) -> a1.concat(";").concat(a2))
                .orElse("");;
        fb.link = entry.getLink();
        fb.date = entry.getPublishedDate();
        fb.updateDate = entry.getUpdatedDate();
        fb.src = src;
        return fb;
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        Message m = exchange.getMessage();
        SyndFeed f = (SyndFeed) m.getBody();
        List<SyndEntry> entryList = f.getEntries();
        String src = f.getLink();
        List<FeedBean> feedList = entryList.stream().map(entry -> this.syndEntryToFeedBean(entry, src)).toList();
        exchange.getMessage().setBody(feedList);
    }
}
