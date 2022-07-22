import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {

	public static void main(String[] args) throws IOException, InterruptedException {
		// System.out.println("Hello, World!");
		
		// Fazer uma conexão HTTP e buscar os top 250 filmes
		String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";//"https://api.mocki.io/v2/549a5d8b";
		URI endereco = URI.create(url);
		//var client = HttpClient.newHttpClient(); Apartir das versões novas do Java (11?) não precisa repetir o tipo da variável!!!!
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body();
		//System.out.println(body);
		
		// Extrair só os dados que interessam (titulo, poster, classificação)
		
		JsonParser parse = new JsonParser();
		List<Map<String, String>> listaDeFilmes = parse.parse(body);
		//System.out.println(listaDeFilmes.size());
		
		// Exibir e manipular os dados
		
		for(Map<String, String> filme : listaDeFilmes) {
			System.out.println(filme.get("title"));
			System.out.println(filme.get("image"));
			System.out.println(filme.get("imDbRating"));
			System.out.println();
		}
	}
}
