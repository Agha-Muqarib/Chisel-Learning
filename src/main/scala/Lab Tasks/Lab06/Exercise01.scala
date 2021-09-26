package Lab06

import chisel3._
import chisel3.util._

class shift_register(init:Int) extends Bundle {
    
    val in = Input(UInt(4.W))
    val out = Output(Bool())
}


class Exercise01(init:Int) extends Module{

    val io = IO (new shift_register(init))
    val state = RegInit(0.U(init.W))
    val load = RegInit(0.U(init.W))

    io.out:=0.B

    when (load === 0.U) {
        
        load := load + 1.U
        state := io.in

    }
    
    .otherwise {

        state := state >> 1
        io.out := state(0)

    }
    
}