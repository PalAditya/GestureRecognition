import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

public class HttpClientTutorial  {
     public final static void main(String[] args) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
             CloseableHttpClient client = HttpClients.custom().build();

        // (1) Use the new Builder API (from v4.3)
       HttpUriRequest request = RequestBuilder.get()
                .setUri("http://www.facebook.com")
                // (2) Use the included enum
                .setHeader("Cookie", "act=1549462441682%2F26;c_user=100013025555228;datr=lZsFW3fvYtvmBcKoZoj0biox;dpr=2;"
                        + "fr=lZsFW3fvYtvmBcKoZoj0biox;m_pixel_ratio=2;pl=n;presence=EDvF3EtimeF1549481145EuserFA21B13025555228A2EstateFDt3F_5b_5dG549481145267CEchFDp_5f1B13025555228F109CC;"
                        + "sb=lZsFW6WjKoF5GJibnutqzADt;")
                .build();
       
       /*HttpUriRequest request = RequestBuilder.get()
                .setUri("http://www.facebook.com").build();*/
        CloseableHttpResponse response = client.execute(request);
        
            /*HttpGet httpget = new HttpGet("http://www.facebook.com/");
            
            System.out.println("Executing request " + httpget.getRequestLine());
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                @Override
                public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }

            };
            String responseBody = httpclient.execute(httpget, responseHandler);*/
            System.out.println("----------------------------------------");
            PrintStream o = new PrintStream(new File("C:/Users/Lenovo/Desktop/A.html")); 
            
            // Store current System.out before assigning a new value 
            PrintStream console = System.out; 

            // Assign o to output stream 
            System.setOut(o); 
            System.out.println(EntityUtils.toString(response.getEntity()));
            /*System.out.println("<base href=\"http://www.almafiesta.com\">"+responseBody);
            // Use stored value for output stream 
            System.setOut(console); 
            String str[]=responseBody.split("\\r?\\n");
            for(int i=0;i<str.length;i++)
            {
                if(str[i].contains("link")&&str[i].contains("href"))
                {
                    System.out.println(str[i]);
                    int x=str[i].indexOf("href");
                    int y=str[i].indexOf("\"",x+6);
                    System.out.println("Stripped: "+str[i].substring(x+6,y));
                }
            }*/
        } finally {
            httpclient.close();
        }
    }
}