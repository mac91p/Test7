package pl.kurs.finaltest.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UriParametersExtractor {

    public static Map<String, String> extractQueryParams(String uri) throws UnsupportedEncodingException {
        if (uri == null)
            return Collections.emptyMap();
        else {
            Map<String, String> queryParams = new HashMap<>();
            String[] pairs = uri.split("&");
            for (String pair : pairs) {
                String[] keyValuePair = pair.split("=");

                queryParams.put(URLDecoder.decode(keyValuePair[0], StandardCharsets.UTF_8.name()),
                        URLDecoder.decode(keyValuePair[1], StandardCharsets.UTF_8.name()));
            }
            return queryParams;
        }
    }
}
