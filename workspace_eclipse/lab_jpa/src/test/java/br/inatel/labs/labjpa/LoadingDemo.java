package br.inatel.labs.labjpa;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.inatel.labs.labjpa.entity.NotaCompra;
import br.inatel.labs.labjpa.service.NotaCompraService;

@SpringBootTest
public class LoadingDemo {
	
	@Autowired
	private NotaCompraService service;
	
	public void demoEagerLoading() {
		  try {
			  	NotaCompra item = service.buscarNotaCompraItemPeloId(1L);
				LocalDate dataEmissao = item.getNotaCompra().getDataEmissao();

				System.out.println( dataEmissao );

				System.out.println("Aconteceu carregamento EAGER");
			  
		  }catch (Exception e) {
			  e.printStackTrace();

		}
	}

		 

	
	
	
	

}