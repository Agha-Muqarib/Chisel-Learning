package Lab06

import chisel3._
import chisel3.util._

class Pipe extends Module {
    
    val io = IO ( new Bundle {
        
        val in = Flipped(Valid(UInt(8.W))) // valid = Input ,
        val out = Valid(UInt(8.W))  // valid = Output ,
        
    })

    io.out := Pipe (io.in, 5)

}