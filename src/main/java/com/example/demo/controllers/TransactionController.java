package com.example.demo.controllers;

import com.example.demo.models.GasolineTankEntity;
import com.example.demo.models.TransactionDetailEntity;
import com.example.demo.request.TransactionRequest;
import com.example.demo.response.BaseResponse;
import com.example.demo.services.GasolineTankService;
import com.example.demo.services.TransactionDetailService;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TransactionController {

    @Autowired
    private GasolineTankService gasolineTankService;

    @Autowired
    private TransactionDetailService transactionDetailService;

    @PostMapping("/transaction")
    public BaseResponse transaction(@RequestBody TransactionRequest transactionRequest) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage("Ha habido un problema procesando la transacción");

        Optional<GasolineTankEntity> gasolineTankOptional =
            gasolineTankService.findById(transactionRequest.getGasolineTankId());

        if (gasolineTankOptional.isPresent()) {
            GasolineTankEntity gasolineTank = gasolineTankOptional.get();
            if ((gasolineTank.getCurrentLevel() - transactionRequest.getAmount()) > 0) {
                gasolineTankService.updateCurrentLevel(
                    transactionRequest.getGasolineTankId(),
                    gasolineTank.getCurrentLevel() - transactionRequest.getAmount()
                );

                TransactionDetailEntity transactionDetail = new TransactionDetailEntity();
                transactionDetail.setClientName(transactionRequest.getClientName());
                transactionDetail.setPaymentType(transactionRequest.getPaymentType());
                transactionDetail.setTransactionDate(new Date());
                transactionDetail.setTransactionHour(new Date());
                transactionDetailService.saveTransactionDetail(transactionDetail);

                baseResponse.setSuccessful(true);
                baseResponse.setMessage("Transacción realizada con éxito.");
            } else {
                baseResponse.setMessage("No se cuenta con el nivel de gasolina que se desea vender.");
            }
        } else {
            baseResponse.setMessage("No hemos encontrado el tanque de donde se está vendiendo la gasolina.");
        }

        return baseResponse;
    }
}
