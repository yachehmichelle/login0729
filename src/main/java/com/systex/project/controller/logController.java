package com.systex.project.controller;

import java.rmi.server.ExportException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.systex.project.model.Account;
import com.systex.project.model.AccountRepository;
import com.systex.project.service.AccountService;

@Controller
public class logController {

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private AccountService accountService;

	@GetMapping("/")
	public String welcome(Model model) {
		return "index"; // 回傳Thymeleaf模板的名稱
	}

	@PostMapping("/register")
	public String register(@ModelAttribute Account account, Model model) {
		accountRepository.save(account);
		model.addAttribute("account", account);
		return "index";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute Account account, Model model) {
		if ((account.getUsername().isEmpty()) || (account.getPassword().isEmpty())) {
			throw new RuntimeException("輸入不可為空白");

		}
		if (!accountService.checkAccuunt(account)) {
			throw new RuntimeException("帳號或是密碼錯誤");
		}
		model.addAttribute("account", account);
		return "home";

	}
}
