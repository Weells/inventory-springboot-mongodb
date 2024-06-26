package com.brunooliveira.inventoryspringbootmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.brunooliveira.inventoryspringbootmongodb.domain.ItemsFolder;
import com.brunooliveira.inventoryspringbootmongodb.domain.Item;
import com.brunooliveira.inventoryspringbootmongodb.repositories.ItemRepository;
import com.brunooliveira.inventoryspringbootmongodb.repositories.ItemsFolderRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private ItemsFolderRepository itemsFolderRepository;
	
	@Override
	public void run(String... args) throws Exception {

		itemRepository.deleteAll();
		itemsFolderRepository.deleteAll();
		
		Item ing1 = new Item(null, "Plastico", 5, "plastic", "Plástico, tem seu nome originário do grego \"plastikos\" que significa - capaz de ser moldado, é um material de origem natural ou sintética, obtido a partir dos derivados de petróleo ou de fontes renováveis como a cana-de-açúcar ou o milho.");
		Item ing2 = new Item(null, "Papel", 10, "paper", "O papel é um material constituído por elementos fibrosos de origem vegetal, geralmente distribuído sob a forma de folhas ou rolos.");
		Item ing3 = new Item(null, "Maçã", 2, "apple", "O fruto é globoso, com uma profunda depressão no ponto de inserção da haste, que o prende aos ramos. De coloração vermelha ou verde, pode apresentar pequenas manchas esverdeadas ou amareladas.");
		Item ing4 = new Item(null, "Plastico", 5, "plastic", "Plástico, tem seu nome originário do grego \"plastikos\" que significa - capaz de ser moldado, é um material de origem natural ou sintética, obtido a partir dos derivados de petróleo ou de fontes renováveis como a cana-de-açúcar ou o milho.");
		Item ing5 = new Item(null, "Plastico", 5, "plastic", "Plástico, tem seu nome originário do grego \"plastikos\" que significa - capaz de ser moldado, é um material de origem natural ou sintética, obtido a partir dos derivados de petróleo ou de fontes renováveis como a cana-de-açúcar ou o milho.");
		Item ing6 = new Item(null, "Plastico", 5, "plastic", "Plástico, tem seu nome originário do grego \"plastikos\" que significa - capaz de ser moldado, é um material de origem natural ou sintética, obtido a partir dos derivados de petróleo ou de fontes renováveis como a cana-de-açúcar ou o milho.");
		Item ing7 = new Item(null, "Plastico", 5, "plastic", "Plástico, tem seu nome originário do grego \"plastikos\" que significa - capaz de ser moldado, é um material de origem natural ou sintética, obtido a partir dos derivados de petróleo ou de fontes renováveis como a cana-de-açúcar ou o milho.");
		Item ing8 = new Item(null, "Plastico", 5, "plastic", "Plástico, tem seu nome originário do grego \"plastikos\" que significa - capaz de ser moldado, é um material de origem natural ou sintética, obtido a partir dos derivados de petróleo ou de fontes renováveis como a cana-de-açúcar ou o milho.");
		Item ing9 = new Item(null, "Plastico", 5, "plastic", "Plástico, tem seu nome originário do grego \"plastikos\" que significa - capaz de ser moldado, é um material de origem natural ou sintética, obtido a partir dos derivados de petróleo ou de fontes renováveis como a cana-de-açúcar ou o milho.");

		
		itemRepository.saveAll(Arrays.asList(ing1, ing2, ing3, ing4, ing5, ing6, ing7, ing8, ing9));
		
		ItemsFolder folder1 = new ItemsFolder(null, "Ingredientes", "atom");
		folder1.getItems().addAll(Arrays.asList(ing1, ing2, ing3, ing4, ing5, ing6, ing7, ing8, ing9));
		
		itemsFolderRepository.saveAll(Arrays.asList(folder1));
		
	}

}
