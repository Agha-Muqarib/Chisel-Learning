package Lab02

import chisel3._
import chisel3.util._


class Ass02 extends Module {
    
    val io = IO( new Bundle {

        val in = Vec(4, Input(Bool()))
        val sel = Vec(2, Input(Bool()))
        val shift_type = Input(Bool())
        val out = Vec(4, Output(Bool()))
})

io.out(0) := MuxLookup(io.sel(0), false.B, Array(
        
        (0.U) -> MuxLookup(io.sel(1), false.B, Array(
            
            (0.U) -> io.in(0),
            (1.U) -> io.in(1)
            
            )),

        (1.U) -> MuxLookup(io.sel(1), false.B, Array(

            (0.U) -> io.in(2),
            (1.U) -> io.in(3)

            ))
        ))

io.out(1) := MuxLookup(io.sel(0), false.B, Array(
        
        (0.U) -> MuxLookup(io.sel(1),false.B, Array(

            (0.U) -> Mux(io.shift_type, io.in(0), 0.U),
            (1.U) -> io.in(1)

            )),

        (1.U) -> MuxLookup(io.sel(1), false.B, Array(

            (0.U) -> io.in(2),
            (1.U) -> io.in(3)
            
            )),

        ))

io.out(2) := MuxLookup(io.sel(0), false.B, Array(

        (1.U) -> MuxLookup(io.sel(1), false.B, Array(

            (0.U) -> Mux(io.shift_type, io.in(0),0.U),
            (1.U) -> Mux(io.shift_type, io.in(1),0.U)

            )),

        (2.U) -> MuxLookup(io.sel(1),false.B,Array(
            (0.U) -> io.in(2),
            (1.U) -> io.in(3)
            
            ))
        ))

io.out(3) := MuxLookup(io.sel(0), false.B, Array(

        (1.U) -> MuxLookup(io.sel(1), false.B, Array(

            (0.U) -> Mux(io.shift_type, io.in(0), 0.U),
            (1.U) -> Mux(io.shift_type, io.in(1), 0.U)

            )),

        (0.U) -> MuxLookup(io.sel(1), false.B, Array(

            (0.U) -> Mux(io.shift_type, io.in(2), 0.U),
            (1.U) -> io.in(3)
            
            ))
        ))
}