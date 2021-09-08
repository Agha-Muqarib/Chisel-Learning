package Example

import chisel3._

class Mux extends Module {
    val io = IO(new Bundle {

        val a = Input(UInt(1.W))
        val b = Input(UInt(1.W))
        val sel = Input(UInt(1.W))
        val c = Output(UInt(1.W))
    })

    // Switch Case in chisel
    
    when(io.sel===0.U){
        io.c:=io.a
    }
    
    .elsewhen(io.sel===1.U){
        io.c:=io.b
    }
    
    .otherwise{
        io.c:= DontCare
    }
}

