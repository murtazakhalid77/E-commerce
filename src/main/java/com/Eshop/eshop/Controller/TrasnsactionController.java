package com.Eshop.eshop.Controller;

import com.Eshop.eshop.Dto.ModelDTO;
import com.Eshop.eshop.Dto.TransactionDTO;
import com.Eshop.eshop.Service.IModelService;
import com.Eshop.eshop.Service.ITransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api")
@Controller
public class TrasnsactionController {
  private final  ITransactionService transactionService;

    public TrasnsactionController(ITransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transaction")
    private ResponseEntity<List<TransactionDTO>> getAll(){

        return ResponseEntity.ok(transactionService.getAllTransactions());
    }
    @PostMapping("/transaction")
    private ResponseEntity<TransactionDTO> addTransaction(@RequestBody TransactionDTO transactionDTO) {
        return ResponseEntity.ok(transactionService.addTransaction(transactionDTO));
    }

//    @GetMapping("/model/{id}")
//    private ResponseEntity<ModelDTO> getModelById(@PathVariable Long id) {
//        return ResponseEntity.ok(modelService.getModelById(id));
//    }
//
//    @PatchMapping("/model/{id}")
//    private ResponseEntity<ModelDTO> updateModelById(@PathVariable Long id, @RequestBody Map<String, Object> fields) {
//        return ResponseEntity.ok(modelService.updateModelrById(id,fields));
//    }
//    @PutMapping("/model/{id}")
//    private ResponseEntity<ModelDTO> deleteModelById(@PathVariable Long id) {
//        return ResponseEntity.ok(modelService.deleteModelById(id));
//    }
}
