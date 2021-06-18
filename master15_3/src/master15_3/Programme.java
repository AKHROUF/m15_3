package master15_3;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Programme {

	public static void main(String[] args) {
		List<Departement> depts = Arrays.asList(
				new Departement(1, "IT"),
				new Departement(2, "RH"),
				new Departement(3, "F&C"));
				
		List<Employe> societe = Arrays.asList(
				new Employe(1, "Mohamed", 'm', 33333, 1),
				new Employe(2, "Ali", 'm', 22222, 2),
				new Employe(3, "Malika", 'f', 44444, 3),
				new Employe(4, "Sofiane", 'm', 11111, 3),
				new Employe(5, "Mohamed", 'm', 55555, 2),
				new Employe(6, "Yara", 'f', 66666, 3),
				new Employe(7, "Akila", 'f', 33333, 1));
		
		//societe.stream().map(e->e.getNom()).forEach(System.out::println);
		//societe.stream().map(Employe::getNom).forEach(System.out::println);
		societe.stream().map(Employe::getNom).distinct().forEach(System.out::println);
		System.out.println("---------------------");
		
		List<Employe> liste = societe.stream()
				.filter(e -> e.getSalaire() > 40000)
				.collect(Collectors.toList());
		liste.forEach(e->System.out.println(e.getNom()));
		System.out.println("---------------------");
		
		Optional<Employe> emp = societe.stream()
				.filter(e -> e.getSalaire() > 90000)
				.findAny(); //.findFirst
		if (emp.isPresent())
			System.out.println(emp.get().getNom());
		else System.out.println("Aucun employé !");
		System.out.println("---------------------");
		
		societe.stream().skip(2).limit(3).forEach(e->System.out.println(e.getNom()));
		System.out.println("---------------------");
		
		DoubleSummaryStatistics stat = societe.stream().collect(
				Collectors.summarizingDouble(e->e.getSalaire()));
		System.out.println(stat);
		System.out.println(stat.getAverage());
		System.out.println("---------------------");

		Map<Integer, List<Employe>> groupes =
				societe.stream().collect(Collectors.
						groupingBy(e->e.getIdDepartement()));
		for(Integer id : groupes.keySet()) {
			System.out.println("Département " + id);
			groupes.get(id).forEach(e-> System.out.println("\t"+ e.getNom()));
		}
		System.out.println("---------------------");
	
		Map<Boolean, List<Employe>> groupes2 =
				societe.stream().collect(Collectors.
						partitioningBy(e->e.getSexe() == 'm'));
		System.out.println("Les femmes :");
		groupes2.get(false).forEach(e-> System.out.println("\t"+ e.getNom()));
		System.out.println("Les hommes :");
		groupes2.get(true).forEach(e-> System.out.println("\t"+ e.getNom()));
	}

}
