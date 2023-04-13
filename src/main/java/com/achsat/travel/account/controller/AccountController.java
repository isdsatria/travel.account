package com.achsat.travel.account.controller;

import com.achsat.travel.account.model.AccountDetail;
import com.achsat.travel.account.model.dto.AccountDTO;
import com.achsat.travel.account.model.dto.StatusMessageDTO;
import com.achsat.travel.account.service.IAccountDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class AccountController {

        @Autowired
        @Qualifier("accountDetailServiceJPA")
        private IAccountDetailService accountDetailService;


        @GetMapping("/accounts")
        @ResponseStatus(HttpStatus.OK)
        public @ResponseBody List<AccountDTO> getAllAccounts(){
            return accountDetailService.findAllAccount();

        }

        @GetMapping("/account/{id}")
        @ResponseStatus(HttpStatus.OK)
        public @ResponseBody AccountDTO getAccountById(@PathVariable("id") int id){
            AccountDTO model = new AccountDTO();
            model.setId(id);
            return accountDetailService.findAccountById(model);
        }

        @GetMapping("/account/getbyemail")
        @ResponseStatus(HttpStatus.OK)
        public @ResponseBody AccountDTO getAccountByEmail(@RequestParam("email") String email){
            AccountDTO model= new AccountDTO();
            model.setEmail(email);
            return accountDetailService.findAccountByEmail(model);
        }


        @PostMapping("/account/create")
        public ResponseEntity<?> createAccount(@RequestBody AccountDTO acct){
            StatusMessageDTO<AccountDTO> responseMsg=  new StatusMessageDTO<AccountDTO>();
            try {
                accountDetailService.create(acct);
                responseMsg.setStatus(HttpStatus.OK.value());
                responseMsg.setMessage("Berhasil create account");
                responseMsg.setData(acct);
                return ResponseEntity.ok().body(responseMsg);
            }catch(Exception e) {
                responseMsg.setMessage("Gagal create account");
                return ResponseEntity.badRequest().body(responseMsg);
            }

         }

         @PutMapping("/account/update")
         public ResponseEntity<?> updateAccount(@RequestBody AccountDTO acct){
             StatusMessageDTO<AccountDTO> responseMsg=  new StatusMessageDTO<AccountDTO>();
             try{
                 accountDetailService.update(acct);
                 responseMsg.setStatus(HttpStatus.OK.value());
                 responseMsg.setMessage("Berhasil update account");
                 responseMsg.setData(acct);
                 return ResponseEntity.ok().body(responseMsg);

             }catch(Exception e) {
                 responseMsg.setMessage("Gagal update account");
                 return ResponseEntity.badRequest().body(responseMsg);
             }
         }

}
