package com.peasch.webbooks.exceptions;

import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.web.client.HttpClientErrorException;

public class CustomErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {

        if(response.status()==401){
            return new BookNotFoundException("non autorisé");
        }
        if(response.status()==404){
            return new PageNotFoundException("page non trouvée");
        }
        if(response.status()==403){
            return new BadMotDePasseEception("mot de passe incorrect");
        }
        return defaultErrorDecoder.decode(s,response);

    }
}
