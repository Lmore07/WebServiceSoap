package com.service.soap.endpoint;

import com.service.soap.bandas.GetBandasRequest;
import com.service.soap.bandas.GetBandasResponse;
import com.service.soap.repository.BandasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class BandasEndpoint {

    private static final String NAMESPACE_URI = "http://service.com/soap/bandas";

    private BandasRepository bandasRepository;

    @Autowired
    public BandasEndpoint(BandasRepository bandasRepository) {
        this.bandasRepository = bandasRepository;
    }
    @PayloadRoot(namespace = NAMESPACE_URI,localPart = "getBandasRequest")
    @ResponsePayload
    public GetBandasResponse getBandas(@RequestPayload GetBandasRequest request){
        GetBandasResponse response = new GetBandasResponse();
        response.setBanda(bandasRepository.findById(request.getId()));
        return response;
    }

}
