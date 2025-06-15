package com.example.API_MP.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.API_MP.service.OauthService;


@RestController
@RequestMapping("/oauth")
public class OauthController{
    OauthService oauthService;

    public OauthController(OauthService os){
        this.oauthService = os;
    }

    @GetMapping("/init")
    public String init() {
        return oauthService.UrlAutorizacion();
    }
    @GetMapping("/callback")
    public ResponseEntity<String> callback(@RequestParam("code") String code,
    @RequestParam("state") String state) {
        String resultado = oauthService.obtenerAccessToken(code, state);
        return ResponseEntity.ok(resultado);
    }
    
}