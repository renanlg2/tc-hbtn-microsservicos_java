package com.song.MegaSenaAPI;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping(value = "megasena")
public class MegaSenaController {

    @RequestMapping(value = "/simpleMessageWelcome")
    public String mensagemBoasVindas(){
        return "Seja Bem Vindo, Parça!";
    }

    @RequestMapping(value = "/getNumbers")
    public List<Integer> numeroMegaSena(){
        List<Integer> listaNumeros = new ArrayList<>();
        int numero = 0;
        ThreadLocalRandom random = ThreadLocalRandom.current();

        do {
            numero = random.nextInt(1,60);

            if (!listaNumeros.contains(numero))
                listaNumeros.add(numero);


        } while (listaNumeros.size() < 6);

        Collections.sort(listaNumeros);

        return listaNumeros;
    }
}
