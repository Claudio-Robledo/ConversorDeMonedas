
import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ConsultaMoneda {

    public ConsultaMoneda() {
    }

    public Moneda convertirMoneda(String base_code, String target_code, double monto) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair/" + base_code + "/" + target_code + "/" + monto);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

        try {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            return (Moneda) (new Gson()).fromJson((String) response.body(), Moneda.class);
        } catch (Exception var9) {
            Exception e = var9;
            throw new RuntimeException("No encontré esa moneda, error" + e.toString());
        }
    }
}
