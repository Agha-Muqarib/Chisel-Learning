package Lab02

import chisel3._
import chisel3.util._

class LmIo_Interface extends Bundle {

    // val s0 = Input(UInt(32.W))
    // val s1 = Input(UInt(32.W))
    // val s2 = Input(UInt(32.W))
    // val s3 = Input(UInt(32.W))
    // val s4 = Input(UInt(32.W))

    val sel0 = Input(UInt(1.W))
    val sel1 = Input(UInt(1.W))
    val sel2 = Input(UInt(1.W))
    
    val out = Output(UInt(32.W))
}

class Ass01 extends Module {

    val io = IO(new LmIo_Interface)

    // val mux1 = Mux(io.sel0, io.s0, io.s1)
    // val mux2 = Mux(io.sel0, io.s2, io.s3)
    // val mux3 = Mux(io.sel1, mux1, mux2)
    
    val sel = Cat(io.sel2, io.sel1, io.sel0)
    
    io.out := MuxCase( false .B , Array (
        
        ( sel === "b000".U ) -> 0.U,
        
        ( sel === "b001".U ) -> 8.U,

        ( sel === "b010".U ) -> 16.U,

        ( sel === "b011".U ) -> 24.U,

        ( sel === BitPat("b1??") ) -> 32.U

))
    
}