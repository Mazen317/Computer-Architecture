
public class Registers {
	
	static int registers[] = new int[32];
	static int DestReg;
//	static int PC;
	

	
	
	public static void RegisterWrite(ControlSignal signal) {
		
		if(signal.getRegDst() == 0)
			DestReg = signal.getRt();
		else
			DestReg = signal.getRd();
		
		
		if(signal.getRegWrite() == 1)
			registers[DestReg] = signal.getReadMemData();
	
	}
	
	public static int RegisterRead(int Reg){
		return registers[Reg];
	}
	
	public static void setRegister(String s,int data) {
		int regNum = Integer.parseInt(String.valueOf(s.charAt(1)));
		if(regNum == 0)
			System.out.println("Cannot override R0");
		else
			registers[regNum] = data;
	}
	
	
//	public static void ConrolPC() {
//		int MUX = ControlSignal.getBranch();
//		int op1 = 0;
//		int op2 = 0;
//		
//		if(MUX == 0) 
//			PC = PC + 1;
//		else {
//			switch(Memory.getOpcode()) {
//				case 4: 
//					op1 = PC;
//					op2 = (Memory.getImm()) << 2;
//					PC = op1 + op2;
//					break;
//					
//				case 7:
//					op1 = PC & 0b1111;
//					op2 = Memory.getAddress();
//					PC = op1|op2; 
//					
//					
//			}
//		}
//		
//	}
	
	
	
	
	
	public static int getRegister(int regNum) {
		return registers[regNum];
	}
	
	
	
	
	public static int getDestReg() {
		return DestReg;
	}
	
//	public static int getPC() {
//		return PC;
//	}
//	
//	public static void setPC(int value) {
//		PC = value;
//	}
	

	
	public static void main(String[] args) {
		registers[0] = 5;
		
	}
	
}
