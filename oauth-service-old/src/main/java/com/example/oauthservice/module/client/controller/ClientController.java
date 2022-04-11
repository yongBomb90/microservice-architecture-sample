package com.example.oauthservice.module.client.controller;

import com.example.oauthservice.module.client.controller.validator.ClientSaveFormValid;
import com.example.oauthservice.module.client.domain.ClientVO;
import com.example.oauthservice.module.client.domain.form.ClientSaveForm;
import com.example.oauthservice.module.client.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final ClientSaveFormValid clientSaveFormValid;
    private final ModelMapper modelMapper;

    @InitBinder("clientSaveForm")
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(clientSaveFormValid);
    }

    // TODO 공통 RESPONSE ENTITY처리
    @PostMapping(value = "/client")
    public Map<String,Object> saveClient(ClientSaveForm clientSaveForm) {

        ClientVO clientVO =
                clientService.saveClient(modelMapper.map(clientSaveForm, ClientVO.class));

        Map<String,Object> map
                = new HashMap<>();
        map.put("data",clientVO);

        return map;
    }





}
