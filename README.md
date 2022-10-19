# :unicorn: Tech News Daily :unicorn:
The Tech News Daily (TND) project creates a [minimal website](https://nicods96.github.io/tech-news-daily/) that shows you the latest published articles from a list of tech blog.  
We can divide the project in three main parts:
1) [The News Poller](/feed-poller/): periodically listening to feeds and updating the feed database.
2) [The News Endpoint](/news-aggregator/): an API exposing the news ordered by latest.
3) [The News Website](/news-html): a lightweight website showing the latest news.

<!--To read more about it, check the [project description]().-->

## News Blogs
Currently, the poller listen to feeds from:
* [Engineering@AirBnB](https://medium.com/feed/airbnb-engineering)
* [AWS](https://aws.amazon.com/blogs/aws/feed/)
* [BigData@Amazon](https://aws.amazon.com/blogs/big-data/feed/)
* [BlaBlaCar](https://medium.com/feed/blablacar)
* [Engineering@BlackRock](https://medium.com/feed/blackrock-engineering)
* [Codemotion Magazine](https://codemotion.com/magazine/feed)
* [Engineering@DataBricks](https://www.databricks.com/blog/category/engineering/feed)
* [GitHub](https://github.blog/feed/)
* [Google AI](http://googleaiblog.blogspot.com/atom.xml)
* [Engineering@Lyft](https://eng.lyft.com/feed)
* [Tech@Trivago](https://tech.trivago.com/rss.xml)
* [Engineering@Meta](https://engineering.fb.com/feed/)
* [Tech@Netflix](https://netflixtechblog.com/feed)
* [OpenAI](https://openai.com/blog/rss/)
* [Research@Spotify](https://research.atspotify.com/feed)
* [Engineering@Spotify](https://engineering.atspotify.com/feed)

If you wanto to add support to a new blog open an issue/send a pull request.
<!--
## Customization
If you want to exposte a custom aggregation of news from different blogs, you can follow the [step-by-step guide](). -->