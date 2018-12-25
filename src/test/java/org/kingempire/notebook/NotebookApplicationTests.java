//package org.kingempire.notebook;
//
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.util.List;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.kingempire.notebook.note.Note;
//import org.kingempire.notebook.note.NoteRepository;
//import org.kingempire.notebook.note.NoteService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
//import org.springframework.test.context.junit4.SpringRunner;
////import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.CredentialsProvider;
//import org.apache.http.impl.client.BasicCredentialsProvider;
//import org.apache.http.auth.AuthScope;
//import org.apache.http.auth.UsernamePasswordCredentials;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.junit.Assert;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest//(webEnvironment=WebEnvironment.RANDOM_PORT)
//public class NotebookApplicationTests {
//
//    public RestTemplate restTemplate;
//
//    @Autowired
//    private NoteRepository nr;
//
//    @Autowired
//    private NoteService ns;
//
//    @Before
//    public void before() {
//        restTemplate = new RestTemplate(getClientHttpRequestFactory());
//    }
//
//    private HttpComponentsClientHttpRequestFactory getClientHttpRequestFactory() {
//        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
//                = new HttpComponentsClientHttpRequestFactory();
//
//        clientHttpRequestFactory.setHttpClient(httpClient());
//        return clientHttpRequestFactory;
//    }
//
//    private HttpClient httpClient() {
//        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
//        credentialsProvider.setCredentials(AuthScope.ANY,
//                new UsernamePasswordCredentials("", ""));
//
//        HttpClient client = HttpClientBuilder
//                .create()
//                .setDefaultCredentialsProvider(credentialsProvider)
//                .build();
//        return client;
//    }
//
//    @Test
//    public void ff() {
//        final String uri = "https://noteboook.herokuapp.com/api/v1/notes";
//
//        ResponseEntity<List<Note>> response = restTemplate.exchange(
//                uri,
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<List<Note>>() {
//        });
//        List<Note> result = response.getBody();
//        System.out.println(result);
//    }
//
////    @Test
////    public void testGetEmployeeList_success() throws URISyntaxException
////    {
////        final String baseUrl = "http://localhost:"+randomServerPort+"/employees/";
////        URI uri = new URI(baseUrl);
//// 
////        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
////         
////        //Verify request succeed
////        Assert.assertEquals(200, result.getStatusCodeValue());
////        Assert.assertEquals(true, result.getBody().contains("employeeList"));
////    }
////    @Test
////    public void createNewNoteTest() {
////        Note n = new Note();
////        n.setAuthor("temp");
////        n.setTitle(" temp title");
////        n.setContent("my temp new content");
////
////        Note nn = nr.save(n);
////        assertNotNull(nn);
////        assertNotNull(nn.getId());
////        assertEquals(n.getTitle(), nn.getTitle());
////    }
////    @Test
////    public void findAllBySearchStringTest() {
////        List<Note> res = ns.findAllBySearchString("composition");
////        res.stream().forEach((x) -> System.out.println(x));
////    }
//    @Test
//    public void findAllByPageAndSizeTest() {
//        List<Note> res = nr.findAllByPageAndSize(1, 3);
//        res.stream().forEach((x) -> System.out.println(x));
//    }
//}
