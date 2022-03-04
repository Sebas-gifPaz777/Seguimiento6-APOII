package ui;

import java.util.Scanner;

import model.BillboardList;

public class Main {
	
	private static BillboardList bl=new BillboardList();
	private static Scanner sc=new Scanner(System.in);
	
	public static void main(String[]args) {
		
		menu();
		//bl.chargeInformation();
		
	}
	
	public static void menu() {
		
		System.out.println(" Bienvenido\n Selecciona una opción:\n1:Agregar valla publicitaria\n2:Mostrar vallas publicitaias\nExportar reporte de peligrosidad\n4:Exit");
		int option=sc.nextInt();
		sc.nextLine();
		
		switch(option) {
		
		case 1:
			String[] info=RegistBillboard();
		}
	}
	
	public static String[] RegistBillboard() {
		System.out.println("Escribe la informacion de la valla de esta forma\nancho++altura++si esta en uso 'true' sino 'false' ");
		String[] parts=sc.nextLine().split("++");
		return parts;
		
	}
}
