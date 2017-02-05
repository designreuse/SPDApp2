package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import entity.Account;
import entity.SPD;
import repository.AccountRepository;
import repository.SPDRepository;

@Controller
public class AccountController {

	@Autowired(required = true)
	private AccountRepository accountRepository;
//	@Autowired(required = true)
	private SPDRepository spdRepository;

	@RequestMapping(value = "/account", params = "add", method = RequestMethod.GET)
	public String getAddAccount(@RequestParam int spdId, Model model) {
		model.addAttribute("spd", spdRepository.findOne(spdId));
		return "account/add";
	}

	@RequestMapping(value = "/account", params = "edit", method = RequestMethod.GET)
	public String getEditAccount(@RequestParam int id, Model model) {
		model.addAttribute("account", accountRepository.findOne(id));
		return "account/edit";
	}

	@RequestMapping(value = "/account", params = "add", method = RequestMethod.POST)
	public String postAddAccount(@RequestParam int spdId, @RequestParam String accountNumber, @RequestParam String mfo,
			@RequestParam String bankName) {
		SPD spd = spdRepository.findOne(spdId);
		Account account = new Account(spd, accountNumber, mfo, bankName);
		accountRepository.save(account);
		return "redirect:spd?id=" + spdId;
	}

	@RequestMapping(value = "/account", params = "edit", method = RequestMethod.POST)
	public String postEditAccount(@RequestParam int id, @RequestParam int spdId, @RequestParam String accountNumber,
			@RequestParam String mfo, @RequestParam String bankName) {
		Account account = accountRepository.findOne(id);
		SPD spd = spdRepository.findOne(spdId);
		account.setSpd(spd);
		account.setAccountNumber(accountNumber);
		account.setMfo(mfo);
		account.setBankName(bankName);
		accountRepository.save(account);
		return "redirect:spd?id=" + account.getSpd().getId();
	}

	@RequestMapping(value = "/account", params = "delete", method = RequestMethod.POST)
	public String postDeleteAccount(@RequestParam int id) {
		Account account = accountRepository.findOne(id);
		int spdId = account.getSpd().getId();
		accountRepository.delete(account);
		return "redirect:spd?id=" + spdId;
	}

}
