package com.achsat.travel.account.controller;

import com.achsat.travel.account.model.AccountDetail;
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
        public @ResponseBody List<AccountDetail> getAllAccounts(){
            return accountDetailService.findAllAccount();

        }

        @GetMapping("/account/{id}")
        @ResponseStatus(HttpStatus.OK)
        public @ResponseBody AccountDetail getAccountById(@PathVariable("id") int id){
            AccountDetail model = new AccountDetail();
            model.setId(id);
            return accountDetailService.findAccountById(model);
        }

        @GetMapping("/account/getbyemail")
        @ResponseStatus(HttpStatus.OK)
        public @ResponseBody AccountDetail getAccountByEmail(@RequestParam("email") String email){
            AccountDetail model= new AccountDetail();
            model.setEmail(email);
            return accountDetailService.findAccountByEmail(model);
        }


        @PostMapping("/account/create")
        public ResponseEntity<?> createAccount(@RequestBody AccountDetail acct){
            StatusMessageDTO<AccountDetail> responseMsg=  new StatusMessageDTO<AccountDetail>();
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
         public ResponseEntity<?> updateAccount(@RequestBody AccountDetail acct){
             StatusMessageDTO<AccountDetail> responseMsg=  new StatusMessageDTO<AccountDetail>();
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
