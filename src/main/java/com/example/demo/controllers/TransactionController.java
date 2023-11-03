package com.example.demo.controllers;

import com.example.demo.models.GasolineTankEntity;
import com.example.demo.models.TransactionDetailEntity;
import com.example.demo.request.TransactionRequest;
import com.example.demo.response.TransactionResponse;
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
    public TransactionResponse transaction(@RequestBody TransactionRequest transactionRequest) {
        TransactionResponse response = new TransactionResponse();
        response.setMessage("Ha habido un problema procesando la transacción");

        Optional<GasolineTankEntity> gasolineTankOptional =
            gasolineTankService.findById(transactionRequest.getGasolineTankId());

        if (gasolineTankOptional.isPresent()) {
            GasolineTankEntity gasolineTank = gasolineTankOptional.get();
            if ((gasolineTank.getCurrentLevel() - transactionRequest.getGallons()) > 0) {
                gasolineTankService.updateCurrentLevel(
                    transactionRequest.getGasolineTankId(),
                    gasolineTank.getCurrentLevel() - transactionRequest.getGallons()
                );

                TransactionDetailEntity transactionDetail = new TransactionDetailEntity();
                transactionDetail.setClientName(transactionRequest.getCustomerName());
                transactionDetail.setPaymentType(transactionRequest.getPaymentType());
                transactionDetail.setTransactionDate(new Date());
                transactionDetail.setTransactionHour(new Date());
                transactionDetailService.saveTransactionDetail(transactionDetail);

                response.setSuccessful(true);
                response.setMessage("Transacción realizada con éxito.");
                response.setPrice(gasolineTank.getGasolineType().getPrice());
            } else {
                response.setMessage("No se cuenta con el nivel de gasolina que se desea vender.");
            }
        } else {
            response.setMessage("No hemos encontrado el tanque de donde se está vendiendo la gasolina.");
        }

        return response;
    }
}
