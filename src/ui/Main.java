package ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Billboard;
import model.BillboardList;
import model.EmptyInformationException;

public class Main {
	
	private static BillboardList bl=new BillboardList();
	private static Scanner sc=new Scanner(System.in);
	
	public static void main(String[]args) {
		try {
			bl.firstCharge();
			menu();
		}catch(IOException | EmptyInformationException e) {
			if(e instanceof IOException)
				e.printStackTrace();
			if(e instanceof EmptyInformationException)
				System.out.println("Falta información por completar");
		}
		
		
	}
	
	public static void menu() throws IOException, EmptyInformationException {
		
		boolean continues=true;
		while(continues) {
			System.out.println(" Bienvenido\n Selecciona una opción:\n1:Agregar valla publicitaria\n2:Mostrar vallas publicitaias\n3:Exportar reporte de peligrosidad\n4:Cargar archivo 1\n5:Cargar archivo 2\n6:Exit");
			int option=sc.nextInt();
			sc.nextLine();
			System.out.println(option);
			
			switch(option) {
			
			case 1:
				String[] info=RegistBillboard();
				bl.registBillboard(info);
				System.out.println();
			break;
			
			case 2:
				showBillboards();
				System.out.println();
			break;
			
			case 3:
				dangerousBillboard();
				System.out.println();
			break;
				
			case 4:
				chargeDocuments1();
				System.out.println();
			break;
			
			case 5:
				chargeDocuments2();
				System.out.println();
			break;
			
			case 6:
				continues=false;
				bl.saveFile();
				System.out.println("El programa ha finalizado");
			break;
			
			default:
				System.out.println("Esta opción no existe, vuelva seleccionar una opción");
				System.out.println();
			break;
				
			}
		}
		
		
	}
	
	public static String[] RegistBillboard() throws IOException {
		System.out.println("Escribe la informacion de la valla de esta forma\nancho++altura++marca++i esta en uso 'true' sino 'false'");
		String[] parts=sc.nextLine().split("\\+\\+");
		for(int i=0;i<parts.length;i++) {
		}
		
		return parts;
	}
	
	public static void showBillboards() {
		System.out.println("W  H  inUse  Brand");
		ArrayList<Billboard> ch=bl.getList();
		int num=0;
		for(int i=0;i<ch.size();i++) {
			System.out.println(ch.get(i).getWidth()+"  "+ch.get(i).getHeigth()+"  "+ch.get(i).isInUse()+"  "+ch.get(i).getBrand());
			num++;
		}
		System.out.println("Total:"+num+" vallas");
	}
	
	public static void dangerousBillboard() throws IOException {
		System.out.println("===========================");
		System.out.println("DANGEROUS BILLBOARD REPORT");
		System.out.println("===========================");
		System.out.println("The dangerous billboard are:");
		ArrayList<Billboard> dg=bl.getDangeruousList();
		int num=1;
		for(int i=0;i<dg.size();i++) {
			System.out.println(num+". "+dg.get(i).getBrand()+" with area "+dg.get(i).getArea());
			num++;
		}
	}
	
	public static void chargeDocuments1() throws IOException, EmptyInformationException {
		bl.chargeCSV1();
	}
	
	public static void chargeDocuments2() throws IOException, EmptyInformationException {
		bl.chargeCSV2();
	}
}
