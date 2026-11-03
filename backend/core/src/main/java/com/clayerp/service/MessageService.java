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
                getDefaultMessage(key, locale),
                locale
        );
    }

    public String getDefaultMessage(String key) {
        Locale locale = LocaleContextHolder.getLocale();
        return getDefaultMessage(key, locale);
    }

    private String getDefaultMessage(String key, Locale locale) {
        return messageSource.getMessage("msg.notfound.for.key", null, locale) + " \"" + key + "\".";
    }
}