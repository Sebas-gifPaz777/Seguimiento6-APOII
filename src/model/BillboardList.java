package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class BillboardList {
	
	private ArrayList<Billboard>bd;
	
	public BillboardList() {
		bd= new ArrayList<>();
	}

	public void registBillboard(String[] info) throws EmptyInformationException {
		for(int i=0;i<info.length;i++) {
			if(info[i].equals(""))
				throw new EmptyInformationException();
		}
		int w=Integer.parseInt(info[0]);
		int h=Integer.parseInt(info[1]);
		int area=w*h;
		String brand=info[2];
		Boolean use=Boolean.parseBoolean(info[3]);
		
		bd.add(new Billboard(w,h,area,brand,use));
		System.out.println("Se ha agregado el anuncion");
	}

	public ArrayList<Billboard> getList() {
		return bd;
	}

	public ArrayList<Billboard> getDangeruousList() throws FileNotFoundException {
		ArrayList<Billboard> dg= new ArrayList<>();
		for(int i=0;i<bd.size();i++) {
			if(bd.get(i).getArea()>=200000)
				dg.add(bd.get(i));
		}
		File file= new File(".\\files\\report.txt");
		fileWriter(file, 2, dg);
		return dg;
	}

	public void chargeCSV1() throws IOException, EmptyInformationException {
		
		File file = new File(".\\files\\Datos1.csv");
		chargerFile(file);
	}

	public void chargeCSV2() throws IOException, EmptyInformationException {
		File file = new File(".\\files\\Datos2.csv");
		chargerFile(file);
	}
	
	public void chargerFile(File file1) throws IOException, EmptyInformationException {
		
		File file = file1;

		FileReader fr = new FileReader(file);

		BufferedReader input = new BufferedReader(fr);

		input.readLine();
		
		
		while (input.ready()) {
			
			String line=input.readLine();
			String [] data = line.split("\\|");
			String temp=data[2];
			data[2]=data[3];
			data[3]=temp;
			registBillboard(data);
		}

		input.close();
		fr.close();
		
	}
	
	public void fileWriter(File file, int num, ArrayList<Billboard>dg2) throws FileNotFoundException {
		PrintWriter pw= new PrintWriter(file);
		if(num==2) {
			pw.println("===========================");
			pw.println("DANGEROUS BILLBOARD REPORT");
			pw.println("===========================");
			pw.println("The dangerous billboard are:");
			
			ArrayList<Billboard> dg=dg2;
			int num1=1;
			for(int i=0;i<dg.size();i++) {
				pw.println(num1+". "+dg.get(i).getBrand()+" with area "+dg.get(i).getArea());
				num1++;
			}
		}
		else {
			for(int i=0;i<bd.size();i++) {
				pw.println(bd.get(i).getWidth()+"|"+bd.get(i).getHeigth()+"|"+bd.get(i).isInUse()+"|"+bd.get(i).getBrand());
			}
		}
		
	}
	
	public void firstCharge() throws IOException, EmptyInformationException {
		File file= new File(".\\files\\Listcomplete.txt");
		chargerFile(file);
	}
	
	public void saveFile() throws FileNotFoundException {
		File file= new File(".\\files\\Listcomplete.txt");
		ArrayList<Billboard>noExist= new ArrayList<>();
		fileWriter(file,1,noExist);
	}

}
