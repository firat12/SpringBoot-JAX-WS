package com.uab.unet.springbootsoapws.endpoint;

import com.uab.unet.springbootsoapws.entity.YbsIl;
import com.uab.unet.springbootsoapws.service.impl.YbsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import tr.gov.uab.unet.spring_boot_soap_ws.*;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class YbsIlEndpoint {
    private static final String NAMESPACE_URI = "http://unet.uab.gov.tr/spring-boot-soap-ws";
    private static final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private YbsService ybsService;

    @PayloadRoot(localPart = "getYbsIlByIdRequest", namespace = NAMESPACE_URI)
    @ResponsePayload
    public GetYbsIlByIdResponse getYbsIl(@RequestPayload GetYbsIlByIdRequest request){
        GetYbsIlByIdResponse response = new GetYbsIlByIdResponse();
        YbsIlDto dto = modelMapper.map(ybsService.getYbsIlById(request.getIlId()), YbsIlDto.class);
        response.setYbsIlDto(dto);
        return response;
    }

    @PayloadRoot(localPart = "getAllYbsIlRequest", namespace = NAMESPACE_URI)
    @ResponsePayload
    public GetAllYbsIlResponse getAllYbsIl(){
        GetAllYbsIlResponse response = new GetAllYbsIlResponse();
        List<YbsIlDto> list = new ArrayList<>();
        List<YbsIl> ilList = ybsService.getAllYbsIller();
        ilList.forEach(item -> {
            YbsIlDto dto = modelMapper.map(item, YbsIlDto.class);
            list.add(dto);
        });
        response.getYbsIlDto().addAll(list);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addYbsIlRequest")
    @ResponsePayload
    public AddYbsIlResponse addYbsIl(@RequestPayload AddYbsIlRequest ybsIlRequest){
        AddYbsIlResponse ilResponse = new AddYbsIlResponse();
        YbsIlStatus status = new YbsIlStatus();
        YbsIl il = modelMapper.map(ybsIlRequest, YbsIl.class);
        Boolean flag = ybsService.addYbsIl(il);

        if(flag){
            YbsIlDto dto = modelMapper.map(il, YbsIlDto.class);
            ilResponse.setYbsIlDto(dto);
            status.setMessage("Kayıt İşlemi Başarılı!");
            status.setStatusCode("SUCCESS");
        }else{
            status.setMessage("Kayıt İşlemi Başarısız!");
            status.setStatusCode("ERROR");
        }
        return ilResponse;
    }

    @PayloadRoot(localPart = "updateYbsIlRequest", namespace = NAMESPACE_URI)
    @ResponsePayload
    public UpdateYbsIlResponse updateYbsIl(@RequestPayload UpdateYbsIlRequest ybsIlRequest){
        UpdateYbsIlResponse response = new UpdateYbsIlResponse();
        YbsIlStatus status = new YbsIlStatus();
        YbsIl il = modelMapper.map(ybsIlRequest.getYbsIlDto(), YbsIl.class);
        ybsService.updateYbsIl(il);
        status.setStatusCode("SUCCESS");
        status.setMessage("Güncelleme İşemi  Başarılı!");
        response.setYbsIlStatus(status);
        return response;
    }

    @PayloadRoot(localPart = "deleteYbsIlRequest", namespace = NAMESPACE_URI)
    @ResponsePayload
    public DeleteYbsIlResponse deleteYbsIl(@RequestPayload DeleteYbsIlRequest ybsIlRequest){
        DeleteYbsIlResponse response = new DeleteYbsIlResponse();
        YbsIlStatus status = new YbsIlStatus();
        YbsIl il = ybsService.getYbsIlById(ybsIlRequest.getYbsIlId());
        if(il == null){
            status.setStatusCode("WARN");
            status.setMessage("Silinecek Kayıt Bulunamadı!");
            response.setYbsIlStatus(status);
            return response;
        }

        ybsService.deleteYbsIl(il);
        status.setStatusCode("SUCCESS");
        status.setMessage("Silme İşemi  Başarılı!");
        response.setYbsIlStatus(status);
        return response;
    }

}
