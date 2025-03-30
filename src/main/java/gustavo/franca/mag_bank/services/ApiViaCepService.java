package gustavo.franca.mag_bank.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import gustavo.franca.mag_bank.domain.Address;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ApiViaCepService {


    public Address getAddress(String cep) throws IOException, InterruptedException {
        Address address = null;

        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://viacep.com.br/ws/"+ cep +"/json/")).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();
            address = mapper.readValue(response.body(), Address.class);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return address;
    }
}
