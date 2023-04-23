package com.example.testexception.controller;


import com.example.testexception.exception.ApiError;
import com.example.testexception.model.Account;
import com.example.testexception.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AccountController {


    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Account account){
        return ResponseEntity.ok(accountService.save(account));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        accountService.delete(id);
        return ResponseEntity.ok("deleted");
    }

    @GetMapping("/getbyinn")
    public ResponseEntity<?> getByInn(@RequestParam String inn){
        return ResponseEntity.ok(accountService.getByInn(inn));
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(accountService.getAll());
    }
    @GetMapping("/getbyid/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) throws ApiError {
        return ResponseEntity.ok(accountService.getById(id));
    }
}
