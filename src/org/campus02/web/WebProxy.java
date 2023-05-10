package org.campus02.web;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.ObjectInputStream;

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
        if (cache.getCache().containsKey(url)) {
            numCacheHits++;
            return cache.readFromCache(url);

        }
        else {
            numCacheMisses++;
            cache.writeToCache(UrlLoader.loadWebpage(url));
            throw new CacheMissException("Fehler");



        }




    }
    public String statHits() {
        return "stats hits: " +numCacheHits;


    }

    public String statsMisses() {
        return "stats misses: "+numCacheMisses;
    }

    public boolean writePageCacheToFile(String pathToFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(pathToFile));
        BufferedWriter bw = new BufferedWriter()) {

        }
    }
}
