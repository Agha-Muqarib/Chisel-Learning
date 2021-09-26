package Lab06

import chisel3._
import chisel3.util._

class Exercise02 (val max: Int, val min: Int = 0) extends Module {
    
    val io = IO (new Bundle {

        val out = Output(UInt(log2Ceil(max).W))

    })

    val counter = RegInit(min.U(log2Ceil(max).W))
    val buffer = Mux(isPow2(max).B && (min == 0).B, counter + 1.U, 
                 Mux(counter === max.U, min.U, counter +1.U))

    counter := buffer
    io.out := counter

}