package com.operacionespes.operacionespes.controller;

import com.operacionespes.operacionespes.dto.QueryClavesDiferentesDto;
import com.operacionespes.operacionespes.dto.QueryHistoricoDto;
import com.operacionespes.operacionespes.repository.BusquedaClavesDiferentesRepository;
import com.operacionespes.operacionespes.response.BusquedaClavesDiferentesBaseResponse;
import com.operacionespes.operacionespes.response.BusquedaClavesDiferentesHistoricoResponse;
import com.operacionespes.operacionespes.response.BusquedaClavesDiferentesResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/operacionespes")
@Slf4j
public class BusquedaClavesDiferentesController {

    @Autowired
    private BusquedaClavesDiferentesRepository busquedaClavesDiferentesRepository;

    @GetMapping("/busquedaclavesdiferentes")
    public ResponseEntity<BusquedaClavesDiferentesBaseResponse> queryClavesDiferentes(@RequestParam Integer ClaveDinamicaId,
                                                                                      @RequestParam String Valor_ClaveDinamica) {
        log.info("Dentro del metodo queryDatosGenerales de la clase BusquedaClaveUnicaController");
        List<QueryClavesDiferentesDto> result = busquedaClavesDiferentesRepository.queryClavesDiferentes(ClaveDinamicaId,
                Valor_ClaveDinamica);
        if (!result.isEmpty()) {
            log.info("Retorna dato de QUERY CLAVES DIFERENTES GENERAL");
            BusquedaClavesDiferentesResponse response = new BusquedaClavesDiferentesResponse();
            response.setDataQueryClavesDiferentes(result);
            return ResponseEntity.ok(response);
        }
        Pageable topOne = PageRequest.of(0, 1);
        List<QueryHistoricoDto> result2 = busquedaClavesDiferentesRepository.queryHistorico(ClaveDinamicaId,
                Valor_ClaveDinamica, topOne);
        if (!result2.isEmpty()) {
            log.info("Retorna dato de QUERY HISTORICO");
            BusquedaClavesDiferentesHistoricoResponse response = new BusquedaClavesDiferentesHistoricoResponse();
            response.setDataQueryHistorico(result2);
            return ResponseEntity.ok(response);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
