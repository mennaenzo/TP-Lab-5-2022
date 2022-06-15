package com.lab5.tp2022.util;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class EntityURLBuilder {
    public static URI buildURL(final String entity, final String id){
        //devuelvo la url para seguir el formato rest
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{entity}/{id}")
                .buildAndExpand(entity,id)
                .toUri();
    }
}
