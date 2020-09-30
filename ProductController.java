package jp.co.internous.mushrooms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.mushrooms.model.domain.MstProduct;
import jp.co.internous.mushrooms.model.mapper.MstProductMapper;
import jp.co.internous.mushrooms.model.session.LoginSession;

@Controller
@RequestMapping("/mushrooms/product")
public class ProductController {
	
	@Autowired
	MstProductMapper productMapper;
	
	//ログインセッション
	@Autowired
	private LoginSession loginSession;
	

	@RequestMapping("/{id}")

	public String index(@PathVariable("id") int id, Model m) {
		
		MstProduct product = productMapper.findById(id);
		
		m.addAttribute("product", product);
		m.addAttribute("loginSession", loginSession);
		
		return "product_detail";
	}
}
