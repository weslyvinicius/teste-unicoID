package br.com.test_unico.unicotest.adapter_in.controller.v1;

import br.com.test_unico.unicotest.adapter_in.controller.v1.contratos.IImportListaFeirasController;
import br.com.test_unico.unicotest.adapter_in.representacao.mapper.IFeiraMapper;
import br.com.test_unico.unicotest.adapter_in.representacao.request.ImportFeiraRequest;
import br.com.test_unico.unicotest.adapter_in.util.CsvUtils;
import br.com.test_unico.unicotest.aplication.port.in.IUseCaseFeira;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@Slf4j
public class ImportListaFeirasController implements IImportListaFeirasController {

    private final IFeiraMapper feiraMapper;

    private final IUseCaseFeira useCaseFeira;

    public ImportListaFeirasController(IFeiraMapper feiraMapper, IUseCaseFeira useCaseFeira) {
        this.feiraMapper = feiraMapper;
        this.useCaseFeira = useCaseFeira;
    }


    @Override
    public void uploadSimple(InputStream body) throws IOException {
        final List<ImportFeiraRequest> read = CsvUtils.read(ImportFeiraRequest.class, body);
        useCaseFeira.importListaDeFeira(feiraMapper.toDomainList(read));

    }

    @Override
    public void uploadMultipart(MultipartFile file) throws IOException {
        final List<ImportFeiraRequest> read = CsvUtils.read(ImportFeiraRequest.class, file.getInputStream());
        useCaseFeira.importListaDeFeira(feiraMapper.toDomainList(read));
    }
}
