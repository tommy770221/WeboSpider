package com.tommy;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * Created by Tommy on 2016/12/25.
 */
public class WeboProcessor implements PageProcessor {

    private Site site = Site
            .me()
            .setDomain("s.weibo.com")
            .addCookie("000000eb.5b08bd3.585fdb38.bcb7bdb8",".sina.com.cn")
            .addCookie("000000eb.5af4bd3.585fdb38.ccbc48af",".sina.com.cn")
            .setSleepTime(3000)
            .setUserAgent(
                    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");

    public void process(Page page) {
        page.addTargetRequest("http://s.weibo.com/weibo/%25E8%2580%2581%25E4%25BA%25BA%25E7%2597%259B%25E9%25BB%259E?topnav=1&wvr=6&b=1");
        page.putField("title",page.getHtml().regex("<script>STK .*"));
    }


    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {

        Spider.create(new WeboProcessor()).addUrl("http://s.weibo.com/weibo")
                .run();
    }
}
