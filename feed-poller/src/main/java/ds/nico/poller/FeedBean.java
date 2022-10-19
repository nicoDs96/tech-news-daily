package ds.nico.poller;

import io.quarkus.mongodb.panache.PanacheMongoEntityBase;
import io.quarkus.mongodb.panache.common.MongoEntity;
import org.bson.codecs.pojo.annotations.BsonId;

import java.util.Date;

@MongoEntity(collection="NewsFeed")
public class FeedBean extends PanacheMongoEntityBase {
    @BsonId
    public String title;
    public String authors;
    public String categories;
    public String link;
    public String src;
    public Date date;
    public Date updateDate;

    public FeedBean(){}

    @Override
    public String toString() {
        return "FeedBean{" +
                "title='" + title + '\'' +
                ", authors=" + authors +
                ", categories=" + categories +
                ", link='" + link + '\'' +
                ", date=" + date +
                ", updateDate=" + updateDate +
                '}';
    }

    public static void upsert(FeedBean f){
        f.persistOrUpdate();
    }
}
