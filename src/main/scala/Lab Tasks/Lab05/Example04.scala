package Lab05

import chisel3._
import chisel3.util._


class IOInterface [T <: Data] (data_type: T) extends Bundle {

        val in1 = Input(data_type.cloneType)
        val in2 = Input(data_type.cloneType)
        val out = Output(data_type.cloneType)
        val sel = Input(Bool())
}

// Adder

class Example04(size: UInt) extends Module {
    
    val io = IO(new IOInterface(size))
    io.out := io.in1 + io.in2
}