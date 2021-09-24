package Lab05

import chisel3._
import chisel3.util._

// emux

class ioInterface[T <: Data] (data_type:T) extends Bundle{

        val out = Output(data_type.cloneType)
        val in1 = Input(data_type.cloneType)
        val in2 = Input(data_type.cloneType)
        val sel = Input(Bool())
}

class Exercise02(size: UInt) extends Module {

    val io = IO(new ioInterface(size))

    io.out := Mux2_to_1(io.in2, io.in1, io.sel)

    def Mux2_to_1[T <: Data](in_0:T, in_1:T, sel: Bool):T = {
    
        Mux (sel, in_1, in_0 )

    }

}
