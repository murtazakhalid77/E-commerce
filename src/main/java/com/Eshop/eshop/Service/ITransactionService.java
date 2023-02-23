package com.Eshop.eshop.Service;

import com.Eshop.eshop.Dto.TransactionDTO;

import java.util.List;

public interface ITransactionService {

   List <TransactionDTO> getAllTransactions();

    TransactionDTO addTransaction(TransactionDTO transactionDTO);
}
