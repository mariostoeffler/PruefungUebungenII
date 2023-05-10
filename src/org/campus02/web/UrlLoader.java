package org.campus02.web;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Collectors;

public class UrlLoader {



    public static WebPage loadWebpage(String url) throws UrlLoaderException {

        try {
            URL myURL = new URL(url);
            try (BufferedReader br = new BufferedReader(new InputStreamReader(myURL.openStream()))) {
                String content = br.lines().collect(Collectors.joining(System.lineSeparator()));
                return new WebPage(url, content);
            } catch (IOException e) {
                throw new UrlLoaderException("Fehler beim Lesen", e);
            }


        } catch (MalformedURLException e) {
            throw new UrlLoaderException("Fehler beim Laden der Website", e);
        }


    }
}
