import java.io.*;
public class P1nX{
	//Areas:
	private static double calcula(double r) throws IOException {
		if(r*Math.PI <= 0){
			System.out.println("ERRO: Digite apenas valores maiores que 0");
			return tentarNovamente(3);
		}
		else{
			return r*Math.PI;
		}		
	}
	
	private static double calcula(double b, double a) throws IOException {
		if(a*b <= 0){
			System.out.println("ERRO: Digite apenas valores maiores que 0");
			return tentarNovamente(3);
		}
		else{
			return a*b;
		}
	}
	
	private static double calcula(double l1, double l2, double l3) throws IOException {
		double p = (l1+l2+l3)/2;
		double A = p*(p-l1)*(p-l2)*(p-l3);
		
		if((Math.abs(l1-l2) > l3 && l3 > l1 + l2)
			||(Math.abs(l3-l2) > l1 && l1 > l3 + l2)
			||(Math.abs(l3-l1) > l2 && l2 > l3 + l1)){
				System.out.println("ERRO: Esses argumentos não formam um triangulo");
				return tentarNovamente(3);
		}
		
		if(Math.sqrt(A) <= 0){
			System.out.println("ERRO: Digite apenas valores maiores que 0");
			return tentarNovamente(3);
		}
		
		else{
			return Math.sqrt(A);
		}
	}
	
	
	//Tipo do triangulo:
	private static String triangulo(double l1, double l2, double l3){
		String tipo;
		if (l1==l2 && l1==l3){
			tipo = "Equilatero";
		}
		else if (l1!=l2 && l1!=l3 && l2!=l3){
			tipo = "Escaleno";
		}
		else{
			tipo = "Isosceles";
		}
		return tipo;
	}
	
	
	//Arredondamento:
	private static double arredonda(double area){
		return Math.round(area);
	}
	
	
	//Tipo Double
	private static boolean ehDouble(String[] str){
		for(int i=0; i<str.length; i++){
			try{
				Double.parseDouble(str[i]);
			}
			catch (NumberFormatException e){
				return false;
			}
		}
		return true;
		
	}
	
	//Tratamento de excessao:
	private static double tentarNovamente(int max)throws IOException {
		String maximo;
		BufferedReader inData;
		inData = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Digite '1' para calcular area de um circulo, '2' para retangulo e '3' para triangulo: ");
		maximo = inData.readLine();
		
		max = Integer.parseInt(maximo);
		
		double[] vet = new double[max];
		String[] tentativa = new String[max];
		
		if(max!=1 && max!=2 && max!=3){
			System.out.println("Erro: Argumentos invalidos");
			return tentarNovamente(3);
		}
		else if(max==1){
			System.out.print("Agora insira o raio do circulo: ");
			tentativa[0] = inData.readLine();
			
			if(ehDouble(tentativa) == false){
				System.out.print("ERRO: Argumento não é do tipo double");
				return tentarNovamente(3);
				}
				
			vet[0] = Double.parseDouble(tentativa[0]);
			return print(vet);
		}
		else if(max==2){
			System.out.println("Agora insira a base e a altura do retangulo: ");
			System.out.print("Base: ");
			for(int i=0; i<max; i++){
				tentativa[i] = inData.readLine();
				vet[i] = Double.parseDouble(tentativa[i]);
				if(i==1){System.out.print("Altura: ");}
		}
			return print(vet);
		}
		else if(max==3){
			System.out.println("Agora insira os lados do triangulo: ");
			for(int i=0; i<max; i++){
				System.out.print("Lado "+(i+1)+": ");
				tentativa[i] = inData.readLine();
				vet[i] = Double.parseDouble(tentativa[i]);
		}
			return print(vet);
		}
		return 0;
	}
	
	//Print:
	public static double print(double[] vet) throws IOException {
		if(vet.length==1){
			System.out.println("Area do circulo = "+ arredonda(calcula(vet[0])) + " unidades de area.");	
		}
		
		else if(vet.length==2){			
			System.out.println("Area do retangulo = "+ arredonda(calcula(vet[0], vet[1])) + " unidades de area.");
		}
		
		else if(vet.length==3){

				System.out.println("Area do triangulo = "+ 
					arredonda(calcula(vet[0], vet[1], vet[2])) +
					" unidades de area.");
			
				System.out.println("O triangulo eh "+
					triangulo(vet[0], vet[1], vet[2]) + ".");
		}
		return 0;
	}
	
	//Main:
	public static void main(String[] args) throws IOException {
	
		double[] vet = new double[args.length];
		
		if(args.length > 3){
			System.out.println("ERRO: Numero de Argumentos excessivo");
			tentarNovamente(3);
		}
		else if(args.length < 1 || args == null){
			System.out.println("ERRO: Numero de Argumentos insuficiente");
			tentarNovamente(3);
		}
		else{
			for(int i=0; i < args.length; i++){
				if(ehDouble(args) == false){
					System.out.println("ERRO: Argumento não é do tipo double");
					tentarNovamente(3);
				}
				else{
					vet[i] = Double.parseDouble(args[i]);
					print(vet);
				}
			}
		}	
	}

}
	


