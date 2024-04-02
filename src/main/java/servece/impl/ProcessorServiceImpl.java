package servece.impl;

import model.FruitTransaction;
import service.ProcessorService;
import service.Handler.OperationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessorServiceImpl implements ProcessorService {

    @Override
    public Map<String, Integer> processOnData(List<FruitTransaction> transactions,
                                              Map<FruitTransaction.Operation,
                                                      OperationHandler> operation) {
        Map<String, Integer> fruitBalance = new HashMap<>();
        for (FruitTransaction fruitTransaction : transactions) {
            OperationHandler operationHandler =
                    operation.get(fruitTransaction.getOperation());
            if (operationHandler != null) {
                operationHandler.apply(fruitTransaction, fruitBalance);
            } else {
                throw new RuntimeException("Operation does not find!");
            }

        }
        return fruitBalance;
    }
}
