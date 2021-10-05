package br.com.test_unico.unicotest.adapter_in.exception.handler;


import br.com.test_unico.unicotest.aplication.exception.AlteracaoDeRegistroNaoPermitidoException;
import br.com.test_unico.unicotest.aplication.exception.ResultNotFoundException;
import br.com.test_unico.unicotest.adapter_in.exception.custom_exception.ValidacaoException;
import br.com.test_unico.unicotest.adapter_in.util.IMessageDefaultKey;
import br.com.test_unico.unicotest.adapter_in.util.MessageSourceUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {

    private final MessageSourceUtil messageSourceUtil;

    public RestExceptionHandler(MessageSourceUtil messageSourceUtil) {
        this.messageSourceUtil = messageSourceUtil;
    }

    @ExceptionHandler(AlteracaoDeRegistroNaoPermitidoException.class)
    public ResponseEntity<?> handelerAlteracaoDeRegistroNaoPermitidoException(AlteracaoDeRegistroNaoPermitidoException alteracaoDeRegistroNaoPermitidoException) {
        ResponseHandlerDetail responseHandlerDetail = ResponseHandlerDetail.builder()
                .datetime(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .classeDeError(alteracaoDeRegistroNaoPermitidoException.getClass().getName())
                .build()
                .addMenssagemErro(messageSourceUtil.getMessageByKey(IMessageDefaultKey.ALTER_REGISTER_NOT_ALLOWED));
        return new ResponseEntity<>(responseHandlerDetail, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResultNotFoundException.class)
    public ResponseEntity<?> handelerNotFoundException(ResultNotFoundException resultNotFoundException) {
        ResponseHandlerDetail responseHandlerDetail = ResponseHandlerDetail.builder()
            .datetime(LocalDateTime.now())
            .status(HttpStatus.NOT_FOUND.value())
            .classeDeError(resultNotFoundException.getClass().getName())
            .build()
            .addMenssagemErro(messageSourceUtil.getMessageByKey(IMessageDefaultKey.DEFAULT_RESULT_NOT_FOUND_KEY));
        return new ResponseEntity<>(responseHandlerDetail, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        ResponseHandlerDetail responseHandlerDetail = ResponseHandlerDetail.builder()
            .datetime(LocalDateTime.now())
            .status(HttpStatus.BAD_REQUEST.value())
            .classeDeError(methodArgumentNotValidException.getClass().getName())
            .build()
            .addCamposObrigarios(messageSourceUtil.getMessageCamposObrigarios(methodArgumentNotValidException.getBindingResult().getFieldErrors()));
        return new ResponseEntity<>(responseHandlerDetail, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<?> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
        ResponseHandlerDetail responseHandlerDetail = ResponseHandlerDetail.builder()
            .datetime(LocalDateTime.now())
            .status(HttpStatus.METHOD_NOT_ALLOWED.value())
            .classeDeError(exception.getClass().getName())
            .build()
            .addMenssagemErro(exception.getMessage());
        return new ResponseEntity<>(responseHandlerDetail, HttpStatus.METHOD_NOT_ALLOWED);

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = ValidacaoException.class)
    public ResponseEntity<?> methodValidacaoException(ValidacaoException validacaoException) {
        ResponseHandlerDetail responseHandlerDetail = ResponseHandlerDetail.builder()
            .datetime(LocalDateTime.now())
            .status(HttpStatus.BAD_REQUEST.value())
            .classeDeError(validacaoException.getClass().getName())
            .build()
            .addListMenssagemError(messageSourceUtil.getListMessages(validacaoException.getMessages()));
        return new ResponseEntity<>(responseHandlerDetail, HttpStatus.METHOD_NOT_ALLOWED);

    }


}
