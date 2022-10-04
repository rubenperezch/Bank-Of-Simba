package com.greenfoxacademy.bankofsimba.controllers;

import com.greenfoxacademy.bankofsimba.models.BankAccount;
import com.greenfoxacademy.bankofsimba.service.AccountsList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static com.greenfoxacademy.bankofsimba.service.AccountsList.accountList;
import static com.greenfoxacademy.bankofsimba.service.AccountsList.setAccountList;


@Controller
public class BankController {

    BankAccount account = new BankAccount("Simba",2000.00,"lion",true, true);

    @GetMapping("/show")
    public String showAccount(Model model) {
        model.addAttribute("accounts",account);
        return "index";
    }

    @GetMapping("/phrase")
    public String display(Model model) {
        model.addAttribute("accounts",account);
        model.addAttribute("phrase","This is an <em>HTML</em> text. <b>Enjoy yourself!</b>");
        return "index";
    }

    @GetMapping("/accounts")
    public String showAllAccounts(Model model) {
        model.addAttribute("accounts",AccountsList.getAccountList());
        return "accounts";
    }

    @GetMapping("/form")
    public String renderRaiseBalanceForm(Model model) {
        model.addAttribute("accounts",AccountsList.getAccountList());
        return "form";
    }

    @PostMapping("/form")
    public String raiseBalance(@RequestParam String name) {

        AccountsList.setAccountList(name);
        return "redirect:/accounts";
    }

    @GetMapping("/addAccount")
    public String renderAddAccountPage(@ModelAttribute BankAccount account) {
        return "add";
    }

    @PostMapping("/addAccount")
    public String addAccount(@ModelAttribute(name = "account") BankAccount account) {
        AccountsList.getAccountList().add(account);
        return "redirect:/accounts";
    }
}
