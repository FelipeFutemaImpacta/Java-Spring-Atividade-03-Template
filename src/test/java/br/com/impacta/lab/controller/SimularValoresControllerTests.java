package br.com.impacta.lab.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import br.com.impacta.lab.JavaSpringTemplateApplication;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
		  classes = JavaSpringTemplateApplication.class)
@AutoConfigureMockMvc
public class SimularValoresControllerTests {

	@Autowired
	private MockMvc mvc;
	
	@Test
	public void ShouldCalculateTocaAndCodTipoPagamento1Test() throws Exception {
		RequestBuilder request = get("/simular").queryParam("codigoProduto", "4")
					.queryParam("codTipoPagamento", "1")
					.accept(MediaType.TEXT_PLAIN);
		
		MvcResult result = mvc.perform(request).andExpect(status().isOk()).andReturn();
		
		String response = result.getResponse().getContentAsString();
		
		assertEquals("Toca sendo pago A vista no dinheiro com 10% de desconto custará 31.5 reais".toUpperCase(), response.toUpperCase());
		
	}
	
	@Test
	public void ShouldCalculateLuvasAndCodTipoPagamento3Test() throws Exception {
		RequestBuilder request = get("/simular").queryParam("codigoProduto", "5")
					.queryParam("codTipoPagamento", "3")
					.accept(MediaType.TEXT_PLAIN);
		
		MvcResult result = mvc.perform(request).andExpect(status().isOk()).andReturn();
		
		String response = result.getResponse().getContentAsString();
		
		assertEquals("Luvas sendo pago Em duas parcelas sem nenhum desconto custará 19.5 reais".toUpperCase(), response.toUpperCase());
		
	}
	
}
