package org.campus02.web;

import java.io.*;

public class WebProxy {

    private PageCache cache;
    private int numCacheHits;
    private int numCacheMisses;

    public WebProxy() {
    cache = new PageCache();
    numCacheHits = 0;
    numCacheMisses = 0;
    }

    public WebProxy(PageCache cache) {
        this.cache = cache;
        numCacheMisses = 0;
        numCacheMisses = 0;
    }

    public WebPage fetch(String url) throws UrlLoaderException, CacheMissException {
       try {
           WebPage webPage = cache.readFromCache(url);
           numCacheHits++;
           return webPage;
       }
       catch (CacheMissException e) {
           System.out.println("not found in cache!" + e);
           WebPage page = UrlLoader.loadWebpage(url);
           cache.writeToCache(page);
           return page;
       }





    }
    public String statHits() {
        return "stats hits: " +numCacheHits;


    }

    public String statsMisses() {
        return "stats misses: "+numCacheMisses;
    }

    public boolean writePageCacheToFile(String pathToFile) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathToFile))) {

            for (String url : cache.getCache().keySet()) {
                WebPage webPage = cache.getCache().get(url);
                bw.write(url + ";" + webPage.getContent());
                bw.newLine();
            }
            bw.flush();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
