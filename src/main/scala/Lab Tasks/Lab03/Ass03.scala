package Lab03

import chisel3._
import chisel3.util._

class Ass03 extends Module{

    val io = IO(new Bundle{

        val input = Input(UInt(2.W))
        val output =Valid(Output(UInt(4.W)))
        
        })

    io.output.valid := false.B
    io.output.bits := 0.U
    
    when ( io.input === "b00".U ) {
        
        io.output.bits := "b0001".U
        io.output.valid := true.B
    }
    
    .elsewhen (io.input === "b01".U ) {
        
        io.output.bits := "b0010".U
        io.output.valid:= true.B
    }
    
    .elsewhen ( io.input === "b10".U ) {
       
        io.output.bits := "b0100".U
        io.output.valid:= true.B
    }
    
    .elsewhen(io.input === "b11".U){
        io.output.bits := "b1000".U
        io.output.valid:= true.B
    }
}