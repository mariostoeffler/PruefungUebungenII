package org.campus02.web;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.HashMap;

public class PageCache {

    private HashMap<String, WebPage> cache;

    public HashMap<String, WebPage> getCache() {
        return cache;
    }

    public WebPage readFromCache(String url) throws CacheMissException {
        if (getCache().containsKey("url")) {
            return cache.get(url);
        }
        else {
            throw new CacheMissException("URL not found");
        }
    }

    public void writeToCache(WebPage webPage) {
        cache.put(webPage.getUrl(), webPage);
    }

    public void warmUp(String pathToUrls) throws UrlLoaderException {

        try (BufferedReader br = new BufferedReader(new FileReader(pathToUrls))) {
            String line;
            while ((line = br.readLine()) != null) {
                String url = line;
                writeToCache(UrlLoader.loadWebpage(url));
            }


        } catch (IOException e) {
            throw new UrlLoaderException("Fehler beim WarmUp");
        }

    }

}
