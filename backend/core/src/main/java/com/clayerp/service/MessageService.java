package com.clayerp.service;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MessageService {

    private final MessageSource messageSource;

    public MessageService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String get(String key, Object... params) {
        Locale locale = LocaleContextHolder.getLocale();

        return messageSource.getMessage(
                key,
                params,
                getDefaultMessage(key),
                Locale.getDefault()
        );
    }

    public String getDefaultMessage(String key) {
        return messageSource.getMessage("msg.notfound.for.key", null, Locale.getDefault())
                + " \"" + key + "\".";
    }

}
