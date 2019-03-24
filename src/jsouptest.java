
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class jsouptest {

    public String get(String URL) throws FileNotFoundException, IOException {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            CloseableHttpClient client = HttpClients.custom().build();

            HttpUriRequest request = RequestBuilder.get()
                    .setUri(URL).build();
            CloseableHttpResponse response = client.execute(request);
            //System.out.println(EntityUtils.toString(response.getEntity()));
            //client.close();
            return EntityUtils.toString(response.getEntity());
        }
    }

    public String post(String URL) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(URL);
        ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("regno", "16CS01017"));
        params.add(new BasicNameValuePair("dob", "1998-02-14"));
        httpPost.setEntity(new UrlEncodedFormEntity(params));

        CloseableHttpResponse response = client.execute(httpPost);
        //assertThat(response.getStatusLine().getStatusCode(), equalTo(200));
        //client.close();
        return EntityUtils.toString(response.getEntity());
    }

    public void req(String _URL) {
        try {
            URL url = new URL(_URL);

            HttpURLConnection hConnection = (HttpURLConnection) url.openConnection();
            HttpURLConnection.setFollowRedirects(true);

            hConnection.setDoOutput(true);
            hConnection.setRequestMethod("POST");

            PrintStream ps = new PrintStream(hConnection.getOutputStream());
            ps.print("regno=16CS01017&amp;dob=1998-02-14");
            ps.close();

            hConnection.connect();

            if (HttpURLConnection.HTTP_OK == hConnection.getResponseCode()) {
                System.out.println("Got you!");
                InputStream is = hConnection.getInputStream();
                OutputStream os = new FileOutputStream("C://Users/Lenovo/Desktop/output.html");
                int data;
                while ((data = is.read()) != -1) {
                    os.write(data);
                }
                is.close();
                os.close();
                hConnection.disconnect();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String args[])throws IOException
    {
        jsouptest obj=new jsouptest();
        obj.req("http://14.139.195.241/Result/login.php");
    }
}
