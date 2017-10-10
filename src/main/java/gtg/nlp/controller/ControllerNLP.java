package gtg.nlp.controller;

import gtg.nlp.common.entity.Claims;
import gtg.nlp.common.entity.SentenceInfo;
import gtg.nlp.service.corenlp.impl.CoreNLPServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerNLP {

	private CoreNLPServiceImpl coreNLPService;

	@Autowired
	public void setCoreNLPService(CoreNLPServiceImpl coreNLPService) {
		this.coreNLPService = coreNLPService;
	}

	@RequestMapping("/")
	public ModelAndView pageIndex()
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("triples", null);
		mav.setViewName("nlp");
		return mav;
	}

	@RequestMapping(value = "/nlp.do" ,method = RequestMethod.POST)
	public ModelAndView pageNLP(@RequestParam("content") String content)
	{
		ModelAndView mav = new ModelAndView();

		SentenceInfo sentenceInfo = coreNLPService.analyse(content);


		mav.setViewName("nlp");
		mav.addObject("dependencies" ,null);
		mav.addObject("claims", sentenceInfo.getClaim());
		mav.addObject("corefchain" , sentenceInfo.getCoref());
		
		return mav;
	}

	@RequestMapping(value = "/nlp-save.do")
	public ModelAndView save(Claims claims)
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("save-success");
		return mav;
	}
}
