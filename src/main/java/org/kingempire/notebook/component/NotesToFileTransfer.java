package org.kingempire.notebook.component;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import org.apache.tomcat.util.codec.binary.Base64;
import org.kingempire.notebook.note.Note;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Anurag Singh
 */
@Component
public class NotesToFileTransfer {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private JSONUtility ju;

    @Autowired
    private Environment env;

    public void getAllNotesSavedInFile(String uri, String filePath) {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Note>> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                new HttpEntity<>(createHeaders_2(env.getProperty("api.notes.username"), env.getProperty("api.notes.password"))),
                new ParameterizedTypeReference<List<Note>>() {
        });

        List<Note> notes = response.getBody();
        try {
            ju.writeListOfObjectToJsonFile(filePath, notes);
            LOG.info("Data has been wrriten to file!");
        } catch (IOException ex) {
            LOG.error(ex.toString());
        }
    }

    private HttpHeaders createHeaders(String username, String password) {
        String plainCreds = username + ":" + password;
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        String base64Creds = new String(base64CredsBytes);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Creds);
        return headers;
    }

    private HttpHeaders createHeaders_2(String username, String password) {
        return new HttpHeaders() {
            {
                String auth = username + ":" + password;
                byte[] encodedAuth = Base64.encodeBase64(
                        auth.getBytes(Charset.forName("US-ASCII")));
                String authHeader = "Basic " + new String(encodedAuth);
                set("Authorization", authHeader);
            }
        };
    }
}
