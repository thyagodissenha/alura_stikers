import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class RequestImdb {
	
	private static Properties getProperties() throws IOException {
		Properties config = new Properties();
		FileInputStream arquivo = new FileInputStream("./resources/config.properties");
		config.load(arquivo);
		return config;
	}
	
	public static List<Map<String, String>> requestGet() throws IOException, InterruptedException{
		
		Properties config = getProperties();
		
		String url = config.getProperty("url");
		URI endereco = URI.create(url);		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body();
		
		return null;
	}
	
	
}
