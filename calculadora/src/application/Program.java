package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Cadastro do anúncio");
		System.out.println();
		System.out.print("Nome do anúncio: ");
		String adsName = sc.next();
		System.out.print("Cliente: ");
		sc.nextLine();
		String clientName = sc.nextLine();
		System.out.print("Data de início (DD/MM/YYYY): ");
		Date initDate = sdf.parse(sc.next());
		System.out.print("Data de término (DD/MM/YYYY): ");
		Date finalDate = sdf.parse(sc.next());
		System.out.print("Investimento por dia: ");
		double investimento = sc.nextDouble();
		
		long diff;
		
		if (finalDate.getTime() > initDate.getTime()) {
			diff = finalDate.getTime() - initDate.getTime();
		}
		else {
			diff = 0 *( finalDate.getTime() - initDate.getTime() );
		}
		
		int duracao = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

		
		int clique = 0;
		int compartilhamento = 0;
		
		int visualizacao = (int) (30 * investimento);
		
		clique = visualizacao / ( 100 / 12 ) ;
		
		compartilhamento = clique / (20 / 3 );
		
		
		if (compartilhamento >= 1) {
			int compVisu = compartilhamento * 40 ;
			visualizacao += compVisu;
			
			int compVisu02 = compVisu;
			
			while(compVisu02 >= 40) {
				int click02 = compVisu02 / ( 100 / 12 ) ;
				clique += click02;
				
				int comp02 = click02 / (20 / 3 );
				compartilhamento += comp02;
				
				if (comp02 >= 1) {
					compVisu02 = comp02 * 40 ;
					visualizacao += compVisu02;
				}else {
					compVisu02 = 0;
				}
			}
		}
		visualizacao = visualizacao * duracao;
		clique = clique * duracao;
		compartilhamento = compartilhamento * duracao;
		investimento = investimento * duracao;
		
		System.out.println();
		System.out.println("----------------");
		System.out.println();
		System.out.println("Nome do anúncio: " + adsName);
		System.out.println("Cliente: " + clientName);
		System.out.println("Valor total investido: $" + String.format("%.2f", investimento)); 
		System.out.println("Quantidade máxima de visualizações: " + visualizacao);
		System.out.println("Quantidade máxima de cliques: "+ clique);
		System.out.println("Quantidade máxima de compartilhamentos: " + compartilhamento);
		
		sc.close();
	}
}

