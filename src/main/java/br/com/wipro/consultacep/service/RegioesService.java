package br.com.wipro.consultacep.service;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegioesService {

	private double valorNorte = 20.83;
	private double valorSudeste = 7.85;
	private double valorCentroOeste = 12.50;
	private double valorNordeste = 15.98;
	private double valorSul = 17.30;
	
	
	private List<Integer> regiaoNorte = Arrays.asList(66 ,68 ,69 , 76, 77);
	private List<Integer> regiaoSudeste = Arrays.asList(0, 1, 2 , 3);
	private List<Integer> regiaoNordeste = Arrays.asList(4, 5, 65, 60, 63, 64);
	private List<Integer> regiaoCentroOeste = Arrays.asList(7);
	private List<Integer> regiaoSul = Arrays.asList(8, 9);
	
}
