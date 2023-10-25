package edu.pw2.superloja.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import edu.pw2.superloja.model.endereco.CepDTO;
import edu.pw2.superloja.model.endereco.Endereco;

@Controller
@RequestMapping("/enderecos")
public class EnderecoController {

    private String apiURL = "https://viacep.com.br/ws";
    private String dataFormat = "json";
    
    @GetMapping("/consulta")
    @ResponseBody
    public String consultaCep(String cep){
        RestTemplate rt = new RestTemplate();
        String urlConsulta = apiURL + "/" + cep + dataFormat;
        CepDTO dados = rt.getForObject(urlConsulta, CepDTO.class);
        Endereco e = new Endereco(dados);
        String resposta = "Resultado" + e;
        return resposta;
    }
}
