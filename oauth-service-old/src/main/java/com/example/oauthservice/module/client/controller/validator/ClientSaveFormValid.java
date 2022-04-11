package com.example.oauthservice.module.client.controller.validator;

import com.example.oauthservice.module.client.domain.form.ClientSaveForm;
import com.example.oauthservice.module.client.jpa.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
@RequiredArgsConstructor
public class ClientSaveFormValid implements Validator {

    private final ClientRepository clientRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return ClientSaveForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ClientSaveForm clientSaveForm = (ClientSaveForm) target;
        // TODO : 데이터 조회 체크
    }
}
