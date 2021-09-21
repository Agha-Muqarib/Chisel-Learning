// package Lab04

// import chisel3._
// import chisel3.util._

// class ImmediateIO extends Bundle {

// 	val instr = Input(UInt(32.W))
// 	val immSel = Output(UInt(32.W))
//     val pc = Input(UInt(32.W))
// }
// class Ass02 extends Module {

// 	val io = IO(new ImmediateIO)
// 	io.immSel := 0.U


// 	switch(io.instr(6,0)) {                 
		
//         // I Type

//         is("b0010011".U){

//             io.immSel := Cat(Fill(20,io.instr(31)),io.instr(31,20))

//         }

//         // S Type

//         is("b0100011".U) {
            
//             io.immSel := Cat(Fill(20, io.instr(31)), io.instr(31, 25), io.instr(11, 7))
	
//         }

//         // U Type

//         is("b110111".U){
            
//             io.immSel := (Cat(io.instr(31), io.instr(30, 25), io.instr(24, 21), 
//                                   io.instr(20),io.instr(19, 12)) << 12.U)
//         }


//         // B Type

//         is("b1100011".U){
		
//             io.immSel := Cat(Fill(19,io.instr(31)),io.instr(31),io.instr(7),
//                               io.instr(30,25),io.instr(11,8), 0.U)+io.pc
//         }
		

//         // J Type

//         is("b1101111".U){

// 		    io.immSel := Cat(Fill(11,io.instr(31)),io.instr(31),io.instr(19,12),
//                               io.instr(20),io.instr(30,25),io.instr(24,21), 0.U)
//         }
//     }
    
// }