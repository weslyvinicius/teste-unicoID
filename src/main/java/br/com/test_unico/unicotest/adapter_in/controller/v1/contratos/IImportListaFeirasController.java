package br.com.test_unico.unicotest.adapter_in.controller.v1.contratos;

import br.com.test_unico.unicotest.adapter_in.util.ConstantsNames;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Api(value = "API REST Projeto Importação de Feira Livre")
@RequestMapping(ConstantsNames.URI_VERSION_NAME)
public interface IImportListaFeirasController {

    @ApiOperation(value = "Serviço para importar os cadastros de Feira Livre por csv: consumes text/csv")
    @PostMapping(value = ConstantsNames.URI_VERSION_UPLOAD, consumes = "text/csv")
    @ResponseStatus(HttpStatus.OK)
    void uploadSimple(@RequestBody InputStream body) throws IOException;

    @ApiOperation(value = "Serviço para importar os cadastros de Feira Livre por csv: consumes multipart/form-data")
    @PostMapping(value = ConstantsNames.URI_VERSION_UPLOAD, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.OK)
    void uploadMultipart(@RequestParam("file") MultipartFile file) throws IOException;
}
