
public class Data {
	
	
	
	//howa 3ady eny ab2a 3amel class lel data keda lewa7daha wla mmken a7otaha fl tester 3ady
	
	public static int data;
	
	public static void readData(int DataAdrs) {
		
			data = Memory.memory[DataAdrs];
		
		
		
	}
	
	public static void writeData(int writeData, int DataAdrs) {
		Memory.memory[DataAdrs] = writeData;
	}
	
	
	
	public static int getData() {
		return data;
	}
	
	
	public static void main(String [] args) {
		
		writeData(20,1024);
		writeData(69,1025);
		int data = getData();
		System.out.println(data);
		//System.out.println(readData(1025));
		
	}

}
