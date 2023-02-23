package com.Eshop.eshop.Service.Impl;

import com.Eshop.eshop.Dto.ProductDTO;
import com.Eshop.eshop.Dto.TransactionDTO;
import com.Eshop.eshop.Service.ITransactionService;
import com.Eshop.eshop.domain.Product;
import com.Eshop.eshop.domain.Transaction;
import com.Eshop.eshop.repositories.TransactionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements ITransactionService {
    TransactionRepository transactionRepository;
    ModelMapper modelMapper;

    public TransactionServiceImpl(TransactionRepository transactionRepository, ModelMapper modelMapper) {
        this.transactionRepository = transactionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TransactionDTO> getAllTransactions() {
     return  transactionRepository.findAll().stream().map(c->toDto(c)).collect(Collectors.toList());
    }

    @Override
    public TransactionDTO addTransaction(TransactionDTO transactionDTO) {
        transactionDTO.setTotalAmount(transactionRepository.getTotal(transactionDTO.getCart().getId()));
        transactionDTO.setLocalDate(LocalDate.now());
      return   toDto(transactionRepository.save(toDomain(transactionDTO)));
    }
    public Transaction toDomain(TransactionDTO transactionDTO){
        return modelMapper.map(transactionDTO,Transaction.class);
    }
    public  TransactionDTO toDto(Transaction transaction){
        return modelMapper.map(transaction,TransactionDTO.class);
    }
}
