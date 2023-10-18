package com.operacionespes.operacionespes.controller;

import com.operacionespes.operacionespes.response.BusquedaClavesDiferentesBaseResponse;
import com.operacionespes.operacionespes.service.BusquedaClavesDiferentesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operacionespes")
@Slf4j
public class BusquedaClavesDiferentesController {

    @Autowired
    private BusquedaClavesDiferentesService busquedaClavesDiferentesService;

    @GetMapping("/busquedaclavesdiferentes")
    public ResponseEntity<BusquedaClavesDiferentesBaseResponse> queryClavesDiferentes(@RequestParam Integer ClaveDinamicaId,
                                                                                      @RequestParam String Valor_ClaveDinamica) {
        log.info("Dentro del metodo queryDatosGenerales de la clase BusquedaClaveUnicaController");
        return busquedaClavesDiferentesService.queryClavesDiferentes(ClaveDinamicaId, Valor_ClaveDinamica);
    }
}
