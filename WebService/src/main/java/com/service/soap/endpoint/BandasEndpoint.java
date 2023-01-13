package com.service.soap.endpoint;


import com.service.soap.bandas.*;
import com.service.soap.repository.BandasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class BandasEndpoint {

    private static final String GET_BANDAS = "http://service.com/soap/bandas";

    private BandasRepository bandasRepository;

    @Autowired
    public BandasEndpoint(BandasRepository bandasRepository) {
        this.bandasRepository = bandasRepository;
    }

    @PayloadRoot(namespace = GET_BANDAS,localPart = "getBandaRequest")
    @ResponsePayload
    public GetBandaResponse getBandaById(@RequestPayload GetBandaRequest request){
        GetBandaResponse response = new GetBandaResponse();
        response.setBanda(bandasRepository.findById(request.getId()));
        return response;
    }

    @PayloadRoot(namespace = GET_BANDAS,localPart = "getBandasRequest")
    @ResponsePayload
    public GetBandasResponse getBandas(){
        List<Bandas> bandas = bandasRepository.selecciona_todas();
        System.out.println(bandas.get(1));
        GetBandasResponse response = new GetBandasResponse();
        response.setBanda(bandas);
        return response;
    }

    @PayloadRoot(namespace = GET_BANDAS,localPart = "insertBandaRequest")
    @ResponsePayload
    public InsertBandaResponse insertBanda(@RequestPayload InsertBandaRequest request){
        InsertBandaResponse response = new InsertBandaResponse();
        response.setMensaje(bandasRepository.insertaBanda(request.getBanda()));
        return response;
    }

    @PayloadRoot(namespace = GET_BANDAS,localPart = "updateBandaRequest")
    @ResponsePayload
    public UpdateBandaResponse updateBanda(@RequestPayload UpdateBandaRequest request){
        UpdateBandaResponse response = new UpdateBandaResponse();
        response.setMensaje(bandasRepository.updateBanda(request.getBanda()));
        return response;
    }

    @PayloadRoot(namespace = GET_BANDAS,localPart = "deleteBandaRequest")
    @ResponsePayload
    public DeleteBandaResponse deleteBanda(@RequestPayload DeleteBandaRequest request){
        DeleteBandaResponse response = new DeleteBandaResponse();
        response.setMensaje(bandasRepository.deleteByID(request.getId()));
        return response;
    }
}
