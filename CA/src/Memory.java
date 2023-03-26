import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class Memory {

	static int memory[] = new int[2048];
	
	
	static int PC = 0;
	int ClockCycle = 1;
	//static int opcode,rs,rt,rd,shamt,Imm,address;
	//static int zeroFlag  = 0;
	//static int Execoutput = 0;
	 int ReadMemData = 0;
	 ControlSignal signal1;
	 ControlSignal signal2;
	 ControlSignal signal3;
	 ControlSignal signal4;
	
	
	
	
	public static String ReadFile() {
		  
		String data= "";
		String result = "";
		int index = 0;
		try {
			      File myObj = new File("src/tester.txt");
			      Scanner myReader = new Scanner(myObj);
			      while (myReader.hasNextLine()) {
			        data = myReader.nextLine();
			        //memory[index] = data;
			        //index++;
			        //System.out.println(data);
			        result = result + data;
			        result = result + "\n";
			        
			        
			      }
			      
			      myReader.close();
			      
		}
		catch (FileNotFoundException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    }
		
		
		return result;
			
		}
	
	
	
	
	
	//reads the instruction one by one, change into 32 bits, and places it in memory
	public static void readInstruction() {
		String file = ReadFile();
		
		int instruction = 0;
		int i = 0;
		int opcode, rd,rs,rt,shamt,Imm,address;
		int regNum1, regNum2, regNum3;
		
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine()) {
		  String line = scanner.nextLine();
		  String[] words = line.split(" ");
		  switch(words[0].toUpperCase())
		  {
		  		case "ADD":
		  			opcode = 0 << 28;
		  			
		  			
		  			regNum1 = Integer.parseInt(String.valueOf(words[2].charAt(1)));
		  			rs = regNum1 << 23;
		  			
		  			regNum2 = Integer.parseInt(String.valueOf(words[3].charAt(1)));
		  			rt = regNum2 << 18;
		  			
		  			regNum3 = Integer.parseInt(String.valueOf(words[1].charAt(1)));
		  			rd = regNum3 << 13;
		  			
		  			shamt = 0;
		  			instruction = opcode|rs|rt|rd|shamt;
		  			break;
		  			
		  		case "SUB":
		  			opcode = 1 << 28;
		  			
		  			
		  			regNum1 = Integer.parseInt(String.valueOf(words[2].charAt(1)));
		  			rs = regNum1 << 23;
		  			
		  			regNum2 = Integer.parseInt(String.valueOf(words[3].charAt(1)));
		  			rt = regNum2 << 18;
		  			
		  			regNum3 = Integer.parseInt(String.valueOf(words[1].charAt(1)));
		  			rd = regNum3 << 13;
		  			
		  			shamt = 0;
		  			instruction = opcode|rs|rt|rd|shamt;
		  			break;
		  			
		  		case "MUL":
		  			opcode = 2 << 28;
		  			
		  			
		  			regNum1 = Integer.parseInt(String.valueOf(words[2].charAt(1)));
		  			rs = regNum1 << 23;
		  			
		  			regNum2 = Integer.parseInt(String.valueOf(words[3].charAt(1)));
		  			rt = regNum2 << 18;
		  			
		  			regNum3 = Integer.parseInt(String.valueOf(words[1].charAt(1)));
		  			rd = regNum3 << 13;
		  			
		  			shamt = 0;
		  			instruction = opcode|rd|rs|rt|shamt;
		  			break;
		  			
		  		case "MOVI":
		  			opcode = 3 << 28;
		  			
		  			
		  			rs = 0 << 23;
		  			
		  			regNum1 = Integer.parseInt(String.valueOf(words[1].charAt(1)));
		  			rt = regNum1 << 18;
		  			
		  			Imm = Integer.parseInt(words[2]) & 0b111111111111111111;
		  			
		  			instruction = opcode|rs|rt|Imm;
		  			break;
		  			
		  		case "JEQ":
		  			opcode = 4 << 28;
		  			
		  			
		  			regNum1 = Integer.parseInt(String.valueOf(words[2].charAt(1)));
		  			rs = regNum1 << 23;
		  			
		  			regNum2 = Integer.parseInt(String.valueOf(words[1].charAt(1)));
		  			rd = regNum2 << 18;
		  			
		  			Imm = Integer.parseInt(String.valueOf(words[3]));
		  			
		  			
		  			
		  			instruction = opcode|rs|rd|Imm;
		  			break;
		  			
		  		case "AND":
		  			opcode = 5 << 28;
		  			
		  			
		  			regNum1 = Integer.parseInt(String.valueOf(words[2].charAt(1)));
		  			rs = regNum1 << 23;
		  			
		  			regNum2 = Integer.parseInt(String.valueOf(words[3].charAt(1)));
		  			rt = regNum2 << 18;
		  			
		  			regNum3 = Integer.parseInt(String.valueOf(words[1].charAt(1)));
		  			rd = regNum3 << 13;
		  			
		  			shamt = 0;
		  			instruction = opcode|rs|rt|rd|shamt;
		  			break;
		  			
		  		case "XORI":
		  			opcode = 6 << 28;
		  			
		  			
		  			regNum1 = Integer.parseInt(String.valueOf(words[2].charAt(1)));
		  			rs = regNum1 << 23;
		  			
		  			regNum2 = Integer.parseInt(String.valueOf(words[1].charAt(1)));
		  			rt = regNum2 << 18;
		  			
		  			
		  			Imm = Integer.parseInt(words[3]) & 0b111111111111111111;
		  				
		  			instruction = opcode|rs|rt|Imm; 
		  			
		  			break;
		  			
		  		case "JMP": 
		  			opcode = 7 << 28;
		  			
		  			
		  			address = Integer.parseInt(String.valueOf(words[1]));
		  			
		  			instruction = opcode|address;
		  			break;
		  			
		  		case "LSL": 
		  			opcode = 8 << 28;
		  			
		  			
		  			regNum1 = Integer.parseInt(String.valueOf(words[2].charAt(1)));
		  			rs = regNum1 << 23;
		  			
		  			rt = 0 << 18;
		  			
		  			regNum2 = Integer.parseInt(String.valueOf(words[1].charAt(1)));
		  			rd = regNum2 << 13;
		  			
		  			shamt = Integer.parseInt(String.valueOf(words[3]));

		  			
		  			instruction = opcode|rs|rt|rd|shamt;
		  			break;
		  			
		  		
		  		case "LSR":
		  			opcode = 9 << 28;
		  			
		  			
		  			regNum1 = Integer.parseInt(String.valueOf(words[2].charAt(1)));
		  			rs = regNum1 << 23;
		  			
		  			rt = 0 << 18;
		  			
		  			regNum2 = Integer.parseInt(String.valueOf(words[1].charAt(1)));
		  			rd = regNum2 << 13;
		  			
		  			shamt = Integer.parseInt(String.valueOf(words[3]));

		  			
		  			instruction = opcode|rs|rt|rd|shamt;
		  			break;
		  		
		  		case "MOVR":
		  			opcode = 10 << 28;
		  			
		  			
		  			regNum1 = Integer.parseInt(String.valueOf(words[2].charAt(1)));
		  			rs = regNum1 << 23;
		  			
		  			regNum2 = Integer.parseInt(String.valueOf(words[1].charAt(1)));
		  			rt = regNum2 << 18;
		  			
		  			Imm = Integer.parseInt(String.valueOf(words[3]));
		  			
		  			instruction = opcode|rs|rt|Imm;
		  			break;
		  		
		  		case "MOVM":
		  			opcode = 11 << 28;
		  			
		  			//String s = words[1];
		  			regNum1 = Integer.parseInt(String.valueOf(words[2].charAt(1)));
		  			rs = regNum1 << 23;
		  			
		  			regNum2 = Integer.parseInt(String.valueOf(words[1].charAt(1)));
		  			rt = regNum2 << 18;
		  			
		  			
		  			Imm = Integer.parseInt(String.valueOf(words[3]));

		  			instruction = opcode|rs|rt|Imm;
		  			break;
		  				 
		  			
		  			
		  }
		  
		  
		  
		  memory[i] = instruction;
		  i++;
		  
		  
		}
		scanner.close();
		
	}
	
	
	public static ControlSignal fetch() { //Stage 1
		ControlSignal x = new ControlSignal();
		int instruction = 0;
		int i = 0;
		
		 //1023 is the last address in memory for the instructions
			if(PC < 1024) {
				instruction = memory[PC];
				//decode(instruction);
				PC++;
			}
			else {
				System.out.println("A7a");
			}
			int temp = PC-1;
		x.setInstrutionNumber(temp);
		x.setInstruction(instruction);
		return x;
	}
	
	
	
	public static ControlSignal decode(ControlSignal signal) { // Stage 2
		
		Registers f = new Registers();
		
		int inst = signal.getInstruction();
		
		int opcode = (inst & 0b11110000000000000000000000000000) >>> 28;
		signal.setOpcode(opcode); 			
		
		int rs = (inst & 0b00001111100000000000000000000000) >>> 23;
		signal.setRs(rs);
		
		int rt = (inst & 0b00000000011111000000000000000000) >>> 18;
		signal.setRt(rt);
		
		int rd = (inst & 0b00000000000000111110000000000000) >>> 13;
		signal.setRd(rd);
		
		int shamt = (inst & 0b0000000000000000000111111111111);
		signal.setShamt(shamt);
		
		int address =(inst & 0b00001111111111111111111111111111);
		signal.setAddress(address);
		
		int Imm = (inst & 0b00000000000000111111111111111111);
		//signal.setImm(Imm);
	
		
		
		
		
        int sign = Imm & (1<<16);
		if(sign == 0) {
			
		}
		
		else
			Imm = (Imm|0b11111111111111110000000000000000);
		

		//execute();
		signal.setImm(Imm);
		return signal;
		
	}
	
	
	
	public static ControlSignal execute(ControlSignal signal) { //Stage 3
		
		
		int op1,op2;
		
		
		
		int opcode = signal.getOpcode();
		int rd = signal.getRd();
		int rs = signal.getRs();
		int rt = signal.getRt();
		int shamt = signal.getShamt();
		int address = signal.getAddress();
		int Imm = signal.getImm();
		int Execoutput = -300;
		Boolean zeroFlag;
		
		if(opcode == 0) { //ADD, R
			
			op1 = Registers.getRegister(rs);
			op2 = Registers.getRegister(rt);
			
			 Execoutput = op1 + op2;
			
		}
		
		else if(opcode == 1) { //SUB, R
			
			op1 = Registers.getRegister(rs);
			op2 = Registers.getRegister(rt);
			
			Execoutput = op1 - op2;
		}
		
		else if(opcode == 2) { //MUL, R
			
			op1 = Registers.getRegister(rs);
			op2 = Registers.getRegister(rt);
			
			Execoutput = op1 * op2; 
		}
		
		else if(opcode == 3) { //MOVI, I
			Execoutput= Imm;
		}
		
		else if(opcode == 4) { //JEQ,I but my result goes to PC
			
			op1 = Registers.getRegister(rs);
			op2 = Registers.getRegister(rt); //hal hena lazem a3mel el shift left dah eh
			
			if(op1 == op2) {
				PC = PC + 1 + Imm; 
			}
		}
		
		else if (opcode == 5) { //AND,R
			
			op1 = Registers.getRegister(rs);
			op2 = Registers.getRegister(rt);
			
			Execoutput = op1 & op2;
		}
		
		else if(opcode == 6) { //XORI,I
			
			op1 = Registers.getRegister(rs);
			
			Execoutput = op1 ^ Imm;
			
		}
		
		else if(opcode == 7) { //JMP
			
			op1 = address << 2;
			op2 = (PC-1) & 0b11110000000000000000000000000000; //el kalam da sa7 bardo wla eh?
			PC = op2|op1;
			
		}
		
		else if(opcode == 8) { //LSL,R
			
			op1 = Registers.getRegister(rs);
			
			Execoutput = op1 << shamt;
		}
		
		else if(opcode == 9) { //LSR, R
			
			op1 = Registers.getRegister(rs);
			
			Execoutput = op1 >>> shamt;
		}
		
		else if(opcode == 10) { //MOVR, I
			
			op1 = Registers.getRegister(rs);
			
			Execoutput = op1 + Imm; 
			
		}
		
		else { // MOVM
			
			op1 = Registers.getRegister(rs);
			
			
			Execoutput = op1 + Imm;
			
		}
		
		if(Execoutput == 0) {
			zeroFlag = true;
			//return zeroFlag;
		}
		
		signal = ControlSignal.Control(opcode,signal);
		signal.setExecoutput(Execoutput);
	
		return signal;
		
		//Memory();
		
	}
	

	public static ControlSignal Memory(ControlSignal signal) { //Stage 4
		
		
		int writeControl = signal.getMemWrite();
		int readControl = ControlSignal.getMemRead();
		
		
		int writeData = Registers.registers[signal.getRt()];
		
		//ReadData = memory[execResult];
		//System.out.println(writeControl);
		//System.out.println("Im here");
		//System.out.println(readControl);
		
		if(writeControl == 1)
			memory[signal.getExecoutput()] = writeData;
		if(readControl == 1)
			signal.setReadMemData(memory[signal.getExecoutput()]);
		
		//WriteBack();
		return signal;
		

		
	}
	
	public int getMemData() {
		return ReadMemData;
	}
	
	
	public static void WriteBack(ControlSignal signal) {
		
		int MUX = ControlSignal.getMemtoReg();
		
		int op1,op2;
		
		op1 = signal.getReadMemData();
		op2 = signal.getExecoutput();
		
		
		//System.out.println(MUX);
		//System.out.println("Hello");
		//System.out.println("op1 is " + op1);
		//System.out.println("op2 is " + op2);
	
		if(MUX == 1)
			Registers.RegisterWrite(signal);
		else
			Registers.RegisterWrite(signal);
		
	}
	public void start() {
		ControlSignal Sig1 = fetch();
		ClockCycle++;
		Sig1 = decode(Sig1);
		ClockCycle++;
		ControlSignal sig2 = fetch(); //still decode 1
		ClockCycle++;
		sig2 = decode(sig2);
		Sig1 = execute(Sig1);
		ClockCycle++;
		ControlSignal sig3 = fetch(); //still decode exec
		ClockCycle++;
		signal2 = decode(sig3);
		signal3 = execute(sig2);
		signal4 = Memory(Sig1);
		ClockCycle++;
		signal1 = fetch();
		WriteBack(signal4);
		ClockCycle++;
		
		
	}
	public boolean isfetch() {
		int inst = memory[PC];
		if(inst == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void NormalPipe() {
		while(isfetch()) {
			if(ClockCycle % 2 == 0 ) {
				signal4 = Memory(signal3);
				signal3 = execute(signal2);
				
				signal2 = decode(signal1);
				ClockCycle++;
			}
			else {
				WriteBack(signal4);
				signal1 = fetch();
				ClockCycle++;
			}
		}
		Exitpipe();
	}
	
	public void Exitpipe() {
		signal4 = Memory(signal3);  //stile decode exec
		ClockCycle++;
		WriteBack(signal4);
		signal3 = execute(signal2);
		signal2 = decode(signal1);
		ClockCycle++;
		signal4 = Memory(signal3);
		ClockCycle++;
		WriteBack(signal4);
		signal3 = execute(signal2); //no decode
		ClockCycle++;
		signal4 = Memory(signal3);
		ClockCycle++;
		WriteBack(signal4);
		ClockCycle++;
		
		
	}
	
	
	
	
	
		
	

	
	public static void main(String[] args) {
		
		//Registers.setRegister("R1", 56);
		//Registers.registers[2] = 20;
		//memory[1029] = 20;
//		Registers.setRegister("R1",100);
//		Registers.setRegister("R2", 1024);
Registers.setRegister("R5", 15);
		Registers.setRegister("R6", 20);
		//Registers.setRegister("R2", 1024);
		
		readInstruction();
//		memory[1029] = 50;
//		
//		ControlSignal signal = fetch();
//		ControlSignal signal1 = decode(signal);
//		
//		ControlSignal signal2 = execute(signal1);
//		System.out.println(signal2.getExecoutput());
//		System.out.println(signal2.getRs());
//		System.out.println(signal2.getRt());
//		
//		ControlSignal signal3 = Memory(signal2);
//		WriteBack(signal3);
		
		
		//System.out.println("Instruction: " );
		//.out.println("R2: " + Registers.getRegister(2));
		
		Memory mem = new Memory();
		mem.start();
		mem.NormalPipe();
		
		System.out.println("R1: " + Registers.getRegister(1));
		System.out.println("R4: " + Registers.getRegister(4));
		
		System.out.println(memory[1029]);
		//System.out.println("R7: " + Registers.getRegister(7));
		//System.out.println(memory[1035]);
		
	}
}
		 
